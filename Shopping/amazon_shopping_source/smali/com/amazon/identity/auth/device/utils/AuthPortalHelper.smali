.class public Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;
.super Ljava/lang/Object;
.source "AuthPortalHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    }
.end annotation


# static fields
.field private static final CUSTOM_USER_AGENT:Ljava/lang/String;

.field private static final EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

.field private final mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    const-class v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    .line 39
    const-class v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    invoke-static {v0}, Ljava/util/EnumSet;->allOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN:Ljava/util/Set;

    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "AmazonWebView/MAPClientLib/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildInfo;->getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;

    move-result-object v1

    iget v1, v1, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/Android/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->CUSTOM_USER_AGENT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    .line 56
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-direct {v0, p1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 57
    return-void
.end method

.method private cleanRefreshToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 210
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-static {p2, v1}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->expireToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    return-void
.end method

.method private requireDeregisterAccount(Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Z
    .locals 2
    .param p1, "authTokenExchangeType"    # Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    .param p2, "authEndpointError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    .line 204
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v0

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->InvalidToken:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "jsonResponse"    # Lorg/json/JSONObject;
    .param p5, "responseCode"    # I
    .param p6, "authTokenExchangeType"    # Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    .param p7, "mapAccountManager"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .prologue
    .line 124
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    if-eqz p4, :cond_0

    invoke-virtual {p4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    aput-object v1, v2, v3

    .line 125
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v1, p4}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->parse(Lorg/json/JSONObject;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v0

    .line 127
    .local v0, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    if-nez v0, :cond_1

    .line 129
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Received unrecongized error from the server with status code %d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {p3, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 133
    const/4 v0, 0x0

    .line 157
    .end local v0    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :goto_1
    return-object v0

    .line 124
    :cond_0
    const-string/jumbo v1, "Null Json Response"

    goto :goto_0

    .line 138
    .restart local v0    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->cleanRefreshToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    invoke-direct {p0, p6, v0}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->requireDeregisterAccount(Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz p7, :cond_2

    .line 144
    new-instance v1, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>()V

    invoke-virtual {p7, p1, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 147
    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Received error code: %s \n Message: %s \n Detail: %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getDetail()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    const-string/jumbo v2, "Received Error code %s from the server. Message: %s .Detail: %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getDetail()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {p3, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_1
.end method

.method public handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "jsonResponse"    # Lorg/json/JSONObject;
    .param p4, "responseCode"    # I
    .param p5, "authTokenExchangeType"    # Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;
    .param p6, "mapAccountManager"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 167
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    new-array v2, v6, [Ljava/lang/Object;

    if-eqz p3, :cond_0

    invoke-virtual {p3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    aput-object v1, v2, v5

    .line 168
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v1, p3}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->parse(Lorg/json/JSONObject;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v0

    .line 170
    .local v0, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    if-nez v0, :cond_1

    .line 172
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Received unrecongized error from the server with status code %d"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    const/4 v0, 0x0

    .line 192
    .end local v0    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :goto_1
    return-object v0

    .line 167
    :cond_0
    const-string/jumbo v1, "Null Json Response"

    goto :goto_0

    .line 180
    .restart local v0    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->cleanRefreshToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    invoke-direct {p0, p5, v0}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->requireDeregisterAccount(Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz p6, :cond_2

    .line 184
    new-instance v1, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>()V

    invoke-virtual {p6, p1, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 187
    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Received error code: %s \n Message: %s \n Detail: %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    const/4 v4, 0x2

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getDetail()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public isFailure(I)Z
    .locals 1
    .param p1, "responseCode"    # I

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->isFailure(I)Z

    move-result v0

    return v0
.end method

.method public startIdentityRequest(Landroid/content/Context;Ljava/net/URL;Lorg/apache/http/client/entity/UrlEncodedFormEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/net/HttpURLConnection;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceUrl"    # Ljava/net/URL;
    .param p3, "postBody"    # Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .param p4, "useTokenAuth"    # Z
    .param p6, "directedId"    # Ljava/lang/String;
    .param p7, "packageName"    # Ljava/lang/String;
    .param p8, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/net/URL;",
            "Lorg/apache/http/client/entity/UrlEncodedFormEntity;",
            "Z",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Ljava/net/HttpURLConnection;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 76
    .local p5, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v7, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;

    invoke-direct {v7}, Lcom/amazon/identity/auth/device/framework/AuthErrorRetryLogic;-><init>()V

    move-object/from16 v0, p8

    invoke-static {p2, v7, v0, p1}, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)Ljava/net/HttpURLConnection;

    move-result-object v3

    .line 78
    .local v3, "conn":Ljava/net/HttpURLConnection;
    if-eqz p4, :cond_0

    .line 80
    new-instance v1, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    move-object/from16 v0, p6

    invoke-direct {v1, p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 81
    .local v1, "authMethodFactory":Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
    move-object/from16 v0, p7

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->setPackageName(Ljava/lang/String;)V

    .line 82
    const-string/jumbo v7, "BustedIdentityADPAuthenticator"

    invoke-virtual {v1, v7}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v2

    .line 84
    .local v2, "authenticationMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    invoke-static {v3, v2}, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->openConnection(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v3

    .line 87
    .end local v1    # "authMethodFactory":Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
    .end local v2    # "authenticationMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    :cond_0
    const/4 v7, 0x1

    invoke-virtual {v3, v7}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 88
    const-string/jumbo v7, "Content-Type"

    const-string/jumbo v8, "application/x-www-form-urlencoded"

    invoke-virtual {v3, v7, v8}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    if-eqz p5, :cond_1

    invoke-interface/range {p5 .. p5}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_1

    .line 92
    invoke-interface/range {p5 .. p5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/apache/http/cookie/Cookie;

    .line 94
    .local v4, "cookie":Lorg/apache/http/cookie/Cookie;
    const-string/jumbo v7, "Cookie"

    const-string/jumbo v8, "%s=%s"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-interface {v4}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-interface {v4}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v7, v8}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 98
    .end local v4    # "cookie":Lorg/apache/http/cookie/Cookie;
    .end local v5    # "i$":Ljava/util/Iterator;
    :cond_1
    const-string/jumbo v7, "POST"

    invoke-virtual {v3, v7}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 101
    const-string/jumbo v7, "User-Agent"

    sget-object v8, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->CUSTOM_USER_AGENT:Ljava/lang/String;

    invoke-virtual {v3, v7, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    sget-object v7, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Starting request to exchange token endpoint"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v6

    .line 107
    .local v6, "stream":Ljava/io/OutputStream;
    :try_start_0
    invoke-virtual {p3, v6}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;->writeTo(Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 111
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 113
    return-object v3

    .line 111
    :catchall_0
    move-exception v7

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v7
.end method
