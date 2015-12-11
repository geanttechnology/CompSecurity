.class public Lde/mindpipe/android/logging/log4j/LogConfigurator;
.super Ljava/lang/Object;
.source "LogConfigurator.java"


# instance fields
.field private fileName:Ljava/lang/String;

.field private filePattern:Ljava/lang/String;

.field private immediateFlush:Z

.field private logCatPattern:Ljava/lang/String;

.field private maxBackupSize:I

.field private maxFileSize:J

.field private rootLevel:Lorg/apache/log4j/Level;

.field private useFileAppender:Z

.field private useLogCatAppender:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    sget-object v0, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    iput-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->rootLevel:Lorg/apache/log4j/Level;

    .line 34
    const-string v0, "%d - [%p::%c::%C] - %m%n"

    iput-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->filePattern:Ljava/lang/String;

    .line 35
    const-string v0, "%m%n"

    iput-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->logCatPattern:Ljava/lang/String;

    .line 36
    const-string v0, "android-log4j.log"

    iput-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->fileName:Ljava/lang/String;

    .line 37
    const/4 v0, 0x5

    iput v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->maxBackupSize:I

    .line 38
    const-wide/32 v0, 0x80000

    iput-wide v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->maxFileSize:J

    .line 39
    iput-boolean v2, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->immediateFlush:Z

    .line 40
    iput-boolean v2, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->useLogCatAppender:Z

    .line 41
    iput-boolean v2, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->useFileAppender:Z

    .line 44
    return-void
.end method

.method private configureFileAppender()V
    .locals 6

    .prologue
    .line 112
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v3

    .line 114
    .local v3, "root":Lorg/apache/log4j/Logger;
    new-instance v1, Lorg/apache/log4j/PatternLayout;

    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getFilePattern()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Lorg/apache/log4j/PatternLayout;-><init>(Ljava/lang/String;)V

    .line 117
    .local v1, "fileLayout":Lorg/apache/log4j/Layout;
    :try_start_0
    new-instance v2, Lorg/apache/log4j/RollingFileAppender;

    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getFileName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v1, v4}, Lorg/apache/log4j/RollingFileAppender;-><init>(Lorg/apache/log4j/Layout;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    .local v2, "rollingFileAppender":Lorg/apache/log4j/RollingFileAppender;
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getMaxBackupSize()I

    move-result v4

    invoke-virtual {v2, v4}, Lorg/apache/log4j/RollingFileAppender;->setMaxBackupIndex(I)V

    .line 123
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getMaxFileSize()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lorg/apache/log4j/RollingFileAppender;->setMaximumFileSize(J)V

    .line 124
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->isImmediateFlush()Z

    move-result v4

    invoke-virtual {v2, v4}, Lorg/apache/log4j/RollingFileAppender;->setImmediateFlush(Z)V

    .line 126
    invoke-virtual {v3, v2}, Lorg/apache/log4j/Logger;->addAppender(Lorg/apache/log4j/Appender;)V

    .line 127
    return-void

    .line 118
    .end local v2    # "rollingFileAppender":Lorg/apache/log4j/RollingFileAppender;
    :catch_0
    move-exception v0

    .line 119
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Exception configuring log system"

    invoke-direct {v4, v5, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
.end method

.method private configureLogCatAppender()V
    .locals 4

    .prologue
    .line 130
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v2

    .line 131
    .local v2, "root":Lorg/apache/log4j/Logger;
    new-instance v1, Lorg/apache/log4j/PatternLayout;

    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getLogCatPattern()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lorg/apache/log4j/PatternLayout;-><init>(Ljava/lang/String;)V

    .line 132
    .local v1, "logCatLayout":Lorg/apache/log4j/Layout;
    new-instance v0, Lde/mindpipe/android/logging/log4j/LogCatAppender;

    invoke-direct {v0, v1}, Lde/mindpipe/android/logging/log4j/LogCatAppender;-><init>(Lorg/apache/log4j/Layout;)V

    .line 134
    .local v0, "logCatAppender":Lde/mindpipe/android/logging/log4j/LogCatAppender;
    invoke-virtual {v2, v0}, Lorg/apache/log4j/Logger;->addAppender(Lorg/apache/log4j/Appender;)V

    .line 135
    return-void
.end method


# virtual methods
.method public configure()V
    .locals 2

    .prologue
    .line 88
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v0

    .line 90
    .local v0, "root":Lorg/apache/log4j/Logger;
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->isUseFileAppender()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 91
    invoke-direct {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->configureFileAppender()V

    .line 94
    :cond_0
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->isUseLogCatAppender()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 95
    invoke-direct {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->configureLogCatAppender()V

    .line 98
    :cond_1
    invoke-virtual {p0}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->getRootLevel()Lorg/apache/log4j/Level;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/log4j/Logger;->setLevel(Lorg/apache/log4j/Level;)V

    .line 99
    return-void
.end method

.method public getFileName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->fileName:Ljava/lang/String;

    return-object v0
.end method

.method public getFilePattern()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->filePattern:Ljava/lang/String;

    return-object v0
.end method

.method public getLogCatPattern()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->logCatPattern:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxBackupSize()I
    .locals 1

    .prologue
    .line 190
    iget v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->maxBackupSize:I

    return v0
.end method

.method public getMaxFileSize()J
    .locals 2

    .prologue
    .line 206
    iget-wide v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->maxFileSize:J

    return-wide v0
.end method

.method public getRootLevel()Lorg/apache/log4j/Level;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->rootLevel:Lorg/apache/log4j/Level;

    return-object v0
.end method

.method public isImmediateFlush()Z
    .locals 1

    .prologue
    .line 218
    iget-boolean v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->immediateFlush:Z

    return v0
.end method

.method public isUseFileAppender()Z
    .locals 1

    .prologue
    .line 230
    iget-boolean v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->useFileAppender:Z

    return v0
.end method

.method public isUseLogCatAppender()Z
    .locals 1

    .prologue
    .line 245
    iget-boolean v0, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->useLogCatAppender:Z

    return v0
.end method

.method public setRootLevel(Lorg/apache/log4j/Level;)V
    .locals 0
    .param p1, "level"    # Lorg/apache/log4j/Level;

    .prologue
    .line 150
    iput-object p1, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->rootLevel:Lorg/apache/log4j/Level;

    .line 151
    return-void
.end method

.method public setUseFileAppender(Z)V
    .locals 0
    .param p1, "useFileAppender"    # Z

    .prologue
    .line 237
    iput-boolean p1, p0, Lde/mindpipe/android/logging/log4j/LogConfigurator;->useFileAppender:Z

    .line 238
    return-void
.end method
