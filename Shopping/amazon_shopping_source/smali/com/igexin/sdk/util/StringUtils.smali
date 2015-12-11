.class public Lcom/igexin/sdk/util/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getMD5Str(Ljava/lang/String;)Ljava/lang/String;
    .locals 13
    .param p0, "sourceStr"    # Ljava/lang/String;

    .prologue
    const/16 v12, 0x10

    .line 28
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v8

    .line 29
    .local v8, "source":[B
    const/4 v7, 0x0

    .line 30
    .local v7, "s":Ljava/lang/String;
    new-array v2, v12, [C

    fill-array-data v2, :array_0

    .line 48
    .local v2, "hexDigits":[C
    const/4 v6, 0x0

    .line 51
    .local v6, "md":Ljava/security/MessageDigest;
    :try_start_0
    const-string/jumbo v11, "MD5"

    invoke-static {v11}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 58
    :goto_0
    if-nez v6, :cond_0

    const/4 v11, 0x0

    .line 72
    :goto_1
    return-object v11

    .line 53
    :catch_0
    move-exception v1

    .line 56
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v1}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_0

    .line 59
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :cond_0
    invoke-virtual {v6, v8}, Ljava/security/MessageDigest;->update([B)V

    .line 60
    invoke-virtual {v6}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v10

    .line 62
    .local v10, "tmp":[B
    const/16 v11, 0x20

    new-array v9, v11, [C

    .line 63
    .local v9, "str":[C
    const/4 v4, 0x0

    .line 64
    .local v4, "k":I
    const/4 v3, 0x0

    .local v3, "i":I
    move v5, v4

    .end local v4    # "k":I
    .local v5, "k":I
    :goto_2
    if-ge v3, v12, :cond_1

    .line 67
    aget-byte v0, v10, v3

    .line 68
    .local v0, "byte0":B
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "k":I
    .restart local v4    # "k":I
    ushr-int/lit8 v11, v0, 0x4

    and-int/lit8 v11, v11, 0xf

    aget-char v11, v2, v11

    aput-char v11, v9, v5

    .line 69
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "k":I
    .restart local v5    # "k":I
    and-int/lit8 v11, v0, 0xf

    aget-char v11, v2, v11

    aput-char v11, v9, v4

    .line 64
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 71
    .end local v0    # "byte0":B
    :cond_1
    new-instance v7, Ljava/lang/String;

    .end local v7    # "s":Ljava/lang/String;
    invoke-direct {v7, v9}, Ljava/lang/String;-><init>([C)V

    .restart local v7    # "s":Ljava/lang/String;
    move-object v11, v7

    .line 72
    goto :goto_1

    .line 30
    nop

    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method
