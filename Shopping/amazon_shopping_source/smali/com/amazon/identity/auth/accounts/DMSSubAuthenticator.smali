.class public Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
.super Ljava/lang/Object;
.source "DMSSubAuthenticator.java"

# interfaces
.implements Lcom/amazon/dcp/sso/ISubAuthenticator;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$6;,
        Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    }
.end annotation


# static fields
.field private static final KINDLE_DEVICE_EMAIL:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field private final mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDeviceType:Ljava/lang/String;

.field private final mIsMultipleAccountAware:Z

.field private final mMultipleAccountsLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

.field private final mOverrideDsn:Ljava/lang/String;

.field private final mPackageName:Ljava/lang/String;

.field private final mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

.field private final mSoftwareComponentId:Ljava/lang/String;

.field private final mTokenAccountPool:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenDeviceName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenStoreAuthCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenTypeAppDeviceType:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenTypeAppDsn:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenTypeEmail:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenUserName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mTokenXmainCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

.field private final mVersionCode:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 87
    const-string/jumbo v0, "com.amazon.kindle"

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceEmailFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->KINDLE_DEVICE_EMAIL:Ljava/lang/String;

    .line 90
    const-class v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "deviceType"    # Ljava/lang/String;
    .param p4, "overrideDsn"    # Ljava/lang/String;
    .param p5, "softwareVersion"    # Ljava/lang/Integer;
    .param p6, "isMultipleAccountAware"    # Z

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 128
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v3, "dcp_amazon_account_man"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 130
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mMultipleAccountsLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 132
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v3, "dcp_data_storage_factory"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 134
    .local v1, "factory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v1}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 136
    new-instance v2, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 138
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v3, "sso_webservice_caller_creator"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 141
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v3, "sso_platform"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 143
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    .line 144
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    .line 145
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mPackageName:Ljava/lang/String;

    .line 146
    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mVersionCode:Ljava/lang/Integer;

    .line 151
    invoke-static {p1, p3, p2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getSoftwareComponentId(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mSoftwareComponentId:Ljava/lang/String;

    .line 153
    iput-boolean p6, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mIsMultipleAccountAware:Z

    .line 155
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSAdpTokenNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 160
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSPrivateKeyFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 165
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceTypeFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.devicedevicetype"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppDeviceType:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 170
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceSerialNumberFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppDsn:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 173
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSDeviceEmailFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.property.deviceemail"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeEmail:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 178
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDMSStoreAuthCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.identity.cookies.xfsn"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenStoreAuthCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 181
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getXmainCookieFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.cookie.xmain"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenXmainCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 184
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getDeviceNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.property.devicename"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenDeviceName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 189
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getUserNameFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.property.username"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenUserName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 195
    new-instance v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-static {p2}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->getAccountPoolFromPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-static {v4, p3, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithDeviceTypePrefix(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenAccountPool:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    .line 201
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;-><init>(Landroid/content/Context;)V

    .line 202
    .local v0, "cookieDataStorageFactory":Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->getDataStore()Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    .line 203
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .param p1, "x1"    # Landroid/os/Bundle;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 61
    const-string/jumbo v0, "com.amazon.dcp.sso.dms.ErrorCode"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p1    # "x1":Landroid/os/Bundle;
    :goto_0
    return-object p1

    .restart local p1    # "x1":Landroid/os/Bundle;
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-virtual {v0, p2, p3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    const-string/jumbo v0, "Requested token type was not found in authenticator cache."

    const/16 v1, 0x68

    invoke-direct {p0, v1, v0}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object p1

    goto :goto_0

    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->KINDLE_DEVICE_EMAIL:Ljava/lang/String;

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v1, p2, v0}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendDeviceEmailChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    :cond_2
    const-string/jumbo v1, "authtoken"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;)V
    .locals 6
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .param p1, "x1"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "x2"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p3, "x3"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x5

    .line 61
    if-nez p2, :cond_1

    const-string/jumbo v0, "Could not parse response"

    invoke-interface {p1, v4, v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getError()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    move-result-object v1

    const/4 v0, 0x0

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$6;->$SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType:[I

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Invalid Response: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->getErrorString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v4, v1}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V

    :goto_1
    if-eqz v0, :cond_0

    invoke-interface {p1, v0}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V

    goto :goto_0

    :pswitch_0
    const/16 v0, 0x64

    const-string/jumbo v1, "Invalid username or password"

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    goto :goto_1

    :pswitch_1
    const/16 v0, 0x65

    const-string/jumbo v1, "Device already registered to another user."

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    goto :goto_1

    :pswitch_2
    const/16 v0, 0x66

    const-string/jumbo v1, "Duplicate device name"

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    goto :goto_1

    :pswitch_3
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Unrecognized Response "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->getErrorString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v4, v1}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V

    goto :goto_1

    :cond_2
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CookieJar;

    invoke-virtual {p2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCookiesRetrievedFromFIRS()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/CookieJar;-><init>(Ljava/util/List;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getXmain()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->isRunningOnMainThread()Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$3;-><init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    :cond_3
    invoke-direct {p0, p2, p3, v4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInner(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Callback with success after storing tokens for the child app."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->onSuccessCallback(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;ILjava/lang/String;)Landroid/os/Bundle;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .param p1, "x1"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInner(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .param p1, "x1"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->onSuccessCallback(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/device/storage/DataStorage;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    return-object v0
.end method

.method private buildSubAuthenticatorErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;
    .locals 4
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 789
    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Error gettingAuthToken "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 790
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 792
    .local v0, "resultBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.dcp.sso.dms.ErrorCode"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 793
    const-string/jumbo v1, "com.amazon.dcp.sso.dms.ErrorMessage"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 795
    return-object v0
.end method

.method public static constructDMSSubAuthForDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceType"    # Ljava/lang/String;
    .param p2, "overrideDsn"    # Ljava/lang/String;
    .param p3, "softwareVersion"    # Ljava/lang/Integer;
    .param p4, "packageName"    # Ljava/lang/String;

    .prologue
    .line 255
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    const/4 v6, 0x1

    move-object v1, p0

    move-object v2, p4

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V

    return-object v0
.end method

.method public static constructDMSSubAuthForThisPackage(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 223
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 224
    .local v2, "packageName":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v8

    .line 225
    .local v8, "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-nez v8, :cond_0

    .line 227
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Could not construct DMSSubAuthenticator for this package ("

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v3, ") because it\'s not properly integrated with MAP"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 230
    :cond_0
    invoke-static {p0, v2}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    .line 234
    .local v5, "softwareVersion":Ljava/lang/Integer;
    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v8}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getOverrideDSN()Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x1

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 241
    :catch_0
    move-exception v7

    .line 243
    .local v7, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Could not construct DMSSubAuthenticator for this package ("

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v3, ") because we couldn\'t query its MAP info provider"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public static constructDMSSubAuthenticatorFromDescription(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "subAuthDescription"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .prologue
    .line 208
    iget-object v0, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    iget-object v1, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->deviceType:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getLegacySubAuthPackageDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 212
    .local v3, "deviceType":Ljava/lang/String;
    iget-object v0, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    .line 213
    .local v5, "softwareVersion":Ljava/lang/Integer;
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iget-object v2, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->packageName:Ljava/lang/String;

    const/4 v4, 0x0

    iget-boolean v6, p1, Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;->isKnownMultipleAccountAware:Z

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V

    return-object v0
.end method

.method private getParentDsn(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1158
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 1160
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    aput-object v2, v0, v1

    .line 1161
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    .line 1167
    :goto_0
    return-object v0

    .line 1164
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 1167
    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.deviceserialname"

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private onSuccessCallback(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V
    .locals 4
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    .prologue
    .line 821
    :try_start_0
    invoke-static {}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->createSuccessBundle()Landroid/os/Bundle;

    move-result-object v1

    .line 822
    .local v1, "resultBundle":Landroid/os/Bundle;
    invoke-interface {p1, v1}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 828
    .end local v1    # "resultBundle":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 824
    :catch_0
    move-exception v0

    .line 826
    .local v0, "e":Landroid/os/RemoteException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Error Callback Success"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static populateChildApplicationTokensWithoutRegister(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "deviceType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/identity/auth/device/storage/AccountTransaction;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x0

    .line 267
    if-eqz p3, :cond_0

    invoke-interface {p3}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 269
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "The input device type or map is null or empty. Ignoring it."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    :cond_1
    :goto_0
    return-void

    .line 273
    :cond_2
    invoke-static {p0, p2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplication(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 278
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    const/4 v6, 0x1

    move-object v1, p0

    move-object v3, p2

    move-object v4, v2

    move-object v5, v2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V

    .line 279
    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokensForChildApp(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method private registerChildApplication$55988019(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "childAppRegistrar"    # Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;
    .param p3, "directedId"    # Ljava/lang/String;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 528
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;

    invoke-direct {v0, p0, p1, p3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$2;-><init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;)V

    .line 612
    .local v0, "callback":Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;
    new-instance v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-direct {v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;-><init>()V

    invoke-virtual {v5, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setUseExchangeToken(Z)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    invoke-virtual {v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceType(Ljava/lang/String;)Z

    invoke-direct {p0, p3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->getParentDsn(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceSerialNumber(Ljava/lang/String;)Z

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSet;

    move-result-object v6

    invoke-static {v2, v6}, Lcom/amazon/identity/auth/accounts/ChildApplicationOverrideDSNHelper;->isOverridingDSN(Ljava/lang/String;Lcom/amazon/identity/auth/device/features/FeatureSet;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v5, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setUseOverrideDSN(Z)V

    :cond_0
    iget-boolean v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mIsMultipleAccountAware:Z

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v2, p3}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isDevicePrimaryAmazonAccount(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    move v2, v3

    :goto_0
    if-eqz v2, :cond_1

    sget-object v6, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Registering secondary account for device type %s"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    aput-object v8, v3, v4

    invoke-static {v7, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    invoke-virtual {v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setAddAsSecondaryAccount(Z)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mVersionCode:Ljava/lang/Integer;

    if-eqz v2, :cond_2

    new-instance v2, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mVersionCode:Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V

    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mSoftwareComponentId:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v5, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSoftwareComponentId(Ljava/lang/String;)V

    :cond_3
    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v1

    .line 614
    .local v1, "registerChildApplicationRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    if-eqz v1, :cond_5

    .line 616
    invoke-interface {p2, p3, v1, v0, p4}, Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;->registerChild(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrarCallback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 623
    :goto_1
    return-void

    .end local v1    # "registerChildApplicationRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    :cond_4
    move v2, v4

    .line 612
    goto :goto_0

    .line 620
    .restart local v1    # "registerChildApplicationRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    :cond_5
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not construct a valid child application registration request"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private setTokensInAccountTransaction(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p2, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p3, "xmain"    # Ljava/lang/String;
    .param p4, "parentDsn"    # Ljava/lang/String;

    .prologue
    .line 696
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAdpToken()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 697
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPrivateKey()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 698
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenStoreAuthCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getStoreAuthenticationCookie()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 701
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenXmainCookie:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-direct {p0, p2, v0, p3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeTokenInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 703
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppDeviceType:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 704
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppDsn:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-direct {p0, p2, v0, p4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 705
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeEmail:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 706
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenDeviceName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 707
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenUserName:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getUserName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 708
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenAccountPool:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAccountPool()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V

    .line 712
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getFeatureSet()Lcom/amazon/identity/auth/device/features/FeatureSet;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mPackageName:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mOverrideDsn:Ljava/lang/String;

    invoke-static {v0, p2, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->setChildApplicationWithDeviceTypeRegistered(Lcom/amazon/identity/auth/device/features/FeatureSet;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 717
    return-void
.end method

.method private storeTokenInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V
    .locals 4
    .param p1, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "key"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 723
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Local storeToken: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 724
    if-nez p3, :cond_1

    .line 726
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Tried to set token %s to null"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 737
    :cond_0
    :goto_0
    return-void

    .line 729
    :cond_1
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 731
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    invoke-virtual {p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 733
    :cond_2
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 735
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    invoke-virtual {p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setToken(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private storeTokenInner(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "xmain"    # Ljava/lang/String;

    .prologue
    .line 681
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->getParentDsn(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 682
    .local v1, "parentDsn":Ljava/lang/String;
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-direct {v0, p2, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 687
    .local v0, "accountTransaction":Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    invoke-direct {p0, p1, v0, p3, v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->setTokensInAccountTransaction(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;)V

    .line 688
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mBackwardsCompatiableDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V

    .line 689
    return-void
.end method

.method private storeUserDataInAccountTransaction(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;Ljava/lang/String;)V
    .locals 4
    .param p1, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "key"    # Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 743
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Local storeUserData: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 744
    if-nez p3, :cond_1

    .line 746
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Tried to set user data %s to null"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 758
    :cond_0
    :goto_0
    return-void

    .line 749
    :cond_1
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 752
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    invoke-virtual {p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 754
    :cond_2
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 756
    iget-object v0, p2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    invoke-virtual {p1, v0, p3}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->setUserData(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private wrapResponseWithGetTokenAndMetrics(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .locals 6
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "authTokenType"    # Ljava/lang/String;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 323
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p4

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$1;-><init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 2

    .prologue
    .line 1153
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "asBinder is not supported in DMSSubAuthenticator"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getAccountRemovalAllowed(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "response"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;

    .prologue
    .line 1098
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "DMS sub authenticator getAccountRemovalAllowed was called"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1100
    new-instance v3, Landroid/accounts/Account;

    invoke-direct {v3, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1101
    .local v3, "account":Landroid/accounts/Account;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mPlatform:Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPreMergeDevice()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    .line 1103
    :goto_0
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 1104
    .local v6, "result":Landroid/os/Bundle;
    const-string/jumbo v0, "booleanResult"

    const/4 v1, 0x1

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1107
    :try_start_0
    invoke-interface {p1, v6}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1113
    :goto_1
    return-void

    .line 1101
    .end local v6    # "result":Landroid/os/Bundle;
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Generating local account removed broadcast."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0, v3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->clearCookies(Landroid/content/Context;Ljava/lang/String;)Z

    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cleared local cookies in pre merge devices"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mMultipleAccountsLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->isAPrimaryAccount(Ljava/lang/String;)Z

    move-result v1

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getPackageName()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mMultipleAccountsLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v5, v7, v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getListOfProfilesWhereTheAccountIsPrimary(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;

    move-result-object v5

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAccountRemovedNotification(Landroid/content/Context;ZLjava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/util/Set;)V

    goto :goto_0

    .line 1111
    .restart local v6    # "result":Landroid/os/Bundle;
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "RemoteException during getAccountRemovalAllowed in DMS sub authenticator"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 7
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;
    .param p4, "authTokenType"    # Ljava/lang/String;
    .param p5, "options"    # Landroid/os/Bundle;
    .param p6, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 290
    const-string/jumbo v5, "DMSSubAuthenticator:GetAuthToken"

    invoke-static {v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v3

    .line 292
    .local v3, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v5, "com.amazon.account"

    invoke-virtual {v5, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 294
    sget-object v5, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "An Attempt to retrieve a token for a non amazon account."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    :goto_0
    return-void

    .line 298
    :cond_0
    new-instance v0, Landroid/accounts/Account;

    invoke-direct {v0, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    .local v0, "account":Landroid/accounts/Account;
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v5, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    .line 302
    .local v2, "directedId":Ljava/lang/String;
    invoke-direct {p0, p1, v2, p4, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->wrapResponseWithGetTokenAndMetrics(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    move-result-object v4

    .line 306
    .local v4, "wrappedResponse":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    if-eqz p6, :cond_1

    .line 308
    new-instance v1, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;

    invoke-direct {v1, p6}, Lcom/amazon/identity/auth/accounts/SubAuthChildApplicationRegistrar;-><init>(Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V

    .line 315
    .local v1, "childAppRegistrar":Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;
    :goto_1
    invoke-direct {p0, v4, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->registerChildApplication$55988019(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 312
    .end local v1    # "childAppRegistrar":Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;
    :cond_1
    new-instance v1, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v1, v5}, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;-><init>(Landroid/content/Context;)V

    .restart local v1    # "childAppRegistrar":Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;
    goto :goto_1
.end method

.method public registerChildApplication(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 365
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isInvalidChildDeviceType(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 367
    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "An Attempt to register an invalid child device type: %s. This is due to wrong integration with MAP."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Child Application registration failed due to invalid child device type. This is due to wrong integration with MAP."

    invoke-interface {p1, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 417
    :goto_0
    return-void

    .line 377
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "RemoteException on callback error for account not existing."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 383
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v1, p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 385
    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "An Attempt to register a child device type for a non-existant amazon account. This can happen if the device has been deregistered during this flow."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 392
    :try_start_1
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Child Application registration failed due to account not being registered on the device. This can happen if the device has been deregistered during this flow."

    invoke-interface {p1, v1, v2}, Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;->onError(ILjava/lang/String;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 397
    :catch_1
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "RemoteException on callback error for account not existing."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 407
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    invoke-static {v1, p2, v2}, Lcom/amazon/identity/auth/accounts/ChildApplicationHelpers;->isChildApplicationDeviceTypeRegistered(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 409
    sget-object v1, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Child Application device type %s is already registered"

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDeviceType:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 410
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->onSuccessCallback(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;)V

    goto :goto_0

    .line 414
    :cond_2
    new-instance v0, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;-><init>(Landroid/content/Context;)V

    .line 416
    .local v0, "standardChildAppRegistrar":Lcom/amazon/identity/auth/accounts/StandardChildApplicationRegistrar;
    invoke-direct {p0, p1, v0, p2, p4}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->registerChildApplication$55988019(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Lcom/amazon/identity/auth/accounts/ChildApplicationRegistrar;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public storeTokensForChildApp(Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/util/Map;)V
    .locals 17
    .param p1, "accountTransaction"    # Lcom/amazon/identity/auth/device/storage/AccountTransaction;
    .param p2, "deviceType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/storage/AccountTransaction;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 423
    .local p3, "tokenMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p3, :cond_0

    invoke-interface/range {p3 .. p3}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "The pre-populated credential map does not have any valid data, ignoring it for device type: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v12, 0x0

    .line 426
    .local v12, "registerResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_0
    if-nez v12, :cond_6

    .line 443
    :goto_1
    return-void

    .line 423
    .end local v12    # "registerResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :cond_1
    const-string/jumbo v2, "adp_token"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string/jumbo v2, "device_private_key"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "The pre-populated credential map does not have valid ADP credentials, ignoring it for device type: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "The pre-populated credential map contains the following  invalid key: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface/range {p3 .. p3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v12, 0x0

    goto :goto_0

    :cond_3
    const-string/jumbo v2, "store_authentication_cookie"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v14, v2

    check-cast v14, Ljava/lang/String;

    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "The batch registration did not return store auth cookie for device type: "

    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    const-string/jumbo v2, "user_device_name"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_a

    const-string/jumbo v2, "com.amazon.dcp.sso.property.devicename"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Using the device name: %s of central device type for child device type: %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v4, v6, v7

    const/4 v7, 0x1

    aput-object p2, v6, v7

    invoke-static {v2, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    :goto_2
    const-string/jumbo v2, "kindle_email_address"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_9

    const-string/jumbo v2, "com.amazon.dcp.sso.property.deviceemail"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Using the device email: %s of central device type for child device type: %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v7, v6, v8

    const/4 v8, 0x1

    aput-object p2, v6, v8

    invoke-static {v2, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    :goto_3
    const-string/jumbo v2, "name"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_8

    const-string/jumbo v2, "com.amazon.dcp.sso.property.username"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Using the username: %s of central device type for child device type: %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v6, v8, v15

    const/4 v15, 0x1

    aput-object p2, v8, v15

    invoke-static {v2, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    :goto_4
    const-string/jumbo v2, "account_pool"

    move-object/from16 v0, p3

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_5

    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.accountpool"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-object v8, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Using the account pool: %s of central device type for child device type: %s"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object v2, v15, v16

    const/16 v16, 0x1

    aput-object p2, v15, v16

    invoke-static {v8, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    :cond_5
    move-object v15, v2

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    const/4 v8, 0x0

    invoke-direct/range {v2 .. v8}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    invoke-virtual {v2, v14}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setStoreAuthenticationCookie(Ljava/lang/String;)V

    invoke-virtual {v2, v15}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setAccountPool(Ljava/lang/String;)V

    move-object v12, v2

    goto/16 :goto_0

    .line 431
    .restart local v12    # "registerResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :cond_6
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "There are %d pre-populated tokens for child device type: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface/range {p3 .. p3}, Ljava/util/Map;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 435
    invoke-interface/range {p3 .. p3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 437
    .local v10, "key":Ljava/lang/String;
    sget-object v2, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Pre-populating the token: %s for child device type: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v10, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_5

    .line 440
    .end local v10    # "key":Ljava/lang/String;
    :cond_7
    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.xmain"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 441
    .local v13, "xMain":Ljava/lang/String;
    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.deviceserialname"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->getUserData(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 442
    .local v11, "parentDsn":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v12, v1, v13, v11}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->setTokensInAccountTransaction(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v11    # "parentDsn":Ljava/lang/String;
    .end local v12    # "registerResponse":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .end local v13    # "xMain":Ljava/lang/String;
    :cond_8
    move-object v6, v2

    goto/16 :goto_4

    :cond_9
    move-object v7, v2

    goto/16 :goto_3

    :cond_a
    move-object v4, v2

    goto/16 :goto_2
.end method

.method public updateAuthToken(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;)V
    .locals 6
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "accountType"    # Ljava/lang/String;
    .param p3, "accountName"    # Ljava/lang/String;
    .param p4, "authTokenType"    # Ljava/lang/String;
    .param p5, "options"    # Landroid/os/Bundle;
    .param p6, "authenticator"    # Lcom/amazon/dcp/sso/IAmazonAccountAuthenticator;

    .prologue
    .line 838
    const-string/jumbo v4, "DMSSubAuthenticator:UpdateAuthToken"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v2

    .line 840
    .local v2, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    sget-object v4, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Updating DMS authentication tokens"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 842
    new-instance v0, Landroid/accounts/Account;

    invoke-direct {v0, p3, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 844
    .local v0, "account":Landroid/accounts/Account;
    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v4, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v1

    .line 845
    .local v1, "directedId":Ljava/lang/String;
    invoke-direct {p0, p1, v1, p4, v2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->wrapResponseWithGetTokenAndMetrics(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;

    move-result-object v3

    .line 848
    .local v3, "wrappedResponse":Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    invoke-virtual {p0, v3, v1, p5, v2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->updateCredentials(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 849
    return-void
.end method

.method public updateCredentials(Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "subAuthenticatorResponse"    # Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 856
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;-><init>()V

    .line 857
    .local v1, "request":Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mVersionCode:Ljava/lang/Integer;

    if-eqz v3, :cond_0

    .line 859
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mVersionCode:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z

    .line 862
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mSoftwareComponentId:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 864
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setSoftwareComponentId(Ljava/lang/String;)V

    .line 867
    :cond_1
    new-instance v0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$4;-><init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Lcom/amazon/dcp/sso/ISubAuthenticatorResponse;Ljava/lang/String;)V

    .line 933
    .local v0, "listener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v2

    .line 935
    .local v2, "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    new-instance v3, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsResponseParser;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsResponseParser;-><init>()V

    new-instance v4, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;

    invoke-direct {v4, p0, p2}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;-><init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v5, v4, p4}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->create(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    move-result-object v4

    invoke-virtual {v4, v2, v3, v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->call()V

    .line 941
    return-void
.end method
