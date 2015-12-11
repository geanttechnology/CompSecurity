.class public Lcom/amazon/mShop/debug/UncaughtExceptionHandler;
.super Ljava/lang/Object;
.source "UncaughtExceptionHandler.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# static fields
.field private static sCrashHandler:Lcom/amazon/mShop/debug/UncaughtExceptionHandler;


# instance fields
.field private mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->sCrashHandler:Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    return-void
.end method

.method private constructor <init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    .locals 1
    .param p1, "sysUncaughtExceptionHandler"    # Ljava/lang/Thread$UncaughtExceptionHandler;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 28
    iput-object p1, p0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 29
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/debug/UncaughtExceptionHandler;
    .locals 3

    .prologue
    .line 21
    const-class v1, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->sCrashHandler:Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    if-nez v0, :cond_0

    .line 22
    new-instance v0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;-><init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    sput-object v0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->sCrashHandler:Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    .line 24
    :cond_0
    sget-object v0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->sCrashHandler:Lcom/amazon/mShop/debug/UncaughtExceptionHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 21
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method protected dumpHprofFile(Ljava/lang/String;)V
    .locals 1
    .param p1, "hprofFilePath"    # Ljava/lang/String;

    .prologue
    .line 79
    :try_start_0
    invoke-static {p1}, Landroid/os/Debug;->dumpHprofData(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 84
    :goto_0
    return-void

    .line 80
    :catch_0
    move-exception v0

    .line 82
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method protected logExceptionStackTrace(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "exceptionLogFileName"    # Ljava/lang/String;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 61
    :try_start_0
    new-instance v0, Ljava/io/PrintWriter;

    const-string/jumbo v1, "UTF-8"

    invoke-direct {v0, p1, v1}, Ljava/io/PrintWriter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    .local v0, "writer":Ljava/io/PrintWriter;
    invoke-virtual {p2, v0}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 63
    invoke-virtual {v0}, Ljava/io/PrintWriter;->close()V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 71
    .end local v0    # "writer":Ljava/io/PrintWriter;
    :goto_0
    return-void

    .line 68
    :catchall_0
    move-exception v1

    throw v1

    .line 66
    :catch_0
    move-exception v1

    goto :goto_0

    .line 64
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 7
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SimpleDateFormat"
        }
    .end annotation

    .prologue
    .line 35
    :try_start_0
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string/jumbo v5, "yy-MM-dd_HH:mm:ss"

    invoke-direct {v1, v5}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 36
    .local v1, "dateFormat":Ljava/text/DateFormat;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 37
    .local v0, "date":Ljava/util/Date;
    invoke-virtual {v1, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    .line 40
    .local v4, "strDate":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "/amazon_mShop_"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "_stacktrace.txt"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 41
    .local v3, "exceptionLogFileName":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "/amazon_mShop_"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ".hprof"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "exceptionHprofFileName":Ljava/lang/String;
    invoke-virtual {p0, v3, p2}, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->logExceptionStackTrace(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 44
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->dumpHprofFile(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    iget-object v5, p0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v5, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 51
    .end local v0    # "date":Ljava/util/Date;
    .end local v1    # "dateFormat":Ljava/text/DateFormat;
    .end local v2    # "exceptionHprofFileName":Ljava/lang/String;
    .end local v3    # "exceptionLogFileName":Ljava/lang/String;
    .end local v4    # "strDate":Ljava/lang/String;
    :goto_0
    return-void

    .line 45
    :catch_0
    move-exception v5

    .line 49
    iget-object v5, p0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v5, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    goto :goto_0

    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v6, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    throw v5
.end method
