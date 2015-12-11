.class public abstract Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;
.super Ljava/lang/Object;
.source "RegisterRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field protected mDeviceSerialNumber:Ljava/lang/String;

.field protected mDeviceType:Ljava/lang/String;

.field protected mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

.field protected mPid:Ljava/lang/String;

.field protected mSecret:Ljava/lang/String;

.field protected mTimestamp:Ljava/lang/String;

.field protected mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method getCustInfo()Lorg/json/JSONObject;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 100
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->newCustInfo()Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public final getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceSerialNumber:Ljava/lang/String;

    return-object v0
.end method

.method public final getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method getJwt()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 105
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    if-nez v4, :cond_0

    move-object v1, v3

    .line 123
    :goto_0
    return-object v1

    .line 112
    :cond_0
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceType:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceSerialNumber:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mSecret:Ljava/lang/String;

    invoke-static {v4, v5, v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->deviceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->getCustInfo()Lorg/json/JSONObject;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mTimestamp:Ljava/lang/String;

    invoke-static {v4, v5, v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->getRegistrationPayload(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 116
    .local v2, "payload":Lorg/json/JSONObject;
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    const-string/jumbo v5, "drvV1"

    invoke-virtual {v4, v5, v2}, Lcom/amazon/identity/kcpsdk/auth/JwtSigner;->signJwt(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    .line 117
    .local v1, "jwt":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "The JWT is "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 120
    .end local v1    # "jwt":Ljava/lang/String;
    .end local v2    # "payload":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 122
    .local v0, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Failed to sign JWT"

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v1, v3

    .line 123
    goto :goto_0
.end method

.method public abstract getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;
.end method

.method public final setDeviceSerialNumber(Ljava/lang/String;)Z
    .locals 2
    .param p1, "deviceSerialNumber"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isValidDeviceSerialNumber(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 50
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setDeviceSerialNumber: device serial number was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    const/4 v0, 0x0

    .line 56
    :goto_0
    return v0

    .line 54
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceSerialNumber:Ljava/lang/String;

    .line 55
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;->getPid(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mPid:Ljava/lang/String;

    .line 56
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final setDeviceType(Ljava/lang/String;)Z
    .locals 2
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isValidDeviceType(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 33
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setDeviceType: deviceType was invalid. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    const/4 v0, 0x0

    .line 38
    :goto_0
    return v0

    .line 37
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mDeviceType:Ljava/lang/String;

    .line 38
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setJwtSigner(Lcom/amazon/identity/kcpsdk/auth/JwtSigner;)V
    .locals 0
    .param p1, "jwtSigner"    # Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mJwtSigner:Lcom/amazon/identity/kcpsdk/auth/JwtSigner;

    .line 88
    return-void
.end method

.method public final setSecret(Ljava/lang/String;)Z
    .locals 2
    .param p1, "secret"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setSecret: secret was invalid. Cannot set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const/4 v0, 0x0

    .line 73
    :goto_0
    return v0

    .line 72
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mSecret:Ljava/lang/String;

    .line 73
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final setTimestamp(Ljava/lang/String;)V
    .locals 1
    .param p1, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mTimestamp:Ljava/lang/String;

    .line 82
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 83
    return-void
.end method

.method public setTrustZone(Z)V
    .locals 1
    .param p1, "trustZoneEnabled"    # Z

    .prologue
    .line 92
    if-eqz p1, :cond_0

    .line 94
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->getInstanceIfAvailable()Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterRequest;->setJwtSigner(Lcom/amazon/identity/kcpsdk/auth/JwtSigner;)V

    .line 96
    :cond_0
    return-void
.end method
