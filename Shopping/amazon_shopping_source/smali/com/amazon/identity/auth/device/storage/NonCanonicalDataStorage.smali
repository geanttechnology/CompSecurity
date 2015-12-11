.class final Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;
.super Lcom/amazon/identity/auth/device/storage/DataStorage;
.source "NonCanonicalDataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage$GetTokenAction;,
        Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage$GetUserDataAction;,
        Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage$GetAccountsAction;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

.field private final mCAStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 150
    const-class v0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 158
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;-><init>()V

    .line 159
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mContext:Landroid/content/Context;

    .line 160
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_map_account_manager_communicator"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    .line 162
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_customer_attribute_store_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;

    .line 164
    .local v0, "factory":Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;->createCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mCAStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 166
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DataStorage;
    .locals 2
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 49
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    const-string/jumbo v1, "dcp_data_storage_factory"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    instance-of v1, v0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;

    if-eqz v1, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Invalid datastorage"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-object v0
.end method

.method private onError(Ljava/lang/String;)Ljava/lang/RuntimeException;
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 313
    sget-object v0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->TAG:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static shouldUseNonCanonicalDataStorage(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 183
    sget-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralAPK:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/Platform;->hasDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralAPK(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->doesPlatformSupportsMultipleProfiles(Landroid/content/Context;)Z

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
.method public addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
    .locals 1
    .param p1, "displayName"    # Ljava/lang/String;
    .param p2, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;

    .prologue
    .line 239
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public expireToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 296
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

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
    .line 231
    const-string/jumbo v0, "getAccountNames not supported in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
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
    .line 225
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mAccountManagerCommunication:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->getAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 302
    const-string/jumbo v0, "Cannot call device data operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "displayName"    # Ljava/lang/String;

    .prologue
    .line 326
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "It is not supported on NonCanonicalDataStorage!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getDisplayName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 332
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "It is not supported on NonCanonicalDataStorage!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 284
    const-string/jumbo v0, "Cannot call getToken on NonCanonicalStorage. Please use MAP\'s API instead."

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 259
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.UUID"

    invoke-static {p2, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.secondary"

    invoke-static {p2, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"

    invoke-static {p2, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 264
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->mCAStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    invoke-interface {v0, p1, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 265
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getValueOrAttributeDefault(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 270
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Cannot call getUserData on NonCanonicalDataStorage for: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public initialize()V
    .locals 0

    .prologue
    .line 208
    return-void
.end method

.method public removeAccount(Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 245
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
    .locals 1
    .param p1, "accountData"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    .prologue
    .line 320
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "namespace"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 308
    const-string/jumbo v0, "Cannot call device data operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;

    .prologue
    .line 290
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 278
    const-string/jumbo v0, "Cannot call write operations on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method

.method public setup()V
    .locals 0

    .prologue
    .line 214
    return-void
.end method

.method public syncDirtyData()V
    .locals 1

    .prologue
    .line 219
    const-string/jumbo v0, "Cannot call sync dirty data on data storage in non-canonical process"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->onError(Ljava/lang/String;)Ljava/lang/RuntimeException;

    move-result-object v0

    throw v0
.end method
