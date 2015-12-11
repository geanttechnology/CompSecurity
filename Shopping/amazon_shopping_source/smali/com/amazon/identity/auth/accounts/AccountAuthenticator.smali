.class public Lcom/amazon/identity/auth/accounts/AccountAuthenticator;
.super Ljava/lang/Object;
.source "AccountAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AccountAuthenticator$1;,
        Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;
    }
.end annotation


# static fields
.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;

    .line 51
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    const-string/jumbo v1, "dcp_data_storage_factory"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;

    invoke-interface {v0}, Lcom/amazon/identity/auth/device/storage/DataStorageFactory;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const-string/jumbo v0, "context"

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 62
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 63
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "dcp_device_info"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 64
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "sso_webservice_caller_creator"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    .line 66
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 67
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 5
    .param p1, "authData"    # Landroid/os/Bundle;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 82
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>()V

    .line 83
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-virtual {p0, p1, v0, p2}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 86
    :try_start_0
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->get()Landroid/os/Bundle;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v2

    .line 104
    :goto_0
    return-object v2

    .line 88
    :catch_0
    move-exception v1

    .line 90
    .local v1, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "MAPCallbackErrorException occurred while authenticating account with panda."

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v2

    goto :goto_0

    .line 95
    .end local v1    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :catch_1
    move-exception v1

    .line 97
    .local v1, "e":Ljava/lang/InterruptedException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "InterruptedException occurred while authenticating account with panda."

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 104
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :goto_1
    const/4 v2, 0x0

    goto :goto_0

    .line 99
    :catch_2
    move-exception v1

    .line 101
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "ExecutionException occurred while authenticating account with panda."

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public authenticateAccount(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 14
    .param p1, "authData"    # Landroid/os/Bundle;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 109
    new-instance v7, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;

    invoke-direct {v7}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;-><init>()V

    .line 110
    .local v7, "request":Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;
    const-string/jumbo v12, "authAccount"

    invoke-virtual {p1, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 111
    .local v5, "login":Ljava/lang/String;
    const-string/jumbo v12, "password"

    invoke-virtual {p1, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 112
    .local v6, "password":Ljava/lang/String;
    const-string/jumbo v12, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p1, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 114
    .local v3, "directedId":Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_0

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 116
    :cond_0
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 117
    .local v4, "error":Landroid/os/Bundle;
    const-string/jumbo v12, "com.amazon.dcp.sso.ErrorCode"

    sget-object v13, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v13}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v13

    invoke-virtual {v4, v12, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 118
    const-string/jumbo v12, "com.amazon.dcp.sso.ErrorMessage"

    const-string/jumbo v13, "A login/directedId and password are required to authenticate/confirmCredential."

    invoke-virtual {v4, v12, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    move-object/from16 v0, p2

    invoke-interface {v0, v4}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 176
    .end local v4    # "error":Landroid/os/Bundle;
    :goto_0
    return-void

    .line 124
    :cond_1
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_2

    .line 126
    invoke-virtual {v7, v5}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setUserID(Ljava/lang/String;)Z

    .line 129
    :cond_2
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_3

    .line 131
    invoke-virtual {v7, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDirectedId(Ljava/lang/String;)Z

    .line 136
    iget-object v12, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v13, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v12, v3, v13}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 137
    .local v8, "sid":Ljava/lang/String;
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_3

    .line 149
    const-string/jumbo v12, "^\"|\"$"

    const-string/jumbo v13, ""

    invoke-virtual {v8, v12, v13}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 150
    .local v9, "trustedDeviceToken":Ljava/lang/String;
    invoke-virtual {v7, v9}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setTrustedDeviceToken(Ljava/lang/String;)V

    .line 154
    .end local v8    # "sid":Ljava/lang/String;
    .end local v9    # "trustedDeviceToken":Ljava/lang/String;
    :cond_3
    invoke-virtual {v7, v6}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setPassword(Ljava/lang/String;)Z

    .line 155
    const-string/jumbo v12, "com.amazon.identity.ap.domain"

    invoke-virtual {p1, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setCookieDomain(Ljava/lang/String;)V

    .line 156
    iget-object v12, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v7, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDeviceInfo(Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)V

    .line 157
    iget-object v12, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v12}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v12

    iget-object v13, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    move-object/from16 v0, p3

    invoke-static {v12, v13, v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->getSigner(Lcom/amazon/identity/platform/setting/PlatformSettings;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    move-result-object v12

    invoke-virtual {v7, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setJwtSigner(Lcom/amazon/identity/kcpsdk/auth/JwtSigner;)V

    .line 159
    const-string/jumbo v12, "calling_package"

    invoke-virtual {p1, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 160
    .local v1, "callingPackage":Ljava/lang/String;
    if-eqz v1, :cond_4

    .line 162
    invoke-virtual {v7, v1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setMetadataAppName(Ljava/lang/String;)V

    .line 163
    iget-object v12, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v12, v1}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    .line 164
    .local v2, "callingPackageVersion":Ljava/lang/Integer;
    if-eqz v2, :cond_4

    .line 166
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v7, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setMetadataAppVersion(Ljava/lang/String;)V

    .line 170
    .end local v2    # "callingPackageVersion":Ljava/lang/Integer;
    :cond_4
    sget-object v12, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v13, "PandaService:SignIn"

    invoke-static {v12, v13}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v12

    .line 171
    move-object/from16 v0, p2

    invoke-static {v12, v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v12

    new-instance v11, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;

    invoke-direct {v11, v12}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator$AuthenticateAccountAmazonWebserviceCallListener;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 174
    .local v11, "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v10

    .line 175
    .local v10, "webRequest":Lcom/amazon/identity/kcpsdk/common/WebRequest;
    new-instance v12, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseParser;

    invoke-direct {v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseParser;-><init>()V

    move-object/from16 v0, p3

    invoke-virtual {p0, v10, v12, v11, v0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto/16 :goto_0
.end method

.method protected invokeWebRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p3, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticator;->mAmazonWebServiceCallerCreator:Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;

    invoke-virtual {v0, p4}, Lcom/amazon/identity/auth/device/framework/AmazonWebServiceCallerCreator;->createSync(Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;

    move-result-object v0

    .line 190
    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;

    move-result-object v0

    .line 192
    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;->call()V

    .line 193
    return-void
.end method
