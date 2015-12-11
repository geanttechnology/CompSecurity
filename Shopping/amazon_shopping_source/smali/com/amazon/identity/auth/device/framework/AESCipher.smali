.class public Lcom/amazon/identity/auth/device/framework/AESCipher;
.super Ljava/lang/Object;
.source "AESCipher.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mKeySpec:Ljavax/crypto/spec/SecretKeySpec;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/identity/auth/device/framework/AESCipher;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>([B)V
    .locals 2
    .param p1, "key"    # [B

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-nez p1, :cond_0

    .line 40
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "encryption key was null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_0
    new-instance v0, Ljavax/crypto/spec/SecretKeySpec;

    const-string/jumbo v1, "AES"

    invoke-direct {v0, p1, v1}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AESCipher;->mKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    .line 43
    return-void
.end method

.method private createAESCipher(ILjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)Ljavax/crypto/Cipher;
    .locals 4
    .param p1, "opMode"    # I
    .param p2, "transformation"    # Ljava/lang/String;
    .param p3, "iv"    # Ljava/security/spec/AlgorithmParameterSpec;

    .prologue
    .line 131
    const/4 v0, 0x0

    .line 134
    .local v0, "cipher":Ljavax/crypto/Cipher;
    :try_start_0
    invoke-static {p2}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 135
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/AESCipher;->mKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v0, p1, v2, p3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/security/InvalidAlgorithmParameterException; {:try_start_0 .. :try_end_0} :catch_3

    .line 153
    :goto_0
    return-object v0

    .line 137
    :catch_0
    move-exception v1

    .line 139
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Aborting cipher creation"

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 141
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v1

    .line 143
    .local v1, "e":Ljavax/crypto/NoSuchPaddingException;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Aborting cipher creation"

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 145
    .end local v1    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    move-exception v1

    .line 147
    .local v1, "e":Ljava/security/InvalidKeyException;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Aborting cipher creation because the key was invalid"

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 149
    .end local v1    # "e":Ljava/security/InvalidKeyException;
    :catch_3
    move-exception v1

    .line 151
    .local v1, "e":Ljava/security/InvalidAlgorithmParameterException;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Aborting cipher creation due to the occurrence of invalid algorithm parameters."

    invoke-static {v2, v3, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static generateAesSecureStorageKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 80
    :try_start_0
    const-string/jumbo v1, "AES"

    invoke-static {v1}, Ljavax/crypto/KeyGenerator;->getInstance(Ljava/lang/String;)Ljavax/crypto/KeyGenerator;

    move-result-object v0

    .line 81
    .local v0, "kgen":Ljavax/crypto/KeyGenerator;
    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Ljavax/crypto/KeyGenerator;->init(I)V

    .line 83
    invoke-virtual {v0}, Ljavax/crypto/KeyGenerator;->generateKey()Ljavax/crypto/SecretKey;

    move-result-object v1

    .line 84
    invoke-interface {v1}, Ljavax/crypto/SecretKey;->getEncoded()[B

    move-result-object v1

    .line 88
    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 93
    :goto_0
    return-object v1

    .line 92
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not generate a symmetric key for algorithm AES"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static generateAesSecureStorageKeyForDevice(Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;)Ljava/lang/String;
    .locals 8
    .param p0, "deviceInfo"    # Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .prologue
    .line 47
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSecret()Ljava/lang/String;

    move-result-object v0

    .line 48
    .local v0, "deviceSecret":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 50
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "deviceSerial":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 58
    :try_start_0
    const-string/jumbo v4, "PBKDF2WithHmacSHA1"

    invoke-static {v4}, Ljavax/crypto/SecretKeyFactory;->getInstance(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;

    move-result-object v2

    .line 59
    .local v2, "factory":Ljavax/crypto/SecretKeyFactory;
    new-instance v3, Ljavax/crypto/spec/PBEKeySpec;

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    const/16 v6, 0x3e8

    const/16 v7, 0x80

    invoke-direct {v3, v4, v5, v6, v7}, Ljavax/crypto/spec/PBEKeySpec;-><init>([C[BII)V

    .line 64
    .local v3, "keySpec":Ljava/security/spec/KeySpec;
    invoke-virtual {v2, v3}, Ljavax/crypto/SecretKeyFactory;->generateSecret(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;

    move-result-object v4

    .line 65
    invoke-interface {v4}, Ljavax/crypto/SecretKey;->getEncoded()[B

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 73
    .end local v1    # "deviceSerial":Ljava/lang/String;
    .end local v2    # "factory":Ljavax/crypto/SecretKeyFactory;
    .end local v3    # "keySpec":Ljava/security/spec/KeySpec;
    :goto_0
    return-object v4

    .line 69
    .restart local v1    # "deviceSerial":Ljava/lang/String;
    :catch_0
    move-exception v4

    sget-object v4, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not generate a symmetric key with PBKDF2"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    .end local v1    # "deviceSerial":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AESCipher;->generateAesSecureStorageKey()Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public static generateIVForEncryption()[B
    .locals 3

    .prologue
    .line 199
    new-instance v1, Ljava/security/SecureRandom;

    invoke-direct {v1}, Ljava/security/SecureRandom;-><init>()V

    .line 200
    .local v1, "random":Ljava/security/SecureRandom;
    const/16 v2, 0x10

    new-array v0, v2, [B

    .line 201
    .local v0, "iv":[B
    invoke-virtual {v1, v0}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 202
    return-object v0
.end method

.method protected static performCipherOperation(Ljavax/crypto/Cipher;[BII)[B
    .locals 4
    .param p0, "cipher"    # Ljavax/crypto/Cipher;
    .param p1, "input"    # [B
    .param p2, "inputOffset"    # I
    .param p3, "inputLen"    # I

    .prologue
    .line 162
    if-nez p0, :cond_0

    .line 164
    const/4 v1, 0x0

    .line 175
    :goto_0
    return-object v1

    .line 166
    :cond_0
    const/4 v1, 0x0

    .line 169
    .local v1, "encoded":[B
    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Ljavax/crypto/Cipher;->doFinal([BII)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 171
    :catch_0
    move-exception v0

    .line 173
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Encrypting / Decrypting failed with the given key. Aborting!"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public concat([B[B)[B
    .locals 5
    .param p1, "iv"    # [B
    .param p2, "cipherText"    # [B

    .prologue
    .line 210
    const/4 v1, 0x0

    .line 213
    .local v1, "result":[B
    :try_start_0
    array-length v2, p1

    array-length v3, p2

    add-int/2addr v2, v3

    new-array v1, v2, [B

    .line 214
    const/4 v2, 0x0

    const/4 v3, 0x0

    array-length v4, p1

    invoke-static {p1, v2, v1, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 215
    const/4 v2, 0x0

    array-length v3, p1

    array-length v4, p2

    invoke-static {p2, v2, v1, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v2, v1

    .line 222
    :goto_0
    return-object v2

    .line 217
    :catch_0
    move-exception v0

    .line 219
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AESCipher;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Exception happended during concatenating the initialization vectors and the cipher text"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 220
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public decryptCBCMode([B)[B
    .locals 5
    .param p1, "encryptedData"    # [B

    .prologue
    const/16 v4, 0x10

    .line 230
    if-nez p1, :cond_0

    .line 232
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "dataToDecrypt is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 235
    :cond_0
    const/4 v0, 0x2

    const-string/jumbo v1, "AES/CBC/PKCS7Padding"

    new-instance v2, Ljavax/crypto/spec/IvParameterSpec;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3, v4}, Ljavax/crypto/spec/IvParameterSpec;-><init>([BII)V

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->createAESCipher(ILjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 240
    array-length v1, p1

    add-int/lit8 v1, v1, -0x10

    invoke-static {v0, p1, v4, v1}, Lcom/amazon/identity/auth/device/framework/AESCipher;->performCipherOperation(Ljavax/crypto/Cipher;[BII)[B

    move-result-object v0

    return-object v0
.end method

.method public decryptECBMode([B)[B
    .locals 3
    .param p1, "dataToDecrypt"    # [B
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 119
    if-nez p1, :cond_0

    .line 121
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "dataToDecrypt is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 124
    :cond_0
    const/4 v0, 0x2

    const-string/jumbo v1, "AES"

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->createAESCipher(ILjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 126
    const/4 v1, 0x0

    array-length v2, p1

    invoke-static {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->performCipherOperation(Ljavax/crypto/Cipher;[BII)[B

    move-result-object v0

    return-object v0
.end method

.method public encryptCBCMode([B)[B
    .locals 5
    .param p1, "dataToEncrypt"    # [B

    .prologue
    .line 183
    if-nez p1, :cond_0

    .line 185
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "dataToEncrypt is null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 188
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/AESCipher;->generateIVForEncryption()[B

    move-result-object v1

    .line 190
    .local v1, "iv":[B
    const/4 v2, 0x1

    const-string/jumbo v3, "AES/CBC/PKCS7Padding"

    new-instance v4, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v4, v1}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    invoke-direct {p0, v2, v3, v4}, Lcom/amazon/identity/auth/device/framework/AESCipher;->createAESCipher(ILjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)Ljavax/crypto/Cipher;

    move-result-object v2

    .line 192
    const/4 v3, 0x0

    array-length v4, p1

    invoke-static {v2, p1, v3, v4}, Lcom/amazon/identity/auth/device/framework/AESCipher;->performCipherOperation(Ljavax/crypto/Cipher;[BII)[B

    move-result-object v0

    .line 194
    .local v0, "cipherText":[B
    invoke-virtual {p0, v1, v0}, Lcom/amazon/identity/auth/device/framework/AESCipher;->concat([B[B)[B

    move-result-object v2

    return-object v2
.end method

.method public encryptECBMode([B)[B
    .locals 3
    .param p1, "dataToEncrypt"    # [B
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 103
    if-nez p1, :cond_0

    .line 105
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "dataToEncrypt is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 108
    :cond_0
    const/4 v0, 0x1

    const-string/jumbo v1, "AES"

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->createAESCipher(ILjava/lang/String;Ljava/security/spec/AlgorithmParameterSpec;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 110
    const/4 v1, 0x0

    array-length v2, p1

    invoke-static {v0, p1, v1, v2}, Lcom/amazon/identity/auth/device/framework/AESCipher;->performCipherOperation(Ljavax/crypto/Cipher;[BII)[B

    move-result-object v0

    return-object v0
.end method
