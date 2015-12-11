.class final Lcom/adobe/mediacore/logging/DefaultLogger;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;


# direct methods
.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    iput-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 0

    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->DEBUG:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->ERROR:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2, p3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
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

    const/4 v0, 0x0

    return-object v0
.end method

.method public i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->INFO:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public setCapacity(I)V
    .locals 0

    return-void
.end method

.method public setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/logging/DefaultLogger;->maxVerbosityLevel:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->WARN:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->getLevel()I

    move-result v1

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {p1, p2, p3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
