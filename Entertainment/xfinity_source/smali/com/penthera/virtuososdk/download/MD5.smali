.class Lcom/penthera/virtuososdk/download/MD5;
.super Ljava/lang/Object;
.source "MD5.java"


# static fields
.field private static final padding:[B


# instance fields
.field private decodeBuffer:[I

.field private finalState:Lcom/penthera/virtuososdk/download/MD5State;

.field private workingState:Lcom/penthera/virtuososdk/download/MD5State;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 27
    const/16 v0, 0x40

    new-array v0, v0, [B

    const/4 v1, 0x0

    .line 28
    const/16 v2, -0x80

    aput-byte v2, v0, v1

    .line 27
    sput-object v0, Lcom/penthera/virtuososdk/download/MD5;->padding:[B

    .line 4
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Lcom/penthera/virtuososdk/download/MD5State;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/MD5State;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    .line 16
    new-instance v0, Lcom/penthera/virtuososdk/download/MD5State;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/MD5State;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    .line 21
    const/16 v0, 0x10

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->decodeBuffer:[I

    .line 39
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/MD5;->reset()V

    .line 40
    return-void
.end method

.method private static FF(IIIIIII)I
    .locals 2
    .param p0, "a"    # I
    .param p1, "b"    # I
    .param p2, "c"    # I
    .param p3, "d"    # I
    .param p4, "x"    # I
    .param p5, "s"    # I
    .param p6, "ac"    # I

    .prologue
    .line 205
    and-int v0, p1, p2

    xor-int/lit8 v1, p1, -0x1

    and-int/2addr v1, p3

    or-int/2addr v0, v1

    add-int/2addr p0, v0

    .line 206
    add-int/2addr p0, p4

    .line 207
    add-int/2addr p0, p6

    .line 209
    shl-int v0, p0, p5

    rsub-int/lit8 v1, p5, 0x20

    ushr-int v1, p0, v1

    or-int p0, v0, v1

    .line 210
    add-int v0, p0, p1

    return v0
.end method

.method private static GG(IIIIIII)I
    .locals 2
    .param p0, "a"    # I
    .param p1, "b"    # I
    .param p2, "c"    # I
    .param p3, "d"    # I
    .param p4, "x"    # I
    .param p5, "s"    # I
    .param p6, "ac"    # I

    .prologue
    .line 214
    and-int v0, p1, p3

    xor-int/lit8 v1, p3, -0x1

    and-int/2addr v1, p2

    or-int/2addr v0, v1

    add-int/2addr p0, v0

    .line 215
    add-int/2addr p0, p4

    .line 216
    add-int/2addr p0, p6

    .line 218
    shl-int v0, p0, p5

    rsub-int/lit8 v1, p5, 0x20

    ushr-int v1, p0, v1

    or-int p0, v0, v1

    .line 219
    add-int v0, p0, p1

    return v0
.end method

.method private static HH(IIIIIII)I
    .locals 2
    .param p0, "a"    # I
    .param p1, "b"    # I
    .param p2, "c"    # I
    .param p3, "d"    # I
    .param p4, "x"    # I
    .param p5, "s"    # I
    .param p6, "ac"    # I

    .prologue
    .line 223
    xor-int v0, p1, p2

    xor-int/2addr v0, p3

    add-int/2addr p0, v0

    .line 224
    add-int/2addr p0, p4

    .line 225
    add-int/2addr p0, p6

    .line 227
    shl-int v0, p0, p5

    rsub-int/lit8 v1, p5, 0x20

    ushr-int v1, p0, v1

    or-int p0, v0, v1

    .line 228
    add-int v0, p0, p1

    return v0
.end method

.method private static II(IIIIIII)I
    .locals 2
    .param p0, "a"    # I
    .param p1, "b"    # I
    .param p2, "c"    # I
    .param p3, "d"    # I
    .param p4, "x"    # I
    .param p5, "s"    # I
    .param p6, "ac"    # I

    .prologue
    .line 232
    xor-int/lit8 v0, p3, -0x1

    or-int/2addr v0, p1

    xor-int/2addr v0, p2

    add-int/2addr p0, v0

    .line 233
    add-int/2addr p0, p4

    .line 234
    add-int/2addr p0, p6

    .line 236
    shl-int v0, p0, p5

    rsub-int/lit8 v1, p5, 0x20

    ushr-int v1, p0, v1

    or-int p0, v0, v1

    .line 237
    add-int v0, p0, p1

    return v0
.end method

.method private decode([BII)[I
    .locals 5
    .param p1, "buffer"    # [B
    .param p2, "len"    # I
    .param p3, "offset"    # I

    .prologue
    .line 267
    const/4 v1, 0x0

    .local v1, "j":I
    move v0, v1

    .local v0, "i":I
    :goto_0
    if-lt v1, p2, :cond_0

    .line 275
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/MD5;->decodeBuffer:[I

    return-object v2

    .line 268
    :cond_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/MD5;->decodeBuffer:[I

    .line 269
    add-int v3, v1, p3

    aget-byte v3, p1, v3

    .line 268
    and-int/lit16 v3, v3, 0xff

    .line 270
    add-int/lit8 v4, v1, 0x1

    add-int/2addr v4, p3

    aget-byte v4, p1, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x8

    .line 268
    or-int/2addr v3, v4

    .line 271
    add-int/lit8 v4, v1, 0x2

    add-int/2addr v4, p3

    aget-byte v4, p1, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x10

    .line 268
    or-int/2addr v3, v4

    .line 272
    add-int/lit8 v4, v1, 0x3

    add-int/2addr v4, p3

    aget-byte v4, p1, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x18

    .line 268
    or-int/2addr v3, v4

    aput v3, v2, v0

    .line 267
    add-int/lit8 v0, v0, 0x1

    add-int/lit8 v1, v1, 0x4

    goto :goto_0
.end method

.method private static encode(J)[B
    .locals 8
    .param p0, "l"    # J

    .prologue
    const/16 v6, 0x8

    const-wide/16 v4, 0xff

    .line 241
    new-array v0, v6, [B

    .line 242
    .local v0, "out":[B
    const/4 v1, 0x0

    and-long v2, p0, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 243
    const/4 v1, 0x1

    ushr-long v2, p0, v6

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 244
    const/4 v1, 0x2

    const/16 v2, 0x10

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 245
    const/4 v1, 0x3

    const/16 v2, 0x18

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 246
    const/4 v1, 0x4

    const/16 v2, 0x20

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 247
    const/4 v1, 0x5

    const/16 v2, 0x28

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 248
    const/4 v1, 0x6

    const/16 v2, 0x30

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 249
    const/4 v1, 0x7

    const/16 v2, 0x38

    ushr-long v2, p0, v2

    and-long/2addr v2, v4

    long-to-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 250
    return-object v0
.end method

.method private static encode([II)[B
    .locals 5
    .param p0, "input"    # [I
    .param p1, "len"    # I

    .prologue
    .line 254
    new-array v2, p1, [B

    .line 256
    .local v2, "out":[B
    const/4 v1, 0x0

    .local v1, "j":I
    move v0, v1

    .local v0, "i":I
    :goto_0
    if-lt v1, p1, :cond_0

    .line 262
    return-object v2

    .line 257
    :cond_0
    aget v3, p0, v0

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v2, v1

    .line 258
    add-int/lit8 v3, v1, 0x1

    aget v4, p0, v0

    ushr-int/lit8 v4, v4, 0x8

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    .line 259
    add-int/lit8 v3, v1, 0x2

    aget v4, p0, v0

    ushr-int/lit8 v4, v4, 0x10

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    .line 260
    add-int/lit8 v3, v1, 0x3

    aget v4, p0, v0

    ushr-int/lit8 v4, v4, 0x18

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    .line 256
    add-int/lit8 v0, v0, 0x1

    add-int/lit8 v1, v1, 0x4

    goto :goto_0
.end method

.method private static toHex([B)Ljava/lang/String;
    .locals 6
    .param p0, "hash"    # [B

    .prologue
    .line 191
    new-instance v0, Ljava/lang/StringBuffer;

    array-length v3, p0

    mul-int/lit8 v3, v3, 0x2

    invoke-direct {v0, v3}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 192
    .local v0, "buf":Ljava/lang/StringBuffer;
    array-length v4, p0

    const/4 v3, 0x0

    :goto_0
    if-lt v3, v4, :cond_0

    .line 201
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 192
    :cond_0
    aget-byte v1, p0, v3

    .line 193
    .local v1, "element":B
    and-int/lit16 v2, v1, 0xff

    .line 194
    .local v2, "intVal":I
    const/16 v5, 0x10

    if-ge v2, v5, :cond_1

    .line 197
    const-string v5, "0"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 199
    :cond_1
    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 192
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method private static transform(Lcom/penthera/virtuososdk/download/MD5State;[I)V
    .locals 10
    .param p0, "state"    # Lcom/penthera/virtuososdk/download/MD5State;
    .param p1, "x"    # [I

    .prologue
    .line 279
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x0

    aget v0, v4, v5

    .line 280
    .local v0, "a":I
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x1

    aget v1, v4, v5

    .line 281
    .local v1, "b":I
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x2

    aget v2, v4, v5

    .line 282
    .local v2, "c":I
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x3

    aget v3, v4, v5

    .line 285
    .local v3, "d":I
    const/4 v4, 0x0

    aget v4, p1, v4

    const/4 v5, 0x7

    const v6, -0x28955b88

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v0

    .line 286
    const/4 v4, 0x1

    aget v7, p1, v4

    const/16 v8, 0xc

    const v9, -0x173848aa

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v3

    .line 287
    const/4 v4, 0x2

    aget v6, p1, v4

    const/16 v7, 0x11

    const v8, 0x242070db

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v2

    .line 288
    const/4 v4, 0x3

    aget v5, p1, v4

    const/16 v6, 0x16

    const v7, -0x3e423112

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v1

    .line 289
    const/4 v4, 0x4

    aget v4, p1, v4

    const/4 v5, 0x7

    const v6, -0xa83f051

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v0

    .line 290
    const/4 v4, 0x5

    aget v7, p1, v4

    const/16 v8, 0xc

    const v9, 0x4787c62a

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v3

    .line 291
    const/4 v4, 0x6

    aget v6, p1, v4

    const/16 v7, 0x11

    const v8, -0x57cfb9ed

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v2

    .line 292
    const/4 v4, 0x7

    aget v5, p1, v4

    const/16 v6, 0x16

    const v7, -0x2b96aff

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v1

    .line 293
    const/16 v4, 0x8

    aget v4, p1, v4

    const/4 v5, 0x7

    const v6, 0x698098d8

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v0

    .line 294
    const/16 v4, 0x9

    aget v7, p1, v4

    const/16 v8, 0xc

    const v9, -0x74bb0851

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v3

    .line 295
    const/16 v4, 0xa

    aget v6, p1, v4

    const/16 v7, 0x11

    const v8, -0xa44f

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v2

    .line 296
    const/16 v4, 0xb

    aget v5, p1, v4

    const/16 v6, 0x16

    const v7, -0x76a32842

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v1

    .line 297
    const/16 v4, 0xc

    aget v4, p1, v4

    const/4 v5, 0x7

    const v6, 0x6b901122

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v0

    .line 298
    const/16 v4, 0xd

    aget v7, p1, v4

    const/16 v8, 0xc

    const v9, -0x2678e6d

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v3

    .line 299
    const/16 v4, 0xe

    aget v6, p1, v4

    const/16 v7, 0x11

    const v8, -0x5986bc72

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v2

    .line 300
    const/16 v4, 0xf

    aget v5, p1, v4

    const/16 v6, 0x16

    const v7, 0x49b40821

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->FF(IIIIIII)I

    move-result v1

    .line 303
    const/4 v4, 0x1

    aget v4, p1, v4

    const/4 v5, 0x5

    const v6, -0x9e1da9e

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v0

    .line 304
    const/4 v4, 0x6

    aget v7, p1, v4

    const/16 v8, 0x9

    const v9, -0x3fbf4cc0

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v3

    .line 305
    const/16 v4, 0xb

    aget v6, p1, v4

    const/16 v7, 0xe

    const v8, 0x265e5a51

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v2

    .line 306
    const/4 v4, 0x0

    aget v5, p1, v4

    const/16 v6, 0x14

    const v7, -0x16493856

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v1

    .line 307
    const/4 v4, 0x5

    aget v4, p1, v4

    const/4 v5, 0x5

    const v6, -0x29d0efa3

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v0

    .line 308
    const/16 v4, 0xa

    aget v7, p1, v4

    const/16 v8, 0x9

    const v9, 0x2441453

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v3

    .line 309
    const/16 v4, 0xf

    aget v6, p1, v4

    const/16 v7, 0xe

    const v8, -0x275e197f

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v2

    .line 310
    const/4 v4, 0x4

    aget v5, p1, v4

    const/16 v6, 0x14

    const v7, -0x182c0438

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v1

    .line 311
    const/16 v4, 0x9

    aget v4, p1, v4

    const/4 v5, 0x5

    const v6, 0x21e1cde6

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v0

    .line 312
    const/16 v4, 0xe

    aget v7, p1, v4

    const/16 v8, 0x9

    const v9, -0x3cc8f82a

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v3

    .line 313
    const/4 v4, 0x3

    aget v6, p1, v4

    const/16 v7, 0xe

    const v8, -0xb2af279

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v2

    .line 314
    const/16 v4, 0x8

    aget v5, p1, v4

    const/16 v6, 0x14

    const v7, 0x455a14ed

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v1

    .line 315
    const/16 v4, 0xd

    aget v4, p1, v4

    const/4 v5, 0x5

    const v6, -0x561c16fb

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v0

    .line 316
    const/4 v4, 0x2

    aget v7, p1, v4

    const/16 v8, 0x9

    const v9, -0x3105c08

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v3

    .line 317
    const/4 v4, 0x7

    aget v6, p1, v4

    const/16 v7, 0xe

    const v8, 0x676f02d9

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v2

    .line 318
    const/16 v4, 0xc

    aget v5, p1, v4

    const/16 v6, 0x14

    const v7, -0x72d5b376

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->GG(IIIIIII)I

    move-result v1

    .line 321
    const/4 v4, 0x5

    aget v4, p1, v4

    const/4 v5, 0x4

    const v6, -0x5c6be

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v0

    .line 322
    const/16 v4, 0x8

    aget v7, p1, v4

    const/16 v8, 0xb

    const v9, -0x788e097f

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v3

    .line 323
    const/16 v4, 0xb

    aget v6, p1, v4

    const/16 v7, 0x10

    const v8, 0x6d9d6122

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v2

    .line 324
    const/16 v4, 0xe

    aget v5, p1, v4

    const/16 v6, 0x17

    const v7, -0x21ac7f4

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v1

    .line 325
    const/4 v4, 0x1

    aget v4, p1, v4

    const/4 v5, 0x4

    const v6, -0x5b4115bc

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v0

    .line 326
    const/4 v4, 0x4

    aget v7, p1, v4

    const/16 v8, 0xb

    const v9, 0x4bdecfa9    # 2.9204306E7f

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v3

    .line 327
    const/4 v4, 0x7

    aget v6, p1, v4

    const/16 v7, 0x10

    const v8, -0x944b4a0

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v2

    .line 328
    const/16 v4, 0xa

    aget v5, p1, v4

    const/16 v6, 0x17

    const v7, -0x41404390

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v1

    .line 329
    const/16 v4, 0xd

    aget v4, p1, v4

    const/4 v5, 0x4

    const v6, 0x289b7ec6

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v0

    .line 330
    const/4 v4, 0x0

    aget v7, p1, v4

    const/16 v8, 0xb

    const v9, -0x155ed806

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v3

    .line 331
    const/4 v4, 0x3

    aget v6, p1, v4

    const/16 v7, 0x10

    const v8, -0x2b10cf7b

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v2

    .line 332
    const/4 v4, 0x6

    aget v5, p1, v4

    const/16 v6, 0x17

    const v7, 0x4881d05    # 3.2000097E-36f

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v1

    .line 333
    const/16 v4, 0x9

    aget v4, p1, v4

    const/4 v5, 0x4

    const v6, -0x262b2fc7

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v0

    .line 334
    const/16 v4, 0xc

    aget v7, p1, v4

    const/16 v8, 0xb

    const v9, -0x1924661b

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v3

    .line 335
    const/16 v4, 0xf

    aget v6, p1, v4

    const/16 v7, 0x10

    const v8, 0x1fa27cf8

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v2

    .line 336
    const/4 v4, 0x2

    aget v5, p1, v4

    const/16 v6, 0x17

    const v7, -0x3b53a99b

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->HH(IIIIIII)I

    move-result v1

    .line 339
    const/4 v4, 0x0

    aget v4, p1, v4

    const/4 v5, 0x6

    const v6, -0xbd6ddbc

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v0

    .line 340
    const/4 v4, 0x7

    aget v7, p1, v4

    const/16 v8, 0xa

    const v9, 0x432aff97

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v3

    .line 341
    const/16 v4, 0xe

    aget v6, p1, v4

    const/16 v7, 0xf

    const v8, -0x546bdc59

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v2

    .line 342
    const/4 v4, 0x5

    aget v5, p1, v4

    const/16 v6, 0x15

    const v7, -0x36c5fc7

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v1

    .line 343
    const/16 v4, 0xc

    aget v4, p1, v4

    const/4 v5, 0x6

    const v6, 0x655b59c3

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v0

    .line 344
    const/4 v4, 0x3

    aget v7, p1, v4

    const/16 v8, 0xa

    const v9, -0x70f3336e

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v3

    .line 345
    const/16 v4, 0xa

    aget v6, p1, v4

    const/16 v7, 0xf

    const v8, -0x100b83

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v2

    .line 346
    const/4 v4, 0x1

    aget v5, p1, v4

    const/16 v6, 0x15

    const v7, -0x7a7ba22f

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v1

    .line 347
    const/16 v4, 0x8

    aget v4, p1, v4

    const/4 v5, 0x6

    const v6, 0x6fa87e4f

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v0

    .line 348
    const/16 v4, 0xf

    aget v7, p1, v4

    const/16 v8, 0xa

    const v9, -0x1d31920

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v3

    .line 349
    const/4 v4, 0x6

    aget v6, p1, v4

    const/16 v7, 0xf

    const v8, -0x5cfebcec

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v2

    .line 350
    const/16 v4, 0xd

    aget v5, p1, v4

    const/16 v6, 0x15

    const v7, 0x4e0811a1    # 5.7071418E8f

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v1

    .line 351
    const/4 v4, 0x4

    aget v4, p1, v4

    const/4 v5, 0x6

    const v6, -0x8ac817e

    invoke-static/range {v0 .. v6}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v0

    .line 352
    const/16 v4, 0xb

    aget v7, p1, v4

    const/16 v8, 0xa

    const v9, -0x42c50dcb

    move v4, v0

    move v5, v1

    move v6, v2

    invoke-static/range {v3 .. v9}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v3

    .line 353
    const/4 v4, 0x2

    aget v6, p1, v4

    const/16 v7, 0xf

    const v8, 0x2ad7d2bb

    move v4, v0

    move v5, v1

    invoke-static/range {v2 .. v8}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v2

    .line 354
    const/16 v4, 0x9

    aget v5, p1, v4

    const/16 v6, 0x15

    const v7, -0x14792c6f

    move v4, v0

    invoke-static/range {v1 .. v7}, Lcom/penthera/virtuososdk/download/MD5;->II(IIIIIII)I

    move-result v1

    .line 356
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x0

    aget v6, v4, v5

    add-int/2addr v6, v0

    aput v6, v4, v5

    .line 357
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x1

    aget v6, v4, v5

    add-int/2addr v6, v1

    aput v6, v4, v5

    .line 358
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x2

    aget v6, v4, v5

    add-int/2addr v6, v2

    aput v6, v4, v5

    .line 359
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/4 v5, 0x3

    aget v6, v4, v5

    add-int/2addr v6, v3

    aput v6, v4, v5

    .line 360
    return-void
.end method

.method private update(Lcom/penthera/virtuososdk/download/MD5State;[BII)V
    .locals 10
    .param p1, "state"    # Lcom/penthera/virtuososdk/download/MD5State;
    .param p2, "buffer"    # [B
    .param p3, "offset"    # I
    .param p4, "length"    # I

    .prologue
    const/16 v9, 0x40

    const/4 v8, 0x0

    .line 132
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    iput-boolean v8, v4, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    .line 135
    add-int v4, p4, p3

    array-length v5, p2

    if-le v4, v5, :cond_0

    .line 136
    array-length v4, p2

    sub-int p4, v4, p3

    .line 142
    :cond_0
    iget-wide v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    const/4 v6, 0x3

    ushr-long/2addr v4, v6

    long-to-int v4, v4

    and-int/lit8 v1, v4, 0x3f

    .line 145
    .local v1, "index":I
    iget-wide v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    shl-int/lit8 v6, p4, 0x3

    int-to-long v6, v6

    add-long/2addr v4, v6

    iput-wide v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    .line 147
    rsub-int/lit8 v2, v1, 0x40

    .line 149
    .local v2, "partlen":I
    const/4 v0, 0x0

    .line 150
    .local v0, "i":I
    if-lt p4, v2, :cond_1

    .line 151
    iget-object v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    invoke-static {p2, p3, v4, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 152
    iget-object v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    invoke-direct {p0, v4, v9, v8}, Lcom/penthera/virtuososdk/download/MD5;->decode([BII)[I

    move-result-object v4

    invoke-static {p1, v4}, Lcom/penthera/virtuososdk/download/MD5;->transform(Lcom/penthera/virtuososdk/download/MD5State;[I)V

    .line 153
    move v0, v2

    :goto_0
    add-int/lit8 v4, v0, 0x3f

    if-lt v4, p4, :cond_3

    .line 156
    const/4 v1, 0x0

    .line 160
    :cond_1
    if-ge v0, p4, :cond_2

    .line 161
    move v3, v0

    .local v3, "start":I
    :goto_1
    if-lt v0, p4, :cond_4

    .line 165
    .end local v3    # "start":I
    :cond_2
    return-void

    .line 154
    :cond_3
    invoke-direct {p0, p2, v9, v0}, Lcom/penthera/virtuososdk/download/MD5;->decode([BII)[I

    move-result-object v4

    invoke-static {p1, v4}, Lcom/penthera/virtuososdk/download/MD5;->transform(Lcom/penthera/virtuososdk/download/MD5State;[I)V

    .line 153
    add-int/lit8 v0, v0, 0x40

    goto :goto_0

    .line 162
    .restart local v3    # "start":I
    :cond_4
    iget-object v4, p1, Lcom/penthera/virtuososdk/download/MD5State;->buffer:[B

    add-int v5, v1, v0

    sub-int/2addr v5, v3

    add-int v6, v0, p3

    aget-byte v6, p2, v6

    aput-byte v6, v4, v5

    .line 161
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method


# virtual methods
.method currentState()Lcom/penthera/virtuososdk/download/MD5State;
    .locals 2

    .prologue
    .line 48
    new-instance v0, Lcom/penthera/virtuososdk/download/MD5State;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/MD5State;-><init>()V

    .line 49
    .local v0, "copy":Lcom/penthera/virtuososdk/download/MD5State;
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/MD5State;->copy(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 50
    return-object v0
.end method

.method public getHash()[B
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 69
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    iget-boolean v4, v4, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    if-nez v4, :cond_0

    .line 70
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-virtual {v4, v5}, Lcom/penthera/virtuososdk/download/MD5State;->copy(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 71
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    iget-wide v0, v4, Lcom/penthera/virtuososdk/download/MD5State;->bitCount:J

    .line 73
    .local v0, "bitCount":J
    const/4 v4, 0x3

    ushr-long v4, v0, v4

    const-wide/16 v6, 0x3f

    and-long/2addr v4, v6

    long-to-int v2, v4

    .line 75
    .local v2, "leftOver":I
    const/16 v4, 0x38

    if-ge v2, v4, :cond_1

    rsub-int/lit8 v3, v2, 0x38

    .line 77
    .local v3, "padlen":I
    :goto_0
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    sget-object v5, Lcom/penthera/virtuososdk/download/MD5;->padding:[B

    invoke-direct {p0, v4, v5, v8, v3}, Lcom/penthera/virtuososdk/download/MD5;->update(Lcom/penthera/virtuososdk/download/MD5State;[BII)V

    .line 79
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/download/MD5;->encode(J)[B

    move-result-object v5

    const/16 v6, 0x8

    invoke-direct {p0, v4, v5, v8, v6}, Lcom/penthera/virtuososdk/download/MD5;->update(Lcom/penthera/virtuososdk/download/MD5State;[BII)V

    .line 80
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    const/4 v5, 0x1

    iput-boolean v5, v4, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    .line 83
    .end local v0    # "bitCount":J
    .end local v2    # "leftOver":I
    .end local v3    # "padlen":I
    :cond_0
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    iget-object v4, v4, Lcom/penthera/virtuososdk/download/MD5State;->state:[I

    const/16 v5, 0x10

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/download/MD5;->encode([II)[B

    move-result-object v4

    return-object v4

    .line 75
    .restart local v0    # "bitCount":J
    .restart local v2    # "leftOver":I
    :cond_1
    rsub-int/lit8 v3, v2, 0x78

    goto :goto_0
.end method

.method public getHashString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/MD5;->getHash()[B

    move-result-object v0

    invoke-static {v0}, Lcom/penthera/virtuososdk/download/MD5;->toHex([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 101
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/MD5State;->reset()V

    .line 102
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->finalState:Lcom/penthera/virtuososdk/download/MD5State;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/penthera/virtuososdk/download/MD5State;->valid:Z

    .line 103
    return-void
.end method

.method setState(Lcom/penthera/virtuososdk/download/MD5State;)V
    .locals 1
    .param p1, "aState"    # Lcom/penthera/virtuososdk/download/MD5State;

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/MD5;->reset()V

    .line 59
    if-eqz p1, :cond_0

    .line 60
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/MD5State;->copy(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 61
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/MD5;->getHashString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public update([BII)V
    .locals 1
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 178
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/MD5;->workingState:Lcom/penthera/virtuososdk/download/MD5State;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/penthera/virtuososdk/download/MD5;->update(Lcom/penthera/virtuososdk/download/MD5State;[BII)V

    .line 179
    return-void
.end method
