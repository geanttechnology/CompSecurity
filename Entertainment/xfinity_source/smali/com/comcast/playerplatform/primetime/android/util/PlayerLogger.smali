.class public Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
.super Ljava/lang/Object;
.source "PlayerLogger.java"

# interfaces
.implements Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private final logger:Lorg/slf4j/Logger;

.field private maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    sget-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .line 16
    const-class v0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    .line 20
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 0

    .prologue
    .line 35
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->DEBUG:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 47
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 49
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 70
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p3}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 77
    :cond_0
    return-void
.end method

.method public getEntries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/logging/LogEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    const/4 v0, 0x0

    return-object v0
.end method

.method public i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 40
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 42
    :cond_0
    return-void
.end method

.method public setCapacity(I)V
    .locals 0
    .param p1, "maxEntryCount"    # I

    .prologue
    .line 27
    return-void
.end method

.method public setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 0
    .param p1, "level"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .line 82
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 56
    :cond_0
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 3
    .param p1, "logTag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 61
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p3}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 63
    :cond_0
    return-void
.end method
