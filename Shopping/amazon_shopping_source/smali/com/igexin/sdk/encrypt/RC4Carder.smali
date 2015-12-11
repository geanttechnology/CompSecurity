.class public Lcom/igexin/sdk/encrypt/RC4Carder;
.super Ljava/lang/Object;
.source "RC4Carder.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static Dencrypt([BLjava/lang/String;)[B
    .locals 1
    .param p0, "data"    # [B
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-static {p0, v0}, Lcom/igexin/sdk/encrypt/RC4Carder;->RC4([B[B)[B

    move-result-object v0

    return-object v0
.end method

.method public static Encrypt([BLjava/lang/String;)[B
    .locals 1
    .param p0, "data"    # [B
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-static {p0, v0}, Lcom/igexin/sdk/encrypt/RC4Carder;->RC4([B[B)[B

    move-result-object v0

    return-object v0
.end method

.method public static RC4([B[B)[B
    .locals 9
    .param p0, "data"    # [B
    .param p1, "key"    # [B

    .prologue
    .line 19
    invoke-static {p1}, Lcom/igexin/sdk/encrypt/RC4Carder;->isKeyValid([B)Z

    move-result v7

    if-nez v7, :cond_0

    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "key is fail!"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 20
    :cond_0
    array-length v7, p0

    const/4 v8, 0x1

    if-ge v7, v8, :cond_1

    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "data is fail!"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 22
    :cond_1
    const/16 v7, 0x100

    new-array v1, v7, [I

    .line 25
    .local v1, "S":[I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v7, v1

    if-ge v3, v7, :cond_2

    .line 26
    aput v3, v1, v3

    .line 25
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 27
    :cond_2
    const/4 v4, 0x0

    .line 28
    .local v4, "j":I
    const/4 v3, 0x0

    :goto_1
    array-length v7, v1

    if-ge v3, v7, :cond_3

    .line 29
    aget v7, v1, v3

    add-int/2addr v7, v4

    array-length v8, p1

    rem-int v8, v3, v8

    aget-byte v8, p1, v8

    and-int/lit16 v8, v8, 0xff

    add-int/2addr v7, v8

    rem-int/lit16 v4, v7, 0x100

    .line 30
    invoke-static {v1, v3, v4}, Lcom/igexin/sdk/encrypt/RC4Carder;->swap([III)V

    .line 28
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 34
    :cond_3
    const/4 v3, 0x0

    .line 35
    const/4 v4, 0x0

    .line 37
    array-length v7, p0

    new-array v2, v7, [B

    .line 39
    .local v2, "encodeData":[B
    const/4 v6, 0x0

    .local v6, "x":I
    :goto_2
    array-length v7, v2

    if-ge v6, v7, :cond_4

    .line 40
    add-int/lit8 v7, v3, 0x1

    rem-int/lit16 v3, v7, 0x100

    .line 41
    aget v7, v1, v3

    add-int/2addr v7, v4

    rem-int/lit16 v4, v7, 0x100

    .line 42
    invoke-static {v1, v3, v4}, Lcom/igexin/sdk/encrypt/RC4Carder;->swap([III)V

    .line 43
    aget v7, v1, v3

    aget v8, v1, v4

    add-int/2addr v7, v8

    rem-int/lit16 v7, v7, 0x100

    aget v5, v1, v7

    .line 44
    .local v5, "k":I
    move v0, v5

    .line 45
    .local v0, "K":I
    aget-byte v7, p0, v6

    xor-int/2addr v7, v0

    int-to-byte v7, v7

    aput-byte v7, v2, v6

    .line 39
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 47
    .end local v0    # "K":I
    .end local v5    # "k":I
    :cond_4
    return-object v2
.end method

.method public static isKeyValid([B)Z
    .locals 7
    .param p0, "key"    # [B

    .prologue
    const/4 v4, 0x0

    .line 50
    move-object v0, p0

    .line 51
    .local v0, "bKey":[B
    array-length v2, v0

    .line 52
    .local v2, "len":I
    const/4 v3, 0x0

    .line 53
    .local v3, "num":I
    if-lez v2, :cond_0

    const/16 v5, 0x100

    if-gt v2, v5, :cond_0

    .line 54
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_2

    .line 55
    aget-byte v5, v0, v1

    and-int/lit16 v5, v5, 0xff

    const/16 v6, 0xe

    if-ne v5, v6, :cond_1

    .line 56
    add-int/lit8 v3, v3, 0x1

    .line 57
    const/4 v5, 0x3

    if-le v3, v5, :cond_1

    .line 64
    .end local v1    # "i":I
    :cond_0
    :goto_1
    return v4

    .line 54
    .restart local v1    # "i":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 62
    :cond_2
    const/4 v4, 0x1

    goto :goto_1
.end method

.method public static swap([III)V
    .locals 2
    .param p0, "source"    # [I
    .param p1, "a"    # I
    .param p2, "b"    # I

    .prologue
    .line 67
    aget v0, p0, p1

    .line 68
    .local v0, "tmp":I
    aget v1, p0, p2

    aput v1, p0, p1

    .line 69
    aput v0, p0, p2

    .line 70
    return-void
.end method
