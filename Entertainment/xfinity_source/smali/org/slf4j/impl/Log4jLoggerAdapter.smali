.class public final Lorg/slf4j/impl/Log4jLoggerAdapter;
.super Lorg/slf4j/helpers/MarkerIgnoringBase;
.source "Log4jLoggerAdapter.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Lorg/slf4j/spi/LocationAwareLogger;


# static fields
.field static final FQCN:Ljava/lang/String;

.field static class$org$slf4j$impl$Log4jLoggerAdapter:Ljava/lang/Class;


# instance fields
.field final transient logger:Lorg/apache/log4j/Logger;

.field final traceCapable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lorg/slf4j/impl/Log4jLoggerAdapter;->class$org$slf4j$impl$Log4jLoggerAdapter:Ljava/lang/Class;

    if-nez v0, :cond_0

    const-string v0, "org.slf4j.impl.Log4jLoggerAdapter"

    invoke-static {v0}, Lorg/slf4j/impl/Log4jLoggerAdapter;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lorg/slf4j/impl/Log4jLoggerAdapter;->class$org$slf4j$impl$Log4jLoggerAdapter:Ljava/lang/Class;

    :goto_0
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    return-void

    :cond_0
    sget-object v0, Lorg/slf4j/impl/Log4jLoggerAdapter;->class$org$slf4j$impl$Log4jLoggerAdapter:Ljava/lang/Class;

    goto :goto_0
.end method

.method constructor <init>(Lorg/apache/log4j/Logger;)V
    .locals 1
    .param p1, "logger"    # Lorg/apache/log4j/Logger;

    .prologue
    .line 75
    invoke-direct {p0}, Lorg/slf4j/helpers/MarkerIgnoringBase;-><init>()V

    .line 76
    iput-object p1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    .line 77
    invoke-virtual {p1}, Lorg/apache/log4j/Logger;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->name:Ljava/lang/String;

    .line 78
    invoke-direct {p0}, Lorg/slf4j/impl/Log4jLoggerAdapter;->isTraceCapable()Z

    move-result v0

    iput-boolean v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->traceCapable:Z

    .line 79
    return-void
.end method

.method static class$(Ljava/lang/String;)Ljava/lang/Class;
    .locals 3
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 66
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    :catch_0
    move-exception v0

    .local v0, "x1":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/NoClassDefFoundError;

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/NoClassDefFoundError;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private isTraceCapable()Z
    .locals 2

    .prologue
    .line 83
    :try_start_0
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isTraceEnabled()Z
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0

    .line 84
    const/4 v1, 0x1

    .line 86
    :goto_0
    return v1

    .line 85
    :catch_0
    move-exception v0

    .line 86
    .local v0, "e":Ljava/lang/NoSuchMethodError;
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public debug(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 209
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 210
    return-void
.end method

.method public debug(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg"    # Ljava/lang/Object;

    .prologue
    .line 227
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 228
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 229
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 231
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg1"    # Ljava/lang/Object;
    .param p3, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 250
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 251
    invoke-static {p1, p2, p3}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 252
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 254
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public debug(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 286
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v0, v1, v2, p1, p2}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 287
    return-void
.end method

.method public debug(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "argArray"    # [Ljava/lang/Object;

    .prologue
    .line 271
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 272
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->arrayFormat(Ljava/lang/String;[Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 273
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 275
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 498
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 499
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg"    # Ljava/lang/Object;

    .prologue
    .line 516
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v1, v2}, Lorg/apache/log4j/Logger;->isEnabledFor(Lorg/apache/log4j/Priority;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 517
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 518
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 520
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg1"    # Ljava/lang/Object;
    .param p3, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 539
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v1, v2}, Lorg/apache/log4j/Logger;->isEnabledFor(Lorg/apache/log4j/Priority;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 540
    invoke-static {p1, p2, p3}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 541
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 543
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 576
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v0, v1, v2, p1, p2}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 577
    return-void
.end method

.method public error(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "argArray"    # [Ljava/lang/Object;

    .prologue
    .line 560
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v1, v2}, Lorg/apache/log4j/Logger;->isEnabledFor(Lorg/apache/log4j/Priority;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 561
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->arrayFormat(Ljava/lang/String;[Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 562
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->ERROR:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 564
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public info(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 305
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 306
    return-void
.end method

.method public info(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg"    # Ljava/lang/Object;

    .prologue
    .line 322
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isInfoEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 323
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 324
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 326
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg1"    # Ljava/lang/Object;
    .param p3, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 345
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    invoke-virtual {v1}, Lorg/apache/log4j/Logger;->isInfoEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 346
    invoke-static {p1, p2, p3}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 347
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 349
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public warn(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 401
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 402
    return-void
.end method

.method public warn(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg"    # Ljava/lang/Object;

    .prologue
    .line 419
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    invoke-virtual {v1, v2}, Lorg/apache/log4j/Logger;->isEnabledFor(Lorg/apache/log4j/Priority;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 420
    invoke-static {p1, p2}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 421
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 423
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "arg1"    # Ljava/lang/Object;
    .param p3, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 442
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    invoke-virtual {v1, v2}, Lorg/apache/log4j/Logger;->isEnabledFor(Lorg/apache/log4j/Priority;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 443
    invoke-static {p1, p2, p3}, Lorg/slf4j/helpers/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lorg/slf4j/helpers/FormattingTuple;

    move-result-object v0

    .line 444
    .local v0, "ft":Lorg/slf4j/helpers/FormattingTuple;
    iget-object v1, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v2, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v3, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lorg/slf4j/helpers/FormattingTuple;->getThrowable()Ljava/lang/Throwable;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 446
    .end local v0    # "ft":Lorg/slf4j/helpers/FormattingTuple;
    :cond_0
    return-void
.end method

.method public warn(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 479
    iget-object v0, p0, Lorg/slf4j/impl/Log4jLoggerAdapter;->logger:Lorg/apache/log4j/Logger;

    sget-object v1, Lorg/slf4j/impl/Log4jLoggerAdapter;->FQCN:Ljava/lang/String;

    sget-object v2, Lorg/apache/log4j/Level;->WARN:Lorg/apache/log4j/Level;

    invoke-virtual {v0, v1, v2, p1, p2}, Lorg/apache/log4j/Logger;->log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 480
    return-void
.end method
