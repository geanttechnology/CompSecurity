.class public Lcom/conviva/session/Session;
.super Ljava/lang/Object;


# instance fields
.field private _api:Lcom/conviva/platforms/PlatformApi;

.field private _clv:Ljava/lang/String;

.field private _contentInfo:Lcom/conviva/ConvivaContentInfo;

.field private _eventQueue:Lcom/conviva/session/EventQueue;

.field private _heartbeatSequenceNumber:I

.field private _monitor:Lcom/conviva/monitor/Monitor;

.field private _nativeReprTags:Ljava/util/Map;
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

.field private _sessionId:I

.field private _settings:Lcom/conviva/utils/Settings;

.field private _startTimeMs:D

.field private _utils:Lcom/conviva/utils/PlatformUtils;


# direct methods
.method public constructor <init>(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;Z)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/conviva/ConvivaContentInfo;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;Z)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iput-object v0, p0, Lcom/conviva/session/Session;->_nativeReprTags:Ljava/util/Map;

    iput-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iput-object v0, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    iput-object v0, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iput-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    iput-object v0, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    iput v2, p0, Lcom/conviva/session/Session;->_sessionId:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/conviva/session/Session;->_startTimeMs:D

    iput v2, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    invoke-static {}, Lcom/conviva/utils/LivePassVersion;->getVersionStr()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/session/Session;->_clv:Ljava/lang/String;

    invoke-static {}, Lcom/conviva/utils/PlatformUtils;->getInstance()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iput-object p2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->randInt()I

    move-result v0

    iput v0, p0, Lcom/conviva/session/Session;->_sessionId:I

    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "tags should not be null"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, v0, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    const-string v3, "null"

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getSettings()Lcom/conviva/utils/Settings;

    move-result-object v0

    iget-object v0, v0, Lcom/conviva/utils/Settings;->platformApiName:Ljava/lang/String;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    :try_start_0
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_3

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    const-class v3, Ljava/lang/Object;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/conviva/platforms/PlatformApi;

    iput-object v0, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getSettings()Lcom/conviva/utils/Settings;

    move-result-object v0

    iget-object v0, v0, Lcom/conviva/utils/Settings;->platformApi:Lcom/conviva/platforms/PlatformApi;

    iput-object v0, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    :cond_4
    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->tags:Ljava/util/Map;

    iput-object v0, p0, Lcom/conviva/session/Session;->_nativeReprTags:Ljava/util/Map;

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getSettings()Lcom/conviva/utils/Settings;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    new-instance v0, Lcom/conviva/session/EventQueue;

    invoke-direct {v0}, Lcom/conviva/session/EventQueue;-><init>()V

    iput-object v0, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    if-nez p4, :cond_5

    new-instance v0, Lcom/conviva/monitor/Monitor;

    iget-object v2, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    iget-object v3, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget v5, p0, Lcom/conviva/session/Session;->_sessionId:I

    iget-object v6, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    move-object v1, p1

    move-object v4, p3

    invoke-direct/range {v0 .. v6}, Lcom/conviva/monitor/Monitor;-><init>(Ljava/lang/Object;Lcom/conviva/session/EventQueue;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;ILcom/conviva/platforms/PlatformApi;)V

    iput-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    :cond_5
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method static synthetic access$000(Lcom/conviva/session/Session;)V
    .locals 0

    invoke-direct {p0}, Lcom/conviva/session/Session;->sendHeartbeat()V

    return-void
.end method

.method static synthetic access$100(Lcom/conviva/session/Session;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/conviva/session/Session;->postHeartbeat(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Lcom/conviva/session/Session;)Lcom/conviva/utils/PlatformUtils;
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    return-object v0
.end method

.method static synthetic access$300(Lcom/conviva/session/Session;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/conviva/session/Session;->onHeartbeatResponse(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/conviva/session/Session;)I
    .locals 1

    iget v0, p0, Lcom/conviva/session/Session;->_sessionId:I

    return v0
.end method

.method static synthetic access$500(Lcom/conviva/session/Session;)Lcom/conviva/utils/Settings;
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    return-object v0
.end method

.method static synthetic access$600(Lcom/conviva/session/Session;Z)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/conviva/session/Session;->createHBTimer(Z)V

    return-void
.end method

.method private createHBTimer(Z)V
    .locals 5

    const/4 v0, 0x0

    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget v0, v0, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    :cond_0
    iget-object v1, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    new-instance v2, Lcom/conviva/session/Session$1;

    invoke-direct {v2, p0}, Lcom/conviva/session/Session$1;-><init>(Lcom/conviva/session/Session;)V

    iget-object v3, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget v3, v3, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    const-string v4, "sendHeartbeat"

    invoke-interface {v1, v2, v0, v3, v4}, Lcom/conviva/platforms/PlatformApi;->createTimer(Ljava/util/TimerTask;IILjava/lang/String;)V

    return-void
.end method

.method private encodeHeartbeat(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/conviva/utils/CallableWithParameters$With1",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Lcom/conviva/session/Session$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/conviva/session/Session$3;-><init>(Lcom/conviva/session/Session;Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V

    const-string v2, "encodeHeartbeat"

    invoke-virtual {v0, v1, v2}, Lcom/conviva/utils/PlatformUtils;->runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V

    return-void
.end method

.method private makeHeartbeat()Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    invoke-virtual {v0}, Lcom/conviva/session/EventQueue;->flushEvents()Ljava/util/List;

    move-result-object v0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    const-string v2, "t"

    const-string v3, "CwsSessionHb"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "evs"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "cid"

    iget-object v2, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget-object v2, v2, Lcom/conviva/utils/Settings;->customerKey:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "clid"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iget-object v2, v2, Lcom/conviva/utils/PlatformUtils;->clientId:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "sid"

    iget v2, p0, Lcom/conviva/session/Session;->_sessionId:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "seq"

    iget v2, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "pver"

    iget-object v2, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget-object v2, v2, Lcom/conviva/utils/Settings;->protocolVersion:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "clv"

    iget-object v2, p0, Lcom/conviva/session/Session;->_clv:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "iid"

    iget-object v2, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget v2, v2, Lcom/conviva/utils/Settings;->clientInstanceId:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getPlatformMetadata()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v2, "pm"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    const-string v0, "tags"

    iget-object v2, p0, Lcom/conviva/session/Session;->_nativeReprTags:Ljava/util/Map;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const-string v0, "Android"

    if-eqz v0, :cond_1

    const-string v0, "pt"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const-string v2, "Android"

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iget-object v0, v0, Lcom/conviva/utils/PlatformUtils;->_PLATFORM_VER:Ljava/lang/String;

    if-eqz v0, :cond_2

    const-string v0, "ptv"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iget-object v2, v2, Lcom/conviva/utils/PlatformUtils;->_PLATFORM_VER:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->viewerId:Ljava/lang/String;

    if-eqz v0, :cond_3

    const-string v0, "vid"

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->viewerId:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-eqz v0, :cond_6

    const-string v0, "an"

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->assetName:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "lv"

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->isLive:Ljava/lang/Boolean;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    invoke-virtual {v0, v1}, Lcom/conviva/monitor/Monitor;->updateHeartbeat(Ljava/util/Map;)V

    :goto_0
    iget-object v0, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v0, v0, Lcom/conviva/ConvivaContentInfo;->playerName:Ljava/lang/String;

    if-eqz v0, :cond_4

    const-string v0, "pn"

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->playerName:Ljava/lang/String;

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_4
    iget-object v0, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget-boolean v0, v0, Lcom/conviva/utils/Settings;->sendLogs:Z

    if-eqz v0, :cond_5

    const-string v0, "lg"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    iget v3, p0, Lcom/conviva/session/Session;->_sessionId:I

    invoke-virtual {v2, v3}, Lcom/conviva/utils/PlatformUtils;->getLogs(I)Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    const-string v0, "st"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v2}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    iget-wide v4, p0, Lcom/conviva/session/Session;->_startTimeMs:D

    sub-double/2addr v2, v4

    double-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "cts"

    iget-object v2, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v2}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    div-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v0, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    return-object v1

    :cond_6
    const-string v0, "sf"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private onHeartbeatResponse(Ljava/lang/String;)V
    .locals 3

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Lcom/conviva/session/Session$5;

    invoke-direct {v1, p0, p1}, Lcom/conviva/session/Session$5;-><init>(Lcom/conviva/session/Session;Ljava/lang/String;)V

    const-string v2, "onHeartbeatResponse"

    invoke-virtual {v0, v1, v2}, Lcom/conviva/utils/PlatformUtils;->runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V

    return-void
.end method

.method private postHeartbeat(Ljava/lang/String;)V
    .locals 6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget-object v1, v1, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/session/Session;->_settings:Lcom/conviva/utils/Settings;

    iget-object v1, v1, Lcom/conviva/utils/Settings;->gatewayPath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v4, "application/json"

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Send HB["

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v3, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "]"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget v3, p0, Lcom/conviva/session/Session;->_sessionId:I

    invoke-virtual {v0, v1, v3}, Lcom/conviva/utils/PlatformUtils;->logSession(Ljava/lang/String;I)V

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "heartbeat to be sent: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->logConsole(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    new-instance v5, Lcom/conviva/session/Session$4;

    invoke-direct {v5, p0}, Lcom/conviva/session/Session$4;-><init>(Lcom/conviva/session/Session;)V

    move-object v3, p1

    invoke-virtual/range {v0 .. v5}, Lcom/conviva/utils/PlatformUtils;->httpRequest(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V

    return-void
.end method

.method private sendHeartbeat()V
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    invoke-virtual {v1}, Lcom/conviva/session/EventQueue;->size()I

    move-result v1

    if-lez v1, :cond_3

    const/4 v0, 0x1

    :cond_0
    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->inSleepingMode()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->isVisible()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_4

    :cond_1
    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "Do not send out heartbeat: player is sleeping or not visible"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    :cond_2
    :goto_0
    return-void

    :cond_3
    iget-object v1, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-nez v1, :cond_0

    goto :goto_0

    :cond_4
    invoke-direct {p0}, Lcom/conviva/session/Session;->makeHeartbeat()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_2

    new-instance v1, Lcom/conviva/session/Session$2;

    invoke-direct {v1, p0}, Lcom/conviva/session/Session$2;-><init>(Lcom/conviva/session/Session;)V

    invoke-direct {p0, v0, v1}, Lcom/conviva/session/Session;->encodeHeartbeat(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V

    goto :goto_0
.end method


# virtual methods
.method public attachStreamer(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    invoke-virtual {v0, p1}, Lcom/conviva/monitor/Monitor;->attachStreamer(Ljava/lang/Object;)V

    return-void
.end method

.method public cleanup()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "Schedule the last hb before session cleanup"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/conviva/session/Session;->sendSessionEndEvent()V

    :cond_0
    invoke-direct {p0}, Lcom/conviva/session/Session;->sendHeartbeat()V

    iget-object v0, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    invoke-interface {v0}, Lcom/conviva/platforms/PlatformApi;->cleanup()V

    iput-object v2, p0, Lcom/conviva/session/Session;->_api:Lcom/conviva/platforms/PlatformApi;

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    invoke-virtual {v0}, Lcom/conviva/monitor/Monitor;->cleanup()V

    iput-object v2, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    :cond_1
    return-void
.end method

.method public pauseMonitor()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    invoke-virtual {v0}, Lcom/conviva/monitor/Monitor;->pauseMonitor()V

    return-void
.end method

.method public reportError(Lcom/conviva/StreamerError;)V
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    invoke-virtual {v0, p1}, Lcom/conviva/monitor/Monitor;->OnError(Lcom/conviva/StreamerError;)V

    :cond_0
    return-void
.end method

.method public sendSessionEndEvent()V
    .locals 8

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "cws.sendSessionEndEvent()"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iget-object v1, p0, Lcom/conviva/session/Session;->_eventQueue:Lcom/conviva/session/EventQueue;

    const-string v2, "CwsSessionEndEvent"

    iget-object v3, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v3}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v4

    iget-wide v6, p0, Lcom/conviva/session/Session;->_startTimeMs:D

    sub-double/2addr v4, v6

    double-to-int v3, v4

    invoke-virtual {v1, v2, v0, v3}, Lcom/conviva/session/EventQueue;->enqueueEvent(Ljava/lang/String;Ljava/util/Map;I)V

    return-void
.end method

.method public start()V
    .locals 4

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Session.start assetName="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/conviva/session/Session;->_contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v2, v2, Lcom/conviva/ConvivaContentInfo;->assetName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/session/Session;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/conviva/session/Session;->_startTimeMs:D

    :try_start_0
    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/session/Session;->_monitor:Lcom/conviva/monitor/Monitor;

    iget-wide v2, p0, Lcom/conviva/session/Session;->_startTimeMs:D

    invoke-virtual {v0, v2, v3}, Lcom/conviva/monitor/Monitor;->start(D)V

    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lcom/conviva/session/Session;->_heartbeatSequenceNumber:I

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/conviva/session/Session;->createHBTimer(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
