.class public final Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;
.super Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
.source "AmazonJwtSigner.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonKeyStore:Ljava/lang/Object;

.field private final mExponent:Ljava/lang/String;

.field private final mHMAC:Ljava/lang/String;

.field private final mModulus:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 9
    .param p1, "amazonKeyStore"    # Ljava/lang/Object;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/auth/JwtSigner;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mAmazonKeyStore:Ljava/lang/Object;

    .line 42
    :try_start_0
    iget-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mAmazonKeyStore:Ljava/lang/Object;

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    const-string/jumbo v7, "getPubkey"

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Class;

    invoke-virtual {v6, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mAmazonKeyStore:Ljava/lang/Object;

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v6, v7, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 50
    .local v2, "pubKey":[B
    if-nez v2, :cond_0

    .line 52
    const-string/jumbo v6, "NoKeyAvailable"

    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 53
    new-instance v6, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v7, "AmazonKeyStore returned null public key"

    invoke-direct {v6, v7}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 44
    .end local v2    # "pubKey":[B
    :catch_0
    move-exception v0

    .line 46
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 47
    new-instance v6, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v6, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v6

    .line 58
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v2    # "pubKey":[B
    :cond_0
    :try_start_1
    new-instance v5, Ljava/security/spec/X509EncodedKeySpec;

    invoke-direct {v5, v2}, Ljava/security/spec/X509EncodedKeySpec;-><init>([B)V

    .line 59
    .local v5, "x509EncodedKeySpec":Ljava/security/spec/X509EncodedKeySpec;
    const-string/jumbo v6, "RSA"

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->getKeyFactoryForAlgorithm(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v6

    .line 61
    invoke-virtual {v6, v5}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object v3

    check-cast v3, Ljava/security/interfaces/RSAPublicKey;

    .line 63
    .local v3, "publicKey":Ljava/security/interfaces/RSAPublicKey;
    invoke-interface {v3}, Ljava/security/interfaces/RSAPublicKey;->getModulus()Ljava/math/BigInteger;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->integerToOctetString(Ljava/math/BigInteger;)[B

    move-result-object v4

    .line 67
    .local v4, "unSignedModulus":[B
    const/16 v6, 0x20

    new-array v1, v6, [B

    .line 68
    .local v1, "hmac":[B
    array-length v6, v2

    add-int/lit8 v6, v6, -0x20

    const/4 v7, 0x0

    const/16 v8, 0x20

    invoke-static {v2, v6, v1, v7, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 70
    const/16 v6, 0xa

    invoke-static {v1, v6}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mHMAC:Ljava/lang/String;

    .line 71
    const/16 v6, 0xa

    invoke-static {v4, v6}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mModulus:Ljava/lang/String;

    .line 72
    invoke-interface {v3}, Ljava/security/interfaces/RSAPublicKey;->getPublicExponent()Ljava/math/BigInteger;

    move-result-object v6

    invoke-virtual {v6}, Ljava/math/BigInteger;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mExponent:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 78
    return-void

    .line 74
    .end local v1    # "hmac":[B
    .end local v3    # "publicKey":Ljava/security/interfaces/RSAPublicKey;
    .end local v4    # "unSignedModulus":[B
    .end local v5    # "x509EncodedKeySpec":Ljava/security/spec/X509EncodedKeySpec;
    :catch_1
    move-exception v0

    .line 76
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 77
    new-instance v6, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v6, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v6
.end method

.method public static getInstanceIfAvailable()Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 86
    :try_start_0
    const-string/jumbo v4, "amazon.security.AmazonKeyStore"

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 97
    .local v1, "amazonKeyStoreClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :try_start_1
    const-string/jumbo v4, "getAmznInstance"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    invoke-virtual {v1, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v4, v5, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 106
    .local v0, "amazonKeyStore":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 108
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    .line 109
    const-string/jumbo v4, "NoKeyStore"

    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 121
    .end local v0    # "amazonKeyStore":Ljava/lang/Object;
    .end local v1    # "amazonKeyStoreClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    return-object v3

    .line 90
    :catch_0
    move-exception v4

    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    goto :goto_0

    .line 99
    .restart local v1    # "amazonKeyStoreClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_1
    move-exception v2

    .line 101
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 102
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Error getting AmazonKeyStore"

    invoke-static {v4, v5, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 115
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "amazonKeyStore":Ljava/lang/Object;
    :cond_0
    :try_start_2
    new-instance v4, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;

    invoke-direct {v4, v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;-><init>(Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-object v3, v4

    goto :goto_0

    .line 117
    :catch_2
    move-exception v2

    .line 120
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Failed to construct AmazonJwtSigner"

    invoke-static {v4, v5, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getSigner(Lcom/amazon/identity/platform/setting/PlatformSettings;Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
    .locals 5
    .param p0, "settings"    # Lcom/amazon/identity/platform/setting/PlatformSettings;
    .param p1, "deviceInfo"    # Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 130
    const-string/jumbo v3, "jwt_impl"

    const-string/jumbo v4, "ds"

    invoke-virtual {p0, v3, v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 131
    .local v1, "implementation":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Found jwt_impl="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 132
    const/4 v2, 0x0

    .line 135
    .local v2, "signer":Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
    const-string/jumbo v3, "tz"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 137
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->getInstanceIfAvailable()Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;

    move-result-object v2

    .line 139
    if-eqz v2, :cond_0

    if-eqz p2, :cond_0

    .line 141
    const-string/jumbo v3, "JWT:TrustZone"

    invoke-virtual {p2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 146
    :cond_0
    if-nez v2, :cond_1

    const-string/jumbo v3, "off"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 148
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSecret()Ljava/lang/String;

    move-result-object v0

    .line 149
    .local v0, "deviceSecret":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 151
    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/HmacJwtSigner;

    .end local v2    # "signer":Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
    invoke-direct {v2, v0}, Lcom/amazon/identity/kcpsdk/auth/HmacJwtSigner;-><init>(Ljava/lang/String;)V

    .line 153
    .restart local v2    # "signer":Lcom/amazon/identity/kcpsdk/auth/JwtSigner;
    if-eqz p2, :cond_1

    .line 155
    const-string/jumbo v3, "JWT:HMAC"

    invoke-virtual {p2, v3}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 160
    .end local v0    # "deviceSecret":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method static integerToOctetString(Ljava/math/BigInteger;)[B
    .locals 6
    .param p0, "integer"    # Ljava/math/BigInteger;

    .prologue
    const/16 v3, 0x100

    const/4 v4, 0x0

    .line 165
    invoke-virtual {p0}, Ljava/math/BigInteger;->toByteArray()[B

    move-result-object v0

    .line 166
    .local v0, "signedModulus":[B
    array-length v1, v0

    .line 168
    .local v1, "signedModulusLength":I
    if-ne v1, v3, :cond_0

    .line 191
    .end local v0    # "signedModulus":[B
    :goto_0
    return-object v0

    .line 173
    .restart local v0    # "signedModulus":[B
    :cond_0
    new-array v2, v3, [B

    .line 174
    .local v2, "unSignedModulus":[B
    aget-byte v3, v0, v4

    if-nez v3, :cond_1

    .line 177
    const/4 v3, 0x1

    rsub-int v4, v1, 0x100

    add-int/lit8 v4, v4, 0x1

    add-int/lit8 v5, v1, -0x1

    invoke-static {v0, v3, v2, v4, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_1
    move-object v0, v2

    .line 191
    goto :goto_0

    .line 185
    :cond_1
    rsub-int v3, v1, 0x100

    invoke-static {v0, v4, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_1
.end method


# virtual methods
.method addHeaderFields(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "header"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 198
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 199
    .local v0, "jwk":Lorg/json/JSONObject;
    const-string/jumbo v1, "kty"

    const-string/jumbo v2, "RSA"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 200
    const-string/jumbo v1, "n"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mModulus:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 201
    const-string/jumbo v1, "e"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mExponent:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 202
    const-string/jumbo v1, "mac"

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mHMAC:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 204
    const-string/jumbo v1, "alg"

    const-string/jumbo v2, "PS256"

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 205
    const-string/jumbo v1, "jwk"

    invoke-virtual {p1, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 206
    return-void
.end method

.method sign([B)[B
    .locals 8
    .param p1, "corpus"    # [B

    .prologue
    .line 214
    :try_start_0
    const-string/jumbo v3, "SHA-256"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/security/MessageDigest;->digest([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 224
    .local v0, "digest":[B
    :try_start_1
    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mAmazonKeyStore:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string/jumbo v4, "sign"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    const-class v7, [B

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonJwtSigner;->mAmazonKeyStore:Ljava/lang/Object;

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 233
    .local v2, "signature":[B
    if-nez v2, :cond_0

    .line 235
    const-string/jumbo v3, "NullSignature"

    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 236
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v4, "AmazonKeyStore returned null signature"

    invoke-direct {v3, v4}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 216
    .end local v0    # "digest":[B
    .end local v2    # "signature":[B
    :catch_0
    move-exception v1

    .line 218
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v3, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 227
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    .restart local v0    # "digest":[B
    :catch_1
    move-exception v1

    .line 229
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 230
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v3, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 239
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "signature":[B
    :cond_0
    return-object v2
.end method
