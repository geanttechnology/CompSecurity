.class public final Lcom/squareup/okhttp/internal/okio/ByteString;
.super Ljava/lang/Object;
.source "ByteString.java"


# static fields
.field public static final EMPTY:Lcom/squareup/okhttp/internal/okio/ByteString;

.field private static final HEX_DIGITS:[C


# instance fields
.field final data:[B

.field private transient hashCode:I

.field private transient utf8:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const/16 v0, 0x10

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/squareup/okhttp/internal/okio/ByteString;->HEX_DIGITS:[C

    .line 43
    const/4 v0, 0x0

    new-array v0, v0, [B

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/ByteString;->of([B)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v0

    sput-object v0, Lcom/squareup/okhttp/internal/okio/ByteString;->EMPTY:Lcom/squareup/okhttp/internal/okio/ByteString;

    return-void

    .line 39
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

.method constructor <init>([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    .line 51
    return-void
.end method

.method public static varargs concat([Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 10
    .param p0, "byteStrings"    # [Lcom/squareup/okhttp/internal/okio/ByteString;

    .prologue
    .line 189
    const/4 v6, 0x0

    .line 190
    .local v6, "size":I
    move-object v0, p0

    .local v0, "arr$":[Lcom/squareup/okhttp/internal/okio/ByteString;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 191
    .local v1, "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->size()I

    move-result v7

    add-int/2addr v6, v7

    .line 190
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 193
    .end local v1    # "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    :cond_0
    new-array v5, v6, [B

    .line 194
    .local v5, "result":[B
    const/4 v4, 0x0

    .line 195
    .local v4, "pos":I
    move-object v0, p0

    array-length v3, v0

    const/4 v2, 0x0

    :goto_1
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 196
    .restart local v1    # "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    iget-object v7, v1, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    const/4 v8, 0x0

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->size()I

    move-result v9

    invoke-static {v7, v8, v5, v4, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 197
    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/okio/ByteString;->size()I

    move-result v7

    add-int/2addr v4, v7

    .line 195
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 199
    .end local v1    # "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    :cond_1
    new-instance v7, Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v7, v5}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    return-object v7
.end method

.method public static decodeBase64(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 2
    .param p0, "base64"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-static {p0}, Lcom/squareup/okhttp/internal/okio/Base64;->decode(Ljava/lang/String;)[B

    move-result-object v0

    .line 97
    .local v0, "decoded":[B
    if-eqz v0, :cond_0

    new-instance v1, Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v1, v0}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static decodeHex(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 7
    .param p0, "hex"    # Ljava/lang/String;

    .prologue
    .line 113
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    rem-int/lit8 v4, v4, 0x2

    if-eqz v4, :cond_0

    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Unexpected hex string: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 115
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    new-array v3, v4, [B

    .line 116
    .local v3, "result":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, v3

    if-ge v2, v4, :cond_1

    .line 117
    mul-int/lit8 v4, v2, 0x2

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Lcom/squareup/okhttp/internal/okio/ByteString;->decodeHexDigit(C)I

    move-result v4

    shl-int/lit8 v0, v4, 0x4

    .line 118
    .local v0, "d1":I
    mul-int/lit8 v4, v2, 0x2

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Lcom/squareup/okhttp/internal/okio/ByteString;->decodeHexDigit(C)I

    move-result v1

    .line 119
    .local v1, "d2":I
    add-int v4, v0, v1

    int-to-byte v4, v4

    aput-byte v4, v3, v2

    .line 116
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 121
    .end local v0    # "d1":I
    .end local v1    # "d2":I
    :cond_1
    invoke-static {v3}, Lcom/squareup/okhttp/internal/okio/ByteString;->of([B)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v4

    return-object v4
.end method

.method private static decodeHexDigit(C)I
    .locals 3
    .param p0, "c"    # C

    .prologue
    .line 125
    const/16 v0, 0x30

    if-lt p0, v0, :cond_0

    const/16 v0, 0x39

    if-gt p0, v0, :cond_0

    add-int/lit8 v0, p0, -0x30

    .line 127
    :goto_0
    return v0

    .line 126
    :cond_0
    const/16 v0, 0x61

    if-lt p0, v0, :cond_1

    const/16 v0, 0x66

    if-gt p0, v0, :cond_1

    add-int/lit8 v0, p0, -0x61

    add-int/lit8 v0, v0, 0xa

    goto :goto_0

    .line 127
    :cond_1
    const/16 v0, 0x41

    if-lt p0, v0, :cond_2

    const/16 v0, 0x46

    if-gt p0, v0, :cond_2

    add-int/lit8 v0, p0, -0x41

    add-int/lit8 v0, v0, 0xa

    goto :goto_0

    .line 128
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected hex digit: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static encodeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 63
    :try_start_0
    new-instance v0, Lcom/squareup/okhttp/internal/okio/ByteString;

    const-string/jumbo v2, "UTF-8"

    invoke-virtual {p0, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    .line 64
    .local v0, "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    iput-object p0, v0, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8:Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    return-object v0

    .line 66
    .end local v0    # "byteString":Lcom/squareup/okhttp/internal/okio/ByteString;
    :catch_0
    move-exception v1

    .line 67
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2
.end method

.method public static varargs of([B)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 2
    .param p0, "data"    # [B

    .prologue
    .line 57
    new-instance v1, Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-virtual {p0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    invoke-direct {v1, v0}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    return-object v1
.end method

.method public static read(Ljava/io/InputStream;I)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 4
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "byteCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 155
    new-array v2, p1, [B

    .line 156
    .local v2, "result":[B
    const/4 v0, 0x0

    .local v0, "offset":I
    :goto_0
    if-ge v0, p1, :cond_1

    .line 157
    sub-int v3, p1, v0

    invoke-virtual {p0, v2, v0, v3}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 158
    .local v1, "read":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    new-instance v3, Ljava/io/EOFException;

    invoke-direct {v3}, Ljava/io/EOFException;-><init>()V

    throw v3

    .line 156
    :cond_0
    add-int/2addr v0, v1

    goto :goto_0

    .line 160
    .end local v1    # "read":I
    :cond_1
    new-instance v3, Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {v3, v2}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    return-object v3
.end method


# virtual methods
.method public base64()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Base64;->encode([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 222
    if-eq p1, p0, :cond_0

    instance-of v0, p1, Lcom/squareup/okhttp/internal/okio/ByteString;

    if-eqz v0, :cond_1

    check-cast p1, Lcom/squareup/okhttp/internal/okio/ByteString;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v0, p1, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-static {v0, v1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public equalsAscii(Ljava/lang/String;)Z
    .locals 5
    .param p1, "ascii"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 136
    if-eqz p1, :cond_0

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v3, v3

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    if-eq v3, v4, :cond_2

    :cond_0
    move v1, v2

    .line 145
    :cond_1
    :goto_0
    return v1

    .line 139
    :cond_2
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8:Ljava/lang/String;

    if-eq p1, v3, :cond_1

    .line 142
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v3, v3

    if-ge v0, v3, :cond_1

    .line 143
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    aget-byte v3, v3, v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v3, v4, :cond_3

    move v1, v2

    goto :goto_0

    .line 142
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 226
    iget v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->hashCode:I

    .line 227
    .local v0, "result":I
    if-eqz v0, :cond_0

    .end local v0    # "result":I
    :goto_0
    return v0

    .restart local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v0

    .end local v0    # "result":I
    iput v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->hashCode:I

    goto :goto_0
.end method

.method public hex()Ljava/lang/String;
    .locals 9

    .prologue
    .line 102
    iget-object v7, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v7, v7

    mul-int/lit8 v7, v7, 0x2

    new-array v6, v7, [C

    .line 103
    .local v6, "result":[C
    const/4 v2, 0x0

    .line 104
    .local v2, "c":I
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    .local v0, "arr$":[B
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    move v3, v2

    .end local v2    # "c":I
    .local v3, "c":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-byte v1, v0, v4

    .line 105
    .local v1, "b":B
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "c":I
    .restart local v2    # "c":I
    sget-object v7, Lcom/squareup/okhttp/internal/okio/ByteString;->HEX_DIGITS:[C

    shr-int/lit8 v8, v1, 0x4

    and-int/lit8 v8, v8, 0xf

    aget-char v7, v7, v8

    aput-char v7, v6, v3

    .line 106
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "c":I
    .restart local v3    # "c":I
    sget-object v7, Lcom/squareup/okhttp/internal/okio/ByteString;->HEX_DIGITS:[C

    and-int/lit8 v8, v1, 0xf

    aget-char v7, v7, v8

    aput-char v7, v6, v2

    .line 104
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 108
    .end local v1    # "b":B
    :cond_0
    new-instance v7, Ljava/lang/String;

    invoke-direct {v7, v6}, Ljava/lang/String;-><init>([C)V

    return-object v7
.end method

.method public size()I
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v0, v0

    return v0
.end method

.method public toAsciiLowercase()Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 7

    .prologue
    const/16 v6, 0x5a

    const/16 v5, 0x41

    .line 170
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v4, v4

    if-ge v1, v4, :cond_5

    .line 171
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    aget-byte v0, v4, v1

    .line 172
    .local v0, "c":B
    if-lt v0, v5, :cond_0

    if-le v0, v6, :cond_1

    .line 170
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 176
    :cond_1
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-virtual {v4}, [B->clone()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 177
    .local v3, "lowercase":[B
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    add-int/lit8 v4, v0, 0x20

    int-to-byte v4, v4

    aput-byte v4, v3, v1

    move v1, v2

    .line 178
    .end local v2    # "i":I
    .restart local v1    # "i":I
    :goto_1
    array-length v4, v3

    if-ge v1, v4, :cond_4

    .line 179
    aget-byte v0, v3, v1

    .line 180
    if-lt v0, v5, :cond_2

    if-le v0, v6, :cond_3

    .line 178
    :cond_2
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 181
    :cond_3
    add-int/lit8 v4, v0, 0x20

    int-to-byte v4, v4

    aput-byte v4, v3, v1

    goto :goto_2

    .line 183
    :cond_4
    new-instance p0, Lcom/squareup/okhttp/internal/okio/ByteString;

    .end local p0    # "this":Lcom/squareup/okhttp/internal/okio/ByteString;
    invoke-direct {p0, v3}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    .line 185
    .end local v0    # "c":B
    .end local v3    # "lowercase":[B
    :cond_5
    return-object p0
.end method

.method public toByteArray()[B
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 231
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v1, v1

    if-nez v1, :cond_0

    .line 232
    const-string/jumbo v1, "ByteString[size=0]"

    .line 240
    :goto_0
    return-object v1

    .line 235
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v1, v1

    const/16 v2, 0x10

    if-gt v1, v2, :cond_1

    .line 236
    const-string/jumbo v1, "ByteString[size=%s data=%s]"

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v3, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/ByteString;->hex()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 240
    :cond_1
    :try_start_0
    const-string/jumbo v1, "ByteString[size=%s md5=%s]"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v4, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string/jumbo v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v4

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-virtual {v4, v5}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v4

    invoke-static {v4}, Lcom/squareup/okhttp/internal/okio/ByteString;->of([B)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v4

    invoke-virtual {v4}, Lcom/squareup/okhttp/internal/okio/ByteString;->hex()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 242
    :catch_0
    move-exception v0

    .line 243
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1
.end method

.method public utf8()Ljava/lang/String;
    .locals 4

    .prologue
    .line 73
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8:Ljava/lang/String;

    .line 76
    .local v1, "result":Ljava/lang/String;
    if-eqz v1, :cond_0

    .end local v1    # "result":Ljava/lang/String;
    :goto_0
    return-object v1

    .restart local v1    # "result":Ljava/lang/String;
    :cond_0
    :try_start_0
    new-instance v1, Ljava/lang/String;

    .end local v1    # "result":Ljava/lang/String;
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    const-string/jumbo v3, "UTF-8"

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    iput-object v1, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->utf8:Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 77
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2
.end method

.method public write(Ljava/io/OutputStream;)V
    .locals 1
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 218
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    invoke-virtual {p1, v0}, Ljava/io/OutputStream;->write([B)V

    .line 219
    return-void
.end method
