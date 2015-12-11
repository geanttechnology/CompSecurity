.class public Lorg/apache/commons/codec/digest/DigestUtils;
.super Ljava/lang/Object;
.source "DigestUtils.java"


# direct methods
.method private static getBytesUtf8(Ljava/lang/String;)[B
    .locals 1
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-static {p0}, Lorg/apache/commons/codec/binary/StringUtils;->getBytesUtf8(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method static getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;
    .locals 3
    .param p0, "algorithm"    # Ljava/lang/String;

    .prologue
    .line 87
    :try_start_0
    invoke-static {p0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 88
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static getShaDigest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 154
    const-string v0, "SHA"

    invoke-static {v0}, Lorg/apache/commons/codec/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method

.method public static sha(Ljava/lang/String;)[B
    .locals 1
    .param p0, "data"    # Ljava/lang/String;

    .prologue
    .line 262
    invoke-static {p0}, Lorg/apache/commons/codec/digest/DigestUtils;->getBytesUtf8(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/codec/digest/DigestUtils;->sha([B)[B

    move-result-object v0

    return-object v0
.end method

.method public static sha([B)[B
    .locals 1
    .param p0, "data"    # [B

    .prologue
    .line 237
    invoke-static {}, Lorg/apache/commons/codec/digest/DigestUtils;->getShaDigest()Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v0

    return-object v0
.end method
