.class public final Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "CentralLocalDataStorage.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sInitialized:Z

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 45
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_local_datastorage_v2"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    .line 50
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 51
    return-void
.end method

.method private addAccountInternal(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 164
    .local p3, "dataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->addAccount(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z

    move-result v0

    return v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 55
    const-class v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    .line 60
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 55
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static setIsInitialized(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x1

    .line 341
    const-string/jumbo v1, "central.local.datastore.info.store"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 343
    .local v0, "sharedPrefs":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "central.local.datastore.init.key"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    .line 344
    if-nez v1, :cond_0

    .line 346
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Was unable to save CentralLocalDataStore as initialized. Retrying..."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, "central.local.datastore.init.key"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    .line 348
    if-nez v1, :cond_0

    .line 350
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Was unable to save CentralLocalDataStore as initialized after retry."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    :goto_0
    return-void

    .line 354
    :cond_0
    sput-boolean v3, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sInitialized:Z

    goto :goto_0
.end method

.method public static shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;Lcom/amazon/identity/auth/device/features/FeatureSet;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;
    .param p1, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/features/Feature;->MovingAwayFromAM:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 3
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "dataPropogationCallback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 141
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 143
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 145
    .local v1, "dataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 147
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 149
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2, v1}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->addAccountInternal(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z

    move-result v0

    .line 151
    .local v0, "addAccountInternalSuccess":Z
    if-eqz v0, :cond_0

    if-eqz p3, :cond_0

    .line 155
    invoke-interface {p3}, Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;->onSuccess()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 157
    :cond_0
    monitor-exit p0

    return v0

    .line 141
    .end local v0    # "addAccountInternalSuccess":Z
    .end local v1    # "dataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 246
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 248
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->removeAccountData(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 250
    if-nez v0, :cond_0

    .line 252
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Expiring the token was not successful. "

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 255
    :cond_0
    monitor-exit p0

    return-void

    .line 246
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
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
    .line 132
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 133
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAccountNames()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getAccounts()Ljava/util/Set;
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
    .line 125
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 126
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAccounts()Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 125
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 261
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 266
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-nez v0, :cond_0

    .line 268
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "getDeviceData should only be called via central apk"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 271
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 272
    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 314
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 315
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 321
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 322
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getDisplayName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 210
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 212
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAccountData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 210
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 188
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 190
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->getAccountData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 188
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized initialize()V
    .locals 6

    .prologue
    .line 92
    monitor-enter p0

    :try_start_0
    sget-boolean v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sInitialized:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    if-eqz v0, :cond_1

    .line 100
    :goto_1
    monitor-exit p0

    return-void

    .line 92
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "central.local.datastore.info.store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, "central.local.datastore.init.key"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->sInitialized:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 97
    :cond_1
    :try_start_2
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Try to do data migration"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cannot dump data from local application. The dump AccountManager data API can only be triggered by com.amazon.imp"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    :goto_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->setIsInitialized(Landroid/content/Context;)V

    goto :goto_1

    .line 97
    :cond_2
    new-instance v2, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v2, v0}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->dumpDataFromAccountManager()Ljava/util/List;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    :cond_3
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "There is no data in old AccountManager. Won\'t do migration"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_4
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "The total number of migration accounts is"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    iget-object v4, v1, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->displayName:Ljava/lang/String;

    iget-object v5, v1, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->directedId:Ljava/lang/String;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    invoke-direct {p0, v4, v5, v1}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->addAccountInternal(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z

    goto :goto_3

    :cond_5
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Try to remove account in old AccountManager"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->directedId:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/storage/AccountManagerDataMigrationHelper;->removeDataFromAccountManagerAfterMigration(Ljava/lang/String;)V

    goto :goto_4

    :cond_6
    const-string/jumbo v0, "DataMigrationSucceed"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Data migration finished"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_2
.end method

.method public declared-synchronized removeAccount(Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 175
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 177
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->removeAccount(Ljava/lang/String;)Z

    move-result v0

    .line 178
    if-nez v0, :cond_0

    .line 180
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Removing the account was not successful."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    :cond_0
    monitor-exit p0

    return-void

    .line 175
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 3
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 296
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 298
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 299
    .local v0, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 300
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 302
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountData(Ljava/lang/String;Ljava/util/Map;)Z

    move-result v1

    .line 304
    if-nez v1, :cond_0

    .line 306
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Setting the data was not successful."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    :cond_0
    return-void
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 279
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 284
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-nez v0, :cond_0

    .line 286
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "setDeviceData should only be called via central apk"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 289
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 290
    invoke-virtual {v0, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->setValue(Ljava/lang/String;Ljava/lang/String;)Z

    .line 291
    return-void
.end method

.method public declared-synchronized setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 218
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 220
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 222
    if-nez v0, :cond_0

    .line 224
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the token was not successful."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 227
    :cond_0
    monitor-exit p0

    return-void

    .line 218
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTokens(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
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
    .line 232
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 234
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountData(Ljava/lang/String;Ljava/util/Map;)Z

    move-result v0

    .line 236
    if-nez v0, :cond_0

    .line 238
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the tokens was not successful."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 241
    :cond_0
    monitor-exit p0

    return-void

    .line 232
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 196
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->initialize()V

    .line 198
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->mLocalDataStorage:Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalDataStorageV2;->setAccountData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 200
    if-nez v0, :cond_0

    .line 202
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Setting the userdata was not successful."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 205
    :cond_0
    monitor-exit p0

    return-void

    .line 196
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setup()V
    .locals 0

    .prologue
    .line 115
    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public declared-synchronized syncDirtyData()V
    .locals 0

    .prologue
    .line 120
    monitor-enter p0

    monitor-exit p0

    return-void
.end method
