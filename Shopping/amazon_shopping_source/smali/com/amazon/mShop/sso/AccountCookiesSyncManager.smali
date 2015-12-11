.class public Lcom/amazon/mShop/sso/AccountCookiesSyncManager;
.super Ljava/lang/Object;
.source "AccountCookiesSyncManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;,
        Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;
    }
.end annotation


# static fields
.field private static volatile sAccountSyncInProgress:Z

.field private static final sAccountSyncMonitor:Ljava/lang/Object;

.field private static final sExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 132
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sExecutor:Ljava/util/concurrent/Executor;

    .line 236
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncInProgress:Z

    .line 262
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 25
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->isAccountSyncInProgress()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Landroid/content/Context;ZZLjava/lang/String;Z)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Z
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Z

    .prologue
    .line 25
    invoke-static {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->doSync(Landroid/content/Context;ZZLjava/lang/String;Z)V

    return-void
.end method

.method static synthetic access$200(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->onCookieFetchCompleted(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300()V
    .locals 0

    .prologue
    .line 25
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->onSynchronizationComplete()V

    return-void
.end method

.method public static checkAndWait()V
    .locals 4

    .prologue
    .line 244
    sget-boolean v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncInProgress:Z

    if-eqz v1, :cond_1

    .line 245
    sget-object v2, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    monitor-enter v2

    .line 248
    :try_start_0
    sget-object v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 255
    .local v0, "e":Ljava/lang/InterruptedException;
    :cond_0
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 257
    :cond_1
    return-void

    .line 249
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_0
    move-exception v0

    .line 251
    .restart local v0    # "e":Ljava/lang/InterruptedException;
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 252
    const-string/jumbo v1, "Amazon.SSOUtil"

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 255
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private static doSync(Landroid/content/Context;ZZLjava/lang/String;Z)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "forceSync"    # Z
    .param p2, "checkLoginAfterCookieRetrieved"    # Z
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "xCookieOnly"    # Z

    .prologue
    .line 175
    new-instance v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    new-instance v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    invoke-direct {v1, p0, p3, p2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;-><init>(Landroid/content/Context;Ljava/lang/String;Z)V

    move-object v2, p0

    move v3, p1

    move-object v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;-><init>(Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;Landroid/content/Context;ZLjava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->getCookies()V

    .line 176
    return-void
.end method

.method public static fetchNonAuthCookies(Landroid/content/Context;)V
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 32
    const/4 v0, 0x0

    invoke-static {p0, v1, v1, v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    .line 33
    return-void
.end method

.method private static isAccountSyncInProgress()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 290
    sget-object v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    monitor-enter v1

    .line 293
    :try_start_0
    sget-boolean v2, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncInProgress:Z

    if-eqz v2, :cond_0

    .line 295
    monitor-exit v1

    .line 301
    :goto_0
    return v0

    .line 300
    :cond_0
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncInProgress:Z

    .line 301
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 302
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private static declared-synchronized onCookieFetchCompleted(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 171
    const-class v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;

    monitor-enter v1

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .end local p1    # "account":Ljava/lang/String;
    :goto_0
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 172
    monitor-exit v1

    return-void

    .line 171
    .restart local p1    # "account":Ljava/lang/String;
    :cond_0
    :try_start_1
    const-string/jumbo p1, ""
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .end local p1    # "account":Ljava/lang/String;
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static onSynchronizationComplete()V
    .locals 4

    .prologue
    .line 270
    sget-object v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    monitor-enter v1

    .line 271
    const/4 v0, 0x0

    :try_start_0
    sput-boolean v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncInProgress:Z

    .line 272
    sget-object v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 273
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 275
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 276
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onSynchronizationComplete() END "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/text/DateFormat;->getTimeInstance(I)Ljava/text/DateFormat;

    move-result-object v2

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v2, v3}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    :cond_0
    return-void

    .line 273
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private static sync(Landroid/content/Context;ZZLjava/lang/String;Z)V
    .locals 7
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "forceSync"    # Z
    .param p2, "checkLoginAfterCookieRetrieved"    # Z
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "xCookieOnly"    # Z

    .prologue
    .line 122
    sget-object v6, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$BackgroundAccountSyncRunnable;-><init>(Landroid/content/Context;ZZLjava/lang/String;Z)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 123
    return-void
.end method

.method public static syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V
    .locals 1
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "forceSync"    # Z
    .param p2, "checkLoginAfterCookieRetrieved"    # Z
    .param p3, "account"    # Ljava/lang/String;

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V

    .line 58
    return-void
.end method

.method public static syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V
    .locals 6
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "forceSync"    # Z
    .param p2, "checkLoginAfterCookieRetrieved"    # Z
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "xCookieOnly"    # Z

    .prologue
    const/4 v5, 0x1

    .line 81
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 82
    const-string/jumbo v1, "Amazon.SSOUtil"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "SSO MAP Account syncAndWait START "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v5}, Ljava/text/DateFormat;->getTimeInstance(I)Ljava/text/DateFormat;

    move-result-object v3

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3, v4}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 85
    :cond_0
    sget-object v2, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    monitor-enter v2

    .line 87
    :try_start_0
    invoke-static {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sync(Landroid/content/Context;ZZLjava/lang/String;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->sAccountSyncMonitor:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 98
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 99
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_2

    .line 100
    const-string/jumbo v1, "Amazon.SSOUtil"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "SSO MAP Account syncAndWait END "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v5}, Ljava/text/DateFormat;->getTimeInstance(I)Ljava/text/DateFormat;

    move-result-object v3

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3, v4}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    :cond_2
    return-void

    .line 92
    :catch_0
    move-exception v0

    .line 94
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_3
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_1

    .line 95
    const-string/jumbo v1, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "AccountCookiesSyncManager#syncAndWait"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 98
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v1
.end method
