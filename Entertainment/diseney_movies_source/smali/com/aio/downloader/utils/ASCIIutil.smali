.class public Lcom/aio/downloader/utils/ASCIIutil;
.super Ljava/lang/Object;
.source "ASCIIutil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ByteArrayToString([B)Ljava/lang/String;
    .locals 8
    .param p0, "bt_ary"    # [B

    .prologue
    const/4 v3, 0x0

    .line 53
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 54
    .local v1, "sb":Ljava/lang/StringBuilder;
    if-eqz p0, :cond_0

    .line 55
    array-length v4, p0

    move v2, v3

    :goto_0
    if-lt v2, v4, :cond_1

    .line 58
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 55
    :cond_1
    aget-byte v0, p0, v2

    .line 56
    .local v0, "b":B
    const-string v5, "%02X "

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v7

    aput-object v7, v6, v3

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 55
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static asciiToString(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 62
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 63
    .local v2, "sbu":Ljava/lang/StringBuffer;
    const-string v3, ","

    invoke-virtual {p0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "chars":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v0

    if-lt v1, v3, :cond_0

    .line 67
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 65
    :cond_0
    aget-object v3, v0, v1

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public static stringToAscii(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 71
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 72
    .local v2, "sbu":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 73
    .local v0, "chars":[C
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v0

    if-lt v1, v3, :cond_0

    .line 80
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 74
    :cond_0
    array-length v3, v0

    add-int/lit8 v3, v3, -0x1

    if-eq v1, v3, :cond_1

    .line 75
    aget-char v3, v0, v1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 73
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 77
    :cond_1
    aget-char v3, v0, v1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    goto :goto_1
.end method

.method public static toparse(Ljava/lang/String;)Ljava/lang/String;
    .locals 13
    .param p0, "recourse"    # Ljava/lang/String;

    .prologue
    const/16 v12, 0x30

    const/16 v11, 0x61

    const/16 v10, 0x41

    .line 11
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .line 12
    .local v0, "chars":[C
    const-string v2, ""

    .line 13
    .local v2, "finalstring":Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v8, v0

    if-lt v3, v8, :cond_0

    .line 37
    :try_start_0
    new-instance v7, Ljava/lang/String;

    invoke-static {v2}, Lcom/aio/downloader/utils/MyBase64;->decode(Ljava/lang/String;)[B

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/String;-><init>([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    .local v7, "res":Ljava/lang/String;
    move-object v2, v7

    .line 46
    .end local v7    # "res":Ljava/lang/String;
    :goto_1
    return-object v2

    .line 14
    :cond_0
    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    .line 16
    .local v4, "m":C
    move v5, v4

    .line 18
    .local v5, "n":I
    if-lt v5, v12, :cond_1

    const/16 v8, 0x39

    if-le v5, v8, :cond_3

    :cond_1
    if-lt v5, v10, :cond_2

    const/16 v8, 0x5a

    if-le v5, v8, :cond_3

    .line 19
    :cond_2
    if-lt v5, v11, :cond_7

    const/16 v8, 0x7a

    if-gt v5, v8, :cond_7

    .line 20
    :cond_3
    rem-int/lit8 v8, v3, 0xa

    sub-int v6, v5, v8

    .line 22
    .local v6, "n2":I
    if-ge v6, v12, :cond_5

    .line 23
    rsub-int/lit8 v8, v6, 0x30

    rsub-int/lit8 v8, v8, 0x7a

    add-int/lit8 v6, v8, 0x1

    .line 33
    :cond_4
    :goto_2
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/aio/downloader/utils/ASCIIutil;->asciiToString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 13
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 24
    :cond_5
    if-lt v5, v10, :cond_6

    if-ge v6, v10, :cond_6

    .line 25
    rsub-int/lit8 v8, v6, 0x41

    rsub-int/lit8 v8, v8, 0x39

    add-int/lit8 v6, v8, 0x1

    .line 26
    goto :goto_2

    :cond_6
    if-lt v5, v11, :cond_4

    if-ge v6, v11, :cond_4

    .line 27
    rsub-int/lit8 v8, v6, 0x61

    rsub-int/lit8 v8, v8, 0x5a

    add-int/lit8 v6, v8, 0x1

    .line 29
    goto :goto_2

    .line 30
    .end local v6    # "n2":I
    :cond_7
    move v6, v5

    .restart local v6    # "n2":I
    goto :goto_2

    .line 40
    .end local v4    # "m":C
    .end local v5    # "n":I
    .end local v6    # "n2":I
    :catch_0
    move-exception v1

    .line 42
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method
