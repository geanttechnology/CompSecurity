.class public Lcom/miginfocom/codec/Base64;
.super Ljava/lang/Object;
.source "Base64.java"


# static fields
.field private static final CA:[C

.field private static final IA:[I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 75
    const-string/jumbo v2, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

    invoke-virtual {v2}, Ljava/lang/String;->toCharArray()[C

    move-result-object v2

    sput-object v2, Lcom/miginfocom/codec/Base64;->CA:[C

    .line 76
    const/16 v2, 0x100

    new-array v2, v2, [I

    sput-object v2, Lcom/miginfocom/codec/Base64;->IA:[I

    .line 78
    sget-object v2, Lcom/miginfocom/codec/Base64;->IA:[I

    const/4 v3, -0x1

    invoke-static {v2, v3}, Ljava/util/Arrays;->fill([II)V

    .line 79
    const/4 v0, 0x0

    .local v0, "i":I
    sget-object v2, Lcom/miginfocom/codec/Base64;->CA:[C

    array-length v1, v2

    .local v1, "iS":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 80
    sget-object v2, Lcom/miginfocom/codec/Base64;->IA:[I

    sget-object v3, Lcom/miginfocom/codec/Base64;->CA:[C

    aget-char v3, v3, v0

    aput v0, v2, v3

    .line 79
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 81
    :cond_0
    sget-object v2, Lcom/miginfocom/codec/Base64;->IA:[I

    const/16 v3, 0x3d

    const/4 v4, 0x0

    aput v4, v2, v3

    .line 82
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final decodeFast(Ljava/lang/String;)[B
    .locals 21
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 523
    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->length()I

    move-result v16

    .line 524
    .local v16, "sLen":I
    if-nez v16, :cond_0

    .line 525
    const/16 v18, 0x0

    move/from16 v0, v18

    new-array v6, v0, [B

    .line 573
    :goto_0
    return-object v6

    .line 527
    :cond_0
    const/4 v14, 0x0

    .local v14, "sIx":I
    add-int/lit8 v7, v16, -0x1

    .line 530
    .local v7, "eIx":I
    :goto_1
    if-ge v14, v7, :cond_1

    sget-object v18, Lcom/miginfocom/codec/Base64;->IA:[I

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Ljava/lang/String;->charAt(I)C

    move-result v19

    move/from16 v0, v19

    and-int/lit16 v0, v0, 0xff

    move/from16 v19, v0

    aget v18, v18, v19

    if-gez v18, :cond_1

    .line 531
    add-int/lit8 v14, v14, 0x1

    goto :goto_1

    .line 534
    :cond_1
    :goto_2
    if-lez v7, :cond_2

    sget-object v18, Lcom/miginfocom/codec/Base64;->IA:[I

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v19

    move/from16 v0, v19

    and-int/lit16 v0, v0, 0xff

    move/from16 v19, v0

    aget v18, v18, v19

    if-gez v18, :cond_2

    .line 535
    add-int/lit8 v7, v7, -0x1

    goto :goto_2

    .line 538
    :cond_2
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v18

    const/16 v19, 0x3d

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_4

    add-int/lit8 v18, v7, -0x1

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v18

    const/16 v19, 0x3d

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_3

    const/4 v12, 0x2

    .line 539
    .local v12, "pad":I
    :goto_3
    sub-int v18, v7, v14

    add-int/lit8 v2, v18, 0x1

    .line 540
    .local v2, "cCnt":I
    const/16 v18, 0x4c

    move/from16 v0, v16

    move/from16 v1, v18

    if-le v0, v1, :cond_6

    const/16 v18, 0x4c

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v18

    const/16 v19, 0xd

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_5

    div-int/lit8 v18, v2, 0x4e

    :goto_4
    shl-int/lit8 v17, v18, 0x1

    .line 542
    .local v17, "sepCnt":I
    :goto_5
    sub-int v18, v2, v17

    mul-int/lit8 v18, v18, 0x6

    shr-int/lit8 v18, v18, 0x3

    sub-int v11, v18, v12

    .line 543
    .local v11, "len":I
    new-array v6, v11, [B

    .line 546
    .local v6, "dArr":[B
    const/4 v4, 0x0

    .line 547
    .local v4, "d":I
    const/4 v3, 0x0

    .local v3, "cc":I
    div-int/lit8 v18, v11, 0x3

    mul-int/lit8 v8, v18, 0x3

    .local v8, "eLen":I
    move v5, v4

    .end local v4    # "d":I
    .local v5, "d":I
    move v15, v14

    .end local v14    # "sIx":I
    .local v15, "sIx":I
    :goto_6
    if-ge v5, v8, :cond_7

    .line 549
    sget-object v18, Lcom/miginfocom/codec/Base64;->IA:[I

    add-int/lit8 v14, v15, 0x1

    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Ljava/lang/String;->charAt(I)C

    move-result v19

    aget v18, v18, v19

    shl-int/lit8 v18, v18, 0x12

    sget-object v19, Lcom/miginfocom/codec/Base64;->IA:[I

    add-int/lit8 v15, v14, 0x1

    .end local v14    # "sIx":I
    .restart local v15    # "sIx":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Ljava/lang/String;->charAt(I)C

    move-result v20

    aget v19, v19, v20

    shl-int/lit8 v19, v19, 0xc

    or-int v18, v18, v19

    sget-object v19, Lcom/miginfocom/codec/Base64;->IA:[I

    add-int/lit8 v14, v15, 0x1

    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Ljava/lang/String;->charAt(I)C

    move-result v20

    aget v19, v19, v20

    shl-int/lit8 v19, v19, 0x6

    or-int v18, v18, v19

    sget-object v19, Lcom/miginfocom/codec/Base64;->IA:[I

    add-int/lit8 v15, v14, 0x1

    .end local v14    # "sIx":I
    .restart local v15    # "sIx":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Ljava/lang/String;->charAt(I)C

    move-result v20

    aget v19, v19, v20

    or-int v9, v18, v19

    .line 552
    .local v9, "i":I
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "d":I
    .restart local v4    # "d":I
    shr-int/lit8 v18, v9, 0x10

    move/from16 v0, v18

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v6, v5

    .line 553
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "d":I
    .restart local v5    # "d":I
    shr-int/lit8 v18, v9, 0x8

    move/from16 v0, v18

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v6, v4

    .line 554
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "d":I
    .restart local v4    # "d":I
    int-to-byte v0, v9

    move/from16 v18, v0

    aput-byte v18, v6, v5

    .line 557
    if-lez v17, :cond_a

    add-int/lit8 v3, v3, 0x1

    const/16 v18, 0x13

    move/from16 v0, v18

    if-ne v3, v0, :cond_a

    .line 558
    add-int/lit8 v14, v15, 0x2

    .line 559
    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    const/4 v3, 0x0

    :goto_7
    move v5, v4

    .end local v4    # "d":I
    .restart local v5    # "d":I
    move v15, v14

    .line 561
    .end local v14    # "sIx":I
    .restart local v15    # "sIx":I
    goto :goto_6

    .line 538
    .end local v2    # "cCnt":I
    .end local v3    # "cc":I
    .end local v5    # "d":I
    .end local v6    # "dArr":[B
    .end local v8    # "eLen":I
    .end local v9    # "i":I
    .end local v11    # "len":I
    .end local v12    # "pad":I
    .end local v15    # "sIx":I
    .end local v17    # "sepCnt":I
    .restart local v14    # "sIx":I
    :cond_3
    const/4 v12, 0x1

    goto/16 :goto_3

    :cond_4
    const/4 v12, 0x0

    goto/16 :goto_3

    .line 540
    .restart local v2    # "cCnt":I
    .restart local v12    # "pad":I
    :cond_5
    const/16 v18, 0x0

    goto/16 :goto_4

    :cond_6
    const/16 v17, 0x0

    goto/16 :goto_5

    .line 563
    .end local v14    # "sIx":I
    .restart local v3    # "cc":I
    .restart local v5    # "d":I
    .restart local v6    # "dArr":[B
    .restart local v8    # "eLen":I
    .restart local v11    # "len":I
    .restart local v15    # "sIx":I
    .restart local v17    # "sepCnt":I
    :cond_7
    if-ge v5, v11, :cond_9

    .line 565
    const/4 v9, 0x0

    .line 566
    .restart local v9    # "i":I
    const/4 v10, 0x0

    .local v10, "j":I
    :goto_8
    sub-int v18, v7, v12

    move/from16 v0, v18

    if-gt v15, v0, :cond_8

    .line 567
    sget-object v18, Lcom/miginfocom/codec/Base64;->IA:[I

    add-int/lit8 v14, v15, 0x1

    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Ljava/lang/String;->charAt(I)C

    move-result v19

    aget v18, v18, v19

    mul-int/lit8 v19, v10, 0x6

    rsub-int/lit8 v19, v19, 0x12

    shl-int v18, v18, v19

    or-int v9, v9, v18

    .line 566
    add-int/lit8 v10, v10, 0x1

    move v15, v14

    .end local v14    # "sIx":I
    .restart local v15    # "sIx":I
    goto :goto_8

    .line 569
    :cond_8
    const/16 v13, 0x10

    .local v13, "r":I
    :goto_9
    if-ge v5, v11, :cond_9

    .line 570
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "d":I
    .restart local v4    # "d":I
    shr-int v18, v9, v13

    move/from16 v0, v18

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v6, v5

    .line 569
    add-int/lit8 v13, v13, -0x8

    move v5, v4

    .end local v4    # "d":I
    .restart local v5    # "d":I
    goto :goto_9

    .end local v9    # "i":I
    .end local v10    # "j":I
    .end local v13    # "r":I
    :cond_9
    move v4, v5

    .end local v5    # "d":I
    .restart local v4    # "d":I
    move v14, v15

    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    goto/16 :goto_0

    .end local v14    # "sIx":I
    .restart local v9    # "i":I
    .restart local v15    # "sIx":I
    :cond_a
    move v14, v15

    .end local v15    # "sIx":I
    .restart local v14    # "sIx":I
    goto :goto_7
.end method

.method public static final encodeToChar([BZ)[C
    .locals 15
    .param p0, "sArr"    # [B
    .param p1, "lineSep"    # Z

    .prologue
    .line 98
    if-eqz p0, :cond_1

    array-length v11, p0

    .line 99
    .local v11, "sLen":I
    :goto_0
    if-nez v11, :cond_2

    .line 100
    const/4 v12, 0x0

    new-array v4, v12, [C

    .line 138
    :cond_0
    :goto_1
    return-object v4

    .line 98
    .end local v11    # "sLen":I
    :cond_1
    const/4 v11, 0x0

    goto :goto_0

    .line 102
    .restart local v11    # "sLen":I
    :cond_2
    div-int/lit8 v12, v11, 0x3

    mul-int/lit8 v6, v12, 0x3

    .line 103
    .local v6, "eLen":I
    add-int/lit8 v12, v11, -0x1

    div-int/lit8 v12, v12, 0x3

    add-int/lit8 v12, v12, 0x1

    shl-int/lit8 v0, v12, 0x2

    .line 104
    .local v0, "cCnt":I
    if-eqz p1, :cond_3

    add-int/lit8 v12, v0, -0x1

    div-int/lit8 v12, v12, 0x4c

    shl-int/lit8 v12, v12, 0x1

    :goto_2
    add-int v5, v0, v12

    .line 105
    .local v5, "dLen":I
    new-array v4, v5, [C

    .line 108
    .local v4, "dArr":[C
    const/4 v9, 0x0

    .local v9, "s":I
    const/4 v2, 0x0

    .local v2, "d":I
    const/4 v1, 0x0

    .local v1, "cc":I
    move v3, v2

    .end local v2    # "d":I
    .local v3, "d":I
    move v10, v9

    .end local v9    # "s":I
    .local v10, "s":I
    :goto_3
    if-ge v10, v6, :cond_4

    .line 110
    add-int/lit8 v9, v10, 0x1

    .end local v10    # "s":I
    .restart local v9    # "s":I
    aget-byte v12, p0, v10

    and-int/lit16 v12, v12, 0xff

    shl-int/lit8 v12, v12, 0x10

    add-int/lit8 v10, v9, 0x1

    .end local v9    # "s":I
    .restart local v10    # "s":I
    aget-byte v13, p0, v9

    and-int/lit16 v13, v13, 0xff

    shl-int/lit8 v13, v13, 0x8

    or-int/2addr v12, v13

    add-int/lit8 v9, v10, 0x1

    .end local v10    # "s":I
    .restart local v9    # "s":I
    aget-byte v13, p0, v10

    and-int/lit16 v13, v13, 0xff

    or-int v7, v12, v13

    .line 113
    .local v7, "i":I
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "d":I
    .restart local v2    # "d":I
    sget-object v12, Lcom/miginfocom/codec/Base64;->CA:[C

    ushr-int/lit8 v13, v7, 0x12

    and-int/lit8 v13, v13, 0x3f

    aget-char v12, v12, v13

    aput-char v12, v4, v3

    .line 114
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "d":I
    .restart local v3    # "d":I
    sget-object v12, Lcom/miginfocom/codec/Base64;->CA:[C

    ushr-int/lit8 v13, v7, 0xc

    and-int/lit8 v13, v13, 0x3f

    aget-char v12, v12, v13

    aput-char v12, v4, v2

    .line 115
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "d":I
    .restart local v2    # "d":I
    sget-object v12, Lcom/miginfocom/codec/Base64;->CA:[C

    ushr-int/lit8 v13, v7, 0x6

    and-int/lit8 v13, v13, 0x3f

    aget-char v12, v12, v13

    aput-char v12, v4, v3

    .line 116
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "d":I
    .restart local v3    # "d":I
    sget-object v12, Lcom/miginfocom/codec/Base64;->CA:[C

    and-int/lit8 v13, v7, 0x3f

    aget-char v12, v12, v13

    aput-char v12, v4, v2

    .line 119
    if-eqz p1, :cond_7

    add-int/lit8 v1, v1, 0x1

    const/16 v12, 0x13

    if-ne v1, v12, :cond_7

    add-int/lit8 v12, v5, -0x2

    if-ge v3, v12, :cond_7

    .line 120
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "d":I
    .restart local v2    # "d":I
    const/16 v12, 0xd

    aput-char v12, v4, v3

    .line 121
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "d":I
    .restart local v3    # "d":I
    const/16 v12, 0xa

    aput-char v12, v4, v2

    .line 122
    const/4 v1, 0x0

    move v2, v3

    .end local v3    # "d":I
    .restart local v2    # "d":I
    :goto_4
    move v3, v2

    .end local v2    # "d":I
    .restart local v3    # "d":I
    move v10, v9

    .line 124
    .end local v9    # "s":I
    .restart local v10    # "s":I
    goto :goto_3

    .line 104
    .end local v1    # "cc":I
    .end local v3    # "d":I
    .end local v4    # "dArr":[C
    .end local v5    # "dLen":I
    .end local v7    # "i":I
    .end local v10    # "s":I
    :cond_3
    const/4 v12, 0x0

    goto :goto_2

    .line 127
    .restart local v1    # "cc":I
    .restart local v3    # "d":I
    .restart local v4    # "dArr":[C
    .restart local v5    # "dLen":I
    .restart local v10    # "s":I
    :cond_4
    sub-int v8, v11, v6

    .line 128
    .local v8, "left":I
    if-lez v8, :cond_0

    .line 130
    aget-byte v12, p0, v6

    and-int/lit16 v12, v12, 0xff

    shl-int/lit8 v13, v12, 0xa

    const/4 v12, 0x2

    if-ne v8, v12, :cond_5

    add-int/lit8 v12, v11, -0x1

    aget-byte v12, p0, v12

    and-int/lit16 v12, v12, 0xff

    shl-int/lit8 v12, v12, 0x2

    :goto_5
    or-int v7, v13, v12

    .line 133
    .restart local v7    # "i":I
    add-int/lit8 v12, v5, -0x4

    sget-object v13, Lcom/miginfocom/codec/Base64;->CA:[C

    shr-int/lit8 v14, v7, 0xc

    aget-char v13, v13, v14

    aput-char v13, v4, v12

    .line 134
    add-int/lit8 v12, v5, -0x3

    sget-object v13, Lcom/miginfocom/codec/Base64;->CA:[C

    ushr-int/lit8 v14, v7, 0x6

    and-int/lit8 v14, v14, 0x3f

    aget-char v13, v13, v14

    aput-char v13, v4, v12

    .line 135
    add-int/lit8 v13, v5, -0x2

    const/4 v12, 0x2

    if-ne v8, v12, :cond_6

    sget-object v12, Lcom/miginfocom/codec/Base64;->CA:[C

    and-int/lit8 v14, v7, 0x3f

    aget-char v12, v12, v14

    :goto_6
    aput-char v12, v4, v13

    .line 136
    add-int/lit8 v12, v5, -0x1

    const/16 v13, 0x3d

    aput-char v13, v4, v12

    goto/16 :goto_1

    .line 130
    .end local v7    # "i":I
    :cond_5
    const/4 v12, 0x0

    goto :goto_5

    .line 135
    .restart local v7    # "i":I
    :cond_6
    const/16 v12, 0x3d

    goto :goto_6

    .end local v8    # "left":I
    .end local v10    # "s":I
    .restart local v9    # "s":I
    :cond_7
    move v2, v3

    .end local v3    # "d":I
    .restart local v2    # "d":I
    goto :goto_4
.end method

.method public static final encodeToString([BZ)Ljava/lang/String;
    .locals 2
    .param p0, "sArr"    # [B
    .param p1, "lineSep"    # Z

    .prologue
    .line 451
    new-instance v0, Ljava/lang/String;

    invoke-static {p0, p1}, Lcom/miginfocom/codec/Base64;->encodeToChar([BZ)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    return-object v0
.end method
