.class public Lcom/exacttarget/etpushsdk/util/ETLogger;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/BackgroundEventListener;


# static fields
.field private static final LOG_FILE_NAME:Ljava/lang/String; = "JB4A-SDK-log.log"

.field private static final MIN_FILE_SIZE:J = 0x61a8L

.field private static final MIN_MEMORY_SIZE:J = 0x1000L

.field private static final TAG:Ljava/lang/String; = "~ETLogger"

.field private static final TEMP_LOG_FILE_NAME:Ljava/lang/String; = "JB4A-SDK-log-temp.log"

.field private static appContext:Landroid/content/Context;

.field private static captureInProgress:Z

.field private static final inMemoryLog:Ljava/lang/StringBuilder;

.field private static final loggerSynchronization:Ljava/lang/Object;

.field private static maxFileSize:J

.field private static maxMemorySize:J

.field private static final sInstance:Lcom/exacttarget/etpushsdk/util/ETLogger;


# instance fields
.field private final captureLogThread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    .line 37
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->loggerSynchronization:Ljava/lang/Object;

    .line 40
    new-instance v0, Lcom/exacttarget/etpushsdk/util/ETLogger;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->sInstance:Lcom/exacttarget/etpushsdk/util/ETLogger;

    .line 41
    const/4 v0, 0x0

    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureInProgress:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0}, Ljava/lang/Thread;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLogThread:Ljava/lang/Thread;

    .line 49
    return-void
.end method

.method static synthetic access$000()Ljava/lang/StringBuilder;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    return-object v0
.end method

.method static synthetic access$100(Lcom/exacttarget/etpushsdk/util/ETLogger;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->addVersionInfo()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/exacttarget/etpushsdk/util/ETLogger;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lcom/exacttarget/etpushsdk/util/ETLogger;->formatLogLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300()J
    .locals 2

    .prologue
    .line 32
    sget-wide v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->maxMemorySize:J

    return-wide v0
.end method

.method static synthetic access$400(Lcom/exacttarget/etpushsdk/util/ETLogger;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V

    return-void
.end method

.method private addVersionInfo()Ljava/lang/String;
    .locals 5

    .prologue
    .line 339
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    if-eqz v0, :cond_0

    .line 340
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "App Version: %s (%d) SDK Version: %s (%d) Package: %s"

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->d(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/n;->c(Landroid/content/Context;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getSdkVersionName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getSdkVersionCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x4

    sget-object v4, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "line.separator"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 347
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method private static copyFile(Ljava/io/File;Ljava/io/File;)V
    .locals 6

    .prologue
    .line 62
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    .line 63
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    move-result v0

    if-nez v0, :cond_0

    .line 64
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Problem creating file: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 67
    :cond_0
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v0}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 68
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v0}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 70
    const-wide/16 v2, 0x0

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Ljava/nio/channels/FileChannel;->transferFrom(Ljava/nio/channels/ReadableByteChannel;JJ)J

    .line 72
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Transferred: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 74
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 75
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V

    .line 76
    return-void
.end method

.method private flushLogToFile(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 320
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 321
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    const-string v1, "~ETLogger"

    invoke-direct {p0, v1, p1}, Lcom/exacttarget/etpushsdk/util/ETLogger;->formatLogLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 324
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->addVersionInfo()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 325
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 326
    sget-object v1, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 328
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    int-to-long v2, v1

    invoke-direct {p0, v2, v3}, Lcom/exacttarget/etpushsdk/util/ETLogger;->logFileReset(J)V

    .line 330
    new-instance v1, Ljava/io/OutputStreamWriter;

    sget-object v2, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v3, "JB4A-SDK-log.log"

    const v4, 0x8000

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 331
    invoke-virtual {v1, v0}, Ljava/io/OutputStreamWriter;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 332
    invoke-virtual {v1}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 336
    :goto_0
    return-void

    .line 333
    :catch_0
    move-exception v0

    .line 334
    const-string v0, "~ETLogger"

    const-string v1, "Problem flushing logging data to file."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private formatLogDate(J)Ljava/lang/String;
    .locals 3

    .prologue
    .line 314
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd HH:mm:ss:SSS"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 315
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1, p1, p2}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private formatLogLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    .line 307
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "%s %-25s %s"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Lcom/exacttarget/etpushsdk/util/ETLogger;->formatLogDate(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    const/4 v3, 0x2

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "line.separator"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->sInstance:Lcom/exacttarget/etpushsdk/util/ETLogger;

    return-object v0
.end method

.method private logFileReset(J)V
    .locals 13

    .prologue
    const-wide/16 v10, 0x0

    const/4 v6, 0x0

    const/4 v0, 0x1

    const/4 v7, 0x0

    .line 353
    cmp-long v1, p1, v10

    if-nez v1, :cond_1

    .line 416
    :cond_0
    :goto_0
    return-void

    .line 363
    :cond_1
    :try_start_0
    sget-object v1, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v2, "JB4A-SDK-log.log"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 364
    sget-object v2, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v3, "JB4A-SDK-log-temp.log"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 366
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 367
    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v3}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 368
    :try_start_1
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    .line 370
    add-long/2addr v4, p1

    sget-wide v8, Lcom/exacttarget/etpushsdk/util/ETLogger;->maxFileSize:J

    cmp-long v3, v4, v8

    if-lez v3, :cond_9

    .line 371
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 372
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_2

    .line 373
    const-string v3, "~ETLogger"

    const-string v4, "Problem deleting file: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 377
    :cond_2
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v3}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v6

    .line 380
    const-wide v4, 0x7fffffffffffffffL

    move-wide v2, p1

    invoke-virtual/range {v1 .. v6}, Ljava/nio/channels/FileChannel;->transferTo(JJLjava/nio/channels/WritableByteChannel;)J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-wide v2

    .line 382
    cmp-long v2, v2, v10

    if-lez v2, :cond_9

    .line 392
    :goto_1
    if-eqz v1, :cond_3

    .line 393
    :try_start_2
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 395
    :cond_3
    if-eqz v6, :cond_4

    .line 396
    invoke-virtual {v6}, Ljava/nio/channels/FileChannel;->close()V

    .line 398
    :cond_4
    if-eqz v0, :cond_0

    .line 399
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v1, "JB4A-SDK-log.log"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 400
    sget-object v1, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v2, "JB4A-SDK-log-temp.log"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 401
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_5

    .line 402
    const-string v2, "~ETLogger"

    const-string v3, "Problem deleting file: %1$s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 405
    :cond_5
    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 407
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 408
    const-string v0, "~ETLogger"

    const-string v2, "Problem deleting file: %1$s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 411
    :catch_0
    move-exception v0

    .line 412
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 388
    :catch_1
    move-exception v0

    move-object v1, v6

    .line 389
    :goto_2
    :try_start_3
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 392
    if-eqz v1, :cond_6

    .line 393
    :try_start_4
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 395
    :cond_6
    if-eqz v6, :cond_0

    .line 396
    invoke-virtual {v6}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto/16 :goto_0

    .line 411
    :catch_2
    move-exception v0

    .line 412
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 391
    :catchall_0
    move-exception v0

    move-object v1, v6

    .line 392
    :goto_3
    if-eqz v1, :cond_7

    .line 393
    :try_start_5
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 395
    :cond_7
    if-eqz v6, :cond_8

    .line 396
    invoke-virtual {v6}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    .line 413
    :cond_8
    :goto_4
    throw v0

    .line 411
    :catch_3
    move-exception v1

    .line 412
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_4

    .line 391
    :catchall_1
    move-exception v0

    goto :goto_3

    .line 388
    :catch_4
    move-exception v0

    goto :goto_2

    :cond_9
    move v0, v7

    goto/16 :goto_1

    :cond_a
    move v0, v7

    move-object v1, v6

    goto/16 :goto_1
.end method


# virtual methods
.method protected varargs captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3

    .prologue
    .line 231
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->isCaptureInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    .line 304
    :goto_0
    return-void

    .line 236
    :cond_0
    sget-object v1, Lcom/exacttarget/etpushsdk/util/ETLogger;->loggerSynchronization:Ljava/lang/Object;

    monitor-enter v1

    .line 237
    :try_start_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/util/h;

    invoke-direct {v2, p0, p3, p2, p1}, Lcom/exacttarget/etpushsdk/util/h;-><init>(Lcom/exacttarget/etpushsdk/util/ETLogger;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 303
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public emailLogFile(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 197
    :try_start_0
    sget-object v2, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v3, "JB4A-SDK-log.log"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 198
    new-instance v3, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Landroid/os/Environment;->DIRECTORY_DOWNLOADS:Ljava/lang/String;

    invoke-static {v5}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "JB4A-SDK-log.log"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 200
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 201
    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_0

    .line 202
    const-string v1, "~ETLogger"

    const-string v2, "Problem deleting file: %1$s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 226
    :goto_0
    return v0

    .line 207
    :cond_0
    const-string v4, "Sending log via email to: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {p2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V

    .line 209
    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/ETLogger;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 211
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.SEND_MULTIPLE"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 212
    const-string v4, "plain/text"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 213
    const-string v4, "android.intent.extra.EMAIL"

    invoke-virtual {v2, v4, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 214
    const-string v4, "android.intent.extra.SUBJECT"

    invoke-virtual {v2, v4, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 215
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v2, v4, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 216
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 217
    invoke-static {v3}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 218
    const-string v3, "android.intent.extra.STREAM"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 220
    const-string v3, "Send Log Using:"

    invoke-static {v2, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v1

    .line 226
    goto :goto_0

    .line 221
    :catch_0
    move-exception v1

    .line 222
    const-string v2, "~ETLogger"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public get()V
    .locals 1

    .prologue
    .line 147
    const/4 v0, 0x0

    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureInProgress:Z

    .line 149
    const-string v0, "Stop capture requests.  Flushing log."

    invoke-direct {p0, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V

    .line 151
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->unregister(Ljava/lang/Object;)V

    .line 152
    return-void
.end method

.method public getInMemoryLog()Ljava/lang/StringBuilder;
    .locals 1

    .prologue
    .line 169
    sget-object v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    return-object v0
.end method

.method public getLogFilePath(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    const-string v0, "JB4A-SDK-log.log"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 179
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isCaptureInProgress()Z
    .locals 1

    .prologue
    .line 160
    sget-boolean v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureInProgress:Z

    return v0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/BackgroundEvent;)V
    .locals 1

    .prologue
    .line 420
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->isInBackground()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 421
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->isCaptureInProgress()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 423
    const-string v0, "App sent to background, so flush log"

    invoke-direct {p0, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V

    .line 426
    :cond_0
    return-void
.end method

.method public startCapture(Landroid/content/Context;JJZ)Z
    .locals 8

    .prologue
    const-wide/16 v6, 0x61a8

    const-wide/16 v4, 0x1000

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 89
    sput-object p1, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    .line 91
    cmp-long v2, p2, v4

    if-gez v2, :cond_0

    .line 92
    const-string v2, "~ETLogger"

    const-string v3, "maxMemorySize must be over %1$d"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v1, v0

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 127
    :goto_0
    return v0

    .line 96
    :cond_0
    cmp-long v2, p4, v6

    if-gez v2, :cond_1

    .line 97
    const-string v2, "~ETLogger"

    const-string v3, "maxFileSize must be over %1$d"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v1, v0

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 101
    :cond_1
    cmp-long v2, p2, p4

    if-lez v2, :cond_2

    .line 102
    const-string v1, "~ETLogger"

    const-string v2, "maxMemorySize must be less than maxFileSize"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 106
    :cond_2
    sput-wide p2, Lcom/exacttarget/etpushsdk/util/ETLogger;->maxMemorySize:J

    .line 107
    sput-wide p4, Lcom/exacttarget/etpushsdk/util/ETLogger;->maxFileSize:J

    .line 109
    sput-boolean v1, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureInProgress:Z

    .line 112
    sget-object v2, Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 115
    if-eqz p6, :cond_3

    .line 116
    sget-object v2, Lcom/exacttarget/etpushsdk/util/ETLogger;->appContext:Landroid/content/Context;

    const-string v3, "JB4A-SDK-log.log"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 117
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 118
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_3

    .line 119
    const-string v3, "~ETLogger"

    const-string v4, "Problem deleting file: %1$s"

    new-array v5, v1, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v0

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 125
    :cond_3
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    move v0, v1

    .line 127
    goto :goto_0
.end method

.method public stopCapture()V
    .locals 1

    .prologue
    .line 135
    const/4 v0, 0x0

    sput-boolean v0, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureInProgress:Z

    .line 137
    const-string v0, "Stop capture requests.  Flushing log."

    invoke-direct {p0, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V

    .line 139
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->unregister(Ljava/lang/Object;)V

    .line 140
    return-void
.end method
