.class public final Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;
.super Ljava/lang/Object;
.source "PIDGenerator.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method

.method public static getPid(Ljava/lang/String;)Ljava/lang/String;
    .locals 14
    .param p0, "serialNumber"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 33
    if-nez p0, :cond_0

    .line 79
    :goto_0
    return-object v9

    .line 41
    :cond_0
    :try_start_0
    const-string/jumbo v10, "UTF-8"

    invoke-virtual {p0, v10}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    .line 43
    .local v5, "dsnBytes":[B
    const-string/jumbo v10, "SHA-256"

    invoke-static {v10}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    .line 44
    .local v3, "digestGenerator":Ljava/security/MessageDigest;
    invoke-virtual {v3, v5}, Ljava/security/MessageDigest;->update([B)V

    .line 47
    invoke-virtual {v3}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 50
    .local v2, "digest":[B
    new-instance v4, Ljava/lang/StringBuilder;

    array-length v10, v2

    mul-int/lit8 v10, v10, 0x2

    invoke-direct {v4, v10}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 51
    .local v4, "digestInHex":Ljava/lang/StringBuilder;
    move-object v0, v2

    .local v0, "arr$":[B
    array-length v8, v2

    .local v8, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_1
    if-ge v7, v8, :cond_1

    aget-byte v1, v0, v7

    .line 53
    .local v1, "b":B
    const-string/jumbo v10, "%02X"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    and-int/lit16 v13, v1, 0xff

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 64
    .end local v1    # "b":B
    :cond_1
    const/16 v10, 0x17

    const/16 v11, 0x1f

    invoke-virtual {v4, v10, v11}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v9

    goto :goto_0

    .line 69
    .end local v0    # "arr$":[B
    .end local v2    # "digest":[B
    .end local v3    # "digestGenerator":Ljava/security/MessageDigest;
    .end local v4    # "digestInHex":Ljava/lang/StringBuilder;
    .end local v5    # "dsnBytes":[B
    .end local v7    # "i$":I
    .end local v8    # "len$":I
    :catch_0
    move-exception v6

    .line 71
    .local v6, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "SHA-256 algorithm does not exist.  PANICK!"

    invoke-static {v10, v11, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 73
    .end local v6    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v6

    .line 76
    .local v6, "e":Ljava/io/UnsupportedEncodingException;
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/PIDGenerator;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "Can\'t get PID: unsupported encoding"

    invoke-static {v10, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
