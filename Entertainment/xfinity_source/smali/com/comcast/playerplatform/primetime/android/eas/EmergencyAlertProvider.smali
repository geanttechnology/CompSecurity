.class public Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
.super Ljava/lang/Object;
.source "EmergencyAlertProvider.java"


# static fields
.field private static instance:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;


# instance fields
.field private activeAlerts:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;"
        }
    .end annotation
.end field

.field private alertEventListener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

.field private alertReadyClockListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

.field private alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

.field private alertResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;

.field private alertServiceUrl:Ljava/net/URI;

.field private animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

.field private applicationContext:Landroid/content/Context;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private isEANActive:Z

.field private isPaused:Z

.field private isScrolling:Z

.field private listeners:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private oldAlerts:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

.field private pollingClockTick:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

.field private pollingInterval:J

.field private pollingIsReady:Z

.field private pollingTimer:Lcom/comcast/playerplatform/util/android/Clock;

.field private requestHeaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

.field private zipResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;


# direct methods
.method private constructor <init>()V
    .locals 3

    .prologue
    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$1;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertEventListener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .line 118
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingClockTick:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .line 128
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$3;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$3;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyClockListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    .line 137
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;

    .line 138
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertEventListener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;

    .line 139
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertEventListener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->zipResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler;

    .line 140
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .line 141
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    .line 142
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->oldAlerts:Ljava/util/Hashtable;

    .line 143
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    .line 144
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->requestHeaders:Ljava/util/HashMap;

    .line 145
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->requestHeaders:Ljava/util/HashMap;

    const-string v1, "Origin"

    const-string v2, "http://player.xcal.tv"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/util/ArrayList;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .param p1, "x1"    # Ljava/util/ArrayList;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->updateActiveAlerts(Ljava/util/ArrayList;)V

    return-void
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->appendPollingUriWithFips(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    return-object v0
.end method

.method static synthetic access$202(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingIsReady:Z

    return p1
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->initClock()V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->generateEasFailure(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$502(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z

    return p1
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/Vector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playAlertIfReady()V

    return-void
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/net/URI;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->requestHeaders:Ljava/util/HashMap;

    return-object v0
.end method

.method private declared-synchronized alertsNeedPlaying()Z
    .locals 1

    .prologue
    .line 321
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isPaused:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->getCurrentAlert()Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private appendPollingUriWithFips(Ljava/lang/String;)V
    .locals 1
    .param p1, "fipsCode"    # Ljava/lang/String;

    .prologue
    .line 301
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->resolve(Ljava/net/URI;Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;

    .line 302
    return-void
.end method

.method private checkForEan(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 282
    .local p1, "alerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    const/4 v2, 0x0

    .line 284
    .local v2, "isEanActive":Z
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 285
    .local v0, "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->getCurrentAlert()Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 286
    const/4 v2, 0x1

    goto :goto_0

    .line 290
    .end local v0    # "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :cond_1
    if-nez v2, :cond_2

    .line 291
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->stopEmergencyActionNotification()V

    .line 294
    :cond_2
    return-void
.end method

.method private destroyAlertReadyClock()V
    .locals 3

    .prologue
    .line 329
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    if-eqz v0, :cond_0

    .line 330
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    monitor-enter v1

    .line 331
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->stop()V

    .line 332
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyClockListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v2}, Lcom/comcast/playerplatform/util/android/Clock;->removeClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 333
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    .line 334
    monitor-exit v1

    .line 336
    :cond_0
    return-void

    .line 334
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private declared-synchronized displayNextAlert()V
    .locals 7

    .prologue
    .line 317
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->applicationContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertEventListener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ljava/util/Vector;->remove(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->displayAlert(Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;Landroid/content/Context;Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;Lcom/comcast/playerplatform/primetime/android/eas/Alert;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 318
    monitor-exit p0

    return-void

    .line 317
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private generateEasFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 349
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;

    if-eqz v1, :cond_0

    .line 350
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 351
    .local v7, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-virtual {v7, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 355
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v7    # "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :cond_0
    new-instance v5, Ljava/util/Hashtable;

    invoke-direct {v5}, Ljava/util/Hashtable;-><init>()V

    .line 356
    .local v5, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "code"

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v5, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 357
    const-string v1, "description"

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v5, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 358
    const-string v2, "alertEndpoint"

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-interface {v5, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 360
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    move-result-object v8

    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    const-string v4, "xuaEASFailure"

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericTupleMessage;-><init>(JLjava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-virtual {v8, v1}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->buildMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 364
    return-void

    :cond_1
    move-object v1, v6

    .line 358
    goto :goto_1
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    .locals 2

    .prologue
    .line 149
    const-class v1, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->instance:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    if-nez v0, :cond_0

    .line 150
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->instance:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    .line 152
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->instance:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 149
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private initAlertReadyClock()V
    .locals 4

    .prologue
    .line 339
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    if-eqz v0, :cond_0

    .line 340
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->destroyAlertReadyClock()V

    .line 343
    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/util/android/Clock;

    const-string v1, "alertReadyTimer"

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getAlertPollingInterval()I

    move-result v2

    int-to-long v2, v2

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Clock;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    .line 344
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyClockListener:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 345
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->start()V

    .line 346
    return-void
.end method

.method private declared-synchronized initClock()V
    .locals 4

    .prologue
    .line 367
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingIsReady:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isPaused:Z

    if-nez v0, :cond_0

    .line 368
    new-instance v0, Lcom/comcast/playerplatform/util/android/Clock;

    const-string v1, "alertProviderClock"

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingInterval:J

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/util/android/Clock;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingTimer:Lcom/comcast/playerplatform/util/android/Clock;

    .line 369
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingTimer:Lcom/comcast/playerplatform/util/android/Clock;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingClockTick:Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/Clock;->addClockEventListener(Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;)V

    .line 370
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingTimer:Lcom/comcast/playerplatform/util/android/Clock;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Clock;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 372
    :cond_0
    monitor-exit p0

    return-void

    .line 367
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized playAlertIfReady()V
    .locals 1

    .prologue
    .line 305
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertsNeedPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 306
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerViewActive()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 307
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isScrolling:Z

    .line 308
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->destroyAlertReadyClock()V

    .line 309
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->displayNextAlert()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 314
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 310
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertReadyTimer:Lcom/comcast/playerplatform/util/android/Clock;

    if-nez v0, :cond_0

    .line 311
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->initAlertReadyClock()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 305
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private playerViewActive()Z
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private stopEmergencyActionNotification()V
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->stopEmergencyActionNotification()V

    .line 298
    return-void
.end method

.method private declared-synchronized updateActiveAlerts(Ljava/util/ArrayList;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/eas/Alert;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 245
    .local p1, "alerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    monitor-enter p0

    :try_start_0
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->getCurrentAlert()Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->animationManager:Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->getCurrentAlert()Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->isEmergencyActionNotification()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 246
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->checkForEan(Ljava/util/ArrayList;)V

    .line 249
    :cond_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_5

    .line 251
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 253
    .local v1, "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->oldAlerts:Ljava/util/Hashtable;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/Hashtable;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 256
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->isEmergencyActionNotification()Z

    move-result v5

    if-eqz v5, :cond_4

    iget-boolean v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->isEANActive:Z

    if-nez v5, :cond_4

    .line 257
    const/4 v2, 0x0

    .line 258
    .local v2, "alreadyInActive":Z
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    invoke-virtual {v5}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 259
    .local v0, "activeAlertObject":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 260
    const/4 v2, 0x1

    .line 264
    .end local v0    # "activeAlertObject":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :cond_3
    if-nez v2, :cond_1

    .line 265
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v1}, Ljava/util/Vector;->add(ILjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 245
    .end local v1    # "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    .end local v2    # "alreadyInActive":Z
    .end local v4    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 270
    .restart local v1    # "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :cond_4
    :try_start_1
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->oldAlerts:Ljava/util/Hashtable;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 271
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->activeAlerts:Ljava/util/Vector;

    invoke-virtual {v5, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 277
    .end local v1    # "alert":Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    :cond_5
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playAlertIfReady()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 278
    monitor-exit p0

    return-void
.end method


# virtual methods
.method public removeListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 240
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->listeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    .line 241
    return-void
.end method

.method public setCustomSettings(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;)V
    .locals 2
    .param p1, "settings"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    .prologue
    .line 227
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    .line 228
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getAlertPollingInterval()I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->pollingInterval:J

    .line 229
    return-void
.end method

.method public setPlayer(Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;)V
    .locals 0
    .param p1, "playerPlatform"    # Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    .line 197
    return-void
.end method
