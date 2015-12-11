.class public Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.super Ljava/lang/Object;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AccountRegistrar$6;,
        Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterDeviceAmazonWebserviceCallListener;,
        Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;,
        Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    }
.end annotation


# static fields
.field private static final GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

.field private final mAuthenticateAccountAction:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

.field private final mContext:Landroid/content/Context;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

.field private final mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

.field private final mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

.field private final mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

.field private final mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 329
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    .line 330
    const-wide/16 v0, 0x1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 350
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 351
    if-nez p1, :cond_0

    .line 353
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "context is null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 356
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    .line 357
    new-instance v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 358
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_device_info"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 359
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_token_mangement"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 360
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 361
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_webservice_caller_creator"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 363
    new-instance v1, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAuthenticateAccountAction:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    .line 364
    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAccountAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    .line 365
    new-instance v1, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 366
    new-instance v1, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 367
    new-instance v1, Lcom/amazon/identity/auth/device/features/FeatureSetCache;

    new-instance v2, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/features/FeatureSetProvider;-><init>(Landroid/content/Context;)V

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/features/FeatureSetCache;-><init>(Lcom/amazon/identity/auth/device/features/FeatureSet;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 368
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 370
    .local v0, "dataStorageFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 372
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/FeatureSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;

    .prologue
    .line 378
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 379
    if-nez p1, :cond_0

    .line 381
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "context is null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 384
    :cond_0
    if-nez p2, :cond_1

    .line 386
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "featureSet is null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 389
    :cond_1
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    .line 390
    new-instance v1, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 391
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_device_info"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 392
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_token_mangement"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 393
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 394
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "sso_webservice_caller_creator"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 396
    new-instance v1, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAuthenticateAccountAction:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    .line 397
    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAccountAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    .line 398
    new-instance v1, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 399
    new-instance v1, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-direct {v1}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 400
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 401
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "dcp_data_storage_factory"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    .line 403
    .local v0, "dataStorageFactory":Lcom/amazon/identity/auth/device/storage/DataStorageFactory;
    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 404
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;Lcom/amazon/identity/auth/device/api/TokenManagement;Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;Lcom/amazon/identity/auth/accounts/AccountAuthenticator;Lcom/amazon/identity/auth/device/token/OAuthTokenManager;Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Lcom/amazon/identity/auth/device/features/FeatureSet;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceInfo"    # Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    .param p3, "tokenManagement"    # Lcom/amazon/identity/auth/device/api/TokenManagement;
    .param p4, "accountManager"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    .param p5, "amazonWebServiceCallerCreator"    # Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;
    .param p6, "authenticateAccountAction"    # Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;
    .param p7, "accountAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
    .param p8, "oAuthTokenManager"    # Lcom/amazon/identity/auth/device/token/OAuthTokenManager;
    .param p9, "delegatedAccountHelper"    # Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;
    .param p10, "amazonAccountManager"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p11, "featureSet"    # Lcom/amazon/identity/auth/device/features/FeatureSet;
    .param p12, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 421
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 422
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    .line 423
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 424
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 425
    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 426
    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 427
    iput-object p6, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAuthenticateAccountAction:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    .line 428
    iput-object p7, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAccountAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    .line 429
    iput-object p8, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 430
    iput-object p9, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 431
    iput-object p10, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 432
    iput-object p11, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    .line 433
    iput-object p12, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 434
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/accounts/AccountRegistrar;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 5
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p1, "x1"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p2, "x2"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v4, 0x0

    .line 86
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->canGetAnonymousCredentials()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    invoke-interface {p2, v4, v4, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    :goto_0
    return-void

    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Attempting to get anonymous credentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;

    invoke-direct {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSecret()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setSecret(Ljava/lang/String;)Z

    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRadioId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setRadioId(Ljava/lang/String;)Z

    invoke-virtual {v2, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setDeviceType(Ljava/lang/String;)Z

    invoke-virtual {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setDeviceSerialNumber(Ljava/lang/String;)Z

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getSoftwareVersion()Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setVersionNumber(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z

    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getSoftwareComponentId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setSoftwareComponentId(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setLocale(Ljava/lang/String;)Z

    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;

    invoke-direct {v0, p0, p2, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$3;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v3, Lcom/amazon/identity/auth/device/features/Feature;->TrustZone:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v1

    invoke-virtual {v2, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setTrustZone(Z)V

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p0, v2, v0, p3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeRegisterWebRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not construct a valid pre-registration request to get anonymous credentials"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p2, v0, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)V
    .locals 5
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p1, "x1"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p2, "x2"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .prologue
    .line 86
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceInfo()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceInfo()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "device attribute received: "

    invoke-direct {v4, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v4, " value: "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v4, "device.metadata"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v4, v1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "device info attribute is null in register Response."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;)Z
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p1, "x1"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .param p2, "x2"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .prologue
    const/4 v0, 0x0

    .line 86
    if-nez p2, :cond_0

    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not save credentials because no AccountRegistrarAuthenticator was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return v0

    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isAnonymousCredentials(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Was expecting anonymous credentials, but recieved account credentials"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getAdpToken()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getPrivateKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;->setAnonymousCredentials(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    goto :goto_0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .param p1, "x1"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 86
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isAnonymousCredentials(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z

    move-result v0

    return v0
.end method

.method private addIgnorePlatformAgnosticToOptions()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 2176
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2177
    .local v0, "options":Landroid/os/Bundle;
    const-string/jumbo v1, "ignore.platform.restrictions"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2178
    return-object v0
.end method

.method private authenticateAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    .locals 9
    .param p1, "email"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "amazonDomain"    # Ljava/lang/String;
    .param p4, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p5, "registrationData"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 923
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAuthenticateAccountAction:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p5

    move-object v5, p6

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->authenticateAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    move-result-object v6

    .line 925
    .local v6, "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    if-nez v6, :cond_1

    .line 927
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v1, 0x0

    invoke-interface {p4, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 928
    const/4 v6, 0x0

    .line 945
    .end local v6    # "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :cond_0
    :goto_0
    return-object v6

    .line 931
    .restart local v6    # "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :cond_1
    invoke-virtual {v6}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->isError()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 933
    const/4 v8, 0x0

    .line 934
    .local v8, "extras":Landroid/os/Bundle;
    iget-object v7, v6, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->challenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    .line 935
    .local v7, "challenge":Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    if-eqz v7, :cond_2

    .line 937
    new-instance v8, Landroid/os/Bundle;

    .end local v8    # "extras":Landroid/os/Bundle;
    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 938
    .restart local v8    # "extras":Landroid/os/Bundle;
    const-string/jumbo v0, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->toBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v8, v0, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 941
    :cond_2
    iget-object v0, v6, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->error:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getRegistrationError()Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v0

    invoke-interface {p4, v0, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 942
    const/4 v6, 0x0

    goto :goto_0
.end method

.method private commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "amazonDomain"    # Ljava/lang/String;
    .param p5, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p6, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p7, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 1254
    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;ZLcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1255
    return-void
.end method

.method private commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;ZLcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 28
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "amazonDomain"    # Ljava/lang/String;
    .param p5, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p6, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p7, "forcePandaRegistration"    # Z
    .param p8, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 1268
    const-string/jumbo v4, "is_delegated_account_registration"

    const/4 v5, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v17

    .line 1270
    .local v17, "isDelegatedAccountRegistration":Ljava/lang/Boolean;
    invoke-static/range {p2 .. p2}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v20

    .line 1273
    .local v20, "pandaEndpointDomain":Ljava/lang/String;
    invoke-static/range {v20 .. v20}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getDomainFromCompleteUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPandaCookieDomain(Ljava/lang/String;)V

    .line 1275
    new-instance v15, Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-direct {v15, v4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;-><init>(Landroid/content/Context;)V

    .line 1278
    .local v15, "cookieManager":Lcom/amazon/identity/auth/device/token/MAPCookieManager;
    invoke-static/range {v20 .. v20}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteCookieDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 1280
    .local v14, "cookieDomainKey":Ljava/lang/String;
    invoke-virtual {v15, v14}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getNonAuthCookies(Ljava/lang/String;)Ljava/util/List;

    move-result-object v19

    .line 1283
    .local v19, "nonAuthCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setNonAuthCookies(Ljava/util/List;)V

    .line 1289
    if-nez p7, :cond_0

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v5, Lcom/amazon/identity/auth/device/features/Feature;->PandaRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1293
    :cond_0
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPandaEndPointDomain(Ljava/lang/String;)V

    .line 1296
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setRegisterEndpoint(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;)V

    .line 1298
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getAddAsSecondaryAccount()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1301
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v22

    .line 1302
    .local v22, "primaryDirectedId":Ljava/lang/String;
    const-string/jumbo v4, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v18

    .line 1307
    .local v18, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    const/4 v5, 0x0

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    move-object/from16 v2, p8

    invoke-virtual {v4, v0, v1, v5, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v21

    .line 1334
    .local v21, "primaryAccessToken":Ljava/lang/String;
    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPrimaryAccessToken(Ljava/lang/String;)Z

    .line 1336
    const-string/jumbo v4, "authAccount"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 1337
    .local v23, "secondaryAccountName":Ljava/lang/String;
    const-string/jumbo v4, "password"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 1338
    .local v24, "secondaryPassword":Ljava/lang/String;
    invoke-static/range {v23 .. v23}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    invoke-static/range {v24 .. v24}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 1340
    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecondaryLogin(Ljava/lang/String;)V

    .line 1341
    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecondaryPassword(Ljava/lang/String;)V

    .line 1347
    .end local v18    # "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .end local v21    # "primaryAccessToken":Ljava/lang/String;
    .end local v22    # "primaryDirectedId":Ljava/lang/String;
    .end local v23    # "secondaryAccountName":Ljava/lang/String;
    .end local v24    # "secondaryPassword":Ljava/lang/String;
    :cond_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v8

    .line 1348
    .local v8, "deviceType":Ljava/lang/String;
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceType(Ljava/lang/String;)Z

    .line 1350
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v9

    .line 1351
    .local v9, "serialNumber":Ljava/lang/String;
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceSerialNumber(Ljava/lang/String;)Z

    .line 1352
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getSoftwareVersion()Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V

    .line 1353
    move-object/from16 v0, p0

    invoke-direct {v0, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getSoftwareComponentId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSoftwareComponentId(Ljava/lang/String;)V

    .line 1354
    const-string/jumbo v4, "calling_package"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 1355
    .local v12, "callingPackage":Ljava/lang/String;
    if-eqz v12, :cond_2

    .line 1357
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setMetadataAppName(Ljava/lang/String;)V

    .line 1358
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-static {v4, v12}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v13

    .line 1359
    .local v13, "callingPackageVersion":Ljava/lang/Integer;
    if-eqz v13, :cond_2

    .line 1361
    invoke-virtual {v13}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setMetadataAppVersion(Ljava/lang/String;)V

    .line 1372
    .end local v13    # "callingPackageVersion":Ljava/lang/Integer;
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSecret()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecret(Ljava/lang/String;)Z

    .line 1374
    invoke-static/range {p4 .. p4}, Lcom/amazon/identity/auth/device/utils/InternationalizationUtil;->fromAmazonDomainToLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setLocale(Ljava/lang/String;)Z

    .line 1375
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getAllMapDeviceTypesAndSoftwareVersion(Landroid/content/Context;Z)Ljava/util/Map;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V

    .line 1379
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->tryRetrieveSelfGeneratedKeyPair(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v4

    const/4 v10, 0x0

    if-nez v4, :cond_4

    sget-object v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Self generated key pair was not available when call register."

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .local v10, "encodedPrivateKey":Ljava/lang/String;
    :goto_0
    move-object/from16 v4, p0

    move-object/from16 v5, p6

    move-object/from16 v6, p5

    move-object/from16 v7, p3

    .line 1381
    invoke-direct/range {v4 .. v10}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRegisterListener(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    move-result-object v26

    .line 1384
    .local v26, "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v5, Lcom/amazon/identity/auth/device/features/Feature;->TrustZone:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setTrustZone(Z)V

    .line 1385
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v25

    .line 1386
    .local v25, "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    if-nez v25, :cond_5

    .line 1388
    sget-object v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not construct a valid registration request"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1389
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v5, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1401
    .end local v8    # "deviceType":Ljava/lang/String;
    .end local v9    # "serialNumber":Ljava/lang/String;
    .end local v10    # "encodedPrivateKey":Ljava/lang/String;
    .end local v12    # "callingPackage":Ljava/lang/String;
    .end local v25    # "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .end local v26    # "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    :goto_1
    return-void

    .line 1309
    .restart local v18    # "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .restart local v22    # "primaryDirectedId":Ljava/lang/String;
    :catch_0
    move-exception v16

    .line 1311
    .local v16, "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    sget-object v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Get error when getting the primary access token for secondary account registration %s."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorMsg()Ljava/lang/String;

    move-result-object v27

    aput-object v27, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1320
    invoke-virtual/range {v16 .. v16}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getAuthEndpointError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v11

    .line 1321
    .local v11, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    if-eqz v11, :cond_3

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v4

    sget-object v5, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidToken:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    if-ne v4, v5, :cond_3

    .line 1324
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v5, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 1329
    :cond_3
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v5, 0x0

    move-object/from16 v0, p6

    invoke-interface {v0, v4, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_1

    .line 1379
    .end local v11    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v16    # "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    .end local v18    # "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .end local v22    # "primaryDirectedId":Ljava/lang/String;
    .restart local v8    # "deviceType":Ljava/lang/String;
    .restart local v9    # "serialNumber":Ljava/lang/String;
    .restart local v12    # "callingPackage":Ljava/lang/String;
    :cond_4
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Self generated key pair was available when call register."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPublicKey()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPublicKeyData(Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getFormat()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPublicKeyFormat(Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getAlgo()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPublicKeyAlgorithm(Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPrivateKey()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 1392
    .restart local v10    # "encodedPrivateKey":Ljava/lang/String;
    .restart local v25    # "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .restart local v26    # "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    :cond_5
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getRegisterEndPoint()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    move-result-object v4

    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    if-ne v4, v5, :cond_6

    .line 1394
    new-instance v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseJsonParser;

    invoke-direct {v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseJsonParser;-><init>()V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    move-object/from16 v3, p8

    invoke-direct {v0, v1, v4, v2, v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_1

    .line 1398
    :cond_6
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v26

    move-object/from16 v3, p8

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeRegisterWebRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_1
.end method

.method private doUpdateCredentials(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v4, 0x0

    .line 1499
    if-nez p4, :cond_0

    .line 1501
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "One or more null parameters"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1504
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1506
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v0, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1575
    :goto_0
    return-void

    .line 1510
    :cond_1
    new-instance v8, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;

    invoke-direct {v8}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;-><init>()V

    .line 1511
    .local v8, "request":Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;
    if-eqz p1, :cond_2

    .line 1513
    invoke-virtual {v8, p1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setURL(Ljava/lang/String;)Z

    .line 1515
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getAllMapDeviceTypesAndSoftwareVersion(Landroid/content/Context;Z)Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V

    .line 1517
    new-instance v6, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;

    invoke-direct {v6, p0, p4, p2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;)V

    .line 1558
    .local v6, "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    invoke-virtual {v8}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v1

    .line 1559
    .local v1, "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    if-eqz v1, :cond_3

    .line 1561
    new-instance v5, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsResponseParser;

    invoke-direct {v5}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsResponseParser;-><init>()V

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 1572
    :cond_3
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not construct a updateCredentials request from this todo item"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1573
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v0, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private getDelegatedAccessTokenOrCallBackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 9
    .param p1, "directedIdPrimary"    # Ljava/lang/String;
    .param p2, "directedIdDelegated"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v8, 0x0

    .line 1114
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 1115
    .local v4, "options":Landroid/os/Bundle;
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.delegateeaccount"

    invoke-virtual {v4, v5, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1116
    const-string/jumbo v5, "com.amazon.identity.ap.domain"

    invoke-virtual {v4, v5, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1118
    const/4 v2, 0x0

    .line 1120
    .local v2, "isListenerCalled":Z
    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v3

    .line 1121
    .local v3, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v5, p2, v3, v4, p5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 1168
    .local v0, "delegatedAccessToken":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    if-nez v2, :cond_0

    .line 1170
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Failed to get delegated access token for unknown reason."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1171
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1174
    :cond_0
    return-object v0

    .line 1127
    .end local v0    # "delegatedAccessToken":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 1129
    .local v1, "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Got error when getting the delegated access token: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorMsg()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1131
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorCode()I

    move-result v5

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v6

    if-ne v5, v6, :cond_1

    .line 1133
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "The delegatee account is already deregistered."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1134
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1135
    const/4 v2, 0x1

    .line 1157
    :goto_1
    const/4 v0, 0x0

    .line 1165
    .restart local v0    # "delegatedAccessToken":Ljava/lang/String;
    goto :goto_0

    .line 1137
    .end local v0    # "delegatedAccessToken":Ljava/lang/String;
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getAuthEndpointError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getAuthEndpointError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v5

    sget-object v6, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->Forbidden:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    if-ne v5, v6, :cond_2

    .line 1140
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "The delegatedd account is not valid in the household."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1141
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1142
    const/4 v2, 0x1

    goto :goto_1

    .line 1144
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorCode()I

    move-result v5

    const/4 v6, 0x3

    if-ne v5, v6, :cond_3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getCause()Ljava/lang/Throwable;

    move-result-object v5

    if-eqz v5, :cond_3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getCause()Ljava/lang/Throwable;

    move-result-object v5

    instance-of v5, v5, Ljava/io/IOException;

    if-eqz v5, :cond_3

    .line 1147
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Cannot register the delegated account due to a network error."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1148
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1149
    const/4 v2, 0x1

    goto :goto_1

    .line 1153
    :cond_3
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Got unknown error when getting the delegated access token"

    invoke-static {v5, v6, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1154
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1155
    const/4 v2, 0x1

    goto :goto_1

    .line 1159
    .end local v1    # "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    :catch_1
    move-exception v1

    .line 1161
    .local v1, "e":Ljava/lang/Exception;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Got Unknown error when getting the delegated access token."

    invoke-static {v5, v6, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1162
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v5, v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1163
    const/4 v2, 0x1

    .line 1164
    const/4 v0, 0x0

    .restart local v0    # "delegatedAccessToken":Ljava/lang/String;
    goto/16 :goto_0
.end method

.method private getRegisterListener(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .locals 10
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "deviceType"    # Ljava/lang/String;
    .param p5, "serialNumber"    # Ljava/lang/String;
    .param p6, "privateKeyOverWrite"    # Ljava/lang/String;

    .prologue
    .line 1742
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object v1, p0

    move-object v2, p1

    move-object v4, p2

    move-object v5, p3

    move-object/from16 v6, p6

    move-object v7, p1

    move-object v8, p5

    move-object v9, p4

    invoke-direct/range {v0 .. v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$4;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/MAPAccountManager;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private getSoftwareComponentId(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 2191
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const/4 v2, 0x0

    invoke-static {v1, p1, v2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getSoftwareComponentId(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2192
    .local v0, "softwareComponentId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2194
    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Software component id is null. Central device type not being used, or DCP setting -device-/os_package_name not set for this device."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 2197
    :cond_0
    return-object v0
.end method

.method private invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x0

    .line 1937
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v2

    .local v2, "primaryAccount":Ljava/lang/String;
    move-object v0, p0

    move-object v1, p1

    move-object v4, v3

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    .line 1942
    invoke-virtual/range {v0 .. v7}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1943
    return-void
.end method

.method private isAnonymousCredentials(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Z
    .locals 4
    .param p1, "response"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    const/4 v2, 0x0

    .line 2076
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 2077
    .local v1, "name":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v0

    .line 2078
    .local v0, "deviceName":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getDirectedId()Ljava/lang/String;

    move-result-object v3

    .line 2079
    if-eqz v3, :cond_1

    .line 2084
    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz v1, :cond_2

    if-nez v0, :cond_0

    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private isSecondaryAccountRegistration(Landroid/os/Bundle;)Z
    .locals 1
    .param p1, "options"    # Landroid/os/Bundle;

    .prologue
    .line 689
    const-string/jumbo v0, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->hasDevicePrimaryAmazonAccount()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "regData"    # Landroid/os/Bundle;
    .param p3, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p4, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p5, "tokenType"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x0

    .line 1225
    if-nez p4, :cond_0

    .line 1227
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "One or more arguments are null or empty"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1230
    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1232
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v0, v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 1244
    :goto_0
    return-void

    .line 1236
    :cond_1
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;-><init>()V

    .line 1237
    .local v1, "request":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
    invoke-virtual {v1, p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setCustomerAccountToken(Ljava/lang/String;)Z

    .line 1238
    invoke-virtual {v1, p5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setCustomerAccountTokenType(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;)V

    .line 1239
    const-string/jumbo v0, "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 1240
    .local v8, "clientContext":Ljava/lang/String;
    invoke-virtual {v1, v8}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setClientContext(Ljava/lang/String;)V

    .line 1241
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isSecondaryAccountRegistration(Landroid/os/Bundle;)Z

    move-result v0

    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setAddAsSecondaryAccount(Z)V

    move-object v0, p0

    move-object v2, p2

    move-object v4, v3

    move-object v5, p3

    move-object v6, p4

    move-object v7, p6

    .line 1243
    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method


# virtual methods
.method authenticateAccountWithDirectedId(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "amazonDomain"    # Ljava/lang/String;
    .param p4, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p5, "registrationData"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v2, 0x0

    .line 971
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 972
    .local v0, "authData":Landroid/os/Bundle;
    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 973
    const-string/jumbo v3, "password"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 974
    const-string/jumbo v3, "com.amazon.identity.ap.domain"

    invoke-virtual {v0, v3, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 975
    const-string/jumbo v3, "calling_package"

    const-string/jumbo v4, "calling_package"

    invoke-virtual {p5, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 978
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAccountAuthenticator:Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    invoke-virtual {v3, v0, p6}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v1

    .line 980
    .local v1, "outData":Landroid/os/Bundle;
    if-nez v1, :cond_1

    .line 982
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "null auth data returned while authenticating."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 983
    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p4, v3, v2}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    move-object v1, v2

    .line 995
    .end local v1    # "outData":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-object v1

    .line 986
    .restart local v1    # "outData":Landroid/os/Bundle;
    :cond_1
    const-string/jumbo v3, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 988
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Error occurred while authenticating. Error code: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v5, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValue(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 991
    const-string/jumbo v3, "com.amazon.dcp.sso.ErrorCode"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->fromValue(I)Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    move-result-object v3

    invoke-interface {p4, v3, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    move-object v1, v2

    .line 993
    goto :goto_0
.end method

.method protected canGetAnonymousCredentials()Z
    .locals 1

    .prologue
    .line 2021
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/RegisterAccountHelper;->canRegisterWithDeviceSecret(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 9
    .param p1, "responseListener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "directedId"    # Ljava/lang/String;
    .param p4, "accountCredentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p5, "deregisterAllAccounts"    # Z
    .param p6, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p7, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 494
    if-nez p1, :cond_0

    .line 496
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "No response set. Could not deregister"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 499
    :cond_0
    if-nez p3, :cond_1

    .line 501
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Deregister failed because an account was not specified."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DEREGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v1, 0x0

    invoke-interface {p1, v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    .line 513
    :goto_0
    return-void

    .line 506
    :cond_1
    if-nez p3, :cond_2

    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "deregister passed null account"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The account cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v6, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;

    invoke-direct {v6}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;-><init>()V

    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->setDidDeleteContent(Z)V

    invoke-virtual {v6, p5}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->setDeregisterAllAccountsForDevice(Z)V

    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;

    move-object v1, p0

    move-object v2, p1

    move v3, p5

    move-object v4, p6

    move-object/from16 v5, p7

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$2;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-virtual {v6}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v2

    new-instance v6, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;

    invoke-direct {v6}, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponseParser;-><init>()V

    move-object v1, p0

    move-object v3, p3

    move-object v4, p2

    move-object v5, p4

    move-object v7, v0

    move-object/from16 v8, p7

    invoke-virtual/range {v1 .. v8}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method

.method public deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "responseListener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "directedId"    # Ljava/lang/String;
    .param p4, "deregisterAllAccounts"    # Z
    .param p5, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v2, 0x0

    .line 466
    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    move-object v4, v2

    move v5, p4

    move-object v6, p5

    move-object v7, p6

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 473
    return-void
.end method

.method public deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 7
    .param p1, "responseListener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "deregisterAllAccounts"    # Z
    .param p4, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 447
    const/4 v2, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 448
    return-void
.end method

.method public getAccountCredentialsFromTokenAndKey(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    .line 2119
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAdpTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->addIgnorePlatformAgnosticToOptions()Landroid/os/Bundle;

    move-result-object v3

    sget-wide v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v6

    .line 2124
    .local v6, "adpToken":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getPrivateKeyKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->addIgnorePlatformAgnosticToOptions()Landroid/os/Bundle;

    move-result-object v3

    sget-wide v4, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v9

    .line 2130
    .local v9, "key":Ljava/lang/String;
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;

    invoke-direct {v0, p0, v6, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;-><init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_3

    .line 2170
    .end local v6    # "adpToken":Ljava/lang/String;
    .end local v9    # "key":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 2151
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v8

    .line 2154
    .local v8, "errorBundle":Landroid/os/Bundle;
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token failed because of callback error. Error Bundle: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v10

    .line 2155
    goto :goto_0

    .line 2157
    .end local v8    # "errorBundle":Landroid/os/Bundle;
    :catch_1
    move-exception v7

    .line 2159
    .local v7, "e":Ljava/lang/InterruptedException;
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token failed because of InterruptedException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v10

    .line 2160
    goto :goto_0

    .line 2162
    .end local v7    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v7

    .line 2164
    .local v7, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token failed because of ExecutionException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v10

    .line 2165
    goto :goto_0

    .line 2167
    .end local v7    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_3
    move-exception v7

    .line 2169
    .local v7, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token failed because of TimeoutException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v10

    .line 2170
    goto :goto_0
.end method

.method protected getCookieJar(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;)Lcom/amazon/identity/auth/device/storage/CookieJar;
    .locals 2
    .param p1, "registerResponse"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .prologue
    .line 2000
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CookieJar;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getCookiesRetrievedFromFIRS()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/CookieJar;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method protected getDeviceSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2005
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSecret()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2010
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getRadioId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2016
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected invokeRegisterWebRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 7
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;
    .param p2, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 1888
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v1

    .line 1889
    .local v1, "directedId":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v5, v1, p3}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->createSync(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;

    move-result-object v0

    .line 1894
    .local v0, "caller":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    :try_start_0
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v5

    new-instance v6, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    invoke-interface {v0, v5, v6, p2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;->call(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .line 1901
    .local v3, "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    if-eqz v3, :cond_0

    .line 1903
    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getServerTime()Ljava/lang/String;

    move-result-object v4

    .line 1904
    .local v4, "serverTime":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 1906
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "The server timestamp is "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 1907
    const-string/jumbo v5, "ClockSkewHappened"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 1908
    invoke-virtual {p1, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->setTimestamp(Ljava/lang/String;)V

    .line 1909
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v5

    new-instance v6, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    invoke-interface {v0, v5, v6, p2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;->call(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    check-cast v3, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .line 1916
    .end local v4    # "serverTime":Ljava/lang/String;
    .restart local v3    # "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :cond_0
    invoke-interface {p2, v3}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onResponseComplete(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_2

    .line 1930
    .end local v3    # "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_0
    return-void

    .line 1920
    :catch_0
    move-exception v5

    invoke-interface {p2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onNetworkFailure()V

    goto :goto_0

    .line 1922
    :catch_1
    move-exception v2

    .line 1924
    .local v2, "e":Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;->getError()Lcom/amazon/identity/kcpsdk/common/ParseError;

    move-result-object v5

    invoke-interface {p2, v5}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    goto :goto_0

    .line 1928
    .end local v2    # "e":Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
    :catch_2
    move-exception v5

    invoke-interface {p2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;->onNetworkFailure()V

    goto :goto_0
.end method

.method protected invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 3
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "accountCredentials"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p5, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p6, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p7, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 1955
    if-nez p3, :cond_0

    .line 1959
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v2, p2, p7}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->createSync(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;

    move-result-object v1

    .line 1972
    .local v1, "caller":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    :goto_0
    invoke-interface {v1, p1, p5, p6}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;

    move-result-object v2

    .line 1974
    invoke-interface {v2}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;->call()V

    .line 1975
    return-void

    .line 1963
    .end local v1    # "caller":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    :cond_0
    move-object v0, p4

    .line 1964
    .local v0, "accountCredentialsToSync":Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    if-nez p4, :cond_1

    .line 1966
    invoke-virtual {p0, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getAccountCredentialsFromTokenAndKey(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v0

    .line 1969
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v2, v0, p7}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->createSync(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;

    move-result-object v1

    .restart local v1    # "caller":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;
    goto :goto_0
.end method

.method public register(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 35
    .param p1, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p3, "givenRegData"    # Landroid/os/Bundle;
    .param p4, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 521
    if-nez p1, :cond_0

    .line 523
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "No response set. Could not register"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 526
    :cond_0
    if-nez p2, :cond_1

    .line 528
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "No registration type set. Could not register"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 531
    :cond_1
    if-eqz p3, :cond_3

    move-object/from16 v10, p3

    .line 533
    .local v10, "regData":Landroid/os/Bundle;
    :goto_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getDevicePrimaryAmazonAccount()Ljava/lang/String;

    move-result-object v33

    .line 534
    .local v33, "primaryAmazonAccount":Ljava/lang/String;
    if-eqz v33, :cond_6

    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4

    const/4 v5, 0x0

    :goto_1
    if-nez v5, :cond_6

    .line 536
    move-object/from16 v0, p1

    move-object/from16 v1, v33

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->accountAlreadyExists(Ljava/lang/String;)V

    .line 634
    :cond_2
    :goto_2
    return-void

    .line 531
    .end local v10    # "regData":Landroid/os/Bundle;
    .end local v33    # "primaryAmazonAccount":Ljava/lang/String;
    :cond_3
    new-instance v10, Landroid/os/Bundle;

    invoke-direct {v10}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 534
    .restart local v10    # "regData":Landroid/os/Bundle;
    .restart local v33    # "primaryAmazonAccount":Ljava/lang/String;
    :cond_4
    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_ACCESS_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_LOGIN_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->REGISTER_DELEGATED_ACCOUNT:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->FROM_AUTH_TOKEN:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DIRECTEDID_CREDENTIALS:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_EXPLICIT_URL:Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-object/from16 v0, p2

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p2

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v11, "is not currently supported to add secondary accounts "

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v5, 0x0

    goto :goto_1

    :cond_5
    const/4 v5, 0x1

    goto :goto_1

    .line 539
    :cond_6
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar$6;->$SwitchMap$com$amazon$identity$auth$device$api$RegistrationType:[I

    invoke-virtual/range {p2 .. p2}, Lcom/amazon/identity/auth/device/api/RegistrationType;->ordinal()I

    move-result v9

    aget v5, v5, v9

    packed-switch v5, :pswitch_data_0

    .line 632
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Unrecognized or unsupported registration type."

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 633
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_2

    .line 542
    :pswitch_0
    const-string/jumbo v5, "authAccount"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 543
    .local v6, "login":Ljava/lang/String;
    const-string/jumbo v5, "password"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 544
    .local v7, "password":Ljava/lang/String;
    if-eqz v6, :cond_7

    if-nez v7, :cond_8

    .line 546
    :cond_7
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Must provide an Amazon login and password to register with it"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 547
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 551
    :cond_8
    invoke-static {v10}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v8

    .line 552
    .local v8, "amazonDomain":Ljava/lang/String;
    if-nez p1, :cond_9

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "Listener is null"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_9
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_a

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_b

    :cond_a
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_b
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isSecondaryAccountRegistration(Landroid/os/Bundle;)Z

    move-result v5

    if-nez v5, :cond_e

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v9, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v5, v9}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v5

    if-eqz v5, :cond_d

    move-object/from16 v5, p0

    move-object/from16 v9, p1

    move-object/from16 v11, p5

    invoke-direct/range {v5 .. v11}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->authenticateAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    move-result-object v5

    if-eqz v5, :cond_2

    :cond_c
    iget-object v12, v5, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->accessToken:Ljava/lang/String;

    sget-object v16, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v11, p0

    move-object v13, v10

    move-object/from16 v14, p4

    move-object/from16 v15, p1

    move-object/from16 v17, p5

    invoke-direct/range {v11 .. v17}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    :cond_d
    new-instance v12, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-direct {v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;-><init>()V

    invoke-virtual {v12, v6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setLogin(Ljava/lang/String;)Z

    invoke-virtual {v12, v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPassword(Ljava/lang/String;)Z

    move-object/from16 v11, p0

    move-object v13, v10

    move-object v14, v6

    move-object v15, v8

    move-object/from16 v16, p4

    move-object/from16 v17, p1

    move-object/from16 v18, p5

    invoke-direct/range {v11 .. v18}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    :cond_e
    move-object/from16 v5, p0

    move-object/from16 v9, p1

    move-object/from16 v11, p5

    invoke-direct/range {v5 .. v11}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->authenticateAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    move-result-object v5

    if-eqz v5, :cond_2

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iget-object v11, v5, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->directedId:Ljava/lang/String;

    invoke-virtual {v9, v11}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_c

    sget-object v9, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "Secondary account already exists on the device"

    invoke-static {v9, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v5, v5, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->directedId:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->accountAlreadyExists(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 555
    .end local v6    # "login":Ljava/lang/String;
    .end local v7    # "password":Ljava/lang/String;
    .end local v8    # "amazonDomain":Ljava/lang/String;
    :pswitch_1
    if-nez p1, :cond_f

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "listener is null"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_f
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v15

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSecret()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/StringUtil;->isEmptyOrWhitespace(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_10

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "No device secret for registeration"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/RegistrationType;->WITH_DEVICE_SECRET:Lcom/amazon/identity/auth/device/api/RegistrationType;

    invoke-static {v5}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->registrationBadSecret(Lcom/amazon/identity/auth/device/api/RegistrationType;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_SECRET:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_10
    new-instance v9, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;

    invoke-direct {v9}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;-><init>()V

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setSecret(Ljava/lang/String;)Z

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRadioId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setRadioId(Ljava/lang/String;)Z

    invoke-virtual {v9, v15}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setDeviceType(Ljava/lang/String;)Z

    move-object/from16 v0, v16

    invoke-virtual {v9, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setDeviceSerialNumber(Ljava/lang/String;)Z

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getSoftwareVersion()Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-result-object v5

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setVersionNumber(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getSoftwareComponentId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setSoftwareComponentId(Ljava/lang/String;)V

    const-string/jumbo v5, "NoState"

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setReason(Ljava/lang/String;)Z

    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setLocale(Ljava/lang/String;)Z

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const/4 v11, 0x0

    invoke-static {v5, v11}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getAllMapDeviceTypesAndSoftwareVersion(Landroid/content/Context;Z)Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v9, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->tryRetrieveSelfGeneratedKeyPair(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v5

    const/16 v17, 0x0

    if-nez v5, :cond_11

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "Self generated key pair was not available when call register with device secret."

    invoke-static {v5, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_3
    const/4 v14, 0x0

    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move-object/from16 v13, p4

    invoke-direct/range {v11 .. v17}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRegisterListener(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v13, Lcom/amazon/identity/auth/device/features/Feature;->TrustZone:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v11, v13}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v11

    invoke-virtual {v9, v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setTrustZone(Z)V

    invoke-virtual {v9}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v9

    if-eqz v9, :cond_12

    new-instance v11, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-direct {v0, v9, v11, v5, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    :cond_11
    sget-object v11, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v13, "Self generated key pair was available when call register with device secret."

    invoke-static {v11, v13}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPublicKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setPublicKeyData(Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getFormat()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setPublicKeyFormat(Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getAlgo()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->setPublicKeyAlgorithm(Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->getEncodedPrivateKey()Ljava/lang/String;

    move-result-object v17

    goto :goto_3

    :cond_12
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Could not construct a valid pre-registration request"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 558
    :pswitch_2
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.ATMain"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 559
    .local v12, "atmainToken":Ljava/lang/String;
    if-nez v12, :cond_13

    .line 561
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Must provide at-main to register with it"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 562
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 566
    :cond_13
    sget-object v16, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AT_MAIN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v11, p0

    move-object v13, v10

    move-object/from16 v14, p4

    move-object/from16 v15, p1

    move-object/from16 v17, p5

    invoke-direct/range {v11 .. v17}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 574
    .end local v12    # "atmainToken":Ljava/lang/String;
    :pswitch_3
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AuthToken"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 575
    .local v14, "authToken":Ljava/lang/String;
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v31

    .line 576
    .local v31, "authTokenContext":Ljava/lang/String;
    invoke-static {v10}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v30

    .line 577
    .local v30, "authCookieDomain":Ljava/lang/String;
    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_14

    invoke-static/range {v31 .. v31}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_14

    invoke-static/range {v30 .. v30}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 580
    :cond_14
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Must provide the auth token, the auth token context, and the auth token domain to register with it"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 582
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 587
    :cond_15
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v9, Lcom/amazon/identity/auth/device/features/Feature;->RegistrationViaAuthToken:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v5, v9}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v5

    if-nez v5, :cond_16

    .line 589
    const-string/jumbo v32, "Registration via auth token is not supported on this platform"

    .line 590
    .local v32, "errorMsg":Ljava/lang/String;
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    move-object/from16 v0, v32

    invoke-static {v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 594
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 598
    .end local v32    # "errorMsg":Ljava/lang/String;
    :cond_16
    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v13, p0

    move-object v15, v10

    move-object/from16 v16, p4

    move-object/from16 v17, p1

    move-object/from16 v19, p5

    invoke-direct/range {v13 .. v19}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 606
    .end local v14    # "authToken":Ljava/lang/String;
    .end local v30    # "authCookieDomain":Ljava/lang/String;
    .end local v31    # "authTokenContext":Ljava/lang/String;
    :pswitch_4
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 607
    .local v16, "accessToken":Ljava/lang/String;
    if-nez v16, :cond_17

    .line 609
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Must provide access token to register with it"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 610
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 614
    :cond_17
    sget-object v20, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v15, p0

    move-object/from16 v17, v10

    move-object/from16 v18, p4

    move-object/from16 v19, p1

    move-object/from16 v21, p5

    invoke-direct/range {v15 .. v21}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 622
    .end local v16    # "accessToken":Ljava/lang/String;
    :pswitch_5
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.URL"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v34

    .line 623
    .local v34, "url":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v34

    move-object/from16 v2, p4

    move-object/from16 v3, p1

    move-object/from16 v4, p5

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithExplicitUrl(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 626
    .end local v34    # "url":Ljava/lang/String;
    :pswitch_6
    if-eqz v10, :cond_18

    if-nez p1, :cond_19

    :cond_18
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "One or more arguments are null or empty"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_19
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.delegateeaccount"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1a

    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1b

    :cond_1a
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Either the delegated account %s or the delegatee account %s is not valid."

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v13, 0x0

    aput-object v19, v11, v13

    const/4 v13, 0x1

    aput-object v18, v11, v13

    invoke-static {v9, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_1b
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1c

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "The delegated account already exists on the device"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->accountAlreadyExists(Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_1c
    const-string/jumbo v5, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    const/4 v9, 0x1

    invoke-virtual {v10, v5, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    const-string/jumbo v5, "is_delegated_account_registration"

    const/4 v9, 0x1

    invoke-virtual {v10, v5, v9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-virtual {v5, v10}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->getDelegationDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v20

    const/4 v5, 0x0

    invoke-static/range {v20 .. v20}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_1d

    const-string/jumbo v9, "www.amazon.com"

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1e

    :cond_1d
    const-string/jumbo v5, "ATVPDKIKX0DER"

    :goto_4
    if-eqz v5, :cond_22

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v11, Lcom/amazon/identity/auth/device/features/Feature;->CombinedDelegatedAuthenticationAndRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v9, v11}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v9

    if-eqz v9, :cond_22

    sget-object v9, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "Using combined delegated account registration with pfm="

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    if-nez p1, :cond_20

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "One or more arguments are null or empty"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_1e
    const-string/jumbo v9, "www.amazon.co.uk"

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1f

    const-string/jumbo v5, "A1F83G8C2ARO7P"

    goto :goto_4

    :cond_1f
    sget-object v9, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "Can\'t use combined delegated registration for domain: "

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_4

    :cond_20
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_21

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_21
    new-instance v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-direct/range {v18 .. v18}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;-><init>()V

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecondaryDirectedId(Ljava/lang/String;)V

    const/4 v9, 0x1

    move-object/from16 v0, v18

    invoke-virtual {v0, v9}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setAddAsChildAccount(Z)V

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setPfmOfDelegatee(Ljava/lang/String;)V

    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->isSecondaryAccountRegistration(Landroid/os/Bundle;)Z

    move-result v5

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setAddAsSecondaryAccount(Z)V

    const/16 v20, 0x0

    const/16 v21, 0x0

    move-object/from16 v17, p0

    move-object/from16 v19, v10

    move-object/from16 v22, p4

    move-object/from16 v23, p1

    move-object/from16 v24, p5

    invoke-direct/range {v17 .. v24}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    :cond_22
    move-object/from16 v17, p0

    move-object/from16 v21, p1

    move-object/from16 v22, p5

    invoke-direct/range {v17 .. v22}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDelegatedAccessTokenOrCallBackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_23

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Failed to get the delegated Access token. Quitting the register delegated account procedure"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_23
    sget-object v22, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v17, p0

    move-object/from16 v19, v10

    move-object/from16 v20, p4

    move-object/from16 v21, p1

    move-object/from16 v23, p5

    invoke-direct/range {v17 .. v23}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 629
    :pswitch_7
    const-string/jumbo v5, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    const-string/jumbo v5, "password"

    invoke-virtual {v10, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    if-eqz v18, :cond_24

    if-nez v19, :cond_25

    :cond_24
    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Must provide an Amazon directedId and password to register with it"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_25
    invoke-static {v10}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v20

    if-nez p1, :cond_26

    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v9, "Listener is null"

    invoke-direct {v5, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    :cond_26
    invoke-static/range {v18 .. v18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_27

    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_28

    :cond_27
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_28
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_29

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "The device is not registered. Can not add secondary account."

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->CUSTOMER_NOT_FOUND:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    const/4 v9, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v5, v9}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto/16 :goto_2

    :cond_29
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExistAfterDeregisteringStateCleanup(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2a

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Secondary account already exists on the device"

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->accountAlreadyExists(Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_2a
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mFeatureSet:Lcom/amazon/identity/auth/device/features/FeatureSet;

    sget-object v9, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistrationWithDirectedId:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v5, v9}, Lcom/amazon/identity/auth/device/features/FeatureSet;->hasFeature(Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v5

    if-eqz v5, :cond_2c

    move-object/from16 v17, p0

    move-object/from16 v21, p1

    move-object/from16 v22, v10

    move-object/from16 v23, p5

    invoke-virtual/range {v17 .. v23}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->authenticateAccountWithDirectedId(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v5

    if-nez v5, :cond_2b

    sget-object v5, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v9, " null auth data was returned. registration is not successful."

    invoke-static {v5, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_2b
    const-string/jumbo v9, "com.amazon.dcp.sso.AddAccount.options.AccessToken"

    invoke-virtual {v5, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    sget-object v22, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v17, p0

    move-object/from16 v19, v10

    move-object/from16 v20, p4

    move-object/from16 v21, p1

    move-object/from16 v23, p5

    invoke-direct/range {v17 .. v23}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->registerWithCustomerAccountToken(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    :cond_2c
    new-instance v22, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-direct/range {v22 .. v22}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;-><init>()V

    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    move-object/from16 v0, v22

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setRegisterEndpoint(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecondaryDirectedId(Ljava/lang/String;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setSecondaryPassword(Ljava/lang/String;)V

    const/4 v5, 0x1

    move-object/from16 v0, v22

    invoke-virtual {v0, v5}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->setAddAsSecondaryAccount(Z)V

    const/16 v24, 0x0

    const/16 v28, 0x1

    move-object/from16 v21, p0

    move-object/from16 v23, v10

    move-object/from16 v25, v20

    move-object/from16 v26, p4

    move-object/from16 v27, p1

    move-object/from16 v29, p5

    invoke-direct/range {v21 .. v29}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->commonRegisterDeviceRequest(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;ZLcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_2

    .line 539
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public registerWithExplicitUrl(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 10
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "accountRegAuth"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p3, "listener"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x0

    .line 1465
    if-nez p3, :cond_0

    .line 1467
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Listner is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1470
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v5

    .line 1471
    .local v5, "serialNumber":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v4

    .line 1473
    .local v4, "deviceType":Ljava/lang/String;
    new-instance v7, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;

    invoke-direct {v7}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;-><init>()V

    .line 1474
    .local v7, "request":Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;
    invoke-virtual {v7, p1}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setURL(Ljava/lang/String;)Z

    .line 1475
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->mContext:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getAllMapDeviceTypesAndSoftwareVersion(Landroid/content/Context;Z)Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v7, v0}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V

    move-object v0, p0

    move-object v1, p3

    move-object v2, p2

    move-object v6, v3

    .line 1477
    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getRegisterListener(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;

    move-result-object v9

    .line 1480
    .local v9, "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v8

    .line 1482
    .local v8, "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    if-eqz v8, :cond_1

    .line 1484
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;-><init>()V

    invoke-direct {p0, v8, v0, v9, p4}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 1491
    :goto_0
    return-void

    .line 1488
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not construct a registration request from this todo item"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1489
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-interface {p3, v0, v3}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;->failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method protected tryRetrieveSelfGeneratedKeyPair(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 2026
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;->retrieveSelfGeneratedKeyPair()Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;

    move-result-object v0

    return-object v0
.end method

.method public updateCredentials(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "response"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v3, 0x0

    .line 703
    if-nez p1, :cond_0

    .line 705
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "No response set. Could not update credentials"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 708
    :cond_0
    if-eqz p3, :cond_1

    const-string/jumbo v0, "com.amazon.dcp.sso.AddAccount.options.URL"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .local v1, "url":Ljava/lang/String;
    :goto_0
    move-object v0, p0

    move-object v2, p2

    move-object v4, p1

    move-object v5, p5

    .line 710
    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->doUpdateCredentials(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 711
    return-void

    .end local v1    # "url":Ljava/lang/String;
    :cond_1
    move-object v1, v3

    .line 708
    goto :goto_0
.end method

.method public updateCredentials(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p1, "response"    # Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "options"    # Landroid/os/Bundle;
    .param p5, "accountRegistrarAuthenticator"    # Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 720
    if-nez p1, :cond_0

    .line 722
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "No response set. Could not update credentials"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 725
    :cond_0
    if-nez p3, :cond_1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    .line 727
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->updateCredentials(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 734
    :goto_0
    return-void

    .line 731
    :cond_1
    if-eqz p4, :cond_2

    const-string/jumbo v0, "com.amazon.dcp.sso.AddAccount.options.URL"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .local v1, "url":Ljava/lang/String;
    :goto_1
    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p1

    move-object v5, p6

    .line 732
    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->doUpdateCredentials(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 731
    .end local v1    # "url":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method
