.class public Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "LocalAppDataAwareDataStorage.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountManagerCommunicator:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

.field private final mContext:Landroid/content/Context;

.field private final mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 38
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    .line 39
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 41
    .local v0, "dsFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 43
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_map_account_manager_communicator"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mAccountManagerCommunicator:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 49
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    .line 50
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_map_account_manager_communicator"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mAccountManagerCommunicator:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .line 54
    return-void
.end method

.method private getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "registerChildAccountIfNeeded"    # Z

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    const/4 v6, 0x0

    .line 240
    if-eqz p3, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 242
    new-instance v6, Ljava/lang/IllegalStateException;

    const-string/jumbo v7, "Cannot get local data on the main thread"

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 245
    :cond_0
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v1

    .line 246
    .local v1, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    if-nez v1, :cond_1

    .line 302
    :goto_0
    return-object v6

    .line 252
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 253
    .local v3, "packageName":Ljava/lang/String;
    if-nez v3, :cond_2

    .line 255
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 259
    :cond_2
    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v7}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v7

    invoke-virtual {v7, v3}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v5

    .line 261
    .local v5, "remoteMapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-nez v5, :cond_3

    .line 263
    sget-object v7, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Key Package is invalid because there is no package %s."

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v3, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 271
    :cond_3
    :try_start_0
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v4

    .line 272
    .local v4, "remoteDeviceType":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getOverrideDSN()Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 279
    .local v2, "overrideDsn":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v7, v4}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 283
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v6

    goto :goto_0

    .line 274
    .end local v2    # "overrideDsn":Ljava/lang/String;
    .end local v4    # "remoteDeviceType":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 276
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v7, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "Couldn\'t determine override device type/DSN for "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 288
    .end local v0    # "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    .restart local v2    # "overrideDsn":Ljava/lang/String;
    .restart local v4    # "remoteDeviceType":Ljava/lang/String;
    :cond_4
    if-eqz p3, :cond_5

    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v7, p1, v4}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplicationDeviceTypeRegistered(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 291
    :cond_5
    sget-object v6, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "device: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " already registered, returning key"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 292
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v4, v7}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 296
    :cond_6
    invoke-direct {p0, p1, v4, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->registerChildApplicationDeviceType(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 298
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v4, v7}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_0

    .line 301
    :cond_7
    sget-object v7, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Could not register application with the device type %s"

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v4, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private registerChildApplicationDeviceType(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "overrideDsn"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 309
    const-string/jumbo v0, "RegisterChildApplicationFromDBLayer"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 311
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 312
    .local v3, "options":Landroid/os/Bundle;
    const-string/jumbo v0, "override_dsn"

    invoke-virtual {v3, v0, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mAccountManagerCommunicator:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    const/4 v4, 0x0

    move-object v1, p1

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v7

    .line 319
    .local v7, "registerChildAccountFuture":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :try_start_0
    invoke-interface {v7}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 320
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 338
    :goto_0
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .line 341
    :goto_1
    return v0

    :cond_0
    move v0, v8

    .line 320
    goto :goto_0

    .line 322
    :catch_0
    move-exception v6

    .line 324
    .local v6, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :try_start_1
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Error registeringChildAccount. Bundle Error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 338
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    .end local v6    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :goto_2
    move v0, v8

    .line 341
    goto :goto_1

    .line 328
    :catch_1
    move-exception v6

    .line 330
    .local v6, "e":Ljava/lang/InterruptedException;
    :try_start_2
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Interrupted exception while registeringChildAccount"

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 338
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    goto :goto_2

    .line 332
    .end local v6    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v6

    .line 334
    .local v6, "e":Ljava/util/concurrent/ExecutionException;
    :try_start_3
    sget-object v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Execution exception while registeringChildAccount"

    invoke-static {v0, v1, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 338
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    goto :goto_2

    .end local v6    # "e":Ljava/util/concurrent/ExecutionException;
    :catchall_0
    move-exception v0

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->finishTrace()V

    throw v0
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z

    move-result v0

    return v0
.end method

.method public expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 199
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 200
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 202
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "expireToken failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    :goto_0
    return-void

    .line 206
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->expireToken(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getAccountNames()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccountNames()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getAccounts()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 347
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 353
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDisplayName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 141
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 144
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getToken failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    const/4 v1, 0x0

    .line 148
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 103
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 104
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 106
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getUserData failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    const/4 v1, 0x0

    .line 110
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public initialize()V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->initialize()V

    .line 60
    return-void
.end method

.method public peekToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 153
    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 154
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 156
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "peekToken failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    const/4 v1, 0x0

    .line 160
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public peekUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 115
    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 118
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "peekUserData failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const/4 v1, 0x0

    .line 122
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public removeAccount(Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->removeAccount(Ljava/lang/String;)V

    .line 98
    return-void
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 1
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 224
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V

    .line 225
    return-void
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    return-void
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 166
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 167
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 169
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setToken failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    :goto_0
    return-void

    .line 173
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setTokens(Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 179
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 181
    .local v3, "tokensWithContextualKeys":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 183
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const/4 v5, 0x1

    invoke-direct {p0, p1, v4, v5}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 185
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 187
    sget-object v4, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "setToken failed because key does not make sense on the platform"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    .end local v0    # "contextualKey":Ljava/lang/String;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_1
    return-void

    .line 190
    .restart local v0    # "contextualKey":Ljava/lang/String;
    .restart local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 193
    .end local v0    # "contextualKey":Ljava/lang/String;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v4, p1, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_1
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 128
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getDeviceTypeKeyFromPackageNameAndRegisterIfNeeded(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "contextualKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 131
    sget-object v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setUserData failed because key does not make sense on the platform"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    :goto_0
    return-void

    .line 135
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setup()V
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setup()V

    .line 66
    return-void
.end method

.method public syncDirtyData()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->syncDirtyData()V

    .line 72
    return-void
.end method
