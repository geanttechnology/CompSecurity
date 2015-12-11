.class public Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;
.super Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.source "AnonymousAccountCredentials.java"


# static fields
.field public static final ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;


# instance fields
.field private mAdpToken:Ljava/lang/String;

.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private mPrivateKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 14
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".SHARED_PREFS"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    .line 26
    if-nez p1, :cond_0

    .line 28
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 31
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mContext:Landroid/content/Context;

    .line 33
    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_amazon_account_man"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 35
    iget-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 37
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 38
    return-void
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->populateCredentials()V

    .line 85
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mPrivateKey:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->populateCredentials()V

    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAdpToken:Ljava/lang/String;

    return-object v0
.end method

.method public isStale(Landroid/content/Context;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    .line 45
    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 55
    :cond_0
    :goto_0
    return v2

    .line 50
    :cond_1
    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v4, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "curAdpToken":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v4, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 55
    .local v1, "curPrivateKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAdpToken:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAdpToken:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mPrivateKey:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mPrivateKey:Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected populateCredentials()V
    .locals 3

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAdpToken:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mPrivateKey:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 70
    :goto_0
    return-void

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mAdpToken:Ljava/lang/String;

    .line 68
    iget-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->mPrivateKey:Ljava/lang/String;

    goto :goto_0
.end method
