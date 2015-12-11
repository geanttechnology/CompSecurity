.class public Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
.super Ljava/lang/Object;
.source "PlayerPlatformAPI.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$6;
    }
.end annotation


# instance fields
.field private final LOG_TAG:Ljava/lang/String;

.field private activity:Landroid/app/Activity;

.field private analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

.field private applicationContext:Landroid/content/Context;

.field private assetLoadingComplete:Z

.field private currentBitrate:J

.field private currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private currentDFPS:J

.field private currentDuration:J

.field private currentFPS:J

.field private currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field private drmComplete:Z

.field private heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

.field private final heartbeatClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

.field private heartbeatInterval:I

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

.field private isMediaOpened:Z

.field private licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

.field private listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field private logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

.field private mediaOpenedSent:Z

.field private offlineDrmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

.field private parentView:Landroid/widget/FrameLayout;

.field private playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

.field private final playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

.field private playbackHasOccured:Z

.field private player:Lcom/comcast/playerplatform/primetime/android/player/Player;

.field private playerListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

.field private playerManager:Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;

.field private playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

.field private playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

.field private totalAudioTracks:I

.field private updateInterval:I

.field private useSecureView:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 6
    .param p1, "playerActivity"    # Landroid/app/Activity;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    const/4 v4, 0x0

    .line 105
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;-><init>(Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/client/ClientState;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V

    .line 106
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/client/ClientState;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V
    .locals 4
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p4, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientState;
    .param p5, "authDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    .line 175
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    .line 65
    const-string v0, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->LOG_TAG:Ljava/lang/String;

    .line 77
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    .line 78
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackHasOccured:Z

    .line 79
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z

    .line 80
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z

    .line 82
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    .line 83
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 86
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentBitrate:J

    .line 87
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentFPS:J

    .line 88
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDFPS:J

    .line 89
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDuration:J

    .line 90
    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->totalAudioTracks:I

    .line 94
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->useSecureView:Z

    .line 1120
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$2;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 1237
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->offlineDrmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 1389
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$4;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$4;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .line 1396
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$5;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .line 177
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "Player API is being initialized"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 179
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    .line 180
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->activity:Landroid/app/Activity;

    .line 181
    invoke-direct {p0, p3, p4, p5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialize(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/client/ClientState;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V

    .line 182
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 6
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    const/4 v2, 0x0

    .line 138
    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, v2

    move-object v5, v2

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;-><init>(Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/client/ClientState;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V

    .line 139
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->addPlayerView()V

    return-void
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->sendMediaOpened()V

    return-void
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/util/android/Clock;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->createAndStartTimers()V

    return-void
.end method

.method static synthetic access$1300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stopAndDestroyTimers()V

    return-void
.end method

.method static synthetic access$1400(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->resetLocalFields()V

    return-void
.end method

.method static synthetic access$1502(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .param p1, "x1"    # Z

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z

    return p1
.end method

.method static synthetic access$1600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->videoReady()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1700(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->mediaOpenedSent:Z

    return v0
.end method

.method static synthetic access$1702(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .param p1, "x1"    # Z

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->mediaOpenedSent:Z

    return p1
.end method

.method static synthetic access$1800(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->sendHeartbeatMessage()V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2000(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updatePlaybackMetrics()V

    return-void
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method static synthetic access$502(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object p1
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    return-object v0
.end method

.method static synthetic access$702(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .param p1, "x1"    # Z

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z

    return p1
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmReady()Z

    move-result v0

    return v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z

    return v0
.end method

.method private addPlayerView()V
    .locals 3

    .prologue
    const/16 v2, 0x11

    .line 387
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerManager:Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->didPlayerChange()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 388
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 389
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 392
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 395
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-gt v0, v2, :cond_2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ne v0, v2, :cond_3

    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    const-string v1, "4.2.2"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->useSecureView:Z

    if-nez v0, :cond_3

    .line 396
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateViewSecurity()V

    .line 398
    :cond_3
    return-void
.end method

.method private checkForAutoPlay()V
    .locals 2

    .prologue
    .line 1319
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getType()Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->DISNEY:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1320
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAutoPlay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1321
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->play()V

    .line 1326
    :cond_0
    :goto_0
    return-void

    .line 1323
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->pause()V

    goto :goto_0
.end method

.method private declared-synchronized createAndStartTimers()V
    .locals 4

    .prologue
    .line 1088
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stopAndDestroyTimers()V

    .line 1089
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatInterval:I

    if-lez v0, :cond_0

    .line 1090
    new-instance v0, Lcom/comcast/playerplatform/util/android/Clock;

    const-string v1, "HeartbeatClock"

    iget v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatInterval:I

    int-to-long v2, v2

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Clock;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    .line 1091
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 1092
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->start()V

    .line 1095
    :cond_0
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    if-lez v0, :cond_1

    .line 1096
    new-instance v0, Lcom/comcast/playerplatform/util/android/Clock;

    const-string v1, "PlaybackClock"

    iget v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    int-to-long v2, v2

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Clock;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    .line 1097
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 1098
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1100
    :cond_1
    monitor-exit p0

    return-void

    .line 1088
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private drmReady()Z
    .locals 1

    .prologue
    .line 1309
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->hasDRM()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1

    .prologue
    .line 1234
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getLargestBitrate()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    .locals 5

    .prologue
    .line 1378
    const/4 v1, 0x0

    .line 1379
    .local v1, "largestProfile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v3, :cond_2

    .line 1380
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableProfiles()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;

    .line 1381
    .local v2, "profile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->getBitrate()I

    move-result v3

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->getBitrate()I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 1382
    :cond_1
    move-object v1, v2

    goto :goto_0

    .line 1386
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "profile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    :cond_2
    return-object v1
.end method

.method private initialize(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/client/ClientState;Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V
    .locals 9
    .param p1, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientState;
    .param p3, "authenticationDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .prologue
    .line 186
    if-eqz p1, :cond_1

    .line 187
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 193
    :goto_0
    if-eqz p3, :cond_2

    .line 194
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v0, p3, v1, v2}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;-><init>(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    .line 202
    :goto_1
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/analytics/NullAnalyticsHandler;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    .line 203
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 204
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->addListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 205
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .line 206
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setAuthDelegate(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V

    .line 207
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setclientState(Lcom/comcast/playerplatform/drm/java/client/ClientState;)V

    .line 209
    new-instance v8, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 211
    .local v8, "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getInitialBitrate()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setInitialBitrate(I)V

    .line 212
    new-instance v7, Lcom/comcast/playerplatform/util/android/Range;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getMinBitrate()I

    move-result v0

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getMaxBitrate()I

    move-result v1

    invoke-direct {v7, v0, v1}, Lcom/comcast/playerplatform/util/android/Range;-><init>(II)V

    .line 213
    .local v7, "bitRange":Lcom/comcast/playerplatform/util/android/Range;
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, v7}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setBitRange(Lcom/comcast/playerplatform/util/android/Range;)V

    .line 215
    new-instance v0, Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    .line 217
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 218
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 221
    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->activity:Landroid/app/Activity;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/service/LicenseService;Landroid/widget/FrameLayout;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerManager:Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;

    .line 223
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    .line 225
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->getInstance()Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->setPlayer(Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;)V

    .line 227
    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getHeartBeatInterval()I

    move-result v0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatInterval:I

    .line 229
    return-void

    .line 190
    .end local v7    # "bitRange":Lcom/comcast/playerplatform/util/android/Range;
    .end local v8    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    goto/16 :goto_0

    .line 196
    :cond_2
    if-nez p2, :cond_3

    .line 197
    new-instance p2, Lcom/comcast/playerplatform/drm/java/client/ClientState;

    .end local p2    # "clientState":Lcom/comcast/playerplatform/drm/java/client/ClientState;
    invoke-direct {p2}, Lcom/comcast/playerplatform/drm/java/client/ClientState;-><init>()V

    .line 199
    .restart local p2    # "clientState":Lcom/comcast/playerplatform/drm/java/client/ClientState;
    :cond_3
    new-instance v0, Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v0, p2, v1, v2}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;-><init>(Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    goto/16 :goto_1
.end method

.method private isPausableState()Z
    .locals 2

    .prologue
    .line 294
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    .line 295
    .local v0, "currentState":Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isPlayableState()Z
    .locals 2

    .prologue
    .line 299
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    .line 300
    .local v0, "currentState":Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->videoReady()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmReady()Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->READY:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private resetLocalFields()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 422
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackHasOccured:Z

    .line 423
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z

    .line 424
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z

    .line 425
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 426
    return-void
.end method

.method private sendHeartbeatMessage()V
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 1455
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v1, :cond_0

    .line 1456
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v4

    .line 1457
    .local v4, "cc":Ljava/lang/String;
    :goto_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v5

    .line 1458
    .local v5, "sap":Ljava/lang/String;
    :goto_1
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->getBufferLength()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    .line 1459
    .local v6, "bufferSize":Ljava/lang/Long;
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentBitrate()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    iget-wide v8, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentFPS:J

    long-to-int v3, v8

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v7

    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v8}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    move-result-object v8

    invoke-interface/range {v0 .. v8}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->heartBeat(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;)V

    .line 1461
    .end local v4    # "cc":Ljava/lang/String;
    .end local v5    # "sap":Ljava/lang/String;
    .end local v6    # "bufferSize":Ljava/lang/Long;
    :cond_0
    return-void

    :cond_1
    move-object v4, v0

    .line 1456
    goto :goto_0

    .restart local v4    # "cc":Ljava/lang/String;
    :cond_2
    move-object v5, v0

    .line 1457
    goto :goto_1
.end method

.method private sendMediaOpened()V
    .locals 15

    .prologue
    .line 1272
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z

    .line 1273
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getHeight()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getWidth()I

    move-result v0

    if-nez v0, :cond_0

    .line 1274
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setHeight(I)V

    .line 1275
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setWidth(I)V

    .line 1278
    :cond_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateVideoSize()V

    .line 1280
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_1

    .line 1281
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    const-string v1, "HLS"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->name()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getVideoWidth()J

    move-result-wide v6

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getVideoHeight()J

    move-result-wide v8

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getDuration()J

    move-result-wide v10

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getStartPosition()J

    move-result-wide v12

    long-to-double v12, v12

    const/4 v14, 0x0

    invoke-virtual/range {v0 .. v14}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V

    .line 1294
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    if-eqz v0, :cond_2

    .line 1295
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$6;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$InitialPlayerState:[I

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1303
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->checkForAutoPlay()V

    .line 1306
    :cond_2
    :goto_0
    return-void

    .line 1297
    :pswitch_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->play()V

    goto :goto_0

    .line 1300
    :pswitch_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->pause()V

    goto :goto_0

    .line 1295
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private setSizeWithAspectRatio(JJ)V
    .locals 11
    .param p1, "movieWidth"    # J
    .param p3, "movieHeight"    # J

    .prologue
    .line 1338
    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getHeight()I

    move-result v8

    int-to-long v4, v8

    .line 1339
    .local v4, "playerHeight":J
    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getWidth()I

    move-result v8

    int-to-long v6, v8

    .line 1340
    .local v6, "playerWidth":J
    long-to-float v8, v6

    long-to-float v9, v4

    div-float v1, v8, v9

    .line 1343
    .local v1, "maxAspectRatio":F
    const-wide/16 v8, 0x0

    cmp-long v8, p1, v8

    if-eqz v8, :cond_0

    const-wide/16 v8, 0x0

    cmp-long v8, p3, v8

    if-nez v8, :cond_1

    .line 1345
    :cond_0
    move v2, v1

    .line 1355
    .local v2, "newAspectRatio":F
    :goto_0
    cmpg-float v8, v2, v1

    if-gtz v8, :cond_2

    .line 1357
    long-to-float v8, v4

    mul-float/2addr v8, v2

    float-to-int v3, v8

    .line 1358
    .local v3, "width":I
    long-to-int v0, v4

    .line 1366
    .local v0, "height":I
    :goto_1
    invoke-direct {p0, v3, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setViewLayout(II)V

    .line 1367
    return-void

    .line 1348
    .end local v0    # "height":I
    .end local v2    # "newAspectRatio":F
    .end local v3    # "width":I
    :cond_1
    long-to-float v8, p1

    long-to-float v9, p3

    div-float v2, v8, v9

    .restart local v2    # "newAspectRatio":F
    goto :goto_0

    .line 1361
    :cond_2
    long-to-int v3, v6

    .line 1362
    .restart local v3    # "width":I
    long-to-float v8, v6

    const/high16 v9, 0x3f800000    # 1.0f

    div-float/2addr v9, v2

    mul-float/2addr v8, v9

    float-to-int v0, v8

    .restart local v0    # "height":I
    goto :goto_1
.end method

.method private setViewLayout(II)V
    .locals 3
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 1370
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v2, 0x11

    invoke-direct {v1, p1, p2, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1371
    return-void
.end method

.method private stopAndDestroyTimers()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1103
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    if-eqz v0, :cond_0

    .line 1104
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->stop()V

    .line 1105
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->removeClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 1106
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->heartbeatClock:Lcom/comcast/playerplatform/util/android/Clock;

    .line 1109
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    if-eqz v0, :cond_1

    .line 1110
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->stop()V

    .line 1111
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->removeClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 1112
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    .line 1114
    :cond_1
    return-void
.end method

.method private updatePlaybackMetrics()V
    .locals 22

    .prologue
    .line 1409
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentBitrate()I

    move-result v4

    int-to-long v14, v4

    .line 1410
    .local v14, "bitrate":J
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentBitrate:J

    cmp-long v4, v4, v14

    if-eqz v4, :cond_0

    .line 1411
    move-object/from16 v0, p0

    iput-wide v14, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentBitrate:J

    .line 1412
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v4, :cond_0

    .line 1413
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object/from16 v0, p0

    iget-wide v5, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentBitrate:J

    const/4 v7, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getVideoHeight()J

    move-result-wide v8

    invoke-virtual/range {p0 .. p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getVideoWidth()J

    move-result-wide v10

    invoke-virtual/range {v4 .. v11}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->bitrateChanged(JLjava/lang/String;JJ)V

    .line 1417
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->getFrameRate()F

    move-result v4

    float-to-long v0, v4

    move-wide/from16 v20, v0

    .line 1418
    .local v20, "framesPerSecond":J
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentFPS:J

    cmp-long v4, v4, v20

    if-eqz v4, :cond_1

    .line 1419
    move-wide/from16 v0, v20

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentFPS:J

    .line 1420
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v4, :cond_1

    .line 1421
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentFPS:J

    invoke-virtual {v4, v6, v7}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->fpsChanged(J)V

    .line 1425
    :cond_1
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->getDroppedFrames()J

    move-result-wide v16

    .line 1426
    .local v16, "droppedFramesPerSecond":J
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDFPS:J

    cmp-long v4, v4, v16

    if-eqz v4, :cond_2

    .line 1427
    move-wide/from16 v0, v16

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDFPS:J

    .line 1428
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v4, :cond_2

    .line 1429
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDFPS:J

    invoke-virtual {v4, v6, v7}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->droppedFPSChanged(J)V

    .line 1434
    :cond_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getDuration()J

    move-result-wide v18

    .line 1435
    .local v18, "duration":J
    move-object/from16 v0, p0

    iget-wide v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDuration:J

    cmp-long v4, v4, v18

    if-eqz v4, :cond_3

    .line 1436
    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDuration:J

    .line 1437
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v4, :cond_3

    .line 1438
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentDuration:J

    invoke-virtual {v4, v6, v7}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->durationChanged(J)V

    .line 1443
    :cond_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v12

    .line 1444
    .local v12, "audioTracks":Ljava/util/List;
    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v13

    .line 1445
    .local v13, "totalLanguages":I
    move-object/from16 v0, p0

    iget v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->totalAudioTracks:I

    if-eq v4, v13, :cond_4

    .line 1446
    move-object/from16 v0, p0

    iput v13, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->totalAudioTracks:I

    .line 1447
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v4, :cond_4

    .line 1448
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->totalAudioTracks:I

    invoke-virtual {v4, v5}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->numberOfAlternativeAudioStreamsChanged(I)V

    .line 1452
    :cond_4
    return-void
.end method

.method private updateVideoSize()V
    .locals 6

    .prologue
    .line 1329
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getLargestBitrate()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;

    move-result-object v0

    .line 1330
    .local v0, "profile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getZoomSetting()Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    move-result-object v1

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->None:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 1331
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->getWidth()I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->getHeight()I

    move-result v1

    int-to-long v4, v1

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setSizeWithAspectRatio(JJ)V

    .line 1335
    :goto_0
    return-void

    .line 1333
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getWidth()I

    move-result v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getHeight()I

    move-result v2

    invoke-direct {p0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setViewLayout(II)V

    goto :goto_0
.end method

.method private updateViewSecurity()V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0x11
    .end annotation

    .prologue
    .line 402
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getType()Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    move-result-object v2

    sget-object v3, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->ESPN:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getType()Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    move-result-object v2

    sget-object v3, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    if-ne v2, v3, :cond_2

    .line 403
    :cond_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 404
    .local v1, "playerView":Landroid/view/ViewGroup;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 405
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    instance-of v2, v2, Lcom/adobe/ave/VideoEngineView;

    if-eqz v2, :cond_1

    .line 406
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/adobe/ave/VideoEngineView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/adobe/ave/VideoEngineView;->setSecure(Z)V

    .line 404
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 410
    .end local v0    # "i":I
    .end local v1    # "playerView":Landroid/view/ViewGroup;
    :cond_2
    return-void
.end method

.method private videoReady()Z
    .locals 1

    .prologue
    .line 1313
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 970
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->addListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 971
    return-void
.end method

.method public applyPlayerSettings()V
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 1076
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 1077
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1079
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V

    .line 1081
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getWidth()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getHeight()I

    move-result v0

    if-lez v0, :cond_1

    .line 1082
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getWidth()I

    move-result v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getHeight()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setDimensionsOfVideo(II)V

    .line 1084
    :cond_1
    return-void
.end method

.method public authenticateAssetOffline(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V
    .locals 5
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .prologue
    .line 1042
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1044
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->offlineDrmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForOfflinePlayback(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 1050
    :goto_0
    return-void

    .line 1048
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->offlineDrmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForOfflinePlayback(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    goto :goto_0
.end method

.method public configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;)V
    .locals 4
    .param p1, "hostInfo"    # Lcom/comcast/playerplatform/analytics/java/util/HostInfo;

    .prologue
    .line 902
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuffer;

    const-string v3, "Configuring analytics, protocol : deviceType: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    const-string v3, " deviceID"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 904
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-virtual {v0, p1, v1}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 905
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    .line 906
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->pluginInitialized(Landroid/content/Context;)V

    .line 907
    return-void
.end method

.method public configureAuditudeAds()V
    .locals 1

    .prologue
    .line 914
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->configureAuditudeAds(Ljava/util/Map;)V

    .line 915
    return-void
.end method

.method public configureAuditudeAds(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 918
    .local p1, "targetingParameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->AUDITUDE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setAdType(Lcom/comcast/playerplatform/primetime/android/enums/AdType;)V

    .line 919
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setC3Ads(Ljava/util/List;)V

    .line 920
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setComscoreEnabled(Z)V

    .line 921
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setTargetingParameters(Ljava/util/Map;)V

    .line 922
    return-void
.end method

.method public configureC3Ads(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1031
    .local p1, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setC3Ads(Ljava/util/List;)V

    .line 1032
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->C3:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setAdType(Lcom/comcast/playerplatform/primetime/android/enums/AdType;)V

    .line 1033
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setComscoreEnabled(Z)V

    .line 1034
    return-void
.end method

.method public createAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 10

    .prologue
    .line 359
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->activity:Landroid/app/Activity;

    iget-object v9, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->applicationContext:Landroid/content/Context;

    invoke-static {v5, v6, v7, v8, v9}, Lcom/comcast/playerplatform/primetime/android/ads/managers/PlayerPlatformAds;->getAdManager(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Landroid/app/Activity;Landroid/content/Context;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    .line 361
    .local v0, "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    if-eqz v0, :cond_1

    .line 362
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-virtual {v0, v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->attachPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V

    .line 363
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->addPlayerEventManager(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    .line 365
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAdData()Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    move-result-object v5

    if-eqz v5, :cond_2

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAdData()Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/asset/AdData;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v1

    .line 366
    .local v1, "adType":Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    :goto_0
    sget-object v5, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->MANIFEST_MANIPULATOR:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    invoke-virtual {v1, v5}, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 367
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 369
    .local v4, "urForAds":Landroid/net/Uri;
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAuthDelegate()Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    move-result-object v5

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAuthDelegate()Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;->getAccessToken()Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v3

    .line 371
    .local v3, "token":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    :goto_1
    const-string v2, ""

    .line 372
    .local v2, "deviceId":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getDeviceId()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 373
    invoke-virtual {v3}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    :cond_0
    move-object v5, v0

    .line 375
    check-cast v5, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v5, v4, v6, v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/ManafestManipulatorManager;->updateUriWithQueryParams(Landroid/net/Uri;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 377
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setManifestUri(Ljava/lang/String;)V

    .line 381
    .end local v1    # "adType":Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .end local v2    # "deviceId":Ljava/lang/String;
    .end local v3    # "token":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .end local v4    # "urForAds":Landroid/net/Uri;
    :cond_1
    return-object v0

    .line 365
    :cond_2
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    move-result-object v1

    goto :goto_0

    .line 369
    .restart local v1    # "adType":Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .restart local v4    # "urForAds":Landroid/net/Uri;
    :cond_3
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClientState()Lcom/comcast/playerplatform/drm/java/client/ClientState;

    move-result-object v5

    sget-object v6, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-virtual {v5, v6}, Lcom/comcast/playerplatform/drm/java/client/ClientState;->retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    move-result-object v3

    goto :goto_1
.end method

.method public destroy()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 240
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "Destroying the player"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stopAndDestroyTimers()V

    .line 243
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->clearListeners()V

    .line 245
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 246
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 247
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->destroy()V

    .line 248
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 251
    :cond_0
    iput-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->drmComplete:Z

    .line 252
    iput-boolean v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->assetLoadingComplete:Z

    .line 254
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->forceSendMessages()V

    .line 255
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->getInstance()Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->removeListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 257
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 258
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->unInitializeEspn()V

    .line 260
    :cond_1
    return-void
.end method

.method public getAutoPlay()Z
    .locals 4

    .prologue
    .line 871
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getAutoPlay() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->isAutoplay()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 873
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->isAutoplay()Z

    move-result v0

    return v0
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
    .line 750
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 4
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
    .line 841
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getAvailableBitrates() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableBitrates()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 843
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableBitrates()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAvailableClosedCaptionTracks()Ljava/util/List;
    .locals 4
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
    .line 764
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getAvailableClosedCaptionTracks() called: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 766
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAvailableProfiles()Ljava/util/List;
    .locals 4
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
    .line 851
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getAvailableBitrates() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableBitrates()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 853
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableProfiles()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBitrateRange()Lcom/comcast/playerplatform/util/android/Range;
    .locals 4

    .prologue
    .line 831
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getBitrateRange() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getBitRange()Lcom/comcast/playerplatform/util/android/Range;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 833
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getBitRange()Lcom/comcast/playerplatform/util/android/Range;

    move-result-object v0

    return-object v0
.end method

.method public getClosedCaptionsStatus()Z
    .locals 4

    .prologue
    .line 791
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getClosedCaptionsStatus() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getClosedCaptionsStatus()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 793
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getClosedCaptionsStatus()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .locals 1

    .prologue
    .line 1016
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .locals 1

    .prologue
    .line 1021
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 4

    .prologue
    .line 755
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getCurrentAudioTrack() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 757
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentBitrate()I
    .locals 4

    .prologue
    .line 821
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getCurrentBitrate() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentBitrate()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 823
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentBitrate()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1

    .prologue
    .line 893
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method public getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 4

    .prologue
    .line 771
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getCurrentClosedCaptionTrack() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 773
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPlaybackSpeed()D
    .locals 2

    .prologue
    .line 740
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPlaybackSpeed()F

    move-result v0

    float-to-double v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPosition()J
    .locals 2

    .prologue
    .line 710
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 720
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getDuration()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getEndPosition()J
    .locals 2

    .prologue
    .line 690
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getEndPosition()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getInitialBitrate()I
    .locals 4

    .prologue
    .line 811
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getInitialBitrate() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getInitialBitrate()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 813
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getInitialBitrate()I

    move-result v0

    return v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 3

    .prologue
    .line 881
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "getLogger() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 883
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 4

    .prologue
    .line 781
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getPlayerStatus() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 783
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method public getStartPosition()J
    .locals 2

    .prologue
    .line 700
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getSupportedClosedCaptionsOptions()Ljava/util/List;
    .locals 4
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
    .line 861
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getSupportedClosedCaptionsOptions() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getSupportedClosedCaptionsOptions()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 863
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getSupportedClosedCaptionsOptions()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
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
    .line 730
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getSupportedPlaybackSpeeds()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 1

    .prologue
    .line 986
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 4

    .prologue
    .line 960
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getVersion() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getPlayerPlatformVersion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 962
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getPlayerPlatformVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideoHeight()J
    .locals 2

    .prologue
    .line 1006
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoHeight()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 1011
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getVideoWidth()J
    .locals 2

    .prologue
    .line 1001
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoWidth()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getView()Landroid/view/View;
    .locals 3

    .prologue
    .line 801
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "getView() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 803
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->parentView:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 996
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->hasCC()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasDRM()Z
    .locals 1

    .prologue
    .line 991
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->hasDRM()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAdPlaying()Z
    .locals 1

    .prologue
    .line 1026
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->isAdPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public pause()V
    .locals 4

    .prologue
    .line 282
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "pause() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 284
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isPausableState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 285
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->pause()V

    .line 286
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v1, v2

    const-string v2, "pause"

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->trickPlay(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 290
    :goto_0
    return-void

    .line 288
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PAUSE:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    goto :goto_0
.end method

.method public play()V
    .locals 4

    .prologue
    .line 267
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "play() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isPlayableState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->play()V

    .line 271
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v1, v2

    const-string v2, "play"

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->trickPlay(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 275
    :goto_0
    return-void

    .line 273
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    goto :goto_0
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 978
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->removeListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 979
    return-void
.end method

.method public requestMediaProgress()V
    .locals 12

    .prologue
    .line 670
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 671
    iget-object v11, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    monitor-enter v11

    .line 672
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v2

    .line 674
    .local v2, "position":J
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPlaybackSpeed()D

    move-result-wide v4

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getStartPosition()J

    move-result-wide v6

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getDuration()J

    move-result-wide v8

    iget v10, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    invoke-virtual/range {v1 .. v10}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaProgress(JDJJI)V

    .line 679
    monitor-exit v11

    .line 681
    .end local v2    # "position":J
    :cond_0
    return-void

    .line 679
    :catchall_0
    move-exception v0

    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public seekToLive()V
    .locals 3

    .prologue
    .line 433
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "seekToLive() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 435
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->seekToLive()V

    .line 437
    :cond_0
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;J)V
    .locals 10
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # J

    .prologue
    .line 325
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 326
    .local v8, "latencyStart":J
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isMediaOpened:Z

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->mediaOpenedSent:Z

    .line 327
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->READY:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 329
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stop()V

    .line 332
    :cond_1
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 333
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->resetLocalFields()V

    .line 334
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->openingMedia(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 335
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_2

    .line 336
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-interface {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 339
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerManager:Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getType()Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->getPlayer(Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;)Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 341
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->createAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v6

    .line 345
    .local v6, "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;

    move-object v2, p0

    move-object v3, p1

    move-wide v4, p2

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$1;-><init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 356
    return-void
.end method

.method public setAutoPlay(Ljava/lang/Boolean;)V
    .locals 4
    .param p1, "flag"    # Ljava/lang/Boolean;

    .prologue
    .line 588
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setAutoPlay() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 589
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setAutoplay(Z)V

    .line 590
    return-void
.end method

.method public setBitrateParameters(Lcom/comcast/playerplatform/util/android/BitrateParameters;)V
    .locals 4
    .param p1, "bitrateParameters"    # Lcom/comcast/playerplatform/util/android/BitrateParameters;

    .prologue
    .line 650
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/BitrateParameters;->getInitialBitrate()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setInitialBitrate(I)V

    .line 651
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    new-instance v1, Lcom/comcast/playerplatform/util/android/Range;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/BitrateParameters;->getMinimumBitrate()I

    move-result v2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/util/android/BitrateParameters;->getMaximumBitrate()I

    move-result v3

    invoke-direct {v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Range;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setBitRange(Lcom/comcast/playerplatform/util/android/Range;)V

    .line 652
    return-void
.end method

.method public setBitrateRange(Lcom/comcast/playerplatform/util/android/Range;)V
    .locals 4
    .param p1, "range"    # Lcom/comcast/playerplatform/util/android/Range;

    .prologue
    .line 642
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setBitrateRange() called : range:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 643
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setBitRange(Lcom/comcast/playerplatform/util/android/Range;)V

    .line 644
    return-void
.end method

.method public setBlock(Z)V
    .locals 4
    .param p1, "flag"    # Z

    .prologue
    .line 479
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setBlock() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 482
    return-void
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 5
    .param p1, "flag"    # Z

    .prologue
    .line 499
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v2, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "setClosedCaptionsEnabled() called : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setClosedCaptionsEnabled(Z)V

    .line 503
    if-eqz p1, :cond_0

    const-string v0, "enabled"

    .line 504
    .local v0, "enabled":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v2, v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "CC "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v4

    invoke-interface {v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->mediaInfo(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 505
    return-void

    .line 503
    .end local v0    # "enabled":Ljava/lang/String;
    :cond_0
    const-string v0, "disabled"

    goto :goto_0
.end method

.method public setClosedCaptionsOptions(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V
    .locals 4
    .param p1, "options"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    .prologue
    .line 659
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setClosedCaptionsOptions() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 660
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setCaptionFormat(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V

    .line 661
    return-void
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 4
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .prologue
    .line 512
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setClosedCaptionsTrack() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 514
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V

    .line 515
    return-void
.end method

.method public setCurrentTimeUpdateInterval(I)V
    .locals 4
    .param p1, "interval"    # I

    .prologue
    .line 597
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setCurrentTimeUpdateInterval() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 599
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setUpdateInterval(I)V

    .line 601
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    .line 603
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    if-eqz v0, :cond_0

    .line 604
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->stop()V

    .line 605
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->removeClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 607
    if-lez p1, :cond_0

    .line 608
    new-instance v0, Lcom/comcast/playerplatform/util/android/Clock;

    const-string v1, "PlaybackClock"

    iget v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateInterval:I

    int-to-long v2, v2

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Clock;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    .line 609
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClockEventListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 610
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playbackClock:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->start()V

    .line 613
    :cond_0
    return-void
.end method

.method public setDimensionsOfVideo(II)V
    .locals 4
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 576
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuffer;

    const-string v3, "setDimensionsOfVideo() called : width:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, " height:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 577
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setWidth(I)V

    .line 578
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setHeight(I)V

    .line 580
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateVideoSize()V

    .line 581
    return-void
.end method

.method public setInitialBitrate(I)V
    .locals 4
    .param p1, "bitrate"    # I

    .prologue
    .line 633
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setInitialBitrate() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 634
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setInitialBitrate(I)V

    .line 635
    return-void
.end method

.method public setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 3
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 620
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "setLogger() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 622
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setLogFactory(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V

    .line 623
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 624
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V

    .line 626
    :cond_0
    return-void
.end method

.method public setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 1
    .param p1, "verbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 1065
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 1066
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V

    .line 1068
    :cond_0
    return-void
.end method

.method public setPlayerAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V
    .locals 1
    .param p1, "adBreakPolicies"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    .prologue
    .line 1060
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V

    .line 1061
    return-void
.end method

.method public setPosition(JZ)V
    .locals 11
    .param p1, "seconds"    # J
    .param p3, "skipAds"    # Z

    .prologue
    .line 444
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v2, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "setPosition() called : "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 446
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 447
    move-wide v8, p1

    .line 449
    .local v8, "seekPosition":J
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    move-result-object v1

    .line 450
    .local v1, "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    if-eqz v1, :cond_1

    .line 451
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v4

    .local v4, "currentPosition":J
    move-wide v2, p1

    move v6, p3

    .line 452
    invoke-virtual/range {v1 .. v6}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getSeekAdjustment(JJZ)J

    move-result-wide v8

    .line 453
    cmp-long v0, v8, v4

    if-nez v0, :cond_1

    .line 460
    .end local v1    # "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .end local v4    # "currentPosition":J
    .end local v8    # "seekPosition":J
    :cond_0
    :goto_0
    return-void

    .line 458
    .restart local v1    # "adManager":Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .restart local v8    # "seekPosition":J
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, v8, v9, p3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPosition(JZ)V

    goto :goto_0
.end method

.method public setPositionRelative(J)V
    .locals 5
    .param p1, "seconds"    # J

    .prologue
    .line 467
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setPositionRelative() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 469
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 470
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPositionRelative(J)V

    .line 472
    :cond_0
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 5
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 522
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v2, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "setPreferredAudioLanguage() called : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 524
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    .line 526
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "SAP changed. "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 527
    .local v0, "sapChanged":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->analytics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v2

    long-to-int v2, v2

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v3

    invoke-interface {v1, v2, v0, v3}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;->mediaInfo(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 528
    return-void
.end method

.method public setPreferredZoomSetting(Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;)V
    .locals 4
    .param p1, "zoom"    # Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .prologue
    .line 489
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setPreferredZoomSetting() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 490
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->setZoomSetting(Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;)V

    .line 491
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->updateVideoSize()V

    .line 492
    return-void
.end method

.method public setViewSecurity(Z)V
    .locals 0
    .param p1, "isSecure"    # Z

    .prologue
    .line 232
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->useSecureView:Z

    .line 233
    return-void
.end method

.method public setVolume(I)V
    .locals 4
    .param p1, "volume"    # I

    .prologue
    .line 564
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "setVolume() called : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 566
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 567
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setVolume(I)V

    .line 569
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 308
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "[com.comcast.playerplatform.primetime.android]::PlayerPlatformAPI"

    const-string v2, "stop() called"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->stopAndDestroyTimers()V

    .line 310
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->initialPlayerState:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 311
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->stop()V

    .line 315
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->currentState:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 318
    return-void
.end method
