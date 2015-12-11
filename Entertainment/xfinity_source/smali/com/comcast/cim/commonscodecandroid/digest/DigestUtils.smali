.class public Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;
.super Ljava/lang/Object;
.source "DigestUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
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

.method private static getMd5Digest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 101
    const-string v0, "MD5"

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method

.method private static getSha256Digest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 115
    const-string v0, "SHA-256"

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method

.method private static getSha384Digest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 129
    const-string v0, "SHA-384"

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method

.method private static getSha512Digest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 143
    const-string v0, "SHA-512"

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method

.method private static getShaDigest()Ljava/security/MessageDigest;
    .locals 1

    .prologue
    .line 154
    const-string v0, "SHA"

    invoke-static {v0}, Lcom/comcast/cim/commonscodecandroid/digest/DigestUtils;->getDigest(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    return-object v0
.end method
