.class public Lcom/amazon/mShop/crash/AmazonCrashHandler;
.super Ljava/lang/Object;
.source "AmazonCrashHandler.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# static fields
.field private static sCrashHandler:Lcom/amazon/mShop/crash/AmazonCrashHandler;


# instance fields
.field private mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->sCrashHandler:Lcom/amazon/mShop/crash/AmazonCrashHandler;

    return-void
.end method

.method private constructor <init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    .locals 1
    .param p1, "sysUncaughtExceptionHandler"    # Ljava/lang/Thread$UncaughtExceptionHandler;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 27
    return-void
.end method

.method private extractCrashInfo(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 10
    .param p1, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 71
    const/4 v3, 0x0

    .line 72
    .local v3, "info":Ljava/lang/String;
    if-eqz p1, :cond_1

    .line 73
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    .line 74
    .local v5, "strBuf":Ljava/lang/StringBuffer;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 75
    invoke-virtual {p1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/StackTraceElement;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v1, v0, v2

    .line 76
    .local v1, "element":Ljava/lang/StackTraceElement;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 75
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 78
    .end local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_0
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    const/16 v9, 0xff

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 80
    .end local v0    # "arr$":[Ljava/lang/StackTraceElement;
    .end local v2    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "strBuf":Ljava/lang/StringBuffer;
    :cond_1
    return-object v3
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/crash/AmazonCrashHandler;
    .locals 3

    .prologue
    .line 30
    const-class v1, Lcom/amazon/mShop/crash/AmazonCrashHandler;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->sCrashHandler:Lcom/amazon/mShop/crash/AmazonCrashHandler;

    if-nez v0, :cond_0

    .line 31
    new-instance v0, Lcom/amazon/mShop/crash/AmazonCrashHandler;

    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/mShop/crash/AmazonCrashHandler;-><init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    sput-object v0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->sCrashHandler:Lcom/amazon/mShop/crash/AmazonCrashHandler;

    .line 33
    :cond_0
    sget-object v0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->sCrashHandler:Lcom/amazon/mShop/crash/AmazonCrashHandler;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 30
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public setupCrashHandler()V
    .locals 0

    .prologue
    .line 62
    invoke-static {p0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 63
    return-void
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 43
    :try_start_0
    invoke-direct {p0, p2}, Lcom/amazon/mShop/crash/AmazonCrashHandler;->extractCrashInfo(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 44
    .local v1, "info":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 45
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-eqz v0, :cond_0

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 46
    const-string/jumbo v2, "applicationExitReason"

    invoke-interface {v0, v2, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 52
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v2, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 54
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v1    # "info":Ljava/lang/String;
    :goto_0
    return-void

    .line 48
    :catch_0
    move-exception v2

    .line 52
    iget-object v2, p0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v2, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    goto :goto_0

    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/mShop/crash/AmazonCrashHandler;->mSysUncaughtExceptionHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v3, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    throw v2
.end method
