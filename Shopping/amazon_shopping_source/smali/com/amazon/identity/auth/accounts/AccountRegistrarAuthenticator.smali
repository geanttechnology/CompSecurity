.class public Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
.super Ljava/lang/Object;
.source "AccountRegistrarAuthenticator.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mContext:Landroid/content/Context;

    .line 25
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 27
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 28
    return-void
.end method


# virtual methods
.method public clearAnonymousCredentials()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 43
    invoke-virtual {p0, v0, v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->setAnonymousCredentials(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public getAdpToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getPrivateKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasAnonymousCredentials()Z
    .locals 5

    .prologue
    .line 48
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v3, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v4, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "adpToken":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v3, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v4, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 55
    .local v1, "privateKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public setAnonymousCredentials(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v0, v1, v2, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v0, v1, v2, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    return-void
.end method
