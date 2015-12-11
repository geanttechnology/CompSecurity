.class public Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "BackwardsCompatiableDataStorage.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mIsUsingNewCentralLocalDataStorage:Z

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 31
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    .line 32
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 34
    .local v0, "dsFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 36
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 38
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    instance-of v1, v1, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    iput-boolean v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mIsUsingNewCentralLocalDataStorage:Z

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 43
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 45
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    instance-of v0, v0, Lcom/amazon/identity/auth/device/storage/CentralLocalDataStorage;

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mIsUsingNewCentralLocalDataStorage:Z

    .line 47
    return-void
.end method

.method private areTokensThatAreHistoricallyInUserdata(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 307
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isADcpOnlyToken(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isEncryptedTokenInUserData(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private encryptUserDataIfNeccesary(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "accountTokenEncryptor"    # Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 285
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isEncryptedTokenInUserData(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 290
    .end local p3    # "value":Ljava/lang/String;
    :goto_0
    return-object p3

    .restart local p3    # "value":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1, p3}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->encryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p3

    goto :goto_0
.end method

.method private encryptedDCPOnlyTokenIfNeccesary(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 295
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isADcpOnlyToken(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 302
    .end local p2    # "value":Ljava/lang/String;
    :goto_0
    return-object p2

    .line 300
    .restart local p2    # "value":Ljava/lang/String;
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;-><init>(Landroid/content/Context;)V

    .line 302
    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;->encryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    goto :goto_0
.end method


# virtual methods
.method public addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 10
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 84
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData()Ljava/util/Map;

    move-result-object v5

    .line 87
    .local v5, "userdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v6, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mIsUsingNewCentralLocalDataStorage:Z

    if-nez v6, :cond_1

    .line 90
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AESCipher;->generateAesSecureStorageKey()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v6, "com.amazon.dcp.sso.property.encryptKey"

    invoke-interface {v5, v6, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    .local v1, "encryptKey":Ljava/lang/String;
    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-direct {p0, v7, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->encryptedDCPOnlyTokenIfNeccesary(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Map$Entry;->setValue(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 92
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;

    invoke-direct {v0, p0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage$1;-><init>(Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;Ljava/lang/String;)V

    .line 100
    .local v0, "accountTokenEncryptor":Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-direct {p0, v0, v7, v8}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->encryptUserDataIfNeccesary(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Map$Entry;->setValue(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 103
    .end local v0    # "accountTokenEncryptor":Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;
    .end local v1    # "encryptKey":Ljava/lang/String;
    :cond_1
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 104
    .local v4, "updatedTokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 106
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getTokens()Ljava/util/Map;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 108
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-direct {p0, v6}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->areTokensThatAreHistoricallyInUserdata(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 110
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 114
    :cond_2
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v4, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 119
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_3
    iget-object v6, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    new-instance v7, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getDirectedId()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8, v5, v4}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-virtual {v6, p1, v7, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z

    move-result v6

    return v6
.end method

.method public expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 206
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->areTokensThatAreHistoricallyInUserdata(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 208
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    :goto_0
    return-void

    .line 212
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->expireToken(Ljava/lang/String;Ljava/lang/String;)V

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
    .line 76
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

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
    .line 70
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 219
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 346
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDisplayName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 179
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->areTokensThatAreHistoricallyInUserdata(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 181
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 185
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUndecryptedUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 138
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v1, p1, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 141
    .local v0, "possibleEncryptedUserData":Ljava/lang/String;
    iget-boolean v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mIsUsingNewCentralLocalDataStorage:Z

    if-eqz v1, :cond_1

    .line 156
    .end local v0    # "possibleEncryptedUserData":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    .line 145
    .restart local v0    # "possibleEncryptedUserData":Ljava/lang/String;
    :cond_1
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isADcpOnlyToken(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 147
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isOtter()Z

    move-result v1

    if-eqz v1, :cond_2

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2, p1}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    :goto_1
    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;->decryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .end local v0    # "possibleEncryptedUserData":Ljava/lang/String;
    if-nez v0, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not decrypt tokens using expected methods."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .restart local v0    # "possibleEncryptedUserData":Ljava/lang/String;
    :cond_2
    new-instance v1, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/framework/DCPOnlyTokenEncryptor;-><init>(Landroid/content/Context;)V

    goto :goto_1

    .line 150
    :cond_3
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isEncryptedTokenInUserData(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 152
    new-instance v1, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2, p1}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 153
    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->decryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public initialize()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->initialize()V

    .line 53
    return-void
.end method

.method public removeAccount(Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->removeAccount(Ljava/lang/String;)V

    .line 128
    return-void
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 1
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 231
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V

    .line 232
    return-void
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    return-void
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 192
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->areTokensThatAreHistoricallyInUserdata(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 194
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    :goto_0
    return-void

    .line 198
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 164
    iget-boolean v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mIsUsingNewCentralLocalDataStorage:Z

    if-eqz v2, :cond_0

    .line 166
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v2, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    :goto_0
    return-void

    .line 169
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mContext:Landroid/content/Context;

    invoke-direct {v0, v2, p1}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 170
    .local v0, "accountTokenEncryptor":Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;
    invoke-direct {p0, v0, p2, p3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->encryptUserDataIfNeccesary(Lcom/amazon/identity/auth/device/storage/AbstractTokenEncryptor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 171
    .local v1, "possibleEncryptedValue":Ljava/lang/String;
    invoke-direct {p0, p2, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->encryptedDCPOnlyTokenIfNeccesary(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 173
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v2, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setup()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setup()V

    .line 59
    return-void
.end method

.method public syncDirtyData()V
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->mStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->syncDirtyData()V

    .line 65
    return-void
.end method
