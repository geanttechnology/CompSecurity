.class public Lcom/amazon/sdk/availability/StagingStream;
.super Ljava/io/OutputStream;
.source "StagingStream.java"


# instance fields
.field private final fos:Ljava/io/FileOutputStream;

.field private final middleStream:Ljava/io/OutputStream;

.field private final publicKey:Ljava/lang/String;

.field private final publicKeySerial:J

.field private userMetadata:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final wrappedStream:Ljava/io/OutputStream;


# direct methods
.method public constructor <init>(Ljava/io/File;Ljava/lang/String;J)V
    .locals 3
    .param p1, "fileToWrite"    # Ljava/io/File;
    .param p2, "publicKey"    # Ljava/lang/String;
    .param p3, "publicKeySerial"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    .line 79
    iput-object p2, p0, Lcom/amazon/sdk/availability/StagingStream;->publicKey:Ljava/lang/String;

    .line 80
    iput-wide p3, p0, Lcom/amazon/sdk/availability/StagingStream;->publicKeySerial:J

    .line 82
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "fileToWrite is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 83
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    iput-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->fos:Ljava/io/FileOutputStream;

    .line 84
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 85
    iget-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->fos:Ljava/io/FileOutputStream;

    iput-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->middleStream:Ljava/io/OutputStream;

    .line 86
    const-string/jumbo v1, "middleStream is fos"

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 102
    :goto_0
    new-instance v1, Ljava/util/zip/GZIPOutputStream;

    iget-object v2, p0, Lcom/amazon/sdk/availability/StagingStream;->middleStream:Ljava/io/OutputStream;

    invoke-direct {v1, v2}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->wrappedStream:Ljava/io/OutputStream;

    .line 103
    return-void

    .line 89
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->fos:Ljava/io/FileOutputStream;

    invoke-virtual {p0, v1}, Lcom/amazon/sdk/availability/StagingStream;->createCryptoStream(Ljava/io/OutputStream;)Ljava/io/OutputStream;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->middleStream:Ljava/io/OutputStream;

    .line 90
    const-string/jumbo v1, "middleStream is cryptostream"

    invoke-static {v1}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/security/InvalidAlgorithmParameterException; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_0

    .line 91
    :catch_0
    move-exception v0

    .line 92
    .local v0, "ex":Ljava/security/NoSuchAlgorithmException;
    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "Initialization failure, no such algorithm"

    invoke-direct {v1, v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 93
    .end local v0    # "ex":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 94
    .local v0, "ex":Ljava/security/InvalidKeyException;
    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "Initialization failure, bad key"

    invoke-direct {v1, v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 95
    .end local v0    # "ex":Ljava/security/InvalidKeyException;
    :catch_2
    move-exception v0

    .line 96
    .local v0, "ex":Ljavax/crypto/NoSuchPaddingException;
    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "Initialization failure, no such padding"

    invoke-direct {v1, v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 97
    .end local v0    # "ex":Ljavax/crypto/NoSuchPaddingException;
    :catch_3
    move-exception v0

    .line 98
    .local v0, "ex":Ljava/security/InvalidAlgorithmParameterException;
    new-instance v1, Ljava/io/IOException;

    const-string/jumbo v2, "Initialization failure, invalid algorithm parameter"

    invoke-direct {v1, v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/sdk/availability/StagingStream;->wrappedStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 134
    return-void
.end method

.method protected createCryptoStream(Ljava/io/OutputStream;)Ljava/io/OutputStream;
    .locals 8
    .param p1, "os"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/InvalidKeyException;,
            Ljavax/crypto/NoSuchPaddingException;,
            Ljava/security/InvalidAlgorithmParameterException;
        }
    .end annotation

    .prologue
    .line 149
    const-string/jumbo v7, "AES/CBC/PKCS5Padding"

    invoke-static {v7}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    .line 150
    .local v1, "cipher":Ljavax/crypto/Cipher;
    const/16 v7, 0x20

    new-array v0, v7, [B

    .line 151
    .local v0, "aesKey":[B
    const/16 v7, 0x10

    new-array v3, v7, [B

    .line 152
    .local v3, "ivBytes":[B
    new-instance v6, Ljava/security/SecureRandom;

    invoke-direct {v6}, Ljava/security/SecureRandom;-><init>()V

    .line 153
    .local v6, "sr":Ljava/security/SecureRandom;
    invoke-virtual {v6, v0}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 154
    invoke-virtual {v6, v3}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 155
    new-instance v4, Ljavax/crypto/spec/SecretKeySpec;

    const-string/jumbo v7, "AES"

    invoke-direct {v4, v0, v7}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 156
    .local v4, "key":Ljavax/crypto/spec/SecretKeySpec;
    new-instance v2, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v2, v3}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 157
    .local v2, "iv":Ljavax/crypto/spec/IvParameterSpec;
    const/4 v7, 0x1

    invoke-virtual {v1, v7, v4, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 158
    new-instance v5, Ljavax/crypto/CipherOutputStream;

    invoke-direct {v5, p1, v1}, Ljavax/crypto/CipherOutputStream;-><init>(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V

    .line 160
    .local v5, "result":Ljava/io/OutputStream;
    invoke-virtual {p0, v0, v3}, Lcom/amazon/sdk/availability/StagingStream;->setupUserMetadata([B[B)V

    .line 162
    return-object v5
.end method

.method protected encrypt([B)[B
    .locals 7
    .param p1, "bytes"    # [B

    .prologue
    const/4 v4, 0x0

    .line 194
    :try_start_0
    const-string/jumbo v5, "RSA/ECB/PKCS1Padding"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 195
    .local v0, "cipher":Ljavax/crypto/Cipher;
    iget-object v5, p0, Lcom/amazon/sdk/availability/StagingStream;->publicKey:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v5, v6}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    .line 196
    .local v2, "keyBytes":[B
    const-string/jumbo v5, "RSA"

    invoke-static {v5}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v5

    new-instance v6, Ljava/security/spec/X509EncodedKeySpec;

    invoke-direct {v6, v2}, Ljava/security/spec/X509EncodedKeySpec;-><init>([B)V

    invoke-virtual {v5, v6}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object v3

    .line 197
    .local v3, "pk":Ljava/security/PublicKey;
    const/4 v5, 0x1

    invoke-virtual {v0, v5, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 198
    invoke-virtual {v0, p1}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_5

    move-result-object v4

    .line 211
    .end local v0    # "cipher":Ljavax/crypto/Cipher;
    .end local v2    # "keyBytes":[B
    .end local v3    # "pk":Ljava/security/PublicKey;
    :goto_0
    return-object v4

    .line 200
    :catch_0
    move-exception v1

    .line 201
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    goto :goto_0

    .line 202
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v1

    .line 203
    .local v1, "e":Ljava/security/spec/InvalidKeySpecException;
    goto :goto_0

    .line 204
    .end local v1    # "e":Ljava/security/spec/InvalidKeySpecException;
    :catch_2
    move-exception v1

    .line 205
    .local v1, "e":Ljava/security/InvalidKeyException;
    goto :goto_0

    .line 206
    .end local v1    # "e":Ljava/security/InvalidKeyException;
    :catch_3
    move-exception v1

    .line 207
    .local v1, "e":Ljavax/crypto/IllegalBlockSizeException;
    goto :goto_0

    .line 208
    .end local v1    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_4
    move-exception v1

    .line 209
    .local v1, "e":Ljavax/crypto/NoSuchPaddingException;
    goto :goto_0

    .line 210
    .end local v1    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_5
    move-exception v1

    .line 211
    .local v1, "e":Ljavax/crypto/BadPaddingException;
    goto :goto_0
.end method

.method public getUserMetadata()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/sdk/availability/StagingStream;->userMetadata:Ljava/util/Map;

    return-object v0
.end method

.method protected setupUserMetadata([B[B)V
    .locals 6
    .param p1, "aesKey"    # [B
    .param p2, "iv"    # [B

    .prologue
    const/4 v5, 0x2

    .line 173
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->userMetadata:Ljava/util/Map;

    .line 175
    iget-wide v1, p0, Lcom/amazon/sdk/availability/StagingStream;->publicKeySerial:J

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 176
    iget-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->userMetadata:Ljava/util/Map;

    const-string/jumbo v2, "publicKeySerial"

    iget-wide v3, p0, Lcom/amazon/sdk/availability/StagingStream;->publicKeySerial:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/sdk/availability/StagingStream;->encrypt([B)[B

    move-result-object v0

    .line 180
    .local v0, "encryptedAesKey":[B
    if-eqz v0, :cond_1

    .line 181
    iget-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->userMetadata:Ljava/util/Map;

    const-string/jumbo v2, "encryptedAesKey"

    invoke-static {v0, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    iget-object v1, p0, Lcom/amazon/sdk/availability/StagingStream;->userMetadata:Ljava/util/Map;

    const-string/jumbo v2, "aesIV"

    invoke-static {p2, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    :cond_1
    return-void
.end method

.method public write(I)V
    .locals 1
    .param p1, "byteToWrite"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    const-string/jumbo v0, "stagingStream write(byte)"

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 116
    iget-object v0, p0, Lcom/amazon/sdk/availability/StagingStream;->wrappedStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write(I)V

    .line 117
    return-void
.end method

.method public write([B)V
    .locals 2
    .param p1, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 121
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "stagingStream write(byte["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "])"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 122
    iget-object v0, p0, Lcom/amazon/sdk/availability/StagingStream;->wrappedStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    .line 123
    return-void
.end method

.method public write([BII)V
    .locals 2
    .param p1, "bytes"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 127
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "stagingStream write(byte["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "], "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 128
    iget-object v0, p0, Lcom/amazon/sdk/availability/StagingStream;->wrappedStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 129
    return-void
.end method
