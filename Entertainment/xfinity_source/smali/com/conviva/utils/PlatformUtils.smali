.class public abstract Lcom/conviva/utils/PlatformUtils;
.super Ljava/lang/Object;


# static fields
.field protected static _instance:Lcom/conviva/utils/PlatformUtils;

.field private static logBuffer:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected final DEFAULT_CLIENT_ID:Ljava/lang/String;

.field private final MAX_SIZE_LOGBUFFER:I

.field public final _PLATFORM:Ljava/lang/String;

.field public _PLATFORM_VER:Ljava/lang/String;

.field protected final _TAG:Ljava/lang/String;

.field private _isSendingPing:Ljava/lang/Boolean;

.field private _pingUrl:Ljava/lang/String;

.field protected _referenceCount:I

.field protected _settings:Lcom/conviva/utils/Settings;

.field public clientId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/conviva/utils/PlatformUtils;->_instance:Lcom/conviva/utils/PlatformUtils;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    sput-object v0, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    return-void
.end method

.method protected constructor <init>(Lcom/conviva/utils/Settings;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v2, p0, Lcom/conviva/utils/PlatformUtils;->_referenceCount:I

    iput-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_settings:Lcom/conviva/utils/Settings;

    const-string v0, "0"

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->DEFAULT_CLIENT_ID:Ljava/lang/String;

    const-string v0, "0"

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->clientId:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_pingUrl:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;

    const-string v0, "Android"

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_PLATFORM:Ljava/lang/String;

    iput-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_PLATFORM_VER:Ljava/lang/String;

    const-string v0, "CONVIVA"

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_TAG:Ljava/lang/String;

    const/16 v0, 0x20

    iput v0, p0, Lcom/conviva/utils/PlatformUtils;->MAX_SIZE_LOGBUFFER:I

    iput-object p1, p0, Lcom/conviva/utils/PlatformUtils;->_settings:Lcom/conviva/utils/Settings;

    const/4 v0, 0x1

    iput v0, p0, Lcom/conviva/utils/PlatformUtils;->_referenceCount:I

    iput-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_pingUrl:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;

    sput-object p0, Lcom/conviva/utils/PlatformUtils;->_instance:Lcom/conviva/utils/PlatformUtils;

    return-void
.end method

.method public static getInstance()Lcom/conviva/utils/PlatformUtils;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    sget-object v0, Lcom/conviva/utils/PlatformUtils;->_instance:Lcom/conviva/utils/PlatformUtils;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Exception;

    const-string v1, "CreateUtils module has not been called"

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/conviva/utils/PlatformUtils;->_instance:Lcom/conviva/utils/PlatformUtils;

    return-object v0
.end method

.method private initPing()V
    .locals 3

    iget-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_pingUrl:Ljava/lang/String;

    if-nez v0, :cond_2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/conviva/utils/PlatformUtils;->clientId:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/conviva/utils/PlatformUtils;->clientId:Ljava/lang/String;

    const/16 v2, 0x2e

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    if-ltz v1, :cond_0

    iget-object v0, p0, Lcom/conviva/utils/PlatformUtils;->clientId:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    :cond_0
    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/Integer;

    invoke-virtual {p0}, Lcom/conviva/utils/PlatformUtils;->randInt()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/conviva/utils/PlatformUtils;->_settings:Lcom/conviva/utils/Settings;

    iget-object v2, v2, Lcom/conviva/utils/Settings;->pingUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "uuid="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&comp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_settings:Lcom/conviva/utils/Settings;

    iget-object v1, v1, Lcom/conviva/utils/Settings;->pingComponentName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_pingUrl:Ljava/lang/String;

    :cond_2
    return-void
.end method

.method private onUncaughtException(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 3

    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Uncaught exception: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->ping(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Caught exception while sending ping: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private urlEncodeString(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    const-string v0, "UTF-8"

    invoke-static {p1, v0}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public epochTimeMs()D
    .locals 2

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    long-to-double v0, v0

    return-wide v0
.end method

.method public err(Ljava/lang/String;)V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ERROR: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    return-void
.end method

.method public getLogs(I)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    sget-object v0, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    sput-object v1, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    return-object v0
.end method

.method public abstract getPlatformMetadata()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public getSettings()Lcom/conviva/utils/Settings;
    .locals 1

    iget-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_settings:Lcom/conviva/utils/Settings;

    return-object v0
.end method

.method public abstract httpRequest(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Boolean;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/conviva/utils/CallableWithParameters$With1",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract inSleepingMode()Ljava/lang/Boolean;
.end method

.method public abstract isVisible()Ljava/lang/Boolean;
.end method

.method public jsonDecode(Ljava/lang/String;)Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    :try_start_0
    invoke-static {p1}, Lorg/json/simple/JSONValue;->parse(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to decode json string: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public jsonEncode(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V
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

    :try_start_0
    invoke-static {p1}, Lorg/json/simple/JSONValue;->toJSONString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/conviva/utils/CallableWithParameters$With1;->exec(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to encode json object: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public log(Ljava/lang/String;)V
    .locals 7

    const/4 v6, 0x0

    invoke-virtual {p0, p1}, Lcom/conviva/utils/PlatformUtils;->logConsole(Ljava/lang/String;)V

    const-string v0, "%.3f"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/conviva/utils/PlatformUtils;->epochTimeMs()D

    move-result-wide v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    div-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    const/16 v2, 0x20

    if-lt v1, v2, :cond_0

    sget-object v1, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    invoke-interface {v1, v6}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    :cond_0
    sget-object v1, Lcom/conviva/utils/PlatformUtils;->logBuffer:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public abstract logConsole(Ljava/lang/String;)V
.end method

.method public logSession(Ljava/lang/String;I)V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "sid="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    return-void
.end method

.method public parseInt(Ljava/lang/String;I)I
    .locals 1

    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result p2

    :goto_0
    return p2

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public ping(Ljava/lang/String;)V
    .locals 7

    const/4 v6, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;

    invoke-direct {p0}, Lcom/conviva/utils/PlatformUtils;->initPing()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/conviva/utils/PlatformUtils;->_pingUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&d="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p1}, Lcom/conviva/utils/PlatformUtils;->urlEncodeString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Ping: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/conviva/utils/PlatformUtils;->httpRequest(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/PlatformUtils;->_isSendingPing:Ljava/lang/Boolean;

    const-string v0, "Failed to send ping"

    invoke-virtual {p0, v0}, Lcom/conviva/utils/PlatformUtils;->err(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public randInt()I
    .locals 4

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    const-wide v2, 0x40ef400000000000L    # 64000.0

    mul-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method

.method public runProtected(Ljava/util/concurrent/Callable;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Callable",
            "<TV;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    :try_start_0
    invoke-interface {p1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-direct {p0, p2, v0}, Lcom/conviva/utils/PlatformUtils;->onUncaughtException(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public abstract setClientIdFromServer(Ljava/lang/String;)V
.end method

.method public abstract startFetchClientId()V
.end method
