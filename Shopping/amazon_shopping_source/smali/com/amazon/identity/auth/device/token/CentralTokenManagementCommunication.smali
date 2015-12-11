.class public Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;
.super Ljava/lang/Object;
.source "CentralTokenManagementCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetCookiesCommand;,
        Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetTokenCommand;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

.field private mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 117
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 120
    new-instance v0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v2, "com.amazon.dcp.sso.ErrorCode"

    const-string/jumbo v3, "com.amazon.dcp.sso.ErrorMessage"

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    .line 125
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 9
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Landroid/accounts/Account;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Landroid/os/Bundle;
    .param p5, "x5"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 35
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v4

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    move-result-object v2

    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getTokenCache(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v3

    const-string/jumbo v5, "true"

    const-string/jumbo v6, "force_refresh_dms_to_oauth_done_once"

    invoke-virtual {v3, p3, v6}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    move v7, v0

    :goto_0
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-static {v3, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    if-nez v7, :cond_0

    if-eqz p4, :cond_3

    const-string/jumbo v3, "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken"

    invoke-virtual {p4, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    :cond_0
    invoke-direct {p0, p3, v2}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->invalidateAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache;)V

    const-string/jumbo v3, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v5, p3, v3}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->expireTokenValue(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_1
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v3

    new-array v8, v0, [Ljava/lang/String;

    aput-object v3, v8, v1

    new-instance v0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;

    move-object v1, p0

    move-object v5, p3

    move-object v6, p5

    invoke-direct/range {v0 .. v7}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;-><init>(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Z)V

    invoke-virtual {v2, v8, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->fetchTokens([Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V

    return-void

    :cond_2
    move v7, v1

    goto :goto_0

    :cond_3
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    if-nez v3, :cond_4

    new-instance v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v3, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    :cond_4
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v3, p3, v4, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->shouldRefreshExistingAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-direct {p0, p3, v2}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->invalidateAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache;)V

    goto :goto_1
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    return-object v0
.end method

.method private invalidateAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tokenCache"    # Lcom/amazon/identity/auth/device/token/TokenCache;

    .prologue
    .line 366
    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {p2, v1}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 368
    .local v0, "accessTokenValue":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v1, p1, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->expireTokenValue(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 369
    return-void
.end method


# virtual methods
.method public getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
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
    .line 155
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v2, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetCookiesCommand;

    invoke-static {p1, p2, p3, p5}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetCookiesCommand;->parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 160
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
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
    const/4 v0, 0x0

    .line 134
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 136
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mGenericIpcSender:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    const-class v1, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetTokenCommand;

    invoke-static {p1, p2, p3}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$GetTokenCommand;->parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2, v6}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->call(Ljava/lang/Class;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 144
    :goto_0
    return-object v6

    .line 138
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isOtter(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    :goto_1
    if-eqz v0, :cond_5

    .line 140
    new-instance v6, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v6, p4}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v3

    if-nez v3, :cond_3

    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v1, "Given Customer Does not exist"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 138
    :cond_2
    invoke-static {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPreMergeDevice(Landroid/content/Context;)Z

    move-result v0

    goto :goto_1

    .line 140
    :cond_3
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    const/16 v0, 0x8

    const-string/jumbo v1, "Token key was empty."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_4
    new-instance v0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;

    move-object v1, p0

    move-object v2, p2

    move-object v4, p1

    move-object v5, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$1;-><init>(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Ljava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 144
    :cond_5
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v6

    goto :goto_0
.end method
