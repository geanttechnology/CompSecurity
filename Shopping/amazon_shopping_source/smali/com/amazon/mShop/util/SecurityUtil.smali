.class public Lcom/amazon/mShop/util/SecurityUtil;
.super Ljava/lang/Object;
.source "SecurityUtil.java"


# static fields
.field private static final PUBLIC_KEY_SPEC:Ljava/security/spec/RSAPublicKeySpec;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/16 v4, 0x10

    .line 15
    new-instance v0, Ljava/security/spec/RSAPublicKeySpec;

    new-instance v1, Ljava/math/BigInteger;

    const-string/jumbo v2, "00929aee0d3595cc2bc2aac2a75b65b5dcdacc62e2f1794f344a536ec535eb18407290e2da8a211e876f68494a5c98d34fefb398c6631f543b02ec05d0757fd2a46e467a5709eaccb2c0a73ea76dbf53b156eb897c103964ab93f5018be88a40df7b3b8ad95d5ea1188857ce1c21a1adfd016a8a46c54cab7edcdf05a9dca7ee3ce6d797f6de8260a0d1a07c73a6e3f37ae9035d8335691298395e8da4df8ab20cb25ee409fb50e3404031035f4cbf9add91cbd96596e64ab577616aacf66a210e92843205e06509d5fbe06aa0e10e4ebc02bc9e1bf597f39f2c98393a7e79cc0f3641c6d053bc8f9b20f443283aa0e88047718360683baaf41f01fe50694b3167"

    invoke-direct {v1, v2, v4}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;I)V

    new-instance v2, Ljava/math/BigInteger;

    const-string/jumbo v3, "10001"

    invoke-direct {v2, v3, v4}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;I)V

    invoke-direct {v0, v1, v2}, Ljava/security/spec/RSAPublicKeySpec;-><init>(Ljava/math/BigInteger;Ljava/math/BigInteger;)V

    sput-object v0, Lcom/amazon/mShop/util/SecurityUtil;->PUBLIC_KEY_SPEC:Ljava/security/spec/RSAPublicKeySpec;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decryptHex(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "encryptedHex"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 29
    invoke-static {p0}, Lcom/amazon/mShop/util/SecurityUtil;->hexToBytes(Ljava/lang/String;)[B

    move-result-object v1

    .line 31
    .local v1, "encrypted":[B
    const-string/jumbo v5, "RSA"

    invoke-static {v5}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v2

    .line 32
    .local v2, "keyFactory":Ljava/security/KeyFactory;
    sget-object v5, Lcom/amazon/mShop/util/SecurityUtil;->PUBLIC_KEY_SPEC:Ljava/security/spec/RSAPublicKeySpec;

    invoke-virtual {v2, v5}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object v3

    .line 34
    .local v3, "publicKey":Ljava/security/PublicKey;
    const-string/jumbo v5, "RSA/ECB/PKCS1Padding"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v4

    .line 35
    .local v4, "rsaCipher":Ljavax/crypto/Cipher;
    const/4 v5, 0x2

    invoke-virtual {v4, v5, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 36
    invoke-virtual {v4, v1}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v0

    .line 37
    .local v0, "decrypted":[B
    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v0}, Ljava/lang/String;-><init>([B)V

    return-object v5
.end method

.method public static hexToBytes(Ljava/lang/String;)[B
    .locals 6
    .param p0, "hex"    # Ljava/lang/String;

    .prologue
    .line 48
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_2

    .line 49
    :cond_0
    const/4 v1, 0x0

    .line 67
    :cond_1
    return-object v1

    .line 53
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    and-int/lit8 v3, v3, 0x1

    const/4 v4, 0x1

    if-ne v3, v4, :cond_3

    .line 54
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Input should have an even number of characters, not odd: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 58
    :cond_3
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    shr-int/lit8 v3, v3, 0x1

    new-array v1, v3, [B

    .line 61
    .local v1, "byteArray":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 62
    add-int/lit8 v3, v2, 0x2

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x10

    invoke-static {v3, v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v0

    .line 64
    .local v0, "bits":I
    shr-int/lit8 v3, v2, 0x1

    and-int/lit16 v4, v0, 0xff

    int-to-byte v4, v4

    aput-byte v4, v1, v3

    .line 61
    add-int/lit8 v2, v2, 0x2

    goto :goto_0
.end method
