.class public Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;
.super Ljava/lang/Object;
.source "AuthenticateAccountAction.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    }
.end annotation


# static fields
.field private static final GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

.field private final mContext:Landroid/content/Context;

.field private final mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    .line 79
    const-class v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    .line 91
    new-instance v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v2, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->CredentialError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v3, "Credential Error"

    const-string/jumbo v4, "Credential Error"

    const-string/jumbo v5, "No Request Id"

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    sput-object v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-direct {v1}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;)V

    .line 104
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "authEndpointErrorParser"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    .prologue
    .line 108
    const-string/jumbo v0, "dcp_device_info"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)V

    .line 111
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "authEndpointErrorParser"    # Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;
    .param p3, "deviceInfo"    # Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .prologue
    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 117
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mContext:Landroid/content/Context;

    .line 118
    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    .line 119
    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 120
    return-void
.end method


# virtual methods
.method public authenticateAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    .locals 17
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "registrationData"    # Landroid/os/Bundle;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 128
    const/4 v9, 0x0

    .line 131
    .local v9, "signInConn":Ljavax/net/ssl/HttpsURLConnection;
    :try_start_0
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->getSignInUrl(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v10

    .line 132
    .local v10, "signInUrl":Ljava/net/URL;
    if-nez v10, :cond_1

    .line 134
    const/4 v2, 0x0

    .line 210
    .end local v10    # "signInUrl":Ljava/net/URL;
    :cond_0
    :goto_0
    return-object v2

    .line 137
    .restart local v10    # "signInUrl":Ljava/net/URL;
    :cond_1
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string/jumbo v13, "Starting request to authenticate account. URL : "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->createURLConnection(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;

    move-result-object v9

    .line 140
    if-nez v9, :cond_3

    .line 142
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "Could not create request to authenticate account"

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    if-eqz v9, :cond_2

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 147
    :cond_3
    :try_start_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->isCurrentEnvironmentDevo()Z

    move-result v11

    if-eqz v11, :cond_4

    .line 149
    const-string/jumbo v11, "x-forwarded-server"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v12

    move-object/from16 v0, p3

    invoke-virtual {v12, v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getPandaHost(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v9, v11, v12}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    :cond_4
    const/4 v11, 0x1

    invoke-virtual {v9, v11}, Ljavax/net/ssl/HttpsURLConnection;->setDoOutput(Z)V

    const-string/jumbo v11, "POST"

    invoke-virtual {v9, v11}, Ljavax/net/ssl/HttpsURLConnection;->setRequestMethod(Ljava/lang/String;)V

    const-string/jumbo v11, "Accept"

    const-string/jumbo v12, "application/json"

    invoke-virtual {v9, v11, v12}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v11, "Content-Type"

    const-string/jumbo v12, "application/json"

    invoke-virtual {v9, v11, v12}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v11, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;

    invoke-direct {v11}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;-><init>()V

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setUserID(Ljava/lang/String;)Z

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setPassword(Ljava/lang/String;)Z

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v11, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDeviceInfo(Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)V

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mContext:Landroid/content/Context;

    invoke-static {v12}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    move-object/from16 v0, p5

    invoke-static {v12, v13, v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->getSigner(Lcom/amazon/identity/platform/setting/PlatformSettings;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setJwtSigner(Lcom/amazon/identity/kcpsdk/auth/JwtSigner;)V

    const-string/jumbo v12, "calling_package"

    move-object/from16 v0, p4

    invoke-virtual {v0, v12}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_5

    invoke-virtual {v11, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setMetadataAppName(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mContext:Landroid/content/Context;

    invoke-static {v13, v12}, Lcom/amazon/identity/auth/device/utils/PackageUtils;->getPackageVersion(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v12

    if-eqz v12, :cond_5

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setMetadataAppVersion(Ljava/lang/String;)V

    :cond_5
    invoke-virtual {v11}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->getRequestJSON()Lorg/json/JSONObject;

    move-result-object v11

    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v12

    invoke-virtual {v11}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->getBytes()[B

    move-result-object v11

    invoke-static {v12, v11}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->writeToStreamAndClose(Ljava/io/OutputStream;[B)V

    .line 154
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v8

    .line 155
    .local v8, "responseCode":I
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string/jumbo v13, "Panda SignIn Response code: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v11

    if-nez v11, :cond_6

    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "Error parsing JSON in Panda response"

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v11, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v12, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v13, "Error parsing JSON in Panda response"

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-direct {v11, v12, v13, v14, v15}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v11}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    .line 160
    .local v2, "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :goto_1
    invoke-virtual {v2}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->isError()Z

    move-result v11

    if-eqz v11, :cond_e

    .line 166
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v11

    iget-object v12, v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;->error:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v12

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v8, v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p5

    invoke-virtual {v0, v11}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 208
    :goto_2
    if-eqz v9, :cond_0

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_0

    .line 157
    .end local v2    # "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :cond_6
    :try_start_2
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v12, v8}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->isFailure(I)Z

    move-result v12

    if-eqz v12, :cond_8

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v12, v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->hasAuthenticationChallenge(Lorg/json/JSONObject;)Z

    move-result v12

    if-nez v12, :cond_8

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mAuthEndpointErrorParser:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;

    invoke-virtual {v12, v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->parse(Lorg/json/JSONObject;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v11

    if-eqz v11, :cond_7

    :goto_3
    sget-object v12, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v13, "Error making request. Code: %s \n Message: %s \n Detail: %s"

    const/4 v14, 0x3

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->getCode()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x1

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getMessage()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x2

    invoke-virtual {v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getDetail()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v12, v13, v14}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v11}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 177
    .end local v8    # "responseCode":I
    .end local v10    # "signInUrl":Ljava/net/URL;
    :catch_0
    move-exception v3

    .line 179
    .local v3, "e":Lorg/json/JSONException;
    :try_start_3
    sget-object v11, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v12, "Error parsing response. Not of an expected format. Error: %s"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-virtual {v3}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v11, v12, v13}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 183
    .local v6, "message":Ljava/lang/String;
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    invoke-static {v11, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    new-instance v7, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v11, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-direct {v7, v11, v6, v12, v13}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    .local v7, "parseError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v7}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 208
    if-eqz v9, :cond_0

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_0

    .line 157
    .end local v3    # "e":Lorg/json/JSONException;
    .end local v6    # "message":Ljava/lang/String;
    .end local v7    # "parseError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .restart local v8    # "responseCode":I
    .restart local v10    # "signInUrl":Ljava/net/URL;
    :cond_7
    :try_start_4
    sget-object v11, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser;->GENERIC_ERROR:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    goto :goto_3

    :cond_8
    const-string/jumbo v12, "request_id"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    sget-object v13, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v15

    invoke-virtual {v15}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    aput-object v12, v13, v14

    const-string/jumbo v12, "response"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    const-string/jumbo v12, "success"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_9

    const-string/jumbo v12, "success"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    const-string/jumbo v12, "customer_id"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v13, "tokens"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    const-string/jumbo v13, "bearer"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v11

    const-string/jumbo v13, "access_token"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v11, v12}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_1

    .line 187
    .end local v8    # "responseCode":I
    .end local v10    # "signInUrl":Ljava/net/URL;
    :catch_1
    move-exception v3

    .line 189
    .local v3, "e":Ljava/io/IOException;
    :try_start_5
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v11

    invoke-static {v11}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p5

    invoke-virtual {v0, v11}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 190
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->mContext:Landroid/content/Context;

    invoke-static {v11, v3, v12}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionWithSubClassMetricName(Ljava/net/URL;Ljava/io/IOException;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p5

    invoke-virtual {v0, v11}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 192
    invoke-virtual {v3}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    .line 193
    .local v5, "exceptionMessage":Ljava/lang/String;
    if-eqz v5, :cond_f

    const-string/jumbo v11, "Received authentication challenge is"

    invoke-virtual {v5, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_f

    .line 195
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "Encountered Panda bug around 401 returned from the server. Assuming this means invalid credentials"

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    sget-object v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->GENERIC_CREDENTIAL_ERROR_ACCOUNT_INFO:Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 208
    if-eqz v9, :cond_0

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_0

    .line 157
    .end local v3    # "e":Ljava/io/IOException;
    .end local v5    # "exceptionMessage":Ljava/lang/String;
    .restart local v8    # "responseCode":I
    .restart local v10    # "signInUrl":Ljava/net/URL;
    :cond_9
    :try_start_6
    const-string/jumbo v12, "challenge"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_d

    const-string/jumbo v12, "challenge"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v12

    invoke-static {v12}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->fromPandaChallengeBody(Lorg/json/JSONObject;)Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    move-result-object v12

    const-string/jumbo v13, "request_id"

    const/4 v14, 0x0

    invoke-static {v11, v13, v14}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v12}, Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;->getReason()Ljava/lang/String;

    move-result-object v13

    const-string/jumbo v14, "AuthenticationFailed"

    invoke-virtual {v14, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_a

    const-string/jumbo v14, "InvalidAuthenticationData"

    invoke-virtual {v14, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_c

    :cond_a
    new-instance v12, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v13, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->CredentialError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-direct {v12, v13, v14, v15, v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v12}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 208
    .end local v8    # "responseCode":I
    .end local v10    # "signInUrl":Ljava/net/URL;
    :catchall_0
    move-exception v11

    if-eqz v9, :cond_b

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_b
    throw v11

    .line 157
    .restart local v8    # "responseCode":I
    .restart local v10    # "signInUrl":Ljava/net/URL;
    :cond_c
    :try_start_7
    new-instance v13, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v14, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->AuthenticationChallenged:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const/4 v15, 0x0

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-direct {v13, v14, v15, v0, v11}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v12, v13}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    goto/16 :goto_1

    :cond_d
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v12, "Error parsing response. Empty response body."

    invoke-static {v11, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v11, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v12, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->ParseError:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const-string/jumbo v13, "Error parsing response. Empty response body."

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-direct {v11, v12, v13, v14, v15}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v11}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V

    goto/16 :goto_1

    .line 172
    .restart local v2    # "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    :cond_e
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->getURL()Ljava/net/URL;

    move-result-object v11

    invoke-static {v11, v8}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;I)Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p5

    invoke-virtual {v0, v11}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V
    :try_end_7
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_2

    .line 200
    .end local v2    # "authenticatedAccountInfo":Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;
    .end local v8    # "responseCode":I
    .end local v10    # "signInUrl":Ljava/net/URL;
    .restart local v3    # "e":Ljava/io/IOException;
    .restart local v5    # "exceptionMessage":Ljava/lang/String;
    :cond_f
    :try_start_8
    sget-object v11, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v12, "Error getting response from server. Error: %s"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v5, v13, v14

    invoke-static {v11, v12, v13}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 202
    .restart local v6    # "message":Ljava/lang/String;
    sget-object v11, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    invoke-static {v11, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    new-instance v4, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    sget-object v11, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->NetworkFailure:Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-direct {v4, v11, v6, v12, v13}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .local v4, "error":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    new-instance v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;

    invoke-direct {v2, v4}, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction$AuthenticatedAccountInfo;-><init>(Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 208
    if-eqz v9, :cond_0

    .line 210
    invoke-virtual {v9}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_0
.end method

.method createURLConnection(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;
    .locals 1
    .param p1, "signInUrl"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 391
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    .line 392
    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    .line 393
    return-object v0
.end method

.method getSignInUrl(Ljava/lang/String;)Ljava/net/URL;
    .locals 7
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 373
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getPandaHost(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 376
    .local v1, "pandaHost":Ljava/lang/String;
    :try_start_0
    new-instance v2, Ljava/net/URL;

    const-string/jumbo v3, "https"

    const/16 v4, 0x1bb

    const-string/jumbo v5, "/auth/signin"

    invoke-direct {v2, v3, v1, v4, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 385
    :goto_0
    return-object v2

    .line 378
    :catch_0
    move-exception v0

    .line 380
    .local v0, "e":Ljava/net/MalformedURLException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AuthenticateAccountAction;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not request URL to hit panda. Domain %s was invalid. Error: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-virtual {v0}, Ljava/net/MalformedURLException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 385
    const/4 v2, 0x0

    goto :goto_0
.end method
