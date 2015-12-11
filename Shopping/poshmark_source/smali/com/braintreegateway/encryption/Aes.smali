.class public final Lcom/braintreegateway/encryption/Aes;
.super Ljava/lang/Object;
.source "Aes.java"


# static fields
.field private static final ALGORITHM:Ljava/lang/String; = "AES"

.field public static final IV_LENGTH:I = 0x10

.field public static final KEY_LENGTH:I = 0x20

.field private static final TRANSFORMATION:Ljava/lang/String; = "AES/CBC/PKCS5Padding"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static aesCipher()Ljavax/crypto/Cipher;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/braintreegateway/encryption/BraintreeEncryptionException;
        }
    .end annotation

    .prologue
    .line 47
    :try_start_0
    const-string v1, "AES/CBC/PKCS5Padding"

    invoke-static {v1}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 48
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v1, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "No Such Algorithm: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 50
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 51
    .local v0, "e":Ljavax/crypto/NoSuchPaddingException;
    new-instance v1, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "No Such Padding: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljavax/crypto/NoSuchPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static encrypt(Ljava/lang/String;[B[B)Ljava/lang/String;
    .locals 9
    .param p0, "data"    # Ljava/lang/String;
    .param p1, "aesKey"    # [B
    .param p2, "iv"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/braintreegateway/encryption/BraintreeEncryptionException;
        }
    .end annotation

    .prologue
    .line 24
    new-instance v5, Ljavax/crypto/spec/SecretKeySpec;

    const-string v6, "AES"

    invoke-direct {v5, p1, v6}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 25
    .local v5, "key":Ljavax/crypto/spec/SecretKeySpec;
    invoke-static {}, Lcom/braintreegateway/encryption/Aes;->aesCipher()Ljavax/crypto/Cipher;

    move-result-object v1

    .line 27
    .local v1, "cipher":Ljavax/crypto/Cipher;
    :try_start_0
    new-instance v4, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v4, p2}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 28
    .local v4, "ivParamSpec":Ljavax/crypto/spec/IvParameterSpec;
    const/4 v6, 0x1

    invoke-virtual {v1, v6, v5, v4}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 29
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {v1, v6}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v3

    .line 30
    .local v3, "encryptedBytes":[B
    new-instance v0, Lorg/apache/http/util/ByteArrayBuffer;

    array-length v6, v3

    array-length v7, p2

    add-int/2addr v6, v7

    invoke-direct {v0, v6}, Lorg/apache/http/util/ByteArrayBuffer;-><init>(I)V

    .line 31
    .local v0, "buffer":Lorg/apache/http/util/ByteArrayBuffer;
    const/4 v6, 0x0

    array-length v7, p2

    invoke-virtual {v0, p2, v6, v7}, Lorg/apache/http/util/ByteArrayBuffer;->append([BII)V

    .line 32
    const/4 v6, 0x0

    array-length v7, v3

    invoke-virtual {v0, v3, v6, v7}, Lorg/apache/http/util/ByteArrayBuffer;->append([BII)V

    .line 33
    new-instance v6, Ljava/lang/String;

    invoke-virtual {v0}, Lorg/apache/http/util/ByteArrayBuffer;->toByteArray()[B

    move-result-object v7

    invoke-static {v7}, Lcom/braintree/org/bouncycastle/util/encoders/Base64;->encode([B)[B

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/String;-><init>([B)V
    :try_end_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/security/InvalidAlgorithmParameterException; {:try_start_0 .. :try_end_0} :catch_3

    return-object v6

    .line 34
    .end local v0    # "buffer":Lorg/apache/http/util/ByteArrayBuffer;
    .end local v3    # "encryptedBytes":[B
    .end local v4    # "ivParamSpec":Ljavax/crypto/spec/IvParameterSpec;
    :catch_0
    move-exception v2

    .line 35
    .local v2, "e":Ljava/security/InvalidKeyException;
    new-instance v6, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Invalid Key: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljava/security/InvalidKeyException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 36
    .end local v2    # "e":Ljava/security/InvalidKeyException;
    :catch_1
    move-exception v2

    .line 37
    .local v2, "e":Ljavax/crypto/BadPaddingException;
    new-instance v6, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Bad Padding: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljavax/crypto/BadPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 38
    .end local v2    # "e":Ljavax/crypto/BadPaddingException;
    :catch_2
    move-exception v2

    .line 39
    .local v2, "e":Ljavax/crypto/IllegalBlockSizeException;
    new-instance v6, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Illegal Block Size: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljavax/crypto/IllegalBlockSizeException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 40
    .end local v2    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_3
    move-exception v2

    .line 41
    .local v2, "e":Ljava/security/InvalidAlgorithmParameterException;
    new-instance v6, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Invalid Algorithm: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljava/security/InvalidAlgorithmParameterException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v6
.end method
