.class public Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "CentralAccountManagerDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheInstanceToRuleThemAll:Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;


# instance fields
.field private volatile mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mAccountInfoLock:[Ljava/lang/Object;

.field private final mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field private final mContext:Landroid/content/Context;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mTokenCacheHolder:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 94
    const-class v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 98
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    .line 112
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_token_cache_holder"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mTokenCacheHolder:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    .line 118
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_account_manager"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .line 119
    return-void
.end method

.method private getAccountInfoSnapshot(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 554
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfosSnapshot()Ljava/util/Map;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRequiredAccountInfo(Ljava/lang/String;Ljava/util/Map;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    return-object v0
.end method

.method private getAccountInfosSnapshot()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 475
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    .line 476
    .local v0, "curInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;>;"
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->isAccountInfoPopulatedAndUsable(Ljava/util/Map;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 478
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 483
    :goto_0
    return-object v1

    .line 481
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v2

    .line 483
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfos()Ljava/util/Map;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 484
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 123
    const-class v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->sTheInstanceToRuleThemAll:Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 125
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->sTheInstanceToRuleThemAll:Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;

    .line 128
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->sTheInstanceToRuleThemAll:Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 123
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 562
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfos()Ljava/util/Map;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRequiredAccountInfo(Ljava/lang/String;Ljava/util/Map;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    return-object v0
.end method

.method private getRawAccountInfos()Ljava/util/Map;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 492
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->isAccountInfoPopulatedAndUsable(Ljava/util/Map;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 494
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdToAccountMapping(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Ljava/util/Map;

    move-result-object v0

    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    new-instance v5, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;

    invoke-direct {v5, v1, v0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;-><init>(Ljava/lang/String;Landroid/accounts/Account;)V

    invoke-virtual {v2, v4, v5}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_0
    iput-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    .line 497
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method private getRequiredAccountInfo(Ljava/lang/String;Ljava/util/Map;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
            ">;)",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;"
        }
    .end annotation

    .prologue
    .line 567
    .local p2, "accountInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;>;"
    if-nez p1, :cond_1

    .line 569
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "MAP called with null directedId"

    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-direct {v3}, Ljava/lang/IllegalArgumentException;-><init>()V

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 570
    const/4 v0, 0x0

    .line 578
    :cond_0
    :goto_0
    return-object v0

    .line 573
    :cond_1
    invoke-interface {p2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    .line 574
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 576
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    invoke-interface {p2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-static {v1, p1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->accountNotRegisteredError(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)V

    goto :goto_0
.end method

.method private invalidateAccountCache()V
    .locals 2

    .prologue
    .line 467
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 469
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    .line 470
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private isAccountInfoPopulatedAndUsable(Ljava/util/Map;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 502
    .local p1, "infos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;>;"
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 133
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isBackedByAccountManager()Z

    move-result v0

    return v0
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 11
    .param p1, "uniqueDisplayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "dataPropogationCallback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 177
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v1

    .line 178
    .local v1, "directedId":Ljava/lang/String;
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 179
    .local v6, "userdata":Landroid/os/Bundle;
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 181
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v6, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 183
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v5

    .line 184
    .local v5, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v8

    .line 186
    :try_start_0
    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->doesAccountExist(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 188
    const/4 v4, 0x0

    monitor-exit v8

    .line 211
    :goto_1
    return v4

    .line 191
    :cond_1
    new-instance v0, Landroid/accounts/Account;

    const-string/jumbo v7, "com.amazon.account"

    invoke-direct {v0, p1, v7}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    .local v0, "account":Landroid/accounts/Account;
    const-string/jumbo v7, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v6, v7, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    iget-object v7, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    const/4 v9, 0x0

    const/4 v10, 0x1

    invoke-virtual {v7, v0, v9, v6, v10}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->addAccountExplicitlySync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Z)Z

    move-result v4

    .line 196
    .local v4, "result":Z
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V

    .line 198
    if-eqz v4, :cond_3

    .line 200
    if-eqz v5, :cond_2

    .line 202
    invoke-virtual {p0, v1, v5}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V

    .line 206
    :cond_2
    if-eqz p3, :cond_3

    .line 208
    invoke-interface {p3}, Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;->onSuccess()V

    .line 211
    :cond_3
    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 213
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v4    # "result":Z
    :catchall_0
    move-exception v7

    monitor-exit v8

    throw v7
.end method

.method public doesAccountExist(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 532
    if-nez p1, :cond_0

    .line 534
    const/4 v0, 0x0

    .line 538
    :goto_0
    return v0

    .line 537
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfosSnapshot()Ljava/util/Map;

    move-result-object v0

    .line 538
    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 395
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v3

    .line 397
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    .line 398
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 400
    sget-object v2, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot expire the requested token for the given directed ID because we couldn\'t construct a TokenCache"

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    monitor-exit v3

    .line 411
    :goto_0
    return-void

    .line 405
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mTokenCacheHolder:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->getTokenCache(Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v1

    .line 408
    .local v1, "tokenCache":Lcom/amazon/identity/auth/device/token/TokenCache;
    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 410
    invoke-virtual {v1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->invalidateAuthTokenByType(Ljava/lang/String;)V

    .line 411
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .end local v1    # "tokenCache":Lcom/amazon/identity/auth/device/token/TokenCache;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public getAccountNames()Ljava/util/Set;
    .locals 4
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
    .line 164
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 165
    .local v1, "accountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfosSnapshot()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    .line 167
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    iget-object v3, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-interface {v1, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 169
    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :cond_0
    return-object v1
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
    .line 157
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfosSnapshot()Ljava/util/Map;

    move-result-object v0

    .line 158
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 420
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-nez v0, :cond_0

    .line 422
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "getDeviceData should only be called via central apk"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 425
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 426
    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 587
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 589
    const/4 v1, 0x0

    .line 592
    :goto_0
    return-object v1

    .line 591
    :cond_0
    new-instance v0, Landroid/accounts/Account;

    const-string/jumbo v1, "com.amazon.account"

    invoke-direct {v0, p1, v1}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 592
    .local v0, "account":Landroid/accounts/Account;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 598
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfosSnapshot()Ljava/util/Map;

    move-result-object v1

    .line 599
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    .line 600
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 602
    const/4 v1, 0x0

    .line 604
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    goto :goto_0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tokenType"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 331
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfoSnapshot(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    .line 332
    .local v0, "accountInfoSnapshot":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 334
    sget-object v6, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Cannot get the requested token for the given directed ID because we couldn\'t construct a TokenCache"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 366
    :goto_0
    return-object v5

    .line 339
    :cond_0
    iget-object v6, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v6, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/framework/Value;

    .line 340
    .local v4, "tokenValueSnapshot":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-eqz v4, :cond_1

    .line 342
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_0

    .line 345
    :cond_1
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v6

    .line 347
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v1

    .line 348
    .local v1, "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v1, :cond_2

    .line 350
    sget-object v7, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Cannot get the requested token for the given directed ID because we couldn\'t construct a TokenCache"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 367
    .end local v1    # "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 355
    .restart local v1    # "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :cond_2
    :try_start_1
    iget-object v5, v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v5, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/Value;

    .line 356
    .local v2, "curTokenValue":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-eqz v2, :cond_3

    .line 358
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    monitor-exit v6

    goto :goto_0

    .line 361
    :cond_3
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mTokenCacheHolder:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    invoke-virtual {v1, v5}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->getTokenCache(Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v5

    .line 362
    invoke-virtual {v5, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 364
    .local v3, "token":Ljava/lang/String;
    iget-object v5, v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    new-instance v7, Lcom/amazon/identity/auth/device/framework/Value;

    invoke-direct {v7, v3}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    invoke-interface {v5, p2, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 366
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v5, v3

    goto :goto_0
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 270
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfoSnapshot(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    .line 271
    .local v0, "accountInfoSnapshot":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 273
    sget-object v6, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Cannot get the requested user data for the given directed ID because it is not registered on the device"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 304
    :goto_0
    return-object v5

    .line 278
    :cond_0
    iget-object v6, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    invoke-interface {v6, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/identity/auth/device/framework/Value;

    .line 279
    .local v4, "userDataValueSnapshot":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-eqz v4, :cond_1

    .line 281
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_0

    .line 284
    :cond_1
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v6

    .line 286
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v1

    .line 287
    .local v1, "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v1, :cond_2

    .line 289
    sget-object v7, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Cannot get the requested user data for the given directed ID because it is not registered on the device"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 305
    .end local v1    # "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 294
    .restart local v1    # "curAccountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :cond_2
    :try_start_1
    iget-object v5, v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    invoke-interface {v5, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/Value;

    .line 295
    .local v2, "curUserDataInCache":Lcom/amazon/identity/auth/device/framework/Value;, "Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;"
    if-eqz v2, :cond_3

    .line 297
    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/Value;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    monitor-exit v6

    goto :goto_0

    .line 300
    :cond_3
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v7, v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    invoke-virtual {v5, v7, p2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->unprotectedGetUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 302
    .local v3, "realUserData":Ljava/lang/String;
    iget-object v5, v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    new-instance v7, Lcom/amazon/identity/auth/device/framework/Value;

    invoke-direct {v7, v3}, Lcom/amazon/identity/auth/device/framework/Value;-><init>(Ljava/lang/Object;)V

    invoke-interface {v5, p2, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 304
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-object v5, v3

    goto :goto_0
.end method

.method public initialize()V
    .locals 0

    .prologue
    .line 140
    return-void
.end method

.method public removeAccount(Ljava/lang/String;)V
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 219
    iget-object v5, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v5

    .line 221
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getAccountInfoSnapshot(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v4

    if-nez v4, :cond_0

    .line 222
    .local v0, "account":Landroid/accounts/Account;
    :goto_0
    if-nez v0, :cond_1

    .line 224
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Cannot remove the requested user because it is not registered on the device"

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    monitor-exit v5

    .line 264
    :goto_1
    return-void

    .line 221
    .end local v0    # "account":Landroid/accounts/Account;
    :cond_0
    iget-object v0, v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    goto :goto_0

    .line 228
    .restart local v0    # "account":Landroid/accounts/Account;
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfo:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v4, p1}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-virtual {v4, v0, v6, v7}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->removeAccount(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Z)Landroid/accounts/AccountManagerFuture;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 231
    .local v2, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Ljava/lang/Boolean;>;"
    const/4 v3, 0x0

    .line 235
    .local v3, "result":Z
    :try_start_1
    invoke-interface {v2}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_1
    .catch Landroid/accounts/OperationCanceledException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v3

    .line 257
    :try_start_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V

    .line 260
    :goto_2
    if-nez v3, :cond_2

    .line 262
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Locally removing the account from the central store was not succesful"

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    :cond_2
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .end local v0    # "account":Landroid/accounts/Account;
    .end local v2    # "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Ljava/lang/Boolean;>;"
    .end local v3    # "result":Z
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 237
    .restart local v0    # "account":Landroid/accounts/Account;
    .restart local v2    # "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Ljava/lang/Boolean;>;"
    .restart local v3    # "result":Z
    :catch_0
    move-exception v1

    .line 239
    .local v1, "e":Landroid/accounts/OperationCanceledException;
    :try_start_3
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Could not locally removed account because the operation was canceled. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/accounts/OperationCanceledException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 257
    :try_start_4
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_2

    .line 243
    .end local v1    # "e":Landroid/accounts/OperationCanceledException;
    :catch_1
    move-exception v1

    .line 245
    .local v1, "e":Landroid/accounts/AuthenticatorException;
    :try_start_5
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Could not locally removed account because their was an Authenticator Exception. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/accounts/AuthenticatorException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 257
    :try_start_6
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2

    .line 249
    .end local v1    # "e":Landroid/accounts/AuthenticatorException;
    :catch_2
    move-exception v1

    .line 251
    .local v1, "e":Ljava/io/IOException;
    :try_start_7
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Could not locally removed account because their was an IO Exception. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 257
    :try_start_8
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V

    goto :goto_2

    .end local v1    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v4

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->invalidateAccountCache()V

    throw v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 6
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 454
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 456
    .local v2, "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v5, v3, v4}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 459
    .end local v2    # "userDataEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 461
    .local v1, "token":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p0, v5, v3, v4}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 463
    .end local v1    # "token":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 435
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isRunningInCentralApk()Z

    move-result v0

    if-nez v0, :cond_0

    .line 437
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "setDeviceData should only be called via central apk"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 440
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 441
    invoke-virtual {v0, p2, p3}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->setValue(Ljava/lang/String;Ljava/lang/String;)Z

    .line 442
    return-void
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tokenType"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 373
    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v3

    .line 375
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    .line 376
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 378
    sget-object v2, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cannot set the requested token for the given directed ID because we couldn\'t construct a TokenCache"

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    monitor-exit v3

    .line 389
    :goto_0
    return-void

    .line 383
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mTokenCacheHolder:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->getTokenCache(Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v1

    .line 386
    .local v1, "tokenCache":Lcom/amazon/identity/auth/device/token/TokenCache;
    iget-object v2, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    invoke-virtual {v1, p2, p3}, Lcom/amazon/identity/auth/device/token/TokenCache;->setAuthToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .end local v1    # "tokenCache":Lcom/amazon/identity/auth/device/token/TokenCache;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 311
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAccountInfoLock:[Ljava/lang/Object;

    monitor-enter v2

    .line 313
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->getRawAccountInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    .line 314
    .local v0, "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    if-nez v0, :cond_0

    .line 316
    sget-object v1, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Cannot set the requested user data for the given directed ID because it is not registered on the device"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    monitor-exit v2

    .line 325
    :goto_0
    return-void

    .line 322
    :cond_0
    iget-object v1, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 324
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v3, v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    invoke-virtual {v1, v3, p2, p3}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .end local v0    # "accountInfo":Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public setup()V
    .locals 0

    .prologue
    .line 146
    return-void
.end method

.method public syncDirtyData()V
    .locals 0

    .prologue
    .line 152
    return-void
.end method
