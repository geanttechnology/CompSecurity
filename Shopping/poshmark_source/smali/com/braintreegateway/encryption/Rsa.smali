.class public final Lcom/braintreegateway/encryption/Rsa;
.super Ljava/lang/Object;
.source "Rsa.java"


# static fields
.field private static final ALGORITHM:Ljava/lang/String; = "RSA"

.field private static final TRANSFORMATION:Ljava/lang/String; = "RSA/ECB/PKCS1Padding"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static encrypt([BLjava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "data"    # [B
    .param p1, "publicKeyString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/braintreegateway/encryption/BraintreeEncryptionException;
        }
    .end annotation

    .prologue
    .line 28
    :try_start_0
    const-string v5, "RSA/ECB/PKCS1Padding"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v4

    .line 29
    .local v4, "rsa":Ljavax/crypto/Cipher;
    invoke-static {p1}, Lcom/braintreegateway/encryption/Rsa;->publicKey(Ljava/lang/String;)Ljava/security/PublicKey;

    move-result-object v3

    .line 30
    .local v3, "publicKey":Ljava/security/PublicKey;
    const/4 v5, 0x1

    invoke-virtual {v4, v5, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 31
    invoke-static {p0}, Lcom/braintree/org/bouncycastle/util/encoders/Base64;->encode([B)[B

    move-result-object v1

    .line 32
    .local v1, "encodedData":[B
    invoke-virtual {v4, v1}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v2

    .line 33
    .local v2, "encryptedData":[B
    new-instance v5, Ljava/lang/String;

    invoke-static {v2}, Lcom/braintree/org/bouncycastle/util/encoders/Base64;->encode([B)[B

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/String;-><init>([B)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_4

    return-object v5

    .line 34
    .end local v1    # "encodedData":[B
    .end local v2    # "encryptedData":[B
    .end local v3    # "publicKey":Ljava/security/PublicKey;
    .end local v4    # "rsa":Ljavax/crypto/Cipher;
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v5, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "No Such Algorithm: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 36
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 37
    .local v0, "e":Ljavax/crypto/NoSuchPaddingException;
    new-instance v5, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "No Such Padding: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljavax/crypto/NoSuchPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 38
    .end local v0    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    move-exception v0

    .line 39
    .local v0, "e":Ljava/security/InvalidKeyException;
    new-instance v5, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid Key: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/security/InvalidKeyException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 40
    .end local v0    # "e":Ljava/security/InvalidKeyException;
    :catch_3
    move-exception v0

    .line 41
    .local v0, "e":Ljavax/crypto/IllegalBlockSizeException;
    new-instance v5, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Illegal Block Size: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljavax/crypto/IllegalBlockSizeException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 42
    .end local v0    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_4
    move-exception v0

    .line 43
    .local v0, "e":Ljavax/crypto/BadPaddingException;
    new-instance v5, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Bad Padding: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljavax/crypto/BadPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v5
.end method

.method private static publicKey(Ljava/lang/String;)Ljava/security/PublicKey;
    .locals 11
    .param p0, "publicKeyString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/braintreegateway/encryption/BraintreeEncryptionException;
        }
    .end annotation

    .prologue
    .line 48
    const/4 v2, 0x0

    .line 50
    .local v2, "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :try_start_0
    invoke-static {p0}, Lcom/braintree/org/bouncycastle/util/encoders/Base64;->decode(Ljava/lang/String;)[B

    move-result-object v0

    .line 51
    .local v0, "decodedPublicKey":[B
    new-instance v3, Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;

    invoke-direct {v3, v0}, Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 52
    .end local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .local v3, "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :try_start_1
    invoke-virtual {v3}, Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;->readObject()Lcom/braintree/org/bouncycastle/asn1/DERObject;

    move-result-object v7

    .line 53
    .local v7, "obj":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    invoke-static {v7}, Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;->getInstance(Ljava/lang/Object;)Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;

    move-result-object v6

    .line 54
    .local v6, "keyStruct":Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;
    new-instance v5, Ljava/security/spec/RSAPublicKeySpec;

    invoke-virtual {v6}, Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;->getModulus()Ljava/math/BigInteger;

    move-result-object v8

    invoke-virtual {v6}, Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;->getPublicExponent()Ljava/math/BigInteger;

    move-result-object v9

    invoke-direct {v5, v8, v9}, Ljava/security/spec/RSAPublicKeySpec;-><init>(Ljava/math/BigInteger;Ljava/math/BigInteger;)V

    .line 55
    .local v5, "keySpec":Ljava/security/spec/RSAPublicKeySpec;
    const-string v8, "RSA"

    invoke-static {v8}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v4

    .line 56
    .local v4, "keyFactory":Ljava/security/KeyFactory;
    invoke-virtual {v4, v5}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    :try_end_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_1 .. :try_end_1} :catch_6
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_5
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v8

    .line 65
    :try_start_2
    invoke-virtual {v3}, Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 67
    return-object v8

    .line 66
    :catch_0
    move-exception v1

    .line 67
    .local v1, "e":Ljava/io/IOException;
    new-instance v8, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "IO Exception: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 57
    .end local v0    # "decodedPublicKey":[B
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .end local v4    # "keyFactory":Ljava/security/KeyFactory;
    .end local v5    # "keySpec":Ljava/security/spec/RSAPublicKeySpec;
    .end local v6    # "keyStruct":Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;
    .end local v7    # "obj":Lcom/braintree/org/bouncycastle/asn1/DERObject;
    .restart local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :catch_1
    move-exception v1

    .line 58
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    :goto_0
    :try_start_3
    new-instance v8, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "No Such Algorithm: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 64
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catchall_0
    move-exception v8

    .line 65
    :goto_1
    :try_start_4
    invoke-virtual {v2}, Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_4

    .line 67
    throw v8

    .line 59
    :catch_2
    move-exception v1

    .line 60
    .local v1, "e":Ljava/security/spec/InvalidKeySpecException;
    :goto_2
    :try_start_5
    new-instance v8, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Invalid Key Spec: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/security/spec/InvalidKeySpecException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 61
    .end local v1    # "e":Ljava/security/spec/InvalidKeySpecException;
    :catch_3
    move-exception v1

    .line 62
    .local v1, "e":Ljava/io/IOException;
    :goto_3
    new-instance v8, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "IO Exception: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 66
    .end local v1    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v1

    .line 67
    .restart local v1    # "e":Ljava/io/IOException;
    new-instance v8, Lcom/braintreegateway/encryption/BraintreeEncryptionException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "IO Exception: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/braintreegateway/encryption/BraintreeEncryptionException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 64
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v0    # "decodedPublicKey":[B
    .restart local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :catchall_1
    move-exception v8

    move-object v2, v3

    .end local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    goto :goto_1

    .line 61
    .end local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :catch_5
    move-exception v1

    move-object v2, v3

    .end local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    goto :goto_3

    .line 59
    .end local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :catch_6
    move-exception v1

    move-object v2, v3

    .end local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    goto :goto_2

    .line 57
    .end local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    :catch_7
    move-exception v1

    move-object v2, v3

    .end local v3    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    .restart local v2    # "in":Lcom/braintree/org/bouncycastle/asn1/ASN1InputStream;
    goto/16 :goto_0
.end method
