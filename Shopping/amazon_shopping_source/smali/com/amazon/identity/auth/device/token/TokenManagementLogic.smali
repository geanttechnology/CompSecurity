.class public Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
.super Ljava/lang/Object;
.source "TokenManagementLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mExecutor:Ljava/util/concurrent/Executor;

.field private final mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

.field private final mMAPCookieManager:Lcom/amazon/identity/auth/device/token/MAPCookieManager;

.field private final mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

.field private final mPendingRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

.field private final mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    .line 47
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    .line 49
    .local v0, "backCompatDataStorage":Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;
    new-instance v1, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2, v0}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 51
    new-instance v1, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 53
    new-instance v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    invoke-direct {v1, p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mMAPCookieManager:Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    .line 55
    new-instance v1, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mPendingRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    .line 57
    new-instance v1, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-direct {v1, v2, v3}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    .line 59
    sget-object v1, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->MAP_COMMON_THREAD_POOL:Ljava/util/concurrent/Executor;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mExecutor:Ljava/util/concurrent/Executor;

    .line 60
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;Lcom/amazon/identity/auth/device/token/OAuthTokenManager;Lcom/amazon/identity/auth/device/token/MAPCookieManager;Ljava/util/concurrent/Executor;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "localAppDataAwareDataStorage"    # Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    .param p3, "oAuthTokenManager"    # Lcom/amazon/identity/auth/device/token/OAuthTokenManager;
    .param p4, "mapCookieManager"    # Lcom/amazon/identity/auth/device/token/MAPCookieManager;
    .param p5, "executor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    .line 70
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 72
    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 74
    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mMAPCookieManager:Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    .line 76
    new-instance v0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mPendingRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    .line 78
    new-instance v0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    .line 80
    iput-object p5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mExecutor:Ljava/util/concurrent/Executor;

    .line 81
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

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

.method static synthetic access$100(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p2, "x2"    # Landroid/os/Bundle;

    .prologue
    const/4 v0, 0x0

    .line 29
    if-eqz p2, :cond_0

    const-string/jumbo v1, "ignore.platform.restrictions"

    invoke-virtual {p2, v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mContext:Landroid/content/Context;

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    const/4 v0, 0x1

    :cond_2
    return v0
.end method

.method static synthetic access$1000(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$4;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$4;-><init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;)V

    return-object v0
.end method

.method static synthetic access$1100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->shouldDoRegistrationCheck(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Start to do registration check."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;-><init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p3, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "x3"    # Landroid/os/Bundle;
    .param p4, "x4"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 29
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v0, p1, p2, p3, p5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p4, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Received an error when calling getOAuthAccessToken. ErrorCode: %d ErrorMessage: %s "

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorCode()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorMsg()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorCode()I

    move-result v1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {p4, v1, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    .line 29
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.identity.cookies.xfsn"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$700(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p3, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$800(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Lcom/amazon/identity/auth/device/utils/KeyInfo;)V
    .locals 4
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .param p4, "x4"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 29
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    new-array v0, v2, [Ljava/lang/Object;

    aput-object p2, v0, v3

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x7

    const-string/jumbo v1, "Token key %s is not recognized"

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p3, v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p3, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$900(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Landroid/os/Bundle;
    .param p4, "x4"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mMAPCookieManager:Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getAuthCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 85
    const-class v1, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 87
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    .line 90
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 85
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 187
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    .line 189
    new-instance v5, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v5, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 191
    .local v5, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    iget-object v7, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;

    move-object v1, p0

    move-object v2, p3

    move-object v3, p1

    move-object v4, p2

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;-><init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-interface {v7, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 208
    return-object v5
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v2, 0x8

    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 100
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Getting token "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 102
    new-instance v8, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v8, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 104
    .local v8, "wrapCallback":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 106
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Directed Id given was null. Cannot get tokens for a deregistered device"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    const-string/jumbo v0, "Directed Id given was null. Cannot get tokens for a deregistered device"

    invoke-static {v8, v2, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 132
    .end local v8    # "wrapCallback":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :goto_0
    return-object v8

    .line 112
    .restart local v8    # "wrapCallback":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Token key was empty."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string/jumbo v0, "Token key was empty."

    invoke-static {v8, v2, v0}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0

    .line 120
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mPendingRequestCallbackHolder:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    const-string/jumbo v1, "%s#%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    aput-object p2, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v8}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->waitForInflightRequestOrMakeRequest(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v7

    .line 124
    .local v7, "newRequestCallback":Lcom/amazon/identity/auth/device/api/Callback;
    if-nez v7, :cond_2

    .line 126
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;

    const-string/jumbo v0, "Get token for type %s is already in flight."

    new-array v1, v5, [Ljava/lang/Object;

    aput-object p2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_0

    .line 130
    :cond_2
    new-instance v4, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v4, v7}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 131
    .local v4, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    iget-object v9, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->mExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v5, p1

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;-><init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-interface {v9, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    move-object v8, v4

    .line 132
    goto :goto_0
.end method
