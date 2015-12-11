.class public Lcom/amazon/identity/auth/device/CommonInfoGetter;
.super Ljava/lang/Object;
.source "CommonInfoGetter.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final WAIT_FOR_COMMON_INFO_TO_BE_GENERATED:J

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGetter;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mLatch:Ljava/util/concurrent/CountDownLatch;

.field private final mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 26
    const-class v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    .line 28
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0xf

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->WAIT_FOR_COMMON_INFO_TO_BE_GENERATED:J

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    .line 45
    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 47
    .local v0, "dataStorageFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 49
    new-instance v1, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    .line 51
    new-instance v1, Ljava/util/concurrent/CountDownLatch;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mLatch:Ljava/util/concurrent/CountDownLatch;

    .line 52
    new-instance v1, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 53
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/CommonInfoGetter;)V
    .locals 9
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/CommonInfoGetter;

    .prologue
    const/4 v8, 0x2

    const/4 v3, 0x0

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGenerator;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->generateCommonInfo()I

    move-result v0

    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Central model has no race conditions in terms of common info and hence can be generated locally. Generated version %d"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getCommonInfoVersion(Lcom/amazon/identity/auth/device/storage/DataStorage;)I

    move-result v0

    if-lez v0, :cond_2

    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "No need to generate more common info. Our needed version is %d and currently we have version %d"

    new-array v2, v8, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getLatestMapApp()Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v0

    if-nez v0, :cond_4

    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot find other package to generate common info from."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_1
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-gtz v0, :cond_0

    :cond_3
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "The main MAP app cannot generate version high enough to function properly. We need version %d or higher, but got %s."

    new-array v4, v8, [Ljava/lang/Object;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v7

    if-eqz v3, :cond_5

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    :goto_2
    aput-object v0, v4, v6

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_4
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Calling Package %s to generate common info"

    new-array v4, v6, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v1, v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getProviderAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/MAPInformationProviderHelpers;->generateCommonInfoUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mSecureContentResolver:Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    const-string/jumbo v2, "value"

    move-object v4, v3

    move-object v5, v3

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/utils/DBHelpers;->querySingleResult(Lcom/amazon/identity/auth/device/framework/SecureContentResolver;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    goto :goto_1

    :cond_5
    const-string/jumbo v0, "<Not Found>"

    goto :goto_2
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/CommonInfoGetter;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/CommonInfoGetter;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGetter;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    const-class v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    if-nez v0, :cond_0

    .line 59
    new-instance v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/CommonInfoGetter;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGetter;

    .line 62
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/CommonInfoGetter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static needToGenerateCommonInfoOnThisPlatform(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 69
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    .line 70
    const/4 v0, 0x0

    .line 73
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private waitForInitToFinish()V
    .locals 5

    .prologue
    .line 137
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mLatch:Ljava/util/concurrent/CountDownLatch;

    sget-wide v2, Lcom/amazon/identity/auth/device/CommonInfoGetter;->WAIT_FOR_COMMON_INFO_TO_BE_GENERATED:J

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 139
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "We timed out waiting for common info to be generated"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 146
    :cond_0
    :goto_0
    return-void

    .line 142
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "We were interrupted waiting for common info to be generated"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public getDsn()Ljava/lang/String;
    .locals 4

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->waitForInitToFinish()V

    .line 112
    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getDsn(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v0

    .line 113
    .local v0, "dsn":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 115
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot generate the dsn"

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 118
    :cond_0
    return-object v0
.end method

.method public getTokenKey()Ljava/lang/String;
    .locals 4

    .prologue
    .line 123
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->waitForInitToFinish()V

    .line 124
    iget-object v1, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/CommonInfoGenerator;->getTokenKey(Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "token":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 127
    sget-object v1, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot generate the token key"

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 130
    :cond_0
    return-object v0
.end method

.method public init()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Common Data has already been initialized"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    :goto_0
    return-void

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->needToGenerateCommonInfoOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 86
    sget-object v0, Lcom/amazon/identity/auth/device/CommonInfoGetter;->TAG:Ljava/lang/String;

    goto :goto_0

    .line 90
    :cond_1
    new-instance v0, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/CommonInfoGetter$1;-><init>(Lcom/amazon/identity/auth/device/CommonInfoGetter;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
