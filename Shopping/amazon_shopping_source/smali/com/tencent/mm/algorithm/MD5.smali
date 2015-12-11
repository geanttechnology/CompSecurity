.class public final Lcom/tencent/mm/algorithm/MD5;
.super Ljava/lang/Object;
.source "MD5.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method public static final getMessageDigest([B)Ljava/lang/String;
    .locals 11
    .param p0, "buffer"    # [B

    .prologue
    .line 29
    const/16 v10, 0x10

    new-array v2, v10, [C

    fill-array-data v2, :array_0

    .line 31
    .local v2, "hexDigits":[C
    :try_start_0
    const-string/jumbo v10, "MD5"

    invoke-static {v10}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v8

    .line 32
    .local v8, "mdTemp":Ljava/security/MessageDigest;
    invoke-virtual {v8, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 33
    invoke-virtual {v8}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v7

    .line 34
    .local v7, "md":[B
    array-length v4, v7

    .line 35
    .local v4, "j":I
    mul-int/lit8 v10, v4, 0x2

    new-array v9, v10, [C

    .line 36
    .local v9, "str":[C
    const/4 v5, 0x0

    .line 37
    .local v5, "k":I
    const/4 v3, 0x0

    .local v3, "i":I
    move v6, v5

    .end local v5    # "k":I
    .local v6, "k":I
    :goto_0
    if-ge v3, v4, :cond_0

    .line 38
    aget-byte v0, v7, v3

    .line 39
    .local v0, "byte0":B
    add-int/lit8 v5, v6, 0x1

    .end local v6    # "k":I
    .restart local v5    # "k":I
    ushr-int/lit8 v10, v0, 0x4

    and-int/lit8 v10, v10, 0xf

    aget-char v10, v2, v10

    aput-char v10, v9, v6

    .line 40
    add-int/lit8 v6, v5, 0x1

    .end local v5    # "k":I
    .restart local v6    # "k":I
    and-int/lit8 v10, v0, 0xf

    aget-char v10, v2, v10

    aput-char v10, v9, v5

    .line 37
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 42
    .end local v0    # "byte0":B
    :cond_0
    new-instance v10, Ljava/lang/String;

    invoke-direct {v10, v9}, Ljava/lang/String;-><init>([C)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    .end local v3    # "i":I
    .end local v4    # "j":I
    .end local v6    # "k":I
    .end local v7    # "md":[B
    .end local v8    # "mdTemp":Ljava/security/MessageDigest;
    .end local v9    # "str":[C
    :goto_1
    return-object v10

    .line 43
    :catch_0
    move-exception v1

    .line 44
    .local v1, "e":Ljava/lang/Exception;
    const/4 v10, 0x0

    goto :goto_1

    .line 29
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
