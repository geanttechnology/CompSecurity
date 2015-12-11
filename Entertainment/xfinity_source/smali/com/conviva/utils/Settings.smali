.class public Lcom/conviva/utils/Settings;
.super Ljava/lang/Object;


# instance fields
.field public clientInstanceId:I

.field public customerKey:Ljava/lang/String;

.field public enableLogging:Z

.field public gatewayPath:Ljava/lang/String;

.field public gatewayUrl:Ljava/lang/String;

.field public heartbeatIntervalMs:I

.field public loadDataTimeoutMs:I

.field public maxEventsPerHeartbeat:I

.field public pingComponentName:Ljava/lang/String;

.field public pingUrl:Ljava/lang/String;

.field public platformApi:Lcom/conviva/platforms/PlatformApi;

.field public platformApiName:Ljava/lang/String;

.field public protocolVersion:Ljava/lang/String;

.field public sendLogs:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0x4e20

    iput v0, p0, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    const/16 v0, 0xa

    iput v0, p0, Lcom/conviva/utils/Settings;->maxEventsPerHeartbeat:I

    iput-object v2, p0, Lcom/conviva/utils/Settings;->customerKey:Ljava/lang/String;

    const-string v0, "https://cws.conviva.com"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    const-string v0, "/0/wsg"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->gatewayPath:Ljava/lang/String;

    const-string v0, "1.7"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->protocolVersion:Ljava/lang/String;

    iput v1, p0, Lcom/conviva/utils/Settings;->clientInstanceId:I

    const-string v0, "com.conviva.platforms.AndroidApi"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->platformApiName:Ljava/lang/String;

    iput-object v2, p0, Lcom/conviva/utils/Settings;->platformApi:Lcom/conviva/platforms/PlatformApi;

    const/16 v0, 0x2710

    iput v0, p0, Lcom/conviva/utils/Settings;->loadDataTimeoutMs:I

    iput-boolean v1, p0, Lcom/conviva/utils/Settings;->enableLogging:Z

    iput-boolean v1, p0, Lcom/conviva/utils/Settings;->sendLogs:Z

    const-string v0, "javacws"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->pingComponentName:Ljava/lang/String;

    const-string v0, "https://pings.conviva.com/ping.ping"

    iput-object v0, p0, Lcom/conviva/utils/Settings;->pingUrl:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public changeSettings(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    if-nez p1, :cond_1

    :cond_0
    return-void

    :cond_1
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v3, "platformApiName"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/utils/Settings;->platformApiName:Ljava/lang/String;

    goto :goto_0

    :cond_2
    const-string v3, "platformApi"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    check-cast v0, Lcom/conviva/platforms/PlatformApi;

    iput-object v0, p0, Lcom/conviva/utils/Settings;->platformApi:Lcom/conviva/platforms/PlatformApi;

    goto :goto_0

    :cond_3
    const-string v3, "gatewayUrl"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/utils/Settings;->gatewayUrl:Ljava/lang/String;

    goto :goto_0

    :cond_4
    const-string v3, "pingUrl"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/utils/Settings;->pingUrl:Ljava/lang/String;

    goto :goto_0

    :cond_5
    const-string v3, "heartbeatIntervalMs"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/conviva/utils/Settings;->heartbeatIntervalMs:I

    goto :goto_0

    :cond_6
    const-string v3, "enableLogging"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/conviva/utils/Settings;->enableLogging:Z

    goto :goto_0

    :cond_7
    new-instance v0, Ljava/lang/Exception;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsupported settings: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v0
.end method
