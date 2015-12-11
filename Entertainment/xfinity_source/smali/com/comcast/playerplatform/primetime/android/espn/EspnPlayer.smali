.class public Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;
.super Ljava/lang/Object;
.source "EspnPlayer.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/player/Player;


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private applicationContext:Landroid/content/Context;

.field private catalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

.field private cookieManager:Ljava/net/CookieManager;

.field private currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

.field private firstAuthAttempt:Z

.field private playbackListener:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

.field private playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

.field private primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

.field private tokenRefreshRunnable:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;)V
    .locals 3
    .param p1, "applicationContext"    # Landroid/content/Context;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p3, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z

    .line 407
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$4;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackListener:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .line 501
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$5;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->tokenRefreshRunnable:Ljava/lang/Runnable;

    .line 66
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->applicationContext:Landroid/content/Context;

    .line 67
    const/4 v0, 0x0

    .line 68
    .local v0, "useNativePlayer":Z
    if-eqz v0, :cond_0

    .line 69
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    invoke-direct {v1, p1}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 74
    :goto_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V

    .line 76
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackListener:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-direct {v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;-><init>(Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    .line 78
    new-instance v1, Ljava/net/CookieManager;

    invoke-direct {v1}, Ljava/net/CookieManager;-><init>()V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;

    .line 79
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;

    invoke-static {v1}, Ljava/net/CookieHandler;->setDefault(Ljava/net/CookieHandler;)V

    .line 80
    return-void

    .line 72
    :cond_0
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    const/4 v2, 0x0

    invoke-direct {v1, p1, p2, p3, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;-><init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/drm/java/service/LicenseService;)V

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->isEspnReady()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->tokenRefreshRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->checkForActiveChannelEvents()V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z

    return v0
.end method

.method static synthetic access$402(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 51
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z

    return p1
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    return-object v0
.end method

.method static synthetic access$600()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->logger:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    return-object v0
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)Ljava/net/CookieManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->cookieManager:Ljava/net/CookieManager;

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;
    .param p1, "x1"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->updatePrimetime(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    return-void
.end method

.method private checkForActiveChannelEvents()V
    .locals 5

    .prologue
    .line 141
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->instantiate()Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->catalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    .line 143
    const/4 v0, 0x0

    .line 144
    .local v0, "eventId":Ljava/lang/String;
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->isChannelListAvailable()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 145
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->catalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getLiveEvents()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .line 146
    .local v1, "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getNetworkId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 147
    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v0

    .line 153
    .end local v1    # "events":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_1
    if-eqz v0, :cond_2

    .line 154
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v3, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setEventId(Ljava/lang/String;)V

    .line 155
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v3, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;)V

    .line 159
    :goto_0
    return-void

    .line 157
    :cond_2
    const/16 v3, 0x8

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "Event can not be found"

    invoke-virtual {p0, v3, v4}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private isChannelListAvailable()Z
    .locals 8

    .prologue
    const/4 v4, 0x1

    .line 162
    new-instance v3, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v3, v4}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 164
    .local v3, "waitForConfig":Ljava/util/concurrent/CountDownLatch;
    new-instance v2, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;

    invoke-direct {v2, p0, v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Ljava/util/concurrent/CountDownLatch;)V

    .line 172
    .local v2, "mReceiver":Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    const-string v5, "com.espn.action.LIVE_EVENT_UPDATED"

    invoke-direct {v1, v5}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 173
    .local v1, "intentFilter":Landroid/content/IntentFilter;
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->applicationContext:Landroid/content/Context;

    invoke-virtual {v5, v2, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 174
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->catalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getLiveEvents()Ljava/util/ArrayList;

    .line 175
    const/4 v0, 0x0

    .line 177
    .local v0, "finished":Z
    :try_start_0
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->catalogManager:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;->getLiveEvents()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-gtz v5, :cond_0

    const-wide/16 v6, 0x7

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, v6, v7, v5}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    if-eqz v5, :cond_1

    :cond_0
    move v0, v4

    .line 182
    :goto_0
    return v0

    .line 177
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 178
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method private isEspnReady()Z
    .locals 10

    .prologue
    const/4 v6, 0x1

    .line 186
    new-instance v5, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v5, v6}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 188
    .local v5, "waitForConfig":Ljava/util/concurrent/CountDownLatch;
    new-instance v4, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$3;

    invoke-direct {v4, p0, v5}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$3;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Ljava/util/concurrent/CountDownLatch;)V

    .line 196
    .local v4, "mReceiver":Landroid/content/BroadcastReceiver;
    new-instance v3, Landroid/content/IntentFilter;

    const-string v7, "com.espn.action.CONFIG_UPDATED"

    invoke-direct {v3, v7}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 197
    .local v3, "intentFilter":Landroid/content/IntentFilter;
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->applicationContext:Landroid/content/Context;

    invoke-virtual {v7, v4, v3}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 199
    const/4 v1, 0x0

    .line 201
    .local v1, "finished":Z
    :try_start_0
    new-instance v2, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v2}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 202
    .local v2, "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->isEspnReady()Z

    move-result v7

    if-nez v7, :cond_0

    const-wide/16 v8, 0x7

    sget-object v7, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v5, v8, v9, v7}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v7

    if-eqz v7, :cond_1

    :cond_0
    move v1, v6

    .line 207
    .end local v2    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    :goto_0
    return v1

    .line 202
    .restart local v2    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 203
    .end local v2    # "helper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    :catch_0
    move-exception v0

    .line 204
    .local v0, "e":Ljava/lang/InterruptedException;
    const/4 v6, 0x2

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    const-string v7, "Failed to configure ESPN playback."

    invoke-virtual {p0, v6, v7}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private declared-synchronized updatePrimetime(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 2
    .param p1, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 512
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getPlaybackUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getPlaybackUrl()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 515
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getPlaybackUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setManifestUri(Ljava/lang/String;)V

    .line 516
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->NO_DRM:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setDrmWorkflow(Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)V

    .line 517
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getAuthCookieName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->authCookieName:Ljava/lang/String;

    .line 518
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getToken()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->authCookieValue:Ljava/lang/String;

    .line 520
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$6;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 527
    :cond_0
    monitor-exit p0

    return-void

    .line 512
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 357
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 358
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 359
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    if-eqz v0, :cond_0

    .line 85
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->playbackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->releaseSession()V

    .line 87
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->destroy()V

    .line 88
    return-void
.end method

.method public getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1

    .prologue
    .line 347
    const/4 v0, 0x0

    return-object v0
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
    .line 277
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 1
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
    .line 322
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableBitrates()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAvailableClosedCaptionTracks()Ljava/util/List;
    .locals 1
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
    .line 287
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAvailableProfiles()Ljava/util/List;
    .locals 1
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
    .line 317
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getAvailableProfiles()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getClosedCaptionsStatus()Z
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getClosedCaptionsStatus()Z

    move-result v0

    return v0
.end method

.method public getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentBitrate()I
    .locals 1

    .prologue
    .line 312
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentBitrate()I

    move-result v0

    return v0
.end method

.method public getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentPlaybackSpeed()F
    .locals 1

    .prologue
    .line 272
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentPosition()J
    .locals 2

    .prologue
    .line 257
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentPosition()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 262
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getEndPosition()J
    .locals 2

    .prologue
    .line 252
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getEndPosition()J

    move-result-wide v0

    return-wide v0
.end method

.method public getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    .locals 1

    .prologue
    .line 404
    const/4 v0, 0x0

    return-object v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1

    .prologue
    .line 337
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    return-object v0
.end method

.method public getSupportedClosedCaptionsOptions()Ljava/util/List;
    .locals 1
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
    .line 327
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getSupportedClosedCaptionsOptions()Ljava/util/List;

    move-result-object v0

    return-object v0
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
    .line 267
    const/4 v0, 0x0

    return-object v0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 352
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideoHeight()J
    .locals 2

    .prologue
    .line 389
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoHeight()J

    move-result-wide v0

    return-wide v0
.end method

.method public getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v0

    return-object v0
.end method

.method public getVideoWidth()J
    .locals 2

    .prologue
    .line 384
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getVideoWidth()J

    move-result-wide v0

    return-wide v0
.end method

.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 379
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->hasCC()Z

    move-result v0

    return v0
.end method

.method public hasDRM()Z
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->hasDRM()Z

    move-result v0

    return v0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->pause()V

    .line 98
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->play()V

    .line 93
    return-void
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 363
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 364
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 365
    return-void
.end method

.method public seekToLive()V
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->seekToLive()V

    .line 213
    return-void
.end method

.method public sendMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 529
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 530
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->eventListener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 532
    :cond_0
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 4
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # J
    .param p4, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    .line 107
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->firstAuthAttempt:Z

    .line 108
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 110
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, " "

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setChannelName(Ljava/lang/String;)V

    .line 113
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 138
    :goto_0
    return-void

    .line 116
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$1;-><init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 1
    .param p1, "flag"    # Z

    .prologue
    .line 227
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setClosedCaptionsEnabled(Z)V

    .line 228
    return-void
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 1
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .prologue
    .line 232
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V

    .line 233
    return-void
.end method

.method public setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 0
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 333
    return-void
.end method

.method public setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 1
    .param p1, "verbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 399
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V

    .line 400
    return-void
.end method

.method public setPosition(JZ)V
    .locals 1
    .param p1, "seconds"    # J
    .param p3, "skipAds"    # Z

    .prologue
    .line 217
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPosition(JZ)V

    .line 218
    return-void
.end method

.method public setPositionRelative(J)V
    .locals 1
    .param p1, "seconds"    # J

    .prologue
    .line 222
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPositionRelative(J)V

    .line 223
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 1
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 237
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    .line 238
    return-void
.end method

.method public setVolume(I)V
    .locals 1
    .param p1, "volume"    # I

    .prologue
    .line 247
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setVolume(I)V

    .line 248
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->stop()V

    .line 103
    return-void
.end method
