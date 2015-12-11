.class public Lcom/amazon/identity/auth/device/token/OAuthTokenManager;
.super Ljava/lang/Object;
.source "OAuthTokenManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    }
.end annotation


# static fields
.field public static final ACCESS_TOKEN:Ljava/lang/String; = "access_token"

.field public static final APP_NAME:Ljava/lang/String; = "app_name"

.field public static final APP_VERSION:Ljava/lang/String; = "app_version"

.field public static final AUTH_COOKIES:Ljava/lang/String; = "auth_cookies"

.field public static final BEARER_TOKEN:Ljava/lang/String; = "bearer_token"

.field public static final DELEGATED_ACCESS_TOKEN:Ljava/lang/String; = "delegated_access_token"

.field public static final DIRECTED_ID:Ljava/lang/String; = "directed_id"

.field public static final DMS_TOKEN:Ljava/lang/String; = "dms_token"

.field public static final DOMAIN:Ljava/lang/String; = "domain"

.field public static final EXPIRES_IN:Ljava/lang/String; = "expires_in"

.field public static final FORCE_REFRESH_DMS_TO_OAUTH_DONE_ONCE_TRUE:Ljava/lang/String; = "true"

.field private static final FUDGE_FACTOR:J

.field public static final KEY_FORCE_REFRESH_DMS_TO_OAUTH_DONE_ONCE:Ljava/lang/String; = "force_refresh_dms_to_oauth_done_once"

.field public static final KEY_OAUTH_REFRESHED_AT:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field public static final REFRESH_TOKEN:Ljava/lang/String; = "refresh_token"

.field public static final REQUESTED_TOKEN_TYPE:Ljava/lang/String; = "requested_token_type"

.field public static final SOURCE_TOKEN:Ljava/lang/String; = "source_token"

.field public static final SOURCE_TOKEN_TYPE:Ljava/lang/String; = "source_token_type"

.field private static final TAG:Ljava/lang/String;

.field public static final TOKEN:Ljava/lang/String; = "token"

.field public static final TOKEN_EXPIRES_IN:Ljava/lang/String; = "token_expires_in"

.field public static final TOKEN_TYPE:Ljava/lang/String; = "token_type"


# instance fields
.field private final mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

.field private final mContext:Landroid/content/Context;

.field private final mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

.field private final mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

.field private final mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

.field private final mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 138
    const-wide/16 v0, 0x1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->FUDGE_FACTOR:J

    .line 145
    const-class v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    .line 147
    const-class v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    .line 174
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_system"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 176
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 178
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    .line 180
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 182
    new-instance v0, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 184
    new-instance v0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    .line 185
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "authPortalHelper"    # Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;
    .param p3, "delegatedAccountHelper"    # Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .prologue
    .line 193
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 194
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    .line 196
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_system"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 198
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    .line 200
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    .line 202
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 204
    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    .line 206
    new-instance v0, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    .line 207
    return-void
.end method

.method private addAppParams(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1096
    .local p1, "postParams":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v1, "app_name"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1097
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v1, "app_version"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildInfo;->getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;

    move-result-object v2

    iget v2, v2, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1098
    return-void
.end method

.method private createErrorMsg(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Ljava/lang/String;
    .locals 4
    .param p1, "authEndpointError"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    .prologue
    .line 823
    if-eqz p1, :cond_0

    .line 825
    const-string/jumbo v0, "Received Error code %s from the server. Message: %s Detail: %s"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getMessage()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getDetail()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 832
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "Invalid error response received from the token exchange endpoint"

    goto :goto_0
.end method

.method private exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 22
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "returnRefreshToken"    # Z
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 610
    if-nez p1, :cond_0

    .line 612
    new-instance v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/16 v3, 0x8

    const-string/jumbo v6, "Given Account is currently not valid"

    invoke-direct {v2, v3, v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v2

    .line 616
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Exchange DMS token to OAuth token for package"

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 618
    const/16 v18, 0x0

    .line 622
    .local v18, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v3, "exchangeDMSCredentialsForOAuthToken"

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v21

    .line 624
    .local v21, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct/range {p0 .. p1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getExchangeTokenURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v4

    .line 625
    .local v4, "serviceURL":Ljava/net/URL;
    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Exchanging DMS token with exchange token endpoint: "

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 627
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v6, "source_token_type"

    const-string/jumbo v7, "dms_token"

    invoke-direct {v3, v6, v7}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v6, "source_token"

    const-string/jumbo v7, "source_token"

    invoke-direct {v3, v6, v7}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v6, "requested_token_type"

    const-string/jumbo v7, "refresh_token"

    invoke-direct {v3, v6, v7}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->addAppParams(Ljava/util/List;)V

    new-instance v5, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v3, "UTF-8"

    invoke-direct {v5, v2, v3}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 628
    .local v5, "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object/from16 v8, p1

    move-object/from16 v9, p2

    move-object/from16 v10, p4

    invoke-virtual/range {v2 .. v10}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->startIdentityRequest(Landroid/content/Context;Ljava/net/URL;Lorg/apache/http/client/entity/UrlEncodedFormEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/net/HttpURLConnection;

    move-result-object v18

    .line 638
    invoke-virtual/range {v18 .. v18}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v10

    .line 639
    .local v10, "responseCode":I
    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Response received for exchange DMS to OAuth end-point"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 640
    invoke-static/range {v18 .. v18}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v9

    .line 641
    .local v9, "jsonResponse":Lorg/json/JSONObject;
    invoke-virtual/range {v21 .. v21}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 643
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    invoke-virtual {v2, v10}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->isFailure(I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 647
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    sget-object v11, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->DMSTokenToOauthTokenExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object/from16 v7, p1

    move-object/from16 v8, p2

    invoke-virtual/range {v6 .. v12}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v17

    .line 655
    .local v17, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->createErrorMsg(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Ljava/lang/String;

    move-result-object v20

    .line 656
    .local v20, "errorMsg":Ljava/lang/String;
    const-string/jumbo v3, "exchangeDMSCredentialsForOAuthTokenFailure"

    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/String;

    const/4 v7, 0x0

    if-nez v17, :cond_2

    const-string/jumbo v2, "InvalidErrorResponse"

    :goto_0
    aput-object v2, v6, v7

    invoke-static {v3, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 659
    new-instance v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v3

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    invoke-direct {v2, v3, v0, v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    throw v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 669
    .end local v4    # "serviceURL":Ljava/net/URL;
    .end local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v9    # "jsonResponse":Lorg/json/JSONObject;
    .end local v10    # "responseCode":I
    .end local v17    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v20    # "errorMsg":Ljava/lang/String;
    .end local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_0
    move-exception v19

    .line 671
    .local v19, "e":Ljava/io/IOException;
    :try_start_1
    const-string/jumbo v2, "exchangeDMSCredentialsForOAuthTokenFailure:IOException"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 672
    new-instance v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v3, 0x3

    invoke-virtual/range {v19 .. v19}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v2, v3, v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 688
    .end local v19    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    if-eqz v18, :cond_1

    .line 690
    invoke-virtual/range {v18 .. v18}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_1
    throw v2

    .line 656
    .restart local v4    # "serviceURL":Ljava/net/URL;
    .restart local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .restart local v9    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v10    # "responseCode":I
    .restart local v17    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .restart local v20    # "errorMsg":Ljava/lang/String;
    .restart local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_2
    :try_start_2
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->name()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 663
    .end local v17    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v20    # "errorMsg":Ljava/lang/String;
    :cond_3
    const-string/jumbo v2, "exchangeDMSCredentialsForOAuthTokenSuccess"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 664
    const-string/jumbo v2, "response"

    invoke-virtual {v9, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string/jumbo v3, "expires_in"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v14

    const-string/jumbo v3, "token_type"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v6, "refresh_token"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    const-string/jumbo v6, "access_token"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    const-string/jumbo v2, "bearer_token"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    new-instance v2, Ljava/text/ParseException;

    const-string/jumbo v3, "Unexpected token type."

    const/4 v6, 0x0

    invoke-direct {v2, v3, v6}, Ljava/text/ParseException;-><init>(Ljava/lang/String;I)V

    throw v2
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/text/ParseException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 674
    .end local v4    # "serviceURL":Ljava/net/URL;
    .end local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v9    # "jsonResponse":Lorg/json/JSONObject;
    .end local v10    # "responseCode":I
    .end local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_1
    move-exception v19

    .line 676
    .local v19, "e":Ljava/text/ParseException;
    :try_start_3
    const-string/jumbo v2, "exchangeDMSCredentialsForOAuthTokenFailure:ParseException"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 677
    new-instance v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v3, 0x5

    invoke-virtual/range {v19 .. v19}, Ljava/text/ParseException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v2, v3, v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 664
    .end local v19    # "e":Ljava/text/ParseException;
    .restart local v4    # "serviceURL":Ljava/net/URL;
    .restart local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .restart local v9    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v10    # "responseCode":I
    .restart local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_4
    if-eqz v16, :cond_5

    if-nez v15, :cond_6

    :cond_5
    :try_start_4
    new-instance v2, Ljava/text/ParseException;

    const-string/jumbo v3, "Incomplete response."

    const/4 v6, 0x0

    invoke-direct {v2, v3, v6}, Ljava/text/ParseException;-><init>(Ljava/lang/String;I)V

    throw v2
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/text/ParseException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 679
    .end local v4    # "serviceURL":Ljava/net/URL;
    .end local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v9    # "jsonResponse":Lorg/json/JSONObject;
    .end local v10    # "responseCode":I
    .end local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_2
    move-exception v19

    .line 683
    .local v19, "e":Lorg/json/JSONException;
    :try_start_5
    const-string/jumbo v2, "exchangeDMSCredentialsForOAuthTokenFailure:JSONException"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 684
    new-instance v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v3, 0x5

    invoke-virtual/range {v19 .. v19}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v2, v3, v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .end local v19    # "e":Lorg/json/JSONException;
    .restart local v4    # "serviceURL":Ljava/net/URL;
    .restart local v5    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .restart local v9    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v10    # "responseCode":I
    .restart local v21    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_6
    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move-object/from16 v13, p2

    .line 664
    :try_start_6
    invoke-virtual/range {v11 .. v16}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->storeOAuthTokens(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->recordRegistrationCheckTime(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/text/ParseException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    if-eqz p3, :cond_8

    .line 688
    :goto_1
    if-eqz v18, :cond_7

    .line 690
    invoke-virtual/range {v18 .. v18}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_7
    return-object v15

    :cond_8
    move-object/from16 v15, v16

    .line 664
    goto :goto_1
.end method

.method private getAuthDomainForDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1079
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v1, "authDomain"

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getDirectedIdDelegatee(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "options"    # Landroid/os/Bundle;

    .prologue
    .line 339
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.delegateeaccount"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 342
    .local v0, "directedIdDelegatee":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 345
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->getDelegateeAccountForTheDelegatedAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v0

    .line 349
    :cond_0
    return-object v0
.end method

.method private getExchangeTokenURL(Ljava/lang/String;)Ljava/net/URL;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 1028
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAuthDomainForDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1030
    .local v0, "domain":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getExchangeTokenURLCommon(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v1

    return-object v1
.end method

.method private getExchangeTokenURLCommon(Ljava/lang/String;)Ljava/net/URL;
    .locals 5
    .param p1, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/AssertionError;
        }
    .end annotation

    .prologue
    .line 1066
    :try_start_0
    new-instance v0, Ljava/net/URL;

    const-string/jumbo v1, "https"

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x1bb

    const-string/jumbo v4, "/ap/exchangetoken"

    invoke-direct {v0, v1, v2, v3, v4}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 1073
    :catch_0
    move-exception v0

    new-instance v0, Ljava/lang/AssertionError;

    const-string/jumbo v1, "Should never happen; hardcoded constant."

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0
.end method

.method private getLocalRefreshToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1140
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-static {p2, v1}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->peekToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private receiveAndStoreUpdatedTokensForOAuthRefresh(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "refreshTokenResponse"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/text/ParseException;,
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 988
    const-string/jumbo v0, "response"

    invoke-virtual {p3, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 989
    .local v6, "responseDict":Lorg/json/JSONObject;
    const-string/jumbo v0, "token_expires_in"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 990
    .local v3, "expiresInSeconds":I
    const-string/jumbo v0, "token_type"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 991
    .local v7, "tokenType":Ljava/lang/String;
    const-string/jumbo v0, "token"

    invoke-virtual {v6, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 993
    .local v5, "accessToken":Ljava/lang/String;
    const-string/jumbo v0, "bearer_token"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 995
    new-instance v0, Ljava/text/ParseException;

    const-string/jumbo v1, "Unexpected token type."

    invoke-direct {v0, v1, v2}, Ljava/text/ParseException;-><init>(Ljava/lang/String;I)V

    throw v0

    .line 998
    :cond_0
    if-nez v5, :cond_1

    .line 1000
    new-instance v0, Ljava/text/ParseException;

    const-string/jumbo v1, "Incomplete response."

    invoke-direct {v0, v1, v2}, Ljava/text/ParseException;-><init>(Ljava/lang/String;I)V

    throw v0

    .line 1003
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1005
    :cond_2
    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->storeOAuthTokens(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 1006
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mServerRegSync:Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/token/ServerRegistrationSyncHelper;->recordRegistrationCheckTime(Ljava/lang/String;)V

    .line 1008
    :cond_3
    return-object v5
.end method

.method private refreshDelegatedOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 19
    .param p1, "directedIdDelegatee"    # Ljava/lang/String;
    .param p2, "directedIdDelegated"    # Ljava/lang/String;
    .param p3, "refreshTokenDelegatee"    # Ljava/lang/String;
    .param p4, "packageName"    # Ljava/lang/String;
    .param p5, "options"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 847
    const/4 v15, 0x0

    .line 850
    .local v15, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    sget-object v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v4, "refreshDelegatedOAuthToken"

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v18

    .line 852
    .local v18, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    const/4 v3, 0x0

    if-eqz p5, :cond_0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    move-object/from16 v0, p5

    invoke-virtual {v3, v0}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->getDelegationDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    :cond_0
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mDelegatedAccountHelper:Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    move-object/from16 v0, p2

    invoke-virtual {v3, v0, v4}, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->getDelegationDomainForDirectedId(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;

    move-result-object v3

    :cond_1
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAuthDomainForDirectedId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    :cond_2
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getExchangeTokenURLCommon(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v5

    .line 854
    .local v5, "serviceURL":Ljava/net/URL;
    sget-object v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Refreshing Delegated Oauth token with exchange token endpoint: "

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 856
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->addAppParams(Ljava/util/List;)V

    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v7, "source_token_type"

    const-string/jumbo v8, "refresh_token"

    invoke-direct {v4, v7, v8}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v7, "source_token"

    move-object/from16 v0, p3

    invoke-direct {v4, v7, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v7, "requested_token_type"

    const-string/jumbo v8, "delegated_access_token"

    invoke-direct {v4, v7, v8}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v7, "directed_id"

    move-object/from16 v0, p2

    invoke-direct {v4, v7, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v6, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v4, "UTF-8"

    invoke-direct {v6, v3, v4}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 859
    .local v6, "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object/from16 v9, p2

    move-object/from16 v10, p4

    move-object/from16 v11, p6

    invoke-virtual/range {v3 .. v11}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->startIdentityRequest(Landroid/content/Context;Ljava/net/URL;Lorg/apache/http/client/entity/UrlEncodedFormEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/net/HttpURLConnection;

    move-result-object v15

    .line 869
    invoke-virtual {v15}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v11

    .line 870
    .local v11, "responseCode":I
    sget-object v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Response received from OAuth refresh to delegated access exchange end-point"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 871
    invoke-static {v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v10

    .line 872
    .local v10, "jsonResponse":Lorg/json/JSONObject;
    invoke-virtual/range {v18 .. v18}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 874
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    invoke-virtual {v3, v11}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->isFailure(I)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 878
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    sget-object v12, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToDelegationAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object/from16 v8, p1

    move-object/from16 v9, p4

    invoke-virtual/range {v7 .. v13}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v14

    .line 885
    .local v14, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->createErrorMsg(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Ljava/lang/String;

    move-result-object v17

    .line 886
    .local v17, "errorMsg":Ljava/lang/String;
    const-string/jumbo v4, "refreshDelegatedOAuthTokenFailure"

    const/4 v3, 0x1

    new-array v7, v3, [Ljava/lang/String;

    const/4 v8, 0x0

    if-nez v14, :cond_4

    const-string/jumbo v3, "InvalidErrorResponse"

    :goto_0
    aput-object v3, v7, v8

    invoke-static {v4, v7}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 888
    new-instance v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    move-object/from16 v0, v17

    invoke-direct {v3, v4, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v3
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 893
    .end local v5    # "serviceURL":Ljava/net/URL;
    .end local v6    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v10    # "jsonResponse":Lorg/json/JSONObject;
    .end local v11    # "responseCode":I
    .end local v14    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v17    # "errorMsg":Ljava/lang/String;
    .end local v18    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_0
    move-exception v16

    .line 895
    .local v16, "e":Ljava/io/IOException;
    :try_start_1
    const-string/jumbo v3, "refreshDelegatedOAuthTokenFailure:IOException"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 896
    new-instance v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v4, 0x3

    invoke-virtual/range {v16 .. v16}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v16

    invoke-direct {v3, v4, v7, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;Ljava/lang/Throwable;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 912
    .end local v16    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    if-eqz v15, :cond_3

    .line 914
    invoke-virtual {v15}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_3
    throw v3

    .line 886
    .restart local v5    # "serviceURL":Ljava/net/URL;
    .restart local v6    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .restart local v10    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v11    # "responseCode":I
    .restart local v14    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .restart local v17    # "errorMsg":Ljava/lang/String;
    .restart local v18    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_4
    :try_start_2
    invoke-virtual {v14}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->name()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 890
    .end local v14    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v17    # "errorMsg":Ljava/lang/String;
    :cond_5
    const-string/jumbo v3, "refreshDelegatedOAuthTokenSuccess"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 891
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p4

    invoke-direct {v0, v1, v2, v10}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->receiveAndStoreUpdatedTokensForOAuthRefresh(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/text/ParseException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v3

    .line 912
    if-eqz v15, :cond_6

    .line 914
    invoke-virtual {v15}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_6
    return-object v3

    .line 898
    .end local v5    # "serviceURL":Ljava/net/URL;
    .end local v6    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v10    # "jsonResponse":Lorg/json/JSONObject;
    .end local v11    # "responseCode":I
    .end local v18    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_1
    move-exception v16

    .line 900
    .local v16, "e":Ljava/text/ParseException;
    :try_start_3
    const-string/jumbo v3, "refreshDelegatedOAuthTokenFailure:ParseException"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 901
    new-instance v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v4, 0x5

    invoke-virtual/range {v16 .. v16}, Ljava/text/ParseException;->getMessage()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v16

    invoke-direct {v3, v4, v7, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 903
    .end local v16    # "e":Ljava/text/ParseException;
    :catch_2
    move-exception v16

    .line 907
    .local v16, "e":Lorg/json/JSONException;
    const-string/jumbo v3, "refreshDelegatedOAuthTokenFailure:JSONException"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 908
    new-instance v3, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v4, 0x5

    invoke-virtual/range {v16 .. v16}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v16

    invoke-direct {v3, v4, v7, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;Ljava/lang/Throwable;)V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method private refreshNormalOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 21
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 740
    const/16 v16, 0x0

    .line 743
    .local v16, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    move-object/from16 v0, p2

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 746
    .local v19, "refreshToken":Ljava/lang/String;
    if-nez v19, :cond_1

    .line 749
    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    invoke-direct {v0, v1, v2, v4, v3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v4

    .line 816
    :cond_0
    :goto_0
    return-object v4

    .line 751
    :cond_1
    sget-object v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v5, "refreshNormalOAuthToken"

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v20

    .line 753
    .local v20, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct/range {p0 .. p1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getExchangeTokenURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v6

    .line 755
    .local v6, "serviceURL":Ljava/net/URL;
    sget-object v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Refreshing Normal OAuth token with exchange token endpoint: "

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 757
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->addAppParams(Ljava/util/List;)V

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "source_token_type"

    const-string/jumbo v9, "refresh_token"

    invoke-direct {v5, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "source_token"

    move-object/from16 v0, v19

    invoke-direct {v5, v8, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "requested_token_type"

    const-string/jumbo v9, "access_token"

    invoke-direct {v5, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v7, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v5, "UTF-8"

    invoke-direct {v7, v4, v5}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 759
    .local v7, "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    move-object/from16 v12, p3

    invoke-virtual/range {v4 .. v12}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->startIdentityRequest(Landroid/content/Context;Ljava/net/URL;Lorg/apache/http/client/entity/UrlEncodedFormEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/net/HttpURLConnection;

    move-result-object v16

    .line 769
    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v12

    .line 770
    .local v12, "responseCode":I
    sget-object v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Response received from OAuth refresh to access exchange end-point"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 771
    invoke-static/range {v16 .. v16}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v11

    .line 772
    .local v11, "jsonResponse":Lorg/json/JSONObject;
    invoke-virtual/range {v20 .. v20}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 774
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    invoke-virtual {v4, v12}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->isFailure(I)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 778
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    sget-object v13, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToAccessExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object/from16 v9, p1

    move-object/from16 v10, p2

    invoke-virtual/range {v8 .. v14}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v15

    .line 785
    .local v15, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->createErrorMsg(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)Ljava/lang/String;

    move-result-object v18

    .line 786
    .local v18, "errorMsg":Ljava/lang/String;
    const-string/jumbo v5, "refreshNormalOAuthTokenFailure"

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v9, 0x0

    if-nez v15, :cond_3

    const-string/jumbo v4, "InvalidErrorResponse"

    :goto_1
    aput-object v4, v8, v9

    invoke-static {v5, v8}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 788
    new-instance v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->PARSE_ERROR:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v5

    move-object/from16 v0, v18

    invoke-direct {v4, v5, v0, v15}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    throw v4
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 795
    .end local v6    # "serviceURL":Ljava/net/URL;
    .end local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v11    # "jsonResponse":Lorg/json/JSONObject;
    .end local v12    # "responseCode":I
    .end local v15    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v18    # "errorMsg":Ljava/lang/String;
    .end local v19    # "refreshToken":Ljava/lang/String;
    .end local v20    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_0
    move-exception v17

    .line 797
    .local v17, "e":Ljava/io/IOException;
    :try_start_1
    const-string/jumbo v4, "refreshNormalOAuthTokenFailure:IOException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 798
    new-instance v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v5, 0x3

    invoke-virtual/range {v17 .. v17}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v4, v5, v8}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 814
    .end local v17    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    if-eqz v16, :cond_2

    .line 816
    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_2
    throw v4

    .line 786
    .restart local v6    # "serviceURL":Ljava/net/URL;
    .restart local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .restart local v11    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v12    # "responseCode":I
    .restart local v15    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .restart local v18    # "errorMsg":Ljava/lang/String;
    .restart local v19    # "refreshToken":Ljava/lang/String;
    .restart local v20    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_3
    :try_start_2
    invoke-virtual {v15}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->name()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 792
    .end local v15    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v18    # "errorMsg":Ljava/lang/String;
    :cond_4
    const-string/jumbo v4, "refreshNormalOAuthTokenSuccess"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 793
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-direct {v0, v1, v2, v11}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->receiveAndStoreUpdatedTokensForOAuthRefresh(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/text/ParseException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v4

    .line 814
    if-eqz v16, :cond_0

    .line 816
    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_0

    .line 800
    .end local v6    # "serviceURL":Ljava/net/URL;
    .end local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v11    # "jsonResponse":Lorg/json/JSONObject;
    .end local v12    # "responseCode":I
    .end local v19    # "refreshToken":Ljava/lang/String;
    .end local v20    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :catch_1
    move-exception v17

    .line 802
    .local v17, "e":Ljava/text/ParseException;
    :try_start_3
    const-string/jumbo v4, "refreshNormalOAuthTokenFailure:ParseException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 803
    new-instance v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v5, 0x5

    invoke-virtual/range {v17 .. v17}, Ljava/text/ParseException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v4, v5, v8}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v4

    .line 805
    .end local v17    # "e":Ljava/text/ParseException;
    :catch_2
    move-exception v17

    .line 809
    .local v17, "e":Lorg/json/JSONException;
    const-string/jumbo v4, "refreshNormalOAuthTokenFailure:JSONException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 810
    new-instance v4, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v5, 0x5

    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v4, v5, v8}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method private requireExchangeDMSTokenForOAuthToken(Landroid/os/Bundle;)Z
    .locals 2
    .param p1, "options"    # Landroid/os/Bundle;

    .prologue
    .line 518
    if-eqz p1, :cond_0

    .line 520
    .end local p1    # "options":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v0, "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 522
    sget-object v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Force refresh the DMS token for OAuth token."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    const/4 v0, 0x1

    .line 525
    :goto_1
    return v0

    .line 518
    .restart local p1    # "options":Landroid/os/Bundle;
    :cond_0
    new-instance p1, Landroid/os/Bundle;

    .end local p1    # "options":Landroid/os/Bundle;
    invoke-direct {p1}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 525
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private requireOAuthRefreshTokenExchange(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "keyInfo"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "options"    # Landroid/os/Bundle;

    .prologue
    .line 532
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->hasLocalOAuthAccessToken(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 534
    const/4 v0, 0x1

    .line 537
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->shouldRefreshExistingAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z

    move-result v0

    goto :goto_0
.end method

.method private tryToCorrectTheOAuthTokensFor3PCentralDevicetype(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "returnRefreshToken"    # Z
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 423
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/platform/util/PlatformUtils;->isThirdPartyDevice(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mContext:Landroid/content/Context;

    invoke-static {v1, p2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v0, "true"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v2, "force_refresh_dms_to_oauth_done_once"

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    .line 425
    :cond_0
    if-nez v0, :cond_1

    .line 427
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    .line 429
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v1, "force_refresh_dms_to_oauth_done_once"

    const-string/jumbo v2, "true"

    invoke-virtual {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    const-string/jumbo v0, "fixCentralTokenOn3PDevices"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 434
    :cond_1
    return-void
.end method


# virtual methods
.method public getAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "keyInfo"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/16 v3, 0x8

    const/4 v4, 0x1

    const/4 v8, 0x0

    .line 214
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 216
    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const-string/jumbo v2, "Given Account is currently not valid"

    invoke-direct {v0, v3, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0

    .line 220
    :cond_0
    const-string/jumbo v0, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 222
    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v2, 0x7

    const-string/jumbo v3, "Token key %s is not a valid key"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v8

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0

    .line 225
    :cond_1
    if-nez p3, :cond_3

    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 227
    .local v5, "nonNullOptions":Landroid/os/Bundle;
    :goto_0
    invoke-direct {p0, p1, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getDirectedIdDelegatee(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    .line 229
    .local v1, "directedIdDelegatee":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 232
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_2
    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const-string/jumbo v2, "Given account or delegated account is currently not valid"

    invoke-direct {v0, v3, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0

    .end local v1    # "directedIdDelegatee":Ljava/lang/String;
    .end local v5    # "nonNullOptions":Landroid/os/Bundle;
    :cond_3
    move-object v5, p3

    .line 225
    goto :goto_0

    .line 232
    .restart local v1    # "directedIdDelegatee":Ljava/lang/String;
    .restart local v5    # "nonNullOptions":Landroid/os/Bundle;
    :cond_4
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v2, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v2

    if-nez v2, :cond_5

    sget-object v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "The delegatee account is already deregistered."

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v0, "The delegatee account %s is already deregistered."

    new-array v2, v4, [Ljava/lang/Object;

    aput-object v1, v2, v8

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "The delegatee account is already deregistered on this device"

    invoke-direct {v0, v2, v3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0

    :cond_5
    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->requireExchangeDMSTokenForOAuthToken(Landroid/os/Bundle;)Z

    move-result v2

    if-eqz v2, :cond_8

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v1, v0, v4, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    move-object v0, p0

    move-object v2, p1

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->refreshDelegatedOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v7

    .line 245
    .local v7, "accessToken":Ljava/lang/String;
    :cond_6
    :goto_1
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 247
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 249
    :cond_7
    return-object v7

    .line 232
    .end local v7    # "accessToken":Ljava/lang/String;
    :cond_8
    invoke-direct {p0, p1, p2, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->requireOAuthRefreshTokenExchange(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z

    move-result v2

    if-eqz v2, :cond_6

    invoke-virtual {p0, v1, v0, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getRefreshToken(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v1, v0, v4, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v3

    :cond_9
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    move-object v0, p0

    move-object v2, p1

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->refreshDelegatedOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v7

    goto :goto_1

    .line 241
    :cond_a
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting access token for package "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-direct {p0, p1, v0, v8, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->tryToCorrectTheOAuthTokensFor3PCentralDevicetype(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)V

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->hasLocalOAuthRefreshToken(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-direct {p0, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->requireExchangeDMSTokenForOAuthToken(Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_d

    :cond_b
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, v8, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v7

    .restart local v7    # "accessToken":Ljava/lang/String;
    :cond_c
    :goto_2
    goto :goto_1

    .end local v7    # "accessToken":Ljava/lang/String;
    :cond_d
    invoke-direct {p0, p1, p2, v5}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->requireOAuthRefreshTokenExchange(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->refreshOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v7

    goto :goto_2
.end method

.method public getOAuthToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 6
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tokenKey"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 270
    const-string/jumbo v0, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 272
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    .line 276
    :goto_0
    return-object v0

    .line 274
    :cond_0
    const-string/jumbo v0, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 276
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getRefreshToken(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 280
    :cond_1
    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/4 v1, 0x7

    const-string/jumbo v2, "Token key %s is not a valid key"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0
.end method

.method public getRefreshToken(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 255
    invoke-direct {p0, p1, p2, v1, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->tryToCorrectTheOAuthTokensFor3PCentralDevicetype(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 257
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getLocalRefreshToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 259
    .local v0, "refreshToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 264
    .end local v0    # "refreshToken":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "refreshToken":Ljava/lang/String;
    :cond_0
    invoke-direct {p0, p1, p2, v1, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getTokenMapFromRegistrationData(Landroid/os/Bundle;)Ljava/util/Map;
    .locals 13
    .param p1, "regTokenData"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v12, 0x0

    .line 290
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/os/Bundle;->size()I

    move-result v8

    if-gtz v8, :cond_1

    .line 292
    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v7

    .line 321
    :goto_0
    return-object v7

    .line 295
    :cond_1
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 297
    .local v7, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.access_token"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 298
    .local v0, "accessToken":Ljava/lang/String;
    const/4 v3, 0x0

    .line 301
    .local v3, "expiresInSeconds":I
    :try_start_0
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 310
    :goto_1
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 312
    .local v4, "refreshToken":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    .line 313
    .local v5, "refreshedAtTime":J
    sget-object v8, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    int-to-long v9, v3

    sget-object v11, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v8, v9, v10, v11}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v8

    add-long v1, v5, v8

    .line 316
    .local v1, "expiresAtTime":J
    invoke-static {v12}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    invoke-static {v12, v8}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v1, v2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 318
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-static {v12, v8}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    const-string/jumbo v8, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

    invoke-static {v12, v8}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 307
    .end local v1    # "expiresAtTime":J
    .end local v4    # "refreshToken":Ljava/lang/String;
    .end local v5    # "refreshedAtTime":J
    :catch_0
    move-exception v8

    sget-object v8, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "NumberFormatException fetching expiresInSeconds data"

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public hasLocalOAuthAccessToken(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1135
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->peekToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasLocalOAuthRefreshToken(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1130
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getLocalRefreshToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public refreshOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
        }
    .end annotation

    .prologue
    .line 703
    if-nez p1, :cond_0

    .line 705
    new-instance v0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;

    const/16 v2, 0x8

    const-string/jumbo v4, "Given Account is currently not valid"

    invoke-direct {v0, v2, v4}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;-><init>(ILjava/lang/String;)V

    throw v0

    .line 708
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v0, "Refreshing access token for "

    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p2, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "package "

    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 712
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getDirectedIdDelegatee(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    .line 713
    .local v1, "directedIdDelegatee":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 715
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-static {p2, v2}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 717
    .local v3, "refreshTokenDelegatee":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 719
    const/4 v0, 0x1

    invoke-direct {p0, v1, p2, v0, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->exchangeDMSCredentialsForOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v3

    .line 723
    :cond_1
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    move-object v0, p0

    move-object v2, p1

    move-object v4, p2

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->refreshDelegatedOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    .line 732
    .end local v3    # "refreshTokenDelegatee":Ljava/lang/String;
    :goto_1
    return-object v0

    .line 708
    .end local v1    # "directedIdDelegatee":Ljava/lang/String;
    :cond_2
    const-string/jumbo v0, "central"

    goto :goto_0

    .line 732
    .restart local v1    # "directedIdDelegatee":Ljava/lang/String;
    :cond_3
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->refreshNormalOAuthTokenAndStore(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public shouldRefreshExistingAccessToken(Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z
    .locals 12
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "keyInfo"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .param p3, "options"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 544
    if-eqz p3, :cond_0

    move-object v4, p3

    .line 547
    .local v4, "nonNullOptions":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v7, "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshOAuthToken"

    invoke-virtual {v4, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 549
    sget-object v6, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Force refresh the OAuth access token."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 574
    :goto_1
    return v5

    .line 544
    .end local v4    # "nonNullOptions":Landroid/os/Bundle;
    :cond_0
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 553
    .restart local v4    # "nonNullOptions":Landroid/os/Bundle;
    :cond_1
    iget-object v7, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, p1, v8}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 556
    .local v1, "accessTokenRefreshedAtString":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v2

    .line 557
    .local v2, "currentTime":J
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_2

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v7

    if-eqz v7, :cond_2

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    cmp-long v7, v2, v7

    if-gez v7, :cond_2

    move v7, v5

    :goto_2
    if-eqz v7, :cond_3

    .line 559
    sget-object v6, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Clock skew detected. Refreshing..."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move v7, v6

    .line 557
    goto :goto_2

    .line 563
    :cond_3
    iget-object v7, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, p1, v8}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 565
    invoke-static {v7}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    .line 568
    .local v0, "accessTokenExpiresTime":Ljava/lang/Long;
    if-eqz v0, :cond_5

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    const-string/jumbo v9, "com.amazon.identity.auth.device.api.TokenKeys.Options.OAuthAccessTokenTTLInMilliSec"

    const-wide/16 v10, 0x0

    invoke-virtual {v4, v9, v10, v11}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v9

    add-long/2addr v7, v9

    sget-wide v9, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->FUDGE_FACTOR:J

    add-long/2addr v7, v9

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v9

    cmp-long v7, v7, v9

    if-ltz v7, :cond_4

    move v7, v5

    :goto_3
    if-eqz v7, :cond_5

    .line 571
    sget-object v6, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "OAuth access token near or past expiry. Refreshing..."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    move v7, v6

    .line 568
    goto :goto_3

    :cond_5
    move v5, v6

    .line 574
    goto/16 :goto_1
.end method

.method public storeOAuthTokens(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "expiresInSeconds"    # I
    .param p4, "refreshToken"    # Ljava/lang/String;
    .param p5, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 966
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 967
    .local v2, "refreshedAtTime":J
    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    int-to-long v6, p3

    sget-object v8, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v5, v6, v7, v8}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v5

    add-long v0, v2, v5

    .line 969
    .local v0, "expiresAtTime":J
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 973
    .local v4, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 975
    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

    invoke-static {p2, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 977
    :cond_0
    invoke-static {p2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 978
    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

    invoke-static {p2, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 979
    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

    invoke-static {p2, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 980
    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->mLocalAppDataAwareDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    invoke-virtual {v5, p1, v4}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V

    .line 981
    return-void
.end method
