.class final Lcom/amazon/dcp/settings/BackgroundSynchronizer;
.super Ljava/lang/Object;
.source "BackgroundSynchronizer.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final THREAD_POOL:Ljava/util/concurrent/ExecutorService;


# instance fields
.field private final mChangeListener:Landroid/content/BroadcastReceiver;

.field private final mContext:Landroid/content/Context;

.field private mInitialSyncComplete:Z

.field private final mLock:Ljava/util/concurrent/locks/ReentrantLock;

.field private final mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

.field private final mSyncCompleted:Ljava/util/concurrent/locks/Condition;

.field private mSyncError:Ljava/lang/Throwable;

.field private mSyncInProgress:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    .line 22
    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/dcp/settings/SettingsCacheUpdater;Landroid/content/Context;)V
    .locals 2
    .param p1, "settingsCacheUpdater"    # Lcom/amazon/dcp/settings/SettingsCacheUpdater;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 25
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncCompleted:Ljava/util/concurrent/locks/Condition;

    .line 26
    iput-boolean v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncInProgress:Z

    .line 27
    iput-boolean v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mInitialSyncComplete:Z

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;

    .line 33
    new-instance v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer$1;

    invoke-direct {v0, p0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer$1;-><init>(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)V

    iput-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mChangeListener:Landroid/content/BroadcastReceiver;

    .line 44
    iput-object p1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    .line 45
    iput-object p2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    .line 46
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)Lcom/amazon/dcp/settings/SettingsCacheUpdater;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/dcp/settings/BackgroundSynchronizer;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSettingsCacheUpdater:Lcom/amazon/dcp/settings/SettingsCacheUpdater;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/dcp/settings/BackgroundSynchronizer;ZLjava/lang/Throwable;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/dcp/settings/BackgroundSynchronizer;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Ljava/lang/Throwable;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V

    return-void
.end method

.method private registerChangeListener()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 61
    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    if-nez v1, :cond_0

    .line 77
    :goto_0
    return-void

    .line 66
    :cond_0
    new-instance v0, Landroid/content/IntentFilter;

    const-string/jumbo v1, "com.amazon.dcp.settings.action.ACTION_SETTINGS_UPDATED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 67
    .local v0, "intentFilter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "content"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 68
    const-string/jumbo v1, "com.amazon.dcp.settings"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/IntentFilter;->addDataAuthority(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string/jumbo v1, "/values/-device-"

    invoke-virtual {v0, v1, v3}, Landroid/content/IntentFilter;->addDataPath(Ljava/lang/String;I)V

    .line 70
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "/values/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/dcp/settings/SettingsContract;->getAppLocalNamespace(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/content/IntentFilter;->addDataPath(Ljava/lang/String;I)V

    .line 72
    const-string/jumbo v1, "/values/-device-/"

    invoke-virtual {v0, v1, v4}, Landroid/content/IntentFilter;->addDataPath(Ljava/lang/String;I)V

    .line 73
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "/values/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/dcp/settings/SettingsContract;->getAppLocalNamespace(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Landroid/content/IntentFilter;->addDataPath(Ljava/lang/String;I)V

    .line 76
    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mChangeListener:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    goto :goto_0
.end method

.method private setSyncInProgress(ZLjava/lang/Throwable;)V
    .locals 2
    .param p1, "inProgress"    # Z
    .param p2, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 198
    if-nez p1, :cond_0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncInProgress:Z

    if-eqz v0, :cond_0

    if-nez p2, :cond_0

    .line 200
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mInitialSyncComplete:Z

    .line 203
    :cond_0
    iput-boolean p1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncInProgress:Z

    .line 204
    iput-object p2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;

    .line 206
    iget-boolean v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncInProgress:Z

    if-nez v0, :cond_1

    .line 208
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncCompleted:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 213
    :cond_1
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 215
    return-void

    .line 213
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method

.method private unregisterChangeListener()V
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 87
    :goto_0
    return-void

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mChangeListener:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    goto :goto_0
.end method


# virtual methods
.method public destroy()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->unregisterChangeListener()V

    .line 57
    return-void
.end method

.method public init()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->registerChangeListener()V

    .line 51
    invoke-virtual {p0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->startSync()V

    .line 52
    return-void
.end method

.method public startSync()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 91
    const/4 v1, 0x0

    .line 92
    .local v1, "success":Z
    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V

    .line 96
    :try_start_0
    sget-object v2, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Requesting sync with content provider."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    sget-object v2, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;

    new-instance v3, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;

    invoke-direct {v3, p0}, Lcom/amazon/dcp/settings/BackgroundSynchronizer$2;-><init>(Lcom/amazon/dcp/settings/BackgroundSynchronizer;)V

    invoke-interface {v2, v3}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    const/4 v1, 0x1

    .line 124
    if-nez v1, :cond_0

    .line 126
    const-string/jumbo v0, "Error posting async task start."

    .line 127
    .local v0, "errorMsg":Ljava/lang/String;
    sget-object v2, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    invoke-static {v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    new-instance v2, Lcom/amazon/dcp/settings/SettingsSyncException;

    invoke-direct {v2, v0}, Lcom/amazon/dcp/settings/SettingsSyncException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v4, v2}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V

    .line 131
    .end local v0    # "errorMsg":Ljava/lang/String;
    :cond_0
    return-void

    .line 124
    :catchall_0
    move-exception v2

    if-nez v1, :cond_1

    .line 126
    const-string/jumbo v0, "Error posting async task start."

    .line 127
    .restart local v0    # "errorMsg":Ljava/lang/String;
    sget-object v3, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    invoke-static {v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    new-instance v3, Lcom/amazon/dcp/settings/SettingsSyncException;

    invoke-direct {v3, v0}, Lcom/amazon/dcp/settings/SettingsSyncException;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v4, v3}, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->setSyncInProgress(ZLjava/lang/Throwable;)V

    .line 129
    .end local v0    # "errorMsg":Ljava/lang/String;
    :cond_1
    throw v2
.end method

.method public waitForInitialSync()V
    .locals 3

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 138
    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mInitialSyncComplete:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 168
    :goto_0
    return-void

    .line 143
    :cond_0
    :try_start_1
    sget-object v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Waiting for initial sync..."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 144
    :goto_1
    iget-boolean v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mInitialSyncComplete:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_1

    .line 148
    :try_start_2
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncCompleted:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 150
    :catch_0
    move-exception v0

    goto :goto_1

    .line 156
    :cond_1
    :try_start_3
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;

    if-eqz v0, :cond_2

    .line 158
    sget-object v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Initial sync failed"

    iget-object v2, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 159
    new-instance v0, Lcom/amazon/dcp/settings/SettingsSyncException;

    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mSyncError:Ljava/lang/Throwable;

    invoke-direct {v0, v1}, Lcom/amazon/dcp/settings/SettingsSyncException;-><init>(Ljava/lang/Throwable;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 166
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    .line 162
    :cond_2
    :try_start_4
    sget-object v0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Wait for initial sync complete."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 166
    iget-object v0, p0, Lcom/amazon/dcp/settings/BackgroundSynchronizer;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0
.end method
