.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DeregisterRequest"
.end annotation


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDeregisterAllOnAccountRemoval:Z

.field private final mDirectedId:Ljava/lang/String;

.field private final mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

.field private mResponseListener:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;

.field private final mSubAuths:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;"
        }
    .end annotation
.end field

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p4, "registrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;",
            "Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")V"
        }
    .end annotation

    .prologue
    .line 190
    .local p3, "subAuths":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 191
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    .line 192
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "sso_platform"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 193
    new-instance v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 195
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "dcp_amazon_account_man"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 197
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "dcp_data_storage_factory"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 199
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 200
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, p3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mSubAuths:Ljava/util/ArrayList;

    .line 201
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    .line 203
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .line 205
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v1

    .line 208
    .local v1, "multipleAccountPlugin":Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    invoke-interface {v1, p2}, Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;->deregisterAllAccountsOnAccountRemoval(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDeregisterAllOnAccountRemoval:Z

    .line 210
    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 211
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Lcom/amazon/identity/auth/device/framework/Tracer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    return-object v0
.end method

.method private notifySubAuthsAccountRemoved()Z
    .locals 8

    .prologue
    .line 389
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 390
    .local v0, "acct":Landroid/accounts/Account;
    if-nez v0, :cond_1

    .line 392
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Sub authenticators are not supported on 3rd party devices yet"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 393
    const/4 v1, 0x1

    .line 419
    :cond_0
    return v1

    .line 396
    :cond_1
    const/4 v1, 0x1

    .line 397
    .local v1, "allSucceeded":Z
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mSubAuths:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .line 399
    .local v3, "desc":Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->getConnectionFactory()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    move-result-object v5

    invoke-interface {v5, v3}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;->createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    move-result-object v5

    new-instance v6, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;

    invoke-direct {v6, v5}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V

    invoke-virtual {v6}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->run()V

    invoke-virtual {v6}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->getConnected()Z

    move-result v5

    if-nez v5, :cond_2

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Failed to establish SubAuthenticator Connection: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, 0x0

    .line 400
    .local v2, "connection":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    :goto_1
    if-nez v2, :cond_3

    .line 402
    iget-object v5, v3, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->deregistrationSubAuthFailure(Ljava/lang/String;)V

    .line 403
    const/4 v1, 0x0

    .line 404
    goto :goto_0

    .line 399
    .end local v2    # "connection":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    :cond_2
    invoke-virtual {v6}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;->getConnection()Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    move-result-object v2

    goto :goto_1

    .line 409
    .restart local v2    # "connection":Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    :cond_3
    :try_start_0
    invoke-virtual {p0, v0, v2}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->notifySubAuthAccountRemoved(Landroid/accounts/Account;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 411
    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->deregistrationSubAuthFailure(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 412
    const/4 v1, 0x0

    .line 417
    :cond_4
    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->closeConnection()V

    goto :goto_0

    :catchall_0
    move-exception v5

    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->closeConnection()V

    throw v5
.end method


# virtual methods
.method public declared-synchronized getConnectionFactory()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;
    .locals 2

    .prologue
    .line 220
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    if-nez v0, :cond_0

    .line 222
    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 220
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getResponseListener()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;
    .locals 1

    .prologue
    .line 234
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mResponseListener:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected isRegistered(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 532
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected notifySubAuthAccountRemoved(Landroid/accounts/Account;Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)Z
    .locals 5
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "connection"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    .prologue
    .line 439
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Notifying subauth: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 440
    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;

    invoke-direct {v0, p2, p1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/accounts/Account;)V

    .line 443
    .local v0, "subAuthDeregistration":Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;
    invoke-virtual {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->getDeregistrationSubAuthTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v1

    .line 444
    .local v1, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 446
    const-wide/16 v2, 0x7

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-string/jumbo v4, "NotifySubAuthAccountRemoval"

    invoke-virtual {v0, v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->run(Ljava/lang/Long;Ljava/util/concurrent/TimeUnit;Ljava/lang/String;)V

    .line 450
    invoke-virtual {v1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 452
    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;->getSuccess()Z

    move-result v2

    return v2
.end method

.method public onRequestComplete(Z)V
    .locals 1
    .param p1, "success"    # Z

    .prologue
    .line 537
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->getResponseListener()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;

    move-result-object v0

    .line 538
    .local v0, "listener":Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;
    if-eqz v0, :cond_0

    .line 540
    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;->onRequestComplete(Z)V

    .line 542
    :cond_0
    return-void
.end method

.method public run()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 240
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->isRegistered(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 243
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->deregistrationRequestFailure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V

    .line 244
    const/4 v7, 0x0

    .line 255
    .local v7, "success":Z
    :goto_0
    invoke-virtual {p0, v7}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->onRequestComplete(Z)V

    .line 256
    return-void

    .line 248
    .end local v7    # "success":Z
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->getDeregistrationTimer()Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v8

    .line 249
    .local v8, "totalDeregistrationTimer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 251
    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->notifySubAuthsAccountRemoved()Z

    move-result v0

    if-nez v0, :cond_8

    move v9, v10

    :goto_1
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->haveWeNotifiedServerOfDeregister(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    new-array v0, v11, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    aput-object v1, v0, v10

    :goto_2
    if-nez v11, :cond_7

    move v7, v10

    :goto_3
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isThirdPartyDevice()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;->getOverridingDSNChildDeviceTypePackages(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_4
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->getConnectionFactory()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;->createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    move-result-object v2

    new-instance v3, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$1;

    invoke-direct {v3, p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$1;-><init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v2, v0, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getAccountCredentialsFromTokenAndKey(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v5

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$400()Ljava/util/concurrent/ExecutorService;

    move-result-object v9

    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;-><init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;)V

    invoke-interface {v9, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_4

    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->getConnectionFactory()Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;->createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    move-result-object v4

    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    iget-boolean v3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDeregisterAllOnAccountRemoval:Z

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;-><init>(Landroid/content/Context;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->run()V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;->getSuccess()Z

    move-result v1

    if-eqz v1, :cond_3

    iget-boolean v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDeregisterAllOnAccountRemoval:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v0

    :goto_5
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_6
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-static {v3, v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->setHasDeregisteredAccount(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)V

    goto :goto_6

    :cond_2
    new-array v0, v11, [Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    aput-object v2, v0, v10

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ArrayUtil;->asSet([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v0

    goto :goto_5

    :cond_3
    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "Deregister was not successful. Not marking accounts that they were deregistered on the server"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    move v11, v1

    goto/16 :goto_2

    :cond_5
    iget-boolean v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDeregisterAllOnAccountRemoval:Z

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getSecondaryAmazonAccounts()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mMapAcctMan:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_7

    :cond_6
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->removeAccount(Ljava/lang/String;)V

    .line 253
    .restart local v7    # "success":Z
    invoke-virtual {v8}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto/16 :goto_0

    .end local v7    # "success":Z
    :cond_7
    move v7, v9

    goto/16 :goto_3

    :cond_8
    move v9, v11

    goto/16 :goto_1
.end method

.method public declared-synchronized setConnectionFactory(Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;)V
    .locals 1
    .param p1, "connectionFactory"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    .prologue
    .line 215
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 216
    monitor-exit p0

    return-void

    .line 215
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setResponseListener(Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;

    .prologue
    .line 229
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mResponseListener:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 230
    monitor-exit p0

    return-void

    .line 229
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
