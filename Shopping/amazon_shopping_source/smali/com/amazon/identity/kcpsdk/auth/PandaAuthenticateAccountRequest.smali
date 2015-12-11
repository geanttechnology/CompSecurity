.class public Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;
.super Lcom/amazon/identity/kcpsdk/auth/PandaRequest;
.source "PandaAuthenticateAccountRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mDeviceSerialNumber:Ljava/lang/String;

.field private mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

.field private mDeviceType:Ljava/lang/String;

.field private mDirectedId:Ljava/lang/String;

.field private mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

.field private mMetadataAppName:Ljava/lang/String;

.field private mMetadataAppVersion:Ljava/lang/String;

.field private mPassword:Ljava/lang/String;

.field private mTrustedDeviceToken:Ljava/lang/String;

.field private mUserID:Ljava/lang/String;

.field private mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;-><init>()V

    return-void
.end method

.method public static isValidDeviceSerialNumber(Ljava/lang/String;)Z
    .locals 1
    .param p0, "deviceSerialNumber"    # Ljava/lang/String;

    .prologue
    .line 177
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isValidDeviceSerialNumber(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isValidDeviceType(Ljava/lang/String;)Z
    .locals 1
    .param p0, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 155
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isValidDeviceType(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isValidDirectedId(Ljava/lang/String;)Z
    .locals 2
    .param p0, "directedId"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " isValidDirectedId: returning false because a null or empty directedId was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const/4 v0, 0x0

    .line 98
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
    .line 103
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " isValidPassword: returning false because a null or empty password was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    const/4 v0, 0x0

    .line 109
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isValidUserID(Ljava/lang/String;)Z
    .locals 2
    .param p0, "userID"    # Ljava/lang/String;

    .prologue
    .line 57
    invoke-static {p0}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 59
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " isValidUserID: returning false because a null or empty user ID was given."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const/4 v0, 0x0

    .line 63
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSerialNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestJSON()Lorg/json/JSONObject;
    .locals 13
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 253
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8}, Lorg/json/JSONObject;-><init>()V

    .line 255
    .local v8, "requestJson":Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 256
    .local v0, "authDataObject":Lorg/json/JSONObject;
    const-string/jumbo v10, "auth_data"

    invoke-virtual {v8, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 257
    const-string/jumbo v10, "use_global_authentication"

    const-string/jumbo v11, "true"

    invoke-virtual {v0, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 259
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 260
    .local v1, "credentials":Lorg/json/JSONObject;
    const-string/jumbo v10, "password"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mPassword:Ljava/lang/String;

    invoke-virtual {v1, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 262
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 264
    new-instance v10, Ljava/lang/IllegalStateException;

    const-string/jumbo v11, "Invalid parameters. Cannot set both login and directedId."

    invoke-direct {v10, v11}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 267
    :cond_0
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_5

    .line 269
    const-string/jumbo v10, "user_id"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    invoke-virtual {v1, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 270
    const-string/jumbo v10, "user_id_password"

    invoke-virtual {v0, v10, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 282
    :goto_0
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mTrustedDeviceToken:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 284
    const-string/jumbo v10, "trusted_device_token"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mTrustedDeviceToken:Ljava/lang/String;

    invoke-virtual {v0, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 287
    :cond_1
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    .line 288
    .local v9, "signInData":Lorg/json/JSONObject;
    const-string/jumbo v10, "signin_data"

    invoke-virtual {v8, v10, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 290
    const-string/jumbo v10, "device_serial"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 291
    const-string/jumbo v10, "device_type"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceType:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 292
    const-string/jumbo v10, "domain"

    const-string/jumbo v11, "Device"

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 293
    const-string/jumbo v11, "app_name"

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppName:Ljava/lang/String;

    if-eqz v10, :cond_7

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppName:Ljava/lang/String;

    :goto_1
    invoke-virtual {v9, v11, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 294
    const-string/jumbo v11, "app_version"

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppVersion:Ljava/lang/String;

    if-eqz v10, :cond_8

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppVersion:Ljava/lang/String;

    :goto_2
    invoke-virtual {v9, v11, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 295
    const-string/jumbo v10, "device_model"

    sget-object v11, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 296
    const-string/jumbo v10, "os_version"

    sget v11, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 297
    const-string/jumbo v11, "software_version"

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-eqz v10, :cond_9

    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {v10}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->getString()Ljava/lang/String;

    move-result-object v10

    :goto_3
    invoke-virtual {v9, v11, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 299
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    if-nez v10, :cond_2

    .line 301
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v11, " software_version was undefined."

    invoke-static {v10, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 303
    :cond_2
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    if-eqz v10, :cond_4

    .line 307
    :try_start_0
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceType:Ljava/lang/String;

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSerialNumber:Ljava/lang/String;

    const/4 v12, 0x0

    invoke-static {v10, v11, v12}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->deviceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 308
    .local v3, "deviceInfo":Lorg/json/JSONObject;
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->newCustInfo()Lorg/json/JSONObject;

    move-result-object v2

    .line 309
    .local v2, "custInfo":Lorg/json/JSONObject;
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_a

    .line 311
    const-string/jumbo v10, "SHA256"

    invoke-static {v10}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    const-string/jumbo v12, "UTF-8"

    invoke-virtual {v11, v12}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v4

    .line 312
    .local v4, "digest":[B
    const-string/jumbo v10, "email_hash"

    const/4 v11, 0x2

    invoke-static {v4, v11}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 318
    .end local v4    # "digest":[B
    :cond_3
    :goto_4
    const/4 v10, 0x0

    invoke-static {v3, v2, v10}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->getRegistrationPayload(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 319
    .local v7, "payload":Lorg/json/JSONObject;
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    const-string/jumbo v11, "drvV2"

    invoke-virtual {v10, v11, v7}, Lcom/amazon/identity/kcpsdk/auth/JwtSigner;->signJwt(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v6

    .line 320
    .local v6, "jwt":Ljava/lang/String;
    const-string/jumbo v10, "device_authentication_token"

    invoke-virtual {v9, v10, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 321
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "The JWT is "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 328
    .end local v2    # "custInfo":Lorg/json/JSONObject;
    .end local v3    # "deviceInfo":Lorg/json/JSONObject;
    .end local v6    # "jwt":Ljava/lang/String;
    .end local v7    # "payload":Lorg/json/JSONObject;
    :cond_4
    :goto_5
    return-object v8

    .line 272
    .end local v9    # "signInData":Lorg/json/JSONObject;
    :cond_5
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_6

    .line 274
    const-string/jumbo v10, "directedId"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v1, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 275
    const-string/jumbo v10, "directedId_password"

    invoke-virtual {v0, v10, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_0

    .line 279
    :cond_6
    new-instance v10, Ljava/lang/IllegalStateException;

    const-string/jumbo v11, "Invalid parameters."

    invoke-direct {v10, v11}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 293
    .restart local v9    # "signInData":Lorg/json/JSONObject;
    :cond_7
    const-string/jumbo v10, "defaultAppName"

    goto/16 :goto_1

    .line 294
    :cond_8
    const-string/jumbo v10, "defaultAppVersion"

    goto/16 :goto_2

    .line 297
    :cond_9
    const-string/jumbo v10, "defaultSoftwareVersion"

    goto/16 :goto_3

    .line 314
    .restart local v2    # "custInfo":Lorg/json/JSONObject;
    .restart local v3    # "deviceInfo":Lorg/json/JSONObject;
    :cond_a
    :try_start_1
    iget-object v10, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 316
    const-string/jumbo v10, "directed_id"

    iget-object v11, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v2, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_4

    .line 323
    .end local v2    # "custInfo":Lorg/json/JSONObject;
    .end local v3    # "deviceInfo":Lorg/json/JSONObject;
    :catch_0
    move-exception v5

    .line 325
    .local v5, "e":Ljava/lang/Exception;
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "Failed to sign JWT"

    invoke-static {v10, v11, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5
.end method

.method public getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .locals 6

    .prologue
    .line 209
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    if-eqz v3, :cond_0

    .line 211
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 248
    :goto_0
    return-object v3

    .line 214
    :cond_0
    const-string/jumbo v3, "/auth/signin"

    invoke-virtual {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->getPandaEndPoint(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 215
    .local v1, "pandaEndPoint":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 217
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v4, " CookieDomain not set."

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    const/4 v3, 0x0

    goto :goto_0

    .line 221
    :cond_1
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 223
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v4, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->WebProtocolHttps:Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    invoke-virtual {v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V

    .line 225
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v3, v1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 227
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    sget-object v4, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V

    .line 229
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "Content-Type"

    const-string/jumbo v5, "application/json"

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->isCurrentEnvironmentDevo()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 234
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    const-string/jumbo v4, "x-forwarded-server"

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->getPandaHost()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    :cond_2
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->getRequestJSON()Lorg/json/JSONObject;

    move-result-object v2

    .line 241
    .local v2, "requestJson":Lorg/json/JSONObject;
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 248
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    goto :goto_0

    .line 243
    .end local v2    # "requestJson":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 245
    .local v0, "e":Lorg/json/JSONException;
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public isValid()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 114
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 116
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " isValid: returning false because a valid userId or directedId has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    :goto_0
    return v0

    .line 120
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mPassword:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 122
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " isValid: returning false because a valid password has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 126
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceType:Ljava/lang/String;

    if-nez v1, :cond_2

    .line 128
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " isValid: returning false because a valid device type has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 132
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSerialNumber:Ljava/lang/String;

    if-nez v1, :cond_3

    .line 134
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, " isValid: returning false because a valid serial number has not been set."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 138
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setDeviceInfo(Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)V
    .locals 1
    .param p1, "deviceInfo"    # Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .prologue
    .line 187
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDeviceSerialNumber(Ljava/lang/String;)Z

    .line 188
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDeviceType(Ljava/lang/String;)Z

    .line 189
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getSoftwareVersion()Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->setDeviceSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V

    .line 190
    return-void
.end method

.method public setDeviceSerialNumber(Ljava/lang/String;)Z
    .locals 2
    .param p1, "deviceSerialNumber"    # Ljava/lang/String;

    .prologue
    .line 165
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->isValidDeviceSerialNumber(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setDeviceSerialNumber: device serial number was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    const/4 v0, 0x0

    .line 172
    :goto_0
    return v0

    .line 171
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSerialNumber:Ljava/lang/String;

    .line 172
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setDeviceSoftwareVersion(Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;)V
    .locals 2
    .param p1, "deviceSoftwareVersion"    # Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    .prologue
    .line 333
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;->isValid()Z

    move-result v0

    if-nez v0, :cond_1

    .line 335
    :cond_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setDeviceSoftwareVersion: device software version is invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    :goto_0
    return-void

    .line 339
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceSoftwareVersion:Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    goto :goto_0
.end method

.method public setDeviceType(Ljava/lang/String;)Z
    .locals 2
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->isValidDeviceType(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 145
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setDeviceType: deviceType was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    const/4 v0, 0x0

    .line 150
    :goto_0
    return v0

    .line 149
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDeviceType:Ljava/lang/String;

    .line 150
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setDirectedId(Ljava/lang/String;)Z
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->isValidDirectedId(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 70
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setDirectedId: directedId was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const/4 v0, 0x0

    .line 75
    :goto_0
    return v0

    .line 74
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mDirectedId:Ljava/lang/String;

    .line 75
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setJwtSigner(Lcom/amazon/identity/kcpsdk/auth/JwtSigner;)V
    .locals 0
    .param p1, "jwtSigner"    # Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    .line 205
    return-void
.end method

.method public setMetadataAppName(Ljava/lang/String;)V
    .locals 0
    .param p1, "metadataAppName"    # Ljava/lang/String;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppName:Ljava/lang/String;

    .line 195
    return-void
.end method

.method public setMetadataAppVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "metadataAppVersion"    # Ljava/lang/String;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mMetadataAppVersion:Ljava/lang/String;

    .line 200
    return-void
.end method

.method public setPassword(Ljava/lang/String;)Z
    .locals 2
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->isValidPassword(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 82
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setPassword: password was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const/4 v0, 0x0

    .line 87
    :goto_0
    return v0

    .line 86
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mPassword:Ljava/lang/String;

    .line 87
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setTrustedDeviceToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "trustedDeviceToken"    # Ljava/lang/String;

    .prologue
    .line 344
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mTrustedDeviceToken:Ljava/lang/String;

    .line 345
    return-void
.end method

.method public setUserID(Ljava/lang/String;)Z
    .locals 2
    .param p1, "userID"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->isValidUserID(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 47
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setUserID: userID was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const/4 v0, 0x0

    .line 52
    :goto_0
    return v0

    .line 51
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest;->mUserID:Ljava/lang/String;

    .line 52
    const/4 v0, 0x1

    goto :goto_0
.end method
