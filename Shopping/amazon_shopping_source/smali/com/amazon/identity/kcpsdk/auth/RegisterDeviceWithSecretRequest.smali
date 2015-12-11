.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;
.super Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;
.source "RegisterDeviceWithSecretRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
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

.field private mPublicKeyAlgorithm:Ljava/lang/String;

.field private mPublicKeyData:Ljava/lang/String;

.field private mPublicKeyFormat:Ljava/lang/String;

.field private mRadioId:Ljava/lang/String;

.field private mReason:Ljava/lang/String;

.field private mSecondaryRadioId:Ljava/lang/String;

.field private mSoftwareComponentId:Ljava/lang/String;

.field private mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;-><init>()V

    .line 37
    return-void
.end method

.method public static isValidLocale(Ljava/lang/String;)Z
    .locals 1
    .param p0, "locale"    # Ljava/lang/String;

    .prologue
    .line 53
    const/4 v0, 0x1

    return v0
.end method

.method public static isValidRadioId(Ljava/lang/String;)Z
    .locals 3
    .param p0, "radioId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 70
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidRadioId: returning false because a null or empty radio id was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    :goto_0
    return v0

    .line 76
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isAlphaNumeric(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 78
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValidRadioId: returning false because a non alpha radio id number was given."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 82
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidReason(Ljava/lang/String;)Z
    .locals 2
    .param p0, "reason"    # Ljava/lang/String;

    .prologue
    .line 111
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 113
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "isValidReason: returning false because a null or empty reason was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    const/4 v0, 0x0

    .line 117
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 11

    .prologue
    const/4 v10, 0x4

    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 193
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->isValid()Z

    move-result v2

    if-nez v2, :cond_0

    .line 195
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "getWebRequest: Cannot construct a WebRequest because the RegisterDeviceWithSecretRequest is invalid. (See previous warnings from RegisterDeviceWithSecretRequest::isValid for details.)"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 198
    const/4 v2, 0x0

    .line 286
    :goto_0
    return-object v2

    .line 201
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v2, :cond_1

    .line 203
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    .line 206
    :cond_1
    new-instance v2, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 208
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 210
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "Accept-Language"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    :cond_2
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v3, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    .line 214
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 215
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "/FirsProxy/getNewDeviceCredentials"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setPath(Ljava/lang/String;)V

    .line 216
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v3, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 218
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "deviceType"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceType:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 219
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "deviceSerialNumber"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "secret"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecret:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "radioId"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mRadioId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecondaryRadioId:Ljava/lang/String;

    if-eqz v2, :cond_3

    .line 225
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "secondaryRadioId"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecondaryRadioId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    :cond_3
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mReason:Ljava/lang/String;

    if-eqz v2, :cond_4

    .line 230
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "reason"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mReason:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    :cond_4
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValid()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 235
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "softwareVersion"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    :cond_5
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSoftwareComponentId:Ljava/lang/String;

    if-eqz v2, :cond_6

    .line 240
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "softwareComponentId"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    :cond_6
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyData:Ljava/lang/String;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyFormat:Ljava/lang/String;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    if-eqz v2, :cond_7

    .line 245
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "publicKeyData"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyData:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "publicKeyFormat"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyFormat:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "publicKeyAlgorithm"

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    :cond_7
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->getJwt()Ljava/lang/String;

    move-result-object v0

    .line 252
    .local v0, "jsonWebToken":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_8

    .line 254
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "deviceRequestVerificationData"

    invoke-virtual {v2, v3, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 257
    :cond_8
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v3, "Content-Type"

    const-string/jumbo v4, "text/xml"

    invoke-virtual {v2, v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    if-lez v2, :cond_9

    .line 263
    new-instance v1, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const-string/jumbo v2, "request"

    new-array v3, v6, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    invoke-direct {v1, v2, v3}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    .line 264
    .local v1, "request":Lcom/amazon/identity/kcpsdk/common/XMLElement;
    new-instance v2, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    invoke-direct {v2, v3}, Lcom/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    .line 265
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->convertToString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody(Ljava/lang/String;)V

    .line 268
    .end local v1    # "request":Lcom/amazon/identity/kcpsdk/common/XMLElement;
    :cond_9
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v2, v6}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setAuthenticationRequired(Z)V

    .line 270
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "getWebRequest: constructed a web request with:\nDevice Type: %s\nReason: %s\nVersion Number: %s\nSoftware Component Id: %s\nLocale: %s"

    const/4 v2, 0x5

    new-array v5, v2, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceType:Ljava/lang/String;

    aput-object v2, v5, v6

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mReason:Ljava/lang/String;

    aput-object v2, v5, v7

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v2

    :goto_1
    aput-object v2, v5, v8

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSoftwareComponentId:Ljava/lang/String;

    if-nez v2, :cond_b

    const-string/jumbo v2, "None"

    :goto_2
    aput-object v2, v5, v9

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    if-nez v2, :cond_c

    const-string/jumbo v2, "Default"

    :goto_3
    aput-object v2, v5, v10

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 279
    sget-object v2, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    new-array v2, v10, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceSerialNumber:Ljava/lang/String;

    aput-object v3, v2, v6

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mRadioId:Ljava/lang/String;

    aput-object v3, v2, v7

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecondaryRadioId:Ljava/lang/String;

    aput-object v3, v2, v8

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecret:Ljava/lang/String;

    aput-object v3, v2, v9

    .line 286
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto/16 :goto_0

    .line 270
    :cond_a
    const-string/jumbo v2, ""

    goto :goto_1

    :cond_b
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSoftwareComponentId:Ljava/lang/String;

    goto :goto_2

    :cond_c
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    goto :goto_3
.end method

.method public isValid()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 148
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceType:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 150
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid device type has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    :goto_0
    return v0

    .line 154
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceSerialNumber:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 156
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid device serial number has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 160
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecret:Ljava/lang/String;

    if-nez v1, :cond_2

    .line 162
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid secret has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 166
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mRadioId:Ljava/lang/String;

    if-nez v1, :cond_3

    .line 168
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "isValid: returning false because a valid radio id has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 172
    :cond_3
    const/4 v0, 0x1

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
    .line 143
    .local p1, "versionMapForApps":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mDeviceTypeSoftwareVersionMap:Ljava/util/Map;

    .line 144
    return-void
.end method

.method public setLocale(Ljava/lang/String;)Z
    .locals 2
    .param p1, "locale"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->isValidLocale(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 43
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setLocale: locale was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const/4 v0, 0x0

    .line 48
    :goto_0
    return v0

    .line 47
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mLocale:Ljava/lang/String;

    .line 48
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setPublicKeyAlgorithm(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyAlgorithm"    # Ljava/lang/String;

    .prologue
    .line 187
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyAlgorithm:Ljava/lang/String;

    .line 188
    return-void
.end method

.method public setPublicKeyData(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyData"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyData:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setPublicKeyFormat(Ljava/lang/String;)V
    .locals 0
    .param p1, "publicKeyFormat"    # Ljava/lang/String;

    .prologue
    .line 182
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mPublicKeyFormat:Ljava/lang/String;

    .line 183
    return-void
.end method

.method public setRadioId(Ljava/lang/String;)Z
    .locals 2
    .param p1, "radioId"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->isValidRadioId(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 60
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setRadioId: radio id was invalid. Cannot set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    const/4 v0, 0x0

    .line 65
    :goto_0
    return v0

    .line 64
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mRadioId:Ljava/lang/String;

    .line 65
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setReason(Ljava/lang/String;)Z
    .locals 2
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 99
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->isValidReason(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 101
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setReason: reason was invalid. Cannot set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const/4 v0, 0x0

    .line 106
    :goto_0
    return v0

    .line 105
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mReason:Ljava/lang/String;

    .line 106
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setSecondaryRadioId(Ljava/lang/String;)Z
    .locals 2
    .param p1, "radioId"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->isValidRadioId(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 89
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setSecondaryRadioId: radio id was invalid. Cannot set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const/4 v0, 0x0

    .line 94
    :goto_0
    return v0

    .line 93
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSecondaryRadioId:Ljava/lang/String;

    .line 94
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setSoftwareComponentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "softwareComponentId"    # Ljava/lang/String;

    .prologue
    .line 134
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mSoftwareComponentId:Ljava/lang/String;

    .line 135
    return-void
.end method

.method public setVersionNumber(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)Z
    .locals 2
    .param p1, "versionNumber"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 122
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValid()Z

    move-result v0

    if-nez v0, :cond_0

    .line 124
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setVersionNumber: version number was invalid. Cannot set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const/4 v0, 0x0

    .line 129
    :goto_0
    return v0

    .line 128
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest;->mVersionNumber:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .line 129
    const/4 v0, 0x1

    goto :goto_0
.end method
