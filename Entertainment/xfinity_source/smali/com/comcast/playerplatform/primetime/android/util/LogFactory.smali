.class public final Lcom/comcast/playerplatform/primetime/android/util/LogFactory;
.super Ljava/lang/Object;
.source "LogFactory.java"

# interfaces
.implements Lcom/adobe/mediacore/logging/LogFactory;


# static fields
.field private static instance:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

.field private static logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    .line 14
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;
    .locals 2

    .prologue
    .line 17
    const-class v1, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->instance:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    if-nez v0, :cond_0

    .line 18
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->instance:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .line 20
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->instance:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 17
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public bridge synthetic getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    return-object v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1

    .prologue
    .line 34
    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    return-object v0
.end method

.method public getLogger(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 25
    const-string v1, "[PSDK]::TimelineMonitor"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "[PSDK]::VideoEngineContentMarkerCache"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 26
    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;-><init>()V

    .line 27
    .local v0, "logger2":Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->NONE:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V

    .line 30
    .end local v0    # "logger2":Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    :goto_0
    return-object v0

    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    goto :goto_0
.end method
