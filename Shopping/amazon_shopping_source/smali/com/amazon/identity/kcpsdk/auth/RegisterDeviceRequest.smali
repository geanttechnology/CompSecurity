.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;
.super Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;
.source "RegisterDeviceRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;,
        Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
    }
.end annotation


# static fields
.field static final TAG:Ljava/lang/String;


# instance fields
.field private mAddAsChildAccount:Z

.field private mAddAsSecondaryAccount:Z

.field private mClientContext:Ljava/lang/String;

.field private mCustomerToken:Ljava/lang/String;

.field private mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

.field private mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

.field private mDeviceTypeSoftwareVersionMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mLocale:Ljava/lang/String;

.field private mLogin:Ljava/lang/String;

.field private mMetadataAppName:Ljava/lang/String;

.field private mMetadataAppVersion:Ljava/lang/String;

.field private mMetadataDeviceModel:Ljava/lang/String;

.field private mMetadataOsVersion:Ljava/lang/String;

.field private mNonAuthCookies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation
.end field

.field private mPandaCookieDomain:Ljava/lang/String;

.field private mPandaEndpointDomain:Ljava/lang/String;

.field private mPassword:Ljava/lang/String;

.field private mPfmOfDelegatee:Ljava/lang/String;

.field private mPrimaryAccessToken:Ljava/lang/String;

.field private mPublicKeyAlgorithm:Ljava/lang/String;

.field private mPublicKeyData:Ljava/lang/String;

.field private mPublicKeyFormat:Ljava/lang/String;

.field private mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

.field private mSecondaryDirectedId:Ljava/lang/String;

.field private mSecondaryLogin:Ljava/lang/String;

.field private mSecondaryPassword:Ljava/lang/String;

.field private mSoftwareComponentId:Ljava/lang/String;

.field private mUseExchangeToken:Z

.field private mUseOverrideDSN:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;-><init>()V

    .line 67
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseOverrideDSN:Z

    .line 119
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AT_MAIN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .line 120
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    .line 121
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    .line 122
    return-void
.end method

.method private getPandaHost()Ljava/lang/String;
    .locals 2

    .prologue
    .line 602
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getPandaEndPointDomain()Ljava/lang/String;

    move-result-object v0

    .line 603
    .local v0, "domain":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getPandaHost(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getWebRequestPanda()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 22

    .prologue
    .line 444
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    if-eqz v17, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_0

    .line 446
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    .line 591
    :goto_0
    return-object v17

    .line 449
    :cond_0
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getPandaHost()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string/jumbo v18, "/auth/register"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 450
    .local v12, "pandaEndPoint":Ljava/lang/String;
    if-nez v12, :cond_1

    .line 452
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Can\'t determine Panda service endpoint because the CookieDomain is not set."

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 453
    const/16 v17, 0x0

    goto :goto_0

    .line 455
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_3

    .line 457
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v17

    if-nez v17, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mClientContext:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_3

    .line 460
    :cond_2
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Customer token or ClientContext is not set. Use MAPAccountManager.KEY_AUTH_TOKEN and MAPAccountManager.KEY_AUTH_TOKEN_CONTEXT to pass them in regData."

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 463
    const/16 v17, 0x0

    goto :goto_0

    .line 467
    :cond_3
    new-instance v17, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 468
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual/range {v17 .. v18}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    .line 469
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 470
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual/range {v17 .. v18}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 471
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    const-string/jumbo v18, "Content-Type"

    const-string/jumbo v19, "application/json"

    invoke-virtual/range {v17 .. v19}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 474
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->isCurrentEnvironmentDevo()Z

    move-result v17

    if-eqz v17, :cond_4

    .line 476
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    const-string/jumbo v18, "x-forwarded-server"

    invoke-direct/range {p0 .. p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getPandaHost()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v17 .. v19}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    :cond_4
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 482
    .local v3, "authDataJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "use_global_authentication"

    const-string/jumbo v18, "true"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 483
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    move/from16 v17, v0

    if-eqz v17, :cond_5

    .line 485
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    const-string/jumbo v18, "Authorization"

    new-instance v19, Ljava/lang/StringBuilder;

    const-string/jumbo v20, "Bearer "

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPrimaryAccessToken:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v17 .. v19}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryLogin:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_8

    .line 490
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 491
    .local v10, "loginPasswordJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "user_id"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryLogin:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 492
    const-string/jumbo v17, "password"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 493
    const-string/jumbo v17, "user_id_password"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 522
    .end local v10    # "loginPasswordJson":Lorg/json/JSONObject;
    :cond_6
    :goto_1
    new-instance v13, Lorg/json/JSONObject;

    invoke-direct {v13}, Lorg/json/JSONObject;-><init>()V

    .line 523
    .local v13, "registrationDataJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "domain"

    const-string/jumbo v18, "Device"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 524
    const-string/jumbo v17, "device_type"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceType:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 525
    const-string/jumbo v17, "device_serial"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSerialNumber:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 526
    const-string/jumbo v18, "app_name"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppName:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppName:Ljava/lang/String;

    move-object/from16 v17, v0

    :goto_2
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 527
    const-string/jumbo v18, "app_version"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppVersion:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppVersion:Ljava/lang/String;

    move-object/from16 v17, v0

    :goto_3
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 529
    const-string/jumbo v18, "device_model"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataDeviceModel:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataDeviceModel:Ljava/lang/String;

    move-object/from16 v17, v0

    :goto_4
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 531
    const-string/jumbo v18, "os_version"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataOsVersion:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataOsVersion:Ljava/lang/String;

    move-object/from16 v17, v0

    :goto_5
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 533
    const-string/jumbo v18, "software_version"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-object/from16 v17, v0

    if-eqz v17, :cond_10

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v17

    :goto_6
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 536
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-object/from16 v17, v0

    if-nez v17, :cond_7

    .line 538
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v18, " software_version was undefined."

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 542
    :cond_7
    new-instance v16, Lorg/json/JSONArray;

    invoke-direct/range {v16 .. v16}, Lorg/json/JSONArray;-><init>()V

    .line 543
    .local v16, "requestedTokenTypeJson":Lorg/json/JSONArray;
    const-string/jumbo v17, "bearer"

    invoke-virtual/range {v16 .. v17}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 544
    const-string/jumbo v17, "mac_dms"

    invoke-virtual/range {v16 .. v17}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 545
    const-string/jumbo v17, "store_authentication_cookie"

    invoke-virtual/range {v16 .. v17}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 546
    const-string/jumbo v17, "website_cookies"

    invoke-virtual/range {v16 .. v17}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 547
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 548
    .local v6, "cookiesJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "domain"

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getPandaCookieDomain()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 549
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 551
    .local v5, "cookiesJSONArray":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mNonAuthCookies:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_7
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_11

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/apache/http/cookie/Cookie;

    .line 553
    .local v4, "cookie":Lorg/apache/http/cookie/Cookie;
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11}, Lorg/json/JSONObject;-><init>()V

    .line 554
    .local v11, "nonAuthCookieJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "Name"

    invoke-interface {v4}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v11, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 555
    const-string/jumbo v17, "Value"

    invoke-interface {v4}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v11, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 556
    invoke-virtual {v5, v11}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_7

    .line 588
    .end local v3    # "authDataJson":Lorg/json/JSONObject;
    .end local v4    # "cookie":Lorg/apache/http/cookie/Cookie;
    .end local v5    # "cookiesJSONArray":Lorg/json/JSONArray;
    .end local v6    # "cookiesJson":Lorg/json/JSONObject;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v11    # "nonAuthCookieJson":Lorg/json/JSONObject;
    .end local v13    # "registrationDataJson":Lorg/json/JSONObject;
    .end local v16    # "requestedTokenTypeJson":Lorg/json/JSONArray;
    :catch_0
    move-exception v8

    .line 590
    .local v8, "e":Lorg/json/JSONException;
    sget-object v17, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Error Creating Panda web requst. Error: %s"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v8}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v17 .. v19}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 591
    const/16 v17, 0x0

    goto/16 :goto_0

    .line 495
    .end local v8    # "e":Lorg/json/JSONException;
    .restart local v3    # "authDataJson":Lorg/json/JSONObject;
    :cond_8
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryDirectedId:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_9

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_9

    .line 497
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    .line 498
    .local v7, "directedIdPasswordJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "directedId"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryDirectedId:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v7, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 499
    const-string/jumbo v17, "password"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v7, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 500
    const-string/jumbo v17, "directedId_password"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_1

    .line 502
    .end local v7    # "directedIdPasswordJson":Lorg/json/JSONObject;
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_a

    .line 504
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 505
    .restart local v10    # "loginPasswordJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "user_id"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 506
    const-string/jumbo v17, "password"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 507
    const-string/jumbo v17, "user_id_password"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_1

    .line 509
    .end local v10    # "loginPasswordJson":Lorg/json/JSONObject;
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->ACCESS_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_b

    .line 511
    const-string/jumbo v17, "access_token"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_1

    .line 513
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v17, v0

    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->AUTH_TOKEN:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_6

    .line 515
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 516
    .local v2, "atMainDataJson":Lorg/json/JSONObject;
    const-string/jumbo v17, "atmain"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 517
    const-string/jumbo v17, "client_context"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mClientContext:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 518
    const-string/jumbo v17, "max_age"

    const v18, 0x127500

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 519
    const-string/jumbo v17, "auth_token"

    move-object/from16 v0, v17

    invoke-virtual {v3, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_1

    .line 526
    .end local v2    # "atMainDataJson":Lorg/json/JSONObject;
    .restart local v13    # "registrationDataJson":Lorg/json/JSONObject;
    :cond_c
    const-string/jumbo v17, "defaultAppName"

    goto/16 :goto_2

    .line 527
    :cond_d
    const-string/jumbo v17, "defaultAppVersion"

    goto/16 :goto_3

    .line 529
    :cond_e
    const-string/jumbo v17, "defaultDeviceName"

    goto/16 :goto_4

    .line 531
    :cond_f
    const-string/jumbo v17, "defaultOsVersion"

    goto/16 :goto_5

    .line 533
    :cond_10
    const-string/jumbo v17, "defaultSoftwareVersion"

    goto/16 :goto_6

    .line 558
    .restart local v5    # "cookiesJSONArray":Lorg/json/JSONArray;
    .restart local v6    # "cookiesJson":Lorg/json/JSONObject;
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v16    # "requestedTokenTypeJson":Lorg/json/JSONArray;
    :cond_11
    const-string/jumbo v17, "website_cookies"

    move-object/from16 v0, v17

    invoke-virtual {v6, v0, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 560
    new-instance v14, Lorg/json/JSONArray;

    invoke-direct {v14}, Lorg/json/JSONArray;-><init>()V

    .line 561
    .local v14, "requestExtensionsJson":Lorg/json/JSONArray;
    const-string/jumbo v17, "device_info"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 562
    const-string/jumbo v17, "customer_info"

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 563
    new-instance v15, Lorg/json/JSONObject;

    invoke-direct {v15}, Lorg/json/JSONObject;-><init>()V

    .line 564
    .local v15, "requestJson":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    move/from16 v17, v0

    if-eqz v17, :cond_12

    .line 566
    const-string/jumbo v17, "secondary_auth_data"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 572
    :goto_8
    const-string/jumbo v17, "registration_data"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 573
    const-string/jumbo v17, "requested_token_type"

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 574
    const-string/jumbo v17, "cookies"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 575
    const-string/jumbo v17, "requested_extensions"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 576
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    invoke-virtual {v15}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody(Ljava/lang/String;)V

    .line 578
    sget-object v18, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v19, "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nLocale: %s"

    const/16 v17, 0x4

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v17, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceType:Ljava/lang/String;

    move-object/from16 v21, v0

    aput-object v21, v20, v17

    const/16 v17, 0x1

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v21

    aput-object v21, v20, v17

    const/16 v21, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-object/from16 v17, v0

    if-nez v17, :cond_13

    const-string/jumbo v17, "None"

    :goto_9
    aput-object v17, v20, v21

    const/16 v21, 0x3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    move-object/from16 v17, v0

    if-nez v17, :cond_14

    const-string/jumbo v17, "Default"

    :goto_a
    aput-object v17, v20, v21

    invoke-static/range {v18 .. v20}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 586
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-object/from16 v17, v0

    goto/16 :goto_0

    .line 570
    :cond_12
    const-string/jumbo v17, "auth_data"

    move-object/from16 v0, v17

    invoke-virtual {v15, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_8

    .line 578
    :cond_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v17

    goto :goto_9

    :cond_14
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    move-object/from16 v17, v0
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_a
.end method

.method public static isValidCustomerAccountToken(Ljava/lang/String;)Z
    .locals 2
    .param p0, "token"    # Ljava/lang/String;

    .prologue
    .line 258
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 260
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValidCustomerAccountToken: returning false because a null or empty auth token was given"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    const/4 v0, 0x0

    .line 264
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidLocale(Ljava/lang/String;)Z
    .locals 1
    .param p0, "locale"    # Ljava/lang/String;

    .prologue
    .line 139
    const/4 v0, 0x1

    return v0
.end method

.method public static isValidLogin(Ljava/lang/String;)Z
    .locals 2
    .param p0, "login"    # Ljava/lang/String;

    .prologue
    .line 162
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValidLogin: returning false because a null or empty login was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    const/4 v0, 0x0

    .line 168
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidPassword(Ljava/lang/String;)Z
    .locals 2
    .param p0, "password"    # Ljava/lang/String;

    .prologue
    .line 191
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValidPassword: returning false because a null or empty password was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    const/4 v0, 0x0

    .line 197
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getAddAsSecondaryAccount()Z
    .locals 1

    .prologue
    .line 269
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    return v0
.end method

.method public getClientContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 864
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mClientContext:Ljava/lang/String;

    return-object v0
.end method

.method getCustInfo()Lorg/json/JSONObject;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 883
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->newCustInfo()Lorg/json/JSONObject;

    move-result-object v0

    .line 884
    .local v0, "custInfo":Lorg/json/JSONObject;
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 886
    const-string/jumbo v1, "access_token"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 888
    :cond_0
    return-object v0
.end method

.method public getCustomerAccountTokenType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    return-object v0
.end method

.method public getPandaCookieDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 849
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPandaCookieDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getPandaEndPointDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 831
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPandaEndpointDomain:Ljava/lang/String;

    return-object v0
.end method

.method protected getPandaTokenExchangeRequestBuilder()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1

    .prologue
    .line 826
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;->builder()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public getRegisterEndPoint()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;
    .locals 1

    .prologue
    .line 859
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    return-object v0
.end method

.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 15

    .prologue
    const/4 v0, 0x0

    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 418
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 420
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getWebRequest: Cannot construct a WebRequest because the RegisterDeviceRequest is invalid. (See previous warnings from RegisterDeviceRequest::isValid for details.)"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    :goto_0
    return-object v0

    .line 426
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    if-ne v1, v4, :cond_1c

    .line 428
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->FIRS:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    if-ne v1, v4, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    :cond_1
    new-instance v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v4, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-eqz v1, :cond_7

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseOverrideDSN:Z

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "/FirsProxy/registerDeviceWithADPToken"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    move-object v1, v0

    move v4, v2

    move v0, v2

    :goto_1
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v5, v6}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v6, "Content-Type"

    const-string/jumbo v7, "text/xml"

    invoke-virtual {v5, v6, v7}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v6, "Expect"

    const-string/jumbo v7, ""

    invoke-virtual {v5, v6, v7}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    if-eqz v5, :cond_2

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v6, "Accept-Language"

    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    invoke-virtual {v5, v6, v7}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    new-instance v6, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "request"

    new-array v7, v2, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    invoke-direct {v6, v5, v7}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    new-instance v7, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "parameters"

    new-array v8, v14, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    new-instance v9, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v10, "deviceType"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceType:Ljava/lang/String;

    new-array v12, v2, [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v9, v10, v11, v12}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V

    aput-object v9, v8, v2

    new-instance v9, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v10, "deviceSerialNumber"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSerialNumber:Ljava/lang/String;

    new-array v12, v2, [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v9, v10, v11, v12}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V

    aput-object v9, v8, v3

    new-instance v9, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v10, "pid"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPid:Ljava/lang/String;

    new-array v12, v2, [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v9, v10, v11, v12}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V

    aput-object v9, v8, v13

    invoke-direct {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    invoke-virtual {v6, v7}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    iget-boolean v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-eqz v5, :cond_d

    const-string/jumbo v8, "deregisterExisting"

    iget-boolean v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    if-eqz v5, :cond_c

    const-string/jumbo v5, "false"

    :goto_2
    invoke-virtual {v7, v8, v5}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    :cond_3
    :goto_3
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecret:Ljava/lang/String;

    if-eqz v5, :cond_4

    const-string/jumbo v5, "secret"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecret:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    :cond_4
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-eqz v5, :cond_11

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValid()Z

    move-result v5

    if-eqz v5, :cond_11

    const-string/jumbo v5, "softwareVersion"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v8}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    :goto_4
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSoftwareComponentId:Ljava/lang/String;

    if-eqz v5, :cond_5

    const-string/jumbo v5, "softwareComponentId"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    :cond_5
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyData:Ljava/lang/String;

    if-eqz v5, :cond_6

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyFormat:Ljava/lang/String;

    if-eqz v5, :cond_6

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    if-eqz v5, :cond_6

    const-string/jumbo v5, "publicKeyData"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyData:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "publicKeyFormat"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyFormat:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "publicKeyAlgorithm"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    :cond_6
    if-eqz v0, :cond_13

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getPandaTokenExchangeRequestBuilder()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v5

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-virtual {v5, v0}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setAccessToken(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPandaCookieDomain:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setCookieDomain(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppVersion:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setAppVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppName:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setAppName(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataOsVersion:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setOsVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    move-result-object v0

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataDeviceModel:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->setHwVersion(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mNonAuthCookies:Ljava/util/List;

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mNonAuthCookies:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_5
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_12

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v9, v0}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->addExistingCookie(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    goto :goto_5

    :cond_7
    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "/FirsProxy/registerAssociatedDevice"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    move-object v1, v0

    move v4, v2

    move v0, v2

    goto/16 :goto_1

    :cond_8
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_a

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "/FirsProxy/registerDeviceToSecondaryCustomer"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    move-object v1, v0

    move v4, v3

    move v0, v3

    goto/16 :goto_1

    :cond_9
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v1, "/FirsProxy/registerDeviceWithToken"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getJwt()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    move v4, v3

    move v0, v3

    goto/16 :goto_1

    :cond_a
    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    if-eqz v1, :cond_b

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "/FirsProxy/registerDeviceToSecondaryCustomer"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    move-object v1, v0

    move v4, v3

    move v0, v2

    goto/16 :goto_1

    :cond_b
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "/FirsProxy/registerDevice"

    invoke-virtual {v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    move-object v1, v0

    move v4, v3

    move v0, v2

    goto/16 :goto_1

    :cond_c
    const-string/jumbo v5, "true"

    goto/16 :goto_2

    :cond_d
    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-nez v5, :cond_e

    iget-boolean v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    if-nez v5, :cond_e

    const-string/jumbo v5, "email"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "password"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    goto/16 :goto_3

    :cond_e
    iget-boolean v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    if-eqz v5, :cond_f

    const-string/jumbo v5, "directedId"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryDirectedId:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "customerType"

    const-string/jumbo v8, "CHILD"

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPfmOfDelegatee:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_3

    const-string/jumbo v5, "pfm"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPfmOfDelegatee:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    goto/16 :goto_3

    :cond_f
    iget-boolean v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    if-eqz v5, :cond_10

    const-string/jumbo v5, "secondaryAccessToken"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "secondaryAccessTokenType"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    invoke-virtual {v8}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    goto/16 :goto_3

    :cond_10
    const-string/jumbo v5, "authToken"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v5, "authTokenType"

    iget-object v8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    invoke-virtual {v8}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;

    goto/16 :goto_3

    :cond_11
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v8, " softwareVersion was undefined."

    invoke-static {v5, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_4

    :cond_12
    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;->build()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;

    move-result-object v0

    if-nez v0, :cond_16

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not construct embeded Panda request."

    invoke-static {v0, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_13
    :goto_6
    if-eqz v4, :cond_14

    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-direct {v0, v4}, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v6, v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    :cond_14
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_15

    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v4, "deviceRequestVerificationData"

    new-array v5, v2, [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v0, v4, v1, v5}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V

    invoke-virtual {v7, v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    :cond_15
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v6}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->convertToString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody(Ljava/lang/String;)V

    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nSoftware Component Id: %s\nLocale: %s"

    const/4 v0, 0x5

    new-array v5, v0, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceType:Ljava/lang/String;

    aput-object v0, v5, v2

    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    invoke-static {v0}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v3

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-nez v0, :cond_17

    const-string/jumbo v0, "None"

    :goto_7
    aput-object v0, v5, v13

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSoftwareComponentId:Ljava/lang/String;

    if-nez v0, :cond_18

    const-string/jumbo v0, "None"

    :goto_8
    aput-object v0, v5, v14

    const/4 v6, 0x4

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    if-nez v0, :cond_19

    const-string/jumbo v0, "Default"

    :goto_9
    aput-object v0, v5, v6

    invoke-static {v1, v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyData:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1a

    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    :goto_a
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    new-array v1, v14, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSerialNumber:Ljava/lang/String;

    aput-object v0, v1, v2

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    aput-object v0, v1, v3

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecret:Ljava/lang/String;

    if-eqz v0, :cond_1b

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecret:Ljava/lang/String;

    :goto_b
    aput-object v0, v1, v13

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto/16 :goto_0

    :cond_16
    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;->getRequest()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Including embedded panda request: "

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    new-instance v5, Lcom/amazon/identity/kcpsdk/common/XMLCData;

    invoke-direct {v5, v0}, Lcom/amazon/identity/kcpsdk/common/XMLCData;-><init>(Ljava/lang/String;)V

    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v8, "identityTokenRequest"

    new-array v9, v3, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    aput-object v5, v9, v2

    invoke-direct {v0, v8, v9}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    invoke-virtual {v7, v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    goto/16 :goto_6

    :cond_17
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v0

    goto :goto_7

    :cond_18
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSoftwareComponentId:Ljava/lang/String;

    goto :goto_8

    :cond_19
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    goto :goto_9

    :cond_1a
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    new-array v0, v14, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyData:Ljava/lang/String;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyFormat:Ljava/lang/String;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    aput-object v1, v0, v13

    goto :goto_a

    :cond_1b
    const-string/jumbo v0, "<No Secret>"

    goto :goto_b

    .line 430
    :cond_1c
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;->Panda:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    if-ne v1, v2, :cond_1d

    .line 432
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->getWebRequestPanda()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v0

    goto/16 :goto_0

    .line 436
    :cond_1d
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "getWebRequest: Cannot construct a WebRequest because the RegisterEndpoint is unknown:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public isValid()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 374
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryLogin:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryDirectedId:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-nez v1, :cond_0

    .line 377
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid login has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 412
    :goto_0
    return v0

    .line 381
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    if-nez v1, :cond_1

    .line 384
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid password has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 388
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    if-nez v1, :cond_2

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPrimaryAccessToken:Ljava/lang/String;

    if-nez v1, :cond_2

    iget-boolean v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    if-nez v1, :cond_2

    .line 391
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid auth token has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 394
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceType:Ljava/lang/String;

    if-nez v1, :cond_3

    .line 396
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid device type has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 400
    :cond_3
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSerialNumber:Ljava/lang/String;

    if-nez v1, :cond_4

    .line 402
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid serial number has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 406
    :cond_4
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    if-nez v1, :cond_5

    .line 408
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a register endpoint has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 412
    :cond_5
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setAddAsChildAccount(Z)V
    .locals 0
    .param p1, "addAsChildAccount"    # Z

    .prologue
    .line 279
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsChildAccount:Z

    .line 280
    return-void
.end method

.method public setAddAsSecondaryAccount(Z)V
    .locals 0
    .param p1, "addAsSecondaryAccount"    # Z

    .prologue
    .line 274
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mAddAsSecondaryAccount:Z

    .line 275
    return-void
.end method

.method public setClientContext(Ljava/lang/String;)V
    .locals 0
    .param p1, "clientContext"    # Ljava/lang/String;

    .prologue
    .line 869
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mClientContext:Ljava/lang/String;

    .line 870
    return-void
.end method

.method public setCustomerAccountToken(Ljava/lang/String;)Z
    .locals 3
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 202
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValidCustomerAccountToken(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 204
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setCustomerAccountToken: password was invalid. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    :goto_0
    return v0

    .line 208
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 210
    :cond_1
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setCustomerAccountToken: cannot specify both an auth token and a login/password. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 215
    :cond_2
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    .line 216
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setCustomerAccountTokenType(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;)V
    .locals 0
    .param p1, "tokenType"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .prologue
    .line 248
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerTokenType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType;

    .line 249
    return-void
.end method

.method public setDeviceSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V
    .locals 2
    .param p1, "deviceSoftwareVersion"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 289
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValid()Z

    move-result v0

    if-nez v0, :cond_0

    .line 291
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setDeviceSoftwareVersion: device software version is invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    :goto_0
    return-void

    .line 295
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    goto :goto_0
.end method

.method public setDeviceTypeToSoftwareVersionMapping(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 369
    .local p1, "versionMapForApps":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    .line 370
    return-void
.end method

.method public setLocale(Ljava/lang/String;)Z
    .locals 2
    .param p1, "locale"    # Ljava/lang/String;

    .prologue
    .line 126
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValidLocale(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 128
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setLocale: locale was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const/4 v0, 0x0

    .line 133
    :goto_0
    return v0

    .line 132
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLocale:Ljava/lang/String;

    .line 133
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setLogin(Ljava/lang/String;)Z
    .locals 3
    .param p1, "login"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 144
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValidLogin(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 146
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setLogin: login was invalid. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    :goto_0
    return v0

    .line 150
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 152
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setLogin: cannot specify both a login and an auth token. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 156
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mLogin:Ljava/lang/String;

    .line 157
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setMetadataAppName(Ljava/lang/String;)V
    .locals 2
    .param p1, "metadataAppName"    # Ljava/lang/String;

    .prologue
    .line 341
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "AppName is only used in Panda and is ignored in Firs."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppName:Ljava/lang/String;

    .line 343
    return-void
.end method

.method public setMetadataAppVersion(Ljava/lang/String;)V
    .locals 2
    .param p1, "metadataAppVersion"    # Ljava/lang/String;

    .prologue
    .line 347
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "AppVersion is only used in Panda and is ignored in Firs."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 348
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataAppVersion:Ljava/lang/String;

    .line 349
    return-void
.end method

.method public setMetadataDeviceModel(Ljava/lang/String;)V
    .locals 2
    .param p1, "metadataDeviceModel"    # Ljava/lang/String;

    .prologue
    .line 353
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "DeviceModel is only used in Panda and is ignored in Firs."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 354
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataDeviceModel:Ljava/lang/String;

    .line 355
    return-void
.end method

.method public setMetadataOsVersion(Ljava/lang/String;)V
    .locals 2
    .param p1, "metadataOsVersion"    # Ljava/lang/String;

    .prologue
    .line 359
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "OsVersion is only used in Panda and is ignored in Firs."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mMetadataOsVersion:Ljava/lang/String;

    .line 361
    return-void
.end method

.method public setNonAuthCookies(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 877
    .local p1, "nonAuthCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mNonAuthCookies:Ljava/util/List;

    .line 878
    return-void
.end method

.method public setPandaCookieDomain(Ljava/lang/String;)V
    .locals 0
    .param p1, "pandaCookieDomain"    # Ljava/lang/String;

    .prologue
    .line 854
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPandaCookieDomain:Ljava/lang/String;

    .line 855
    return-void
.end method

.method public setPandaEndPointDomain(Ljava/lang/String;)V
    .locals 2
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 839
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 841
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setPandaEndpointDomain: domain was invalid (null, empty)"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 845
    :goto_0
    return-void

    .line 844
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPandaEndpointDomain:Ljava/lang/String;

    goto :goto_0
.end method

.method public setPassword(Ljava/lang/String;)Z
    .locals 3
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 173
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValidPassword(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 175
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setPassword: login was invalid. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    :goto_0
    return v0

    .line 179
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mCustomerToken:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 181
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setPassword: cannot specify both a password and an auth token. Cannot be set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 185
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPassword:Ljava/lang/String;

    .line 186
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setPfmOfDelegatee(Ljava/lang/String;)V
    .locals 0
    .param p1, "pfmOfDelegatee"    # Ljava/lang/String;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPfmOfDelegatee:Ljava/lang/String;

    .line 285
    return-void
.end method

.method public setPrimaryAccessToken(Ljava/lang/String;)Z
    .locals 2
    .param p1, "primaryToken"    # Ljava/lang/String;

    .prologue
    .line 221
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->isValidCustomerAccountToken(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 223
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setmPrimaryToken: token is invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    const/4 v0, 0x0

    .line 228
    :goto_0
    return v0

    .line 227
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPrimaryAccessToken:Ljava/lang/String;

    .line 228
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setPublicKeyAlgorithm(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyAlgorithm"    # Ljava/lang/String;

    .prologue
    .line 331
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    .line 332
    return-void
.end method

.method public setPublicKeyData(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyData"    # Ljava/lang/String;

    .prologue
    .line 321
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyData:Ljava/lang/String;

    .line 322
    return-void
.end method

.method public setPublicKeyFormat(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyFormat"    # Ljava/lang/String;

    .prologue
    .line 326
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mPublicKeyFormat:Ljava/lang/String;

    .line 327
    return-void
.end method

.method public setRegisterEndpoint(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;)V
    .locals 0
    .param p1, "registerEndpoint"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    .prologue
    .line 336
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mRegisterEndpoint:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum;

    .line 337
    return-void
.end method

.method public setSecondaryDirectedId(Ljava/lang/String;)V
    .locals 0
    .param p1, "directedID"    # Ljava/lang/String;

    .prologue
    .line 238
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryDirectedId:Ljava/lang/String;

    .line 239
    return-void
.end method

.method public setSecondaryLogin(Ljava/lang/String;)V
    .locals 0
    .param p1, "login"    # Ljava/lang/String;

    .prologue
    .line 233
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryLogin:Ljava/lang/String;

    .line 234
    return-void
.end method

.method public setSecondaryPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 243
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSecondaryPassword:Ljava/lang/String;

    .line 244
    return-void
.end method

.method public setSoftwareComponentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "softwareComponentId"    # Ljava/lang/String;

    .prologue
    .line 300
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mSoftwareComponentId:Ljava/lang/String;

    .line 301
    return-void
.end method

.method public setUseExchangeToken(Z)V
    .locals 0
    .param p1, "useExchangeToken"    # Z

    .prologue
    .line 305
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseExchangeToken:Z

    .line 306
    return-void
.end method

.method public setUseOverrideDSN(Z)V
    .locals 0
    .param p1, "useOverrideDSN"    # Z

    .prologue
    .line 316
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceRequest;->mUseOverrideDSN:Z

    .line 317
    return-void
.end method
