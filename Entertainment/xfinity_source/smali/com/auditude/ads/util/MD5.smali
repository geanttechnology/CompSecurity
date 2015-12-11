.class public Lcom/auditude/ads/util/MD5;
.super Ljava/lang/Object;
.source "MD5.java"


# static fields
.field private static md:Ljava/security/MessageDigest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x0

    sput-object v0, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;

    return-void
.end method

.method public static GetMd5String(Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 16
    sget-object v6, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;

    if-nez v6, :cond_0

    .line 20
    :try_start_0
    const-string v6, "MD5"

    invoke-static {v6}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v6

    sput-object v6, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 28
    :cond_0
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 51
    :goto_0
    return-object v5

    .line 22
    :catch_0
    move-exception v1

    .line 24
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    goto :goto_0

    .line 32
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :cond_1
    :try_start_1
    const-string v5, "UTF-8"

    invoke-virtual {p0, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 33
    .local v0, "defaultBytes":[B
    sget-object v5, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;

    invoke-virtual {v5}, Ljava/security/MessageDigest;->reset()V

    .line 34
    sget-object v5, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;

    invoke-virtual {v5, v0}, Ljava/security/MessageDigest;->update([B)V

    .line 36
    sget-object v5, Lcom/auditude/ads/util/MD5;->md:Ljava/security/MessageDigest;

    invoke-virtual {v5}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    .line 38
    .local v3, "messageDigest":[B
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    .line 39
    .local v4, "sb":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v5, v3

    if-lt v2, v5, :cond_2

    .line 44
    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 41
    :cond_2
    aget-byte v5, v3, v2

    and-int/lit16 v5, v5, 0xff

    or-int/lit16 v5, v5, 0x100

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x3

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    .line 39
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 46
    .end local v0    # "defaultBytes":[B
    .end local v2    # "i":I
    .end local v3    # "messageDigest":[B
    .end local v4    # "sb":Ljava/lang/StringBuffer;
    :catch_1
    move-exception v5

    .line 51
    const-string v5, ""

    goto :goto_0
.end method
