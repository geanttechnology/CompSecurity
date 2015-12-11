.class public Lcom/conviva/LivePass;
.super Ljava/lang/Object;


# static fields
.field private static _globalSessionId:I

.field private static _sessionFactory:Lcom/conviva/session/SessionFactory;

.field private static _settings:Lcom/conviva/utils/Settings;

.field private static _toggleTracesSet:Ljava/lang/Boolean;

.field private static _toggleTracesSetValue:Ljava/lang/Boolean;

.field private static _utils:Lcom/conviva/utils/PlatformUtils;

.field private static readyState:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;

    sput-object v2, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    sput-object v2, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    sput-object v2, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->_toggleTracesSet:Ljava/lang/Boolean;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->_toggleTracesSetValue:Ljava/lang/Boolean;

    const/4 v0, -0x1

    sput v0, Lcom/conviva/LivePass;->_globalSessionId:I

    return-void
.end method

.method static synthetic access$000()Ljava/lang/Boolean;
    .locals 1

    sget-object v0, Lcom/conviva/LivePass;->_toggleTracesSet:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$100()Lcom/conviva/utils/Settings;
    .locals 1

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/Boolean;
    .locals 1

    sget-object v0, Lcom/conviva/LivePass;->_toggleTracesSetValue:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$300()Lcom/conviva/utils/PlatformUtils;
    .locals 1

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    return-object v0
.end method

.method static synthetic access$400()Lcom/conviva/session/SessionFactory;
    .locals 1

    sget-object v0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    return-object v0
.end method

.method static synthetic access$402(Lcom/conviva/session/SessionFactory;)Lcom/conviva/session/SessionFactory;
    .locals 0

    sput-object p0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    return-object p0
.end method

.method static synthetic access$502(Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    sput-object p0, Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;

    return-object p0
.end method

.method public static attachStreamer(ILjava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    sget-object v0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    invoke-virtual {v0, p0}, Lcom/conviva/session/SessionFactory;->getSession(I)Lcom/conviva/session/Session;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "LivePass.attachStreamer(): session not found"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {v0, p1}, Lcom/conviva/session/Session;->attachStreamer(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static cleanupSession(I)V
    .locals 3

    sget-object v0, Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Lcom/conviva/LivePass$8;

    invoke-direct {v1, p0}, Lcom/conviva/LivePass$8;-><init>(I)V

    const-string v2, "Livepass.cleanupSession"

    invoke-virtual {v0, v1, v2}, Lcom/conviva/utils/PlatformUtils;->runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static createSession(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;)I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/conviva/LivePass;->createSessionWorker(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;Z)I

    move-result v0

    return v0
.end method

.method private static createSessionWorker(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;Z)I
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
            ">;Z)I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    sget-object v0, Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "createSession before LivePass.init"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->ping(Ljava/lang/String;)V

    :cond_0
    new-instance v0, Ljava/lang/Exception;

    const-string v1, "createSession before LivePass.init"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    iget-object v0, v0, Lcom/conviva/utils/Settings;->customerKey:Ljava/lang/String;

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/Exception;

    const-string v1, "Cannot create session: customerKey is null"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    sget-object v0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    invoke-virtual {v0}, Lcom/conviva/session/SessionFactory;->newSessionId()I

    move-result v4

    sget-object v6, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v0, Lcom/conviva/LivePass$3;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/conviva/LivePass$3;-><init>(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;IZ)V

    const-string v1, "LivePass.createSession"

    invoke-virtual {v6, v0, v1}, Lcom/conviva/utils/PlatformUtils;->runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V

    return v4
.end method

.method public static init(Ljava/lang/String;Landroid/content/Context;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/conviva/LivePass;->initWithSettings(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;)V

    return-void
.end method

.method public static initWithSettings(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/Exception;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid customerKey: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    sget-object v0, Lcom/conviva/LivePass;->readyState:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    :goto_0
    return-void

    :cond_2
    invoke-static {p1, p2}, Lcom/conviva/utils/Utils;->CreateUtils(Ljava/util/Map;Landroid/content/Context;)Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->startFetchClientId()V

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getSettings()Lcom/conviva/utils/Settings;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    sget-object v1, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v1}, Lcom/conviva/utils/PlatformUtils;->randInt()I

    move-result v1

    iput v1, v0, Lcom/conviva/utils/Settings;->clientInstanceId:I

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    iput-object p0, v0, Lcom/conviva/utils/Settings;->customerKey:Ljava/lang/String;

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/conviva/utils/Settings;->sendLogs:Z

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    new-instance v1, Lcom/conviva/LivePass$1;

    invoke-direct {v1}, Lcom/conviva/LivePass$1;-><init>()V

    const-string v2, "LivePass.init"

    invoke-virtual {v0, v1, v2}, Lcom/conviva/utils/PlatformUtils;->runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static pauseMonitor(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    sget-object v0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    invoke-virtual {v0, p0}, Lcom/conviva/session/SessionFactory;->getSession(I)Lcom/conviva/session/Session;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "LivePass.pauseSession(): session not found"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {v0}, Lcom/conviva/session/Session;->pauseMonitor()V

    goto :goto_0
.end method

.method public static reportError(ILjava/lang/String;I)V
    .locals 2

    sget-object v0, Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;

    invoke-virtual {v0, p0}, Lcom/conviva/session/SessionFactory;->getSession(I)Lcom/conviva/session/Session;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;

    const-string v1, "LivePass.reportError(): session not found"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2}, Lcom/conviva/StreamerError;->makeUnscopedError(Ljava/lang/String;I)Lcom/conviva/StreamerError;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/conviva/session/Session;->reportError(Lcom/conviva/StreamerError;)V

    goto :goto_0
.end method

.method public static toggleTraces(Ljava/lang/Boolean;)V
    .locals 2

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/conviva/LivePass;->_toggleTracesSet:Ljava/lang/Boolean;

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/conviva/LivePass;->_settings:Lcom/conviva/utils/Settings;

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    iput-boolean v1, v0, Lcom/conviva/utils/Settings;->enableLogging:Z

    :goto_0
    return-void

    :cond_0
    sput-object p0, Lcom/conviva/LivePass;->_toggleTracesSetValue:Ljava/lang/Boolean;

    goto :goto_0
.end method
