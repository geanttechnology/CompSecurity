.class public final Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
.super Ljava/lang/Object;
.source "AnalyticsProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$8;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;


# instance fields
.field private analyticsConfigured:Z

.field private analyticsEventListener:Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

.field private analyticsUrl:Ljava/lang/String;

.field private appStateDelegate:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;

.field private applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

.field private batchInterval:J

.field private deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private isEnabled:Z

.field private jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;"
        }
    .end annotation
.end field

.field private listeners:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;",
            ">;"
        }
    .end annotation
.end field

.field private maxBatchSize:I

.field private messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;"
        }
    .end annotation
.end field

.field private messagingTask:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture",
            "<*>;"
        }
    .end annotation
.end field

.field private offlineStorageEnabled:Z

.field private final scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

.field private serverRetries:I

.field private sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

.field private xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I

    .line 404
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsEventListener:Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    .line 90
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    .line 91
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;

    .line 92
    invoke-static {v1}, Ljava/util/concurrent/Executors;->newScheduledThreadPool(I)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 93
    iput-boolean v1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    .line 94
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;

    .line 95
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    return-object v0
.end method

.method static synthetic access$102(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
    .param p1, "x1"    # Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    return-object p1
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsEventListener:Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    return-object v0
.end method

.method static synthetic access$300()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/Vector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->listeners:Ljava/util/Vector;

    return-object v0
.end method

.method static synthetic access$502(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
    .param p1, "x1"    # I

    .prologue
    .line 54
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I

    return p1
.end method

.method static synthetic access$508(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)I
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I

    return v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->offlineStorageEnabled:Z

    return v0
.end method

.method private batchSendMessages(Ljava/util/List;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 237
    .local p1, "messages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    sget-object v8, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v9, "batchSendMessages"

    invoke-interface {v8, v9}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 238
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 239
    .local v1, "builder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v7

    .line 240
    .local v7, "size":I
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v7}, Ljava/util/ArrayList;-><init>(I)V

    .line 241
    .local v0, "batchedMessages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    sget-object v8, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "found "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " messages to send"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 243
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v7, :cond_0

    .line 244
    const/4 v8, 0x0

    invoke-interface {p1, v8}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    .line 246
    .local v5, "msg":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    :try_start_0
    iget-object v8, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;

    invoke-interface {v8, v5}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 247
    .local v6, "msgJson":Ljava/lang/String;
    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v9, 0x1e

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 248
    invoke-interface {v0, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    .end local v6    # "msgJson":Ljava/lang/String;
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 249
    :catch_0
    move-exception v3

    .line 250
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 255
    .end local v3    # "e":Ljava/io/IOException;
    .end local v5    # "msg":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 256
    .local v2, "data":Ljava/lang/String;
    invoke-direct {p0, v0, v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sendDataToServer(Ljava/util/List;Ljava/lang/String;)V

    .line 257
    return-void
.end method

.method private checkForHeartBeat(Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;)V
    .locals 2
    .param p1, "msg"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    .prologue
    .line 186
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->getEventName()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaHeartBeat:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 187
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sendNextMessages(Z)V

    .line 189
    :cond_0
    return-void
.end method

.method private getCurrentNetworkInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .locals 3

    .prologue
    .line 192
    const-string v0, "unknown"

    .line 193
    .local v0, "inHomeState":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->appStateDelegate:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;

    if-eqz v1, :cond_0

    .line 194
    sget-object v1, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$8;->$SwitchMap$com$comcast$playerplatform$analytics$java$event$ApplicationStateDelegate$InHomeState:[I

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->appStateDelegate:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;->getInHomeState()Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 206
    :cond_0
    :goto_0
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;

    invoke-direct {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;-><init>(Ljava/lang/String;)V

    return-object v1

    .line 196
    :pswitch_0
    const-string v0, "inHome"

    .line 197
    goto :goto_0

    .line 199
    :pswitch_1
    const-string v0, "outOfHome"

    .line 200
    goto :goto_0

    .line 194
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
    .locals 3

    .prologue
    .line 304
    const-class v1, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v2, "getInstance"

    invoke-interface {v0, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 305
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Analytics provider instance requested"

    invoke-interface {v0, v2}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 307
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    if-nez v0, :cond_0

    .line 308
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .line 311
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 304
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private saveQueue()V
    .locals 2

    .prologue
    .line 392
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->offlineStorageEnabled:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    if-eqz v0, :cond_0

    .line 393
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v1, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 402
    :cond_0
    return-void
.end method

.method private sendDataToServer(Ljava/util/List;Ljava/lang/String;)V
    .locals 8
    .param p2, "data"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 260
    .local p1, "dataMessages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "sendDataToServer"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 261
    iget-object v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsUrl:Ljava/lang/String;

    const-string v3, "POST"

    const/4 v4, 0x0

    new-instance v5, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;

    invoke-direct {v5, p0, p1}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;Ljava/util/List;)V

    iget-object v6, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object v1, p2

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    invoke-virtual {v7, v0}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 272
    return-void
.end method

.method private declared-synchronized sendNextMessages(Z)V
    .locals 10
    .param p1, "force"    # Z

    .prologue
    .line 210
    monitor-enter p0

    :try_start_0
    iget-object v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->size()I

    move-result v5

    .line 211
    .local v5, "queueSize":I
    if-nez p1, :cond_0

    iget v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->maxBatchSize:I

    if-lt v5, v7, :cond_1

    :cond_0
    const/4 v6, 0x1

    .line 212
    .local v6, "readyToSend":Z
    :goto_0
    sget-object v8, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "messages "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    if-eqz v6, :cond_2

    const-string v7, "are"

    :goto_1
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, " ready to send"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v8, v7}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 214
    if-eqz v6, :cond_4

    .line 215
    iget v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->maxBatchSize:I

    invoke-static {v5, v7}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 216
    .local v1, "batchSize":I
    sget-object v7, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "calculated batch size = "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 217
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 219
    .local v0, "batch":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    iget-object v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 220
    .local v3, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    if-ge v2, v1, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 221
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    .line 222
    .local v4, "msg":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 220
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 211
    .end local v0    # "batch":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    .end local v1    # "batchSize":I
    .end local v2    # "i":I
    .end local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    .end local v4    # "msg":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    .end local v6    # "readyToSend":Z
    :cond_1
    const/4 v6, 0x0

    goto :goto_0

    .line 212
    .restart local v6    # "readyToSend":Z
    :cond_2
    const-string v7, "are not"

    goto :goto_1

    .line 225
    .restart local v0    # "batch":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    .restart local v1    # "batchSize":I
    .restart local v2    # "i":I
    .restart local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    :cond_3
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_4

    .line 226
    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->batchSendMessages(Ljava/util/List;)V

    .line 230
    .end local v0    # "batch":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    .end local v1    # "batchSize":I
    .end local v2    # "i":I
    .end local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    :cond_4
    iget-boolean v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->offlineStorageEnabled:Z

    if-eqz v7, :cond_5

    iget v7, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->serverRetries:I

    const/4 v8, 0x5

    if-lt v7, v8, :cond_5

    .line 231
    sget-object v7, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v8, "server retries exceeded defined amount, saving messages to disk"

    invoke-interface {v7, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 232
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->saveQueue()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 234
    :cond_5
    monitor-exit p0

    return-void

    .line 210
    .end local v5    # "queueSize":I
    .end local v6    # "readyToSend":Z
    :catchall_0
    move-exception v7

    monitor-exit p0

    throw v7
.end method

.method private startMessagingTask()V
    .locals 7

    .prologue
    .line 356
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "startMessagingTask"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 358
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messagingTask:Ljava/util/concurrent/ScheduledFuture;

    if-nez v0, :cond_0

    .line 359
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v1, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$3;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$3;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->batchInterval:J

    iget-wide v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->batchInterval:J

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messagingTask:Ljava/util/concurrent/ScheduledFuture;

    .line 366
    :cond_0
    return-void
.end method


# virtual methods
.method public declared-synchronized buildMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    .locals 8
    .param p1, "message"    # Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    .prologue
    .line 141
    monitor-enter p0

    :try_start_0
    iget-boolean v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsConfigured:Z

    if-eqz v4, :cond_2

    .line 142
    new-instance v2, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;

    invoke-direct {v2}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;-><init>()V

    .line 143
    .local v2, "xMessageComposer":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;
    invoke-virtual {v2, p1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->setMessageBuilder(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 144
    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->constructMessage()V

    .line 146
    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    .line 147
    .local v1, "xMessage":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    const-string v4, "2.0"

    invoke-virtual {v1, v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setProtocol(Ljava/lang/String;)V

    .line 148
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    invoke-virtual {v1, v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setApplicationInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;)V

    .line 149
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    invoke-virtual {v1, v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setDeviceInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;)V

    .line 150
    new-instance v4, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setSessionInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;)V

    .line 152
    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getEvent()Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->getEventName()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaOpeningMedia:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 153
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getEvent()Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->getTimeStamp()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;->setPluginId(Ljava/lang/String;)V

    .line 155
    :cond_0
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    invoke-virtual {v1, v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setSessionInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;)V

    .line 157
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->getCurrentNetworkInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;

    move-result-object v0

    .line 158
    .local v0, "networkInfo":Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getEvent()Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->setNetworkInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;)V

    .line 160
    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->getFormattedMessage()Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    move-result-object v3

    .line 163
    .local v3, "xuaMessage":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    iget-boolean v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->offlineStorageEnabled:Z

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->size()I

    move-result v4

    iget-object v5, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v5}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize()I

    move-result v5

    if-ne v4, v5, :cond_1

    .line 164
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->scheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v5, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$1;

    invoke-direct {v5, p0, v3}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$1;-><init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;)V

    invoke-virtual {v4, v5}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 178
    :goto_0
    sget-object v4, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v5, "Added message to queue : {}"

    invoke-virtual {v3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->getEventName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lorg/slf4j/Logger;->info(Ljava/lang/String;Ljava/lang/Object;)V

    .line 179
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->checkForHeartBeat(Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    .end local v0    # "networkInfo":Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .end local v1    # "xMessage":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    .end local v2    # "xMessageComposer":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;
    .end local v3    # "xuaMessage":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    :goto_1
    monitor-exit p0

    return-void

    .line 175
    .restart local v0    # "networkInfo":Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .restart local v1    # "xMessage":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    .restart local v2    # "xMessageComposer":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;
    .restart local v3    # "xuaMessage":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    :cond_1
    :try_start_1
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v4, v3}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->offer(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 141
    .end local v0    # "networkInfo":Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
    .end local v1    # "xMessage":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    .end local v2    # "xMessageComposer":Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;
    .end local v3    # "xuaMessage":Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 181
    :cond_2
    :try_start_2
    sget-object v4, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v5, "The analytics plugin must be first configured to send messages"

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public clone()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 315
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "clone"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 316
    new-instance v0, Ljava/lang/CloneNotSupportedException;

    invoke-direct {v0}, Ljava/lang/CloneNotSupportedException;-><init>()V

    throw v0
.end method

.method public configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 9
    .param p1, "hostInfo"    # Lcom/comcast/playerplatform/analytics/java/util/HostInfo;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 110
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "configureAnalytics"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 111
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v6

    .line 112
    .local v6, "configurationManager":Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    invoke-virtual {v6}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    :try_start_0
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getApplicationName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getApplicationVersion()Ljava/lang/String;

    move-result-object v2

    const-string v3, "PlayerPlatform"

    const-string v4, "0.3.005"

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getAccountId()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .line 115
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getDeviceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getDeviceVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/analytics/java/util/HostInfo;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .line 116
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .line 117
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 118
    const-string v0, "AnalyticsEndpoint"

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsUrl:Ljava/lang/String;

    .line 119
    const-string v0, "MaxBatchSize"

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->maxBatchSize:I

    .line 120
    const-string v0, "BatchInterval"

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->batchInterval:J

    .line 122
    const-string v0, "MaxQueueSize"

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    .line 123
    .local v8, "maxQueueSize":I
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v0, v8}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->setMaxSize(I)V

    .line 125
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsConfigured:Z

    .line 126
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    if-eqz v0, :cond_0

    .line 127
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->enable()V

    .line 129
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Analytics plugin configuredEnabled:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    .end local v8    # "maxQueueSize":I
    :goto_0
    return-void

    .line 131
    :catch_0
    move-exception v7

    .line 132
    .local v7, "ex":Ljava/lang/Exception;
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "The analytics plugin must be first configured to send messages"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    goto :goto_0

    .line 136
    .end local v7    # "ex":Ljava/lang/Exception;
    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "The analytics plugin must be first configured to send messages"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public enable()V
    .locals 2

    .prologue
    .line 346
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "enable"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 347
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    .line 348
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsConfigured:Z

    if-eqz v0, :cond_0

    .line 349
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->startMessagingTask()V

    .line 353
    :goto_0
    return-void

    .line 351
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "The analytics plugin must be first configured to send messages"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public declared-synchronized forceSendMessages()V
    .locals 2

    .prologue
    .line 275
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsConfigured:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->isEnabled:Z

    if-eqz v0, :cond_0

    .line 276
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sendNextMessages(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 281
    :goto_0
    monitor-exit p0

    return-void

    .line 278
    :cond_0
    :try_start_1
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->saveQueue()V

    .line 279
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "The analytics plugin must be first configured to send messages"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 275
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getMaxBatchSize()I
    .locals 2

    .prologue
    .line 284
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "getMaxBatchSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 285
    iget v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->maxBatchSize:I

    return v0
.end method

.method public getMaxQueueSize()I
    .locals 2

    .prologue
    .line 294
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "getMaxQueueSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 295
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize()I

    move-result v0

    return v0
.end method

.method public setMaxBatchSize(I)V
    .locals 2
    .param p1, "maxMessages"    # I

    .prologue
    .line 289
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "setMaxBatchSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 290
    iput p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->maxBatchSize:I

    .line 291
    return-void
.end method

.method public setMaxQueueSize(I)V
    .locals 2
    .param p1, "maxMessages"    # I

    .prologue
    .line 299
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;

    const-string v1, "setMaxQueueSize"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 300
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->setMaxSize(I)V

    .line 301
    return-void
.end method
