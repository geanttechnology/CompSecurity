.class public Lcom/aio/downloader/utils/MD5;
.super Ljava/lang/Object;
.source "MD5.java"


# static fields
.field private static final HASH_ALGORITHM:Ljava/lang/String; = "MD5"

.field private static final RADIX:I = 0x24


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static enlode(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "imageUri"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/MD5;->getMD5([B)[B

    move-result-object v1

    .line 59
    .local v1, "md5":[B
    new-instance v2, Ljava/math/BigInteger;

    invoke-direct {v2, v1}, Ljava/math/BigInteger;-><init>([B)V

    invoke-virtual {v2}, Ljava/math/BigInteger;->abs()Ljava/math/BigInteger;

    move-result-object v0

    .line 60
    .local v0, "bi":Ljava/math/BigInteger;
    const/16 v2, 0x24

    invoke-virtual {v0, v2}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static getHashString(Ljava/security/MessageDigest;)Ljava/lang/String;
    .locals 6
    .param p0, "digest"    # Ljava/security/MessageDigest;

    .prologue
    .line 27
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 28
    .local v1, "builder":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v4, :cond_0

    .line 33
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 28
    :cond_0
    aget-byte v0, v3, v2

    .line 30
    .local v0, "b":B
    shr-int/lit8 v5, v0, 0x4

    and-int/lit8 v5, v5, 0xf

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 31
    and-int/lit8 v5, v0, 0xf

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 28
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static getMD5(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "content"    # Ljava/lang/String;

    .prologue
    .line 14
    :try_start_0
    const-string v2, "MD5"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 15
    .local v0, "digest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/security/MessageDigest;->update([B)V

    .line 16
    invoke-static {v0}, Lcom/aio/downloader/utils/MD5;->getHashString(Ljava/security/MessageDigest;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 22
    .end local v0    # "digest":Ljava/security/MessageDigest;
    :goto_0
    return-object v2

    .line 18
    :catch_0
    move-exception v1

    .line 20
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v1}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    .line 22
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private static getMD5([B)[B
    .locals 3
    .param p0, "data"    # [B

    .prologue
    .line 64
    const/4 v1, 0x0

    .line 66
    .local v1, "hash":[B
    :try_start_0
    const-string v2, "MD5"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 67
    .local v0, "digest":Ljava/security/MessageDigest;
    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 68
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 72
    .end local v0    # "digest":Ljava/security/MessageDigest;
    :goto_0
    return-object v1

    .line 69
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static getMd5Name(Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "imageUri"    # Ljava/lang/String;

    .prologue
    .line 38
    const-string v0, "MD5"

    .line 39
    .local v0, "HASH_ALGORITHM":Ljava/lang/String;
    const/16 v1, 0x24

    .line 40
    .local v1, "RADIX":I
    const/4 v5, 0x0

    .line 43
    .local v5, "hash":[B
    :try_start_0
    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    .line 44
    .local v3, "digest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/security/MessageDigest;->update([B)V

    .line 45
    invoke-virtual {v3}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v6

    .line 46
    .local v6, "md5":[B
    new-instance v7, Ljava/math/BigInteger;

    invoke-direct {v7, v6}, Ljava/math/BigInteger;-><init>([B)V

    invoke-virtual {v7}, Ljava/math/BigInteger;->abs()Ljava/math/BigInteger;

    move-result-object v2

    .line 47
    .local v2, "bi":Ljava/math/BigInteger;
    invoke-virtual {v2, v1}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 51
    .end local v2    # "bi":Ljava/math/BigInteger;
    .end local v3    # "digest":Ljava/security/MessageDigest;
    .end local v6    # "md5":[B
    :goto_0
    return-object v7

    .line 48
    :catch_0
    move-exception v4

    .line 49
    .local v4, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v4}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    .line 51
    const/4 v7, 0x0

    goto :goto_0
.end method
