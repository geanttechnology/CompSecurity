.class public Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;
.super Ljava/lang/Object;
.source "AnonymousCredentialsStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mContext:Landroid/content/Context;

    .line 22
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 24
    .local v0, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 25
    return-void
.end method


# virtual methods
.method public getCredentials()Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .locals 2

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public hasCredentials()Z
    .locals 2

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->getCredentials()Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    .line 47
    .local v0, "credentials":Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getToken()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getPrivateKey()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setCredentials(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;)Z
    .locals 4
    .param p1, "credentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AnonymousAccountCredentials;->ANONYMOUS_CREDENTIALS_NAMESPACE:Ljava/lang/String;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->getPrivateKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const/4 v0, 0x1

    return v0
.end method
