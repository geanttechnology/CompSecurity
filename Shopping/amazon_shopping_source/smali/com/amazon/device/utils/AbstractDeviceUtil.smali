.class public abstract Lcom/amazon/device/utils/AbstractDeviceUtil;
.super Landroid/database/ContentObserver;
.source "AbstractDeviceUtil.java"

# interfaces
.implements Lcom/amazon/device/utils/DeviceUtil;


# instance fields
.field protected final mBackgroundThreadFactory:Ljava/util/concurrent/ThreadFactory;

.field private mCustomerID:Ljava/lang/String;

.field private final mFetchCustomerIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

.field private final mFetchSessionIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

.field private mRemoteIP:Ljava/lang/String;

.field private mSessionID:Ljava/lang/String;

.field protected final mSharedPrefs:Landroid/content/SharedPreferences;

.field private mUserAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const-wide/16 v3, 0x3e8

    const/4 v1, 0x1

    .line 46
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 48
    if-nez p1, :cond_0

    .line 49
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    const-string/jumbo v0, "com.amazon.device.utils"

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 54
    new-instance v0, Lcom/amazon/device/utils/BackgroundThreadFactory;

    invoke-direct {v0}, Lcom/amazon/device/utils/BackgroundThreadFactory;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mBackgroundThreadFactory:Ljava/util/concurrent/ThreadFactory;

    .line 57
    const/4 v9, 0x1

    .line 58
    .local v9, "MAX_THREADS":I
    const/4 v8, 0x1

    .line 59
    .local v8, "MAX_FETCH_REQUESTS":I
    const/16 v10, 0x3e8

    .line 61
    .local v10, "TIME_BEFORE_THREAD_SHUTDOWN":I
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6, v1}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    iget-object v7, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mBackgroundThreadFactory:Ljava/util/concurrent/ThreadFactory;

    move v2, v1

    invoke-direct/range {v0 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    iput-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mFetchSessionIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 65
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6, v1}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    iget-object v7, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mBackgroundThreadFactory:Ljava/util/concurrent/ThreadFactory;

    move v2, v1

    invoke-direct/range {v0 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V

    iput-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mFetchCustomerIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 69
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/utils/AbstractDeviceUtil;ILjava/security/SecureRandom;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/utils/AbstractDeviceUtil;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/security/SecureRandom;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/utils/AbstractDeviceUtil;->getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/device/utils/AbstractDeviceUtil;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/utils/AbstractDeviceUtil;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mCustomerID:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$202(Lcom/amazon/device/utils/AbstractDeviceUtil;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/utils/AbstractDeviceUtil;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSessionID:Ljava/lang/String;

    return-object p1
.end method

.method private declared-synchronized createCustomerID()V
    .locals 2

    .prologue
    .line 130
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mCustomerID:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 150
    :goto_0
    monitor-exit p0

    return-void

    .line 134
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mFetchCustomerIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v1, Lcom/amazon/device/utils/AbstractDeviceUtil$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/utils/AbstractDeviceUtil$1;-><init>(Lcom/amazon/device/utils/AbstractDeviceUtil;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private createRemoteIp()V
    .locals 1

    .prologue
    .line 117
    const-string/jumbo v0, "10.0.0.1"

    iput-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mRemoteIP:Ljava/lang/String;

    .line 118
    return-void
.end method

.method private declared-synchronized createSessionID()V
    .locals 2

    .prologue
    .line 154
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSessionID:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 175
    :goto_0
    monitor-exit p0

    return-void

    .line 158
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mFetchSessionIDThreadPool:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v1, Lcom/amazon/device/utils/AbstractDeviceUtil$2;

    invoke-direct {v1, p0}, Lcom/amazon/device/utils/AbstractDeviceUtil$2;-><init>(Lcom/amazon/device/utils/AbstractDeviceUtil;)V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 154
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private createUserAgent()V
    .locals 6

    .prologue
    .line 121
    invoke-virtual {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->fetchDeviceType()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 122
    const-string/jumbo v0, ""

    .line 123
    .local v0, "appName":Ljava/lang/String;
    const-string/jumbo v1, ""

    .line 124
    .local v1, "appVersion":Ljava/lang/String;
    const-string/jumbo v2, "%s:::%s:::%s:::%s"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object v1, v3, v4

    const/4 v4, 0x2

    invoke-virtual {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->fetchDeviceType()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    sget-object v5, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mUserAgent:Ljava/lang/String;

    .line 126
    .end local v0    # "appName":Ljava/lang/String;
    .end local v1    # "appVersion":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private getRandomDigits(ILjava/security/SecureRandom;)Ljava/lang/String;
    .locals 7
    .param p1, "count"    # I
    .param p2, "sr"    # Ljava/security/SecureRandom;

    .prologue
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 200
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "%0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "%dd"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v1, v4, [Ljava/lang/Object;

    const-wide/high16 v2, 0x4024000000000000L    # 10.0

    int-to-double v4, p1

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    double-to-int v2, v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p2, v2}, Ljava/security/SecureRandom;->nextInt(I)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public fetchCustomerID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mCustomerID:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 110
    invoke-direct {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->createCustomerID()V

    .line 112
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mCustomerID:Ljava/lang/String;

    return-object v0
.end method

.method public fetchRemoteIP()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mRemoteIP:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 88
    invoke-direct {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->createRemoteIp()V

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mRemoteIP:Ljava/lang/String;

    return-object v0
.end method

.method public fetchSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSessionID:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 99
    invoke-direct {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->createSessionID()V

    .line 101
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mSessionID:Ljava/lang/String;

    return-object v0
.end method

.method public fetchUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mUserAgent:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 77
    invoke-direct {p0}, Lcom/amazon/device/utils/AbstractDeviceUtil;->createUserAgent()V

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/utils/AbstractDeviceUtil;->mUserAgent:Ljava/lang/String;

    return-object v0
.end method
