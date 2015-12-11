.class public final Lcom/google/zxing/oned/ITFReader;
.super Lcom/google/zxing/oned/OneDReader;
.source "SourceFile"


# static fields
.field private static final DEFAULT_ALLOWED_LENGTHS:[I

.field private static final END_PATTERN_REVERSED:[I

.field private static final MAX_AVG_VARIANCE:I = 0x6b

.field private static final MAX_INDIVIDUAL_VARIANCE:I = 0xc7

.field private static final N:I = 0x1

.field static final PATTERNS:[[I

.field private static final START_PATTERN:[I

.field private static final W:I = 0x3


# instance fields
.field private narrowLineWidth:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x5

    .line 53
    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/zxing/oned/ITFReader;->DEFAULT_ALLOWED_LENGTHS:[I

    .line 64
    new-array v0, v5, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/zxing/oned/ITFReader;->START_PATTERN:[I

    .line 65
    new-array v0, v4, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcom/google/zxing/oned/ITFReader;->END_PATTERN_REVERSED:[I

    .line 70
    const/16 v0, 0xa

    new-array v0, v0, [[I

    const/4 v1, 0x0

    new-array v2, v3, [I

    fill-array-data v2, :array_3

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-array v2, v3, [I

    fill-array-data v2, :array_4

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-array v2, v3, [I

    fill-array-data v2, :array_5

    aput-object v2, v0, v1

    new-array v1, v3, [I

    fill-array-data v1, :array_6

    aput-object v1, v0, v4

    new-array v1, v3, [I

    fill-array-data v1, :array_7

    aput-object v1, v0, v5

    new-array v1, v3, [I

    fill-array-data v1, :array_8

    aput-object v1, v0, v3

    const/4 v1, 0x6

    new-array v2, v3, [I

    fill-array-data v2, :array_9

    aput-object v2, v0, v1

    const/4 v1, 0x7

    new-array v2, v3, [I

    fill-array-data v2, :array_a

    aput-object v2, v0, v1

    const/16 v1, 0x8

    new-array v2, v3, [I

    fill-array-data v2, :array_b

    aput-object v2, v0, v1

    const/16 v1, 0x9

    new-array v2, v3, [I

    fill-array-data v2, :array_c

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/zxing/oned/ITFReader;->PATTERNS:[[I

    return-void

    .line 53
    :array_0
    .array-data 4
        0x30
        0x2c
        0x18
        0x14
        0x12
        0x10
        0xe
        0xc
        0xa
        0x8
        0x6
    .end array-data

    .line 64
    :array_1
    .array-data 4
        0x1
        0x1
        0x1
        0x1
    .end array-data

    .line 65
    :array_2
    .array-data 4
        0x1
        0x1
        0x3
    .end array-data

    .line 70
    :array_3
    .array-data 4
        0x1
        0x1
        0x3
        0x3
        0x1
    .end array-data

    :array_4
    .array-data 4
        0x3
        0x1
        0x1
        0x1
        0x3
    .end array-data

    :array_5
    .array-data 4
        0x1
        0x3
        0x1
        0x1
        0x3
    .end array-data

    :array_6
    .array-data 4
        0x3
        0x3
        0x1
        0x1
        0x1
    .end array-data

    :array_7
    .array-data 4
        0x1
        0x1
        0x3
        0x1
        0x3
    .end array-data

    :array_8
    .array-data 4
        0x3
        0x1
        0x3
        0x1
        0x1
    .end array-data

    :array_9
    .array-data 4
        0x1
        0x3
        0x3
        0x1
        0x1
    .end array-data

    :array_a
    .array-data 4
        0x1
        0x1
        0x1
        0x3
        0x3
    .end array-data

    :array_b
    .array-data 4
        0x3
        0x1
        0x1
        0x3
        0x1
    .end array-data

    :array_c
    .array-data 4
        0x1
        0x3
        0x1
        0x3
        0x1
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/google/zxing/oned/OneDReader;-><init>()V

    .line 56
    const/4 v0, -0x1

    iput v0, p0, Lcom/google/zxing/oned/ITFReader;->narrowLineWidth:I

    return-void
.end method

.method private static decodeDigit([I)I
    .locals 6

    .prologue
    .line 332
    const/16 v3, 0x6b

    .line 333
    const/4 v0, -0x1

    .line 334
    sget-object v1, Lcom/google/zxing/oned/ITFReader;->PATTERNS:[[I

    array-length v4, v1

    .line 335
    const/4 v1, 0x0

    :goto_0
    if-ge v1, v4, :cond_0

    .line 336
    sget-object v2, Lcom/google/zxing/oned/ITFReader;->PATTERNS:[[I

    aget-object v2, v2, v1

    .line 337
    const/16 v5, 0xc7

    invoke-static {p0, v2, v5}, Lcom/google/zxing/oned/ITFReader;->patternMatchVariance([I[II)I

    move-result v2

    .line 338
    if-ge v2, v3, :cond_2

    move v0, v1

    .line 335
    :goto_1
    add-int/lit8 v1, v1, 0x1

    move v3, v2

    goto :goto_0

    .line 343
    :cond_0
    if-ltz v0, :cond_1

    .line 344
    return v0

    .line 346
    :cond_1
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_2
    move v2, v3

    goto :goto_1
.end method

.method private static decodeMiddle(Lcom/google/zxing/common/BitArray;IILjava/lang/StringBuilder;)V
    .locals 9

    .prologue
    const/4 v1, 0x0

    const/4 v8, 0x5

    .line 142
    const/16 v0, 0xa

    new-array v3, v0, [I

    .line 143
    new-array v4, v8, [I

    .line 144
    new-array v5, v8, [I

    move v0, p1

    .line 146
    :goto_0
    if-ge v0, p2, :cond_2

    .line 149
    invoke-static {p0, v0, v3}, Lcom/google/zxing/oned/ITFReader;->recordPattern(Lcom/google/zxing/common/BitArray;I[I)V

    move v2, v1

    .line 151
    :goto_1
    if-ge v2, v8, :cond_0

    .line 152
    shl-int/lit8 v6, v2, 0x1

    .line 153
    aget v7, v3, v6

    aput v7, v4, v2

    .line 154
    add-int/lit8 v6, v6, 0x1

    aget v6, v3, v6

    aput v6, v5, v2

    .line 151
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 157
    :cond_0
    invoke-static {v4}, Lcom/google/zxing/oned/ITFReader;->decodeDigit([I)I

    move-result v2

    .line 158
    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 159
    invoke-static {v5}, Lcom/google/zxing/oned/ITFReader;->decodeDigit([I)I

    move-result v2

    .line 160
    add-int/lit8 v2, v2, 0x30

    int-to-char v2, v2

    invoke-virtual {p3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 162
    array-length v6, v3

    move v2, v0

    move v0, v1

    :goto_2
    if-ge v0, v6, :cond_1

    aget v7, v3, v0

    .line 163
    add-int/2addr v2, v7

    .line 162
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_1
    move v0, v2

    .line 165
    goto :goto_0

    .line 166
    :cond_2
    return-void
.end method

.method private static findGuardPattern(Lcom/google/zxing/common/BitArray;I[I)[I
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 292
    array-length v5, p2

    .line 293
    new-array v6, v5, [I

    .line 294
    invoke-virtual {p0}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v7

    move v0, p1

    move v1, v4

    move v2, v4

    .line 299
    :goto_0
    if-ge p1, v7, :cond_4

    .line 300
    invoke-virtual {p0, p1}, Lcom/google/zxing/common/BitArray;->get(I)Z

    move-result v8

    xor-int/2addr v8, v2

    if-eqz v8, :cond_0

    .line 301
    aget v8, v6, v1

    add-int/lit8 v8, v8, 0x1

    aput v8, v6, v1

    .line 299
    :goto_1
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 303
    :cond_0
    add-int/lit8 v8, v5, -0x1

    if-ne v1, v8, :cond_2

    .line 304
    const/16 v8, 0xc7

    invoke-static {v6, p2, v8}, Lcom/google/zxing/oned/ITFReader;->patternMatchVariance([I[II)I

    move-result v8

    const/16 v9, 0x6b

    if-ge v8, v9, :cond_1

    .line 305
    new-array v1, v10, [I

    aput v0, v1, v4

    aput p1, v1, v3

    return-object v1

    .line 307
    :cond_1
    aget v8, v6, v4

    aget v9, v6, v3

    add-int/2addr v8, v9

    add-int/2addr v0, v8

    .line 308
    add-int/lit8 v8, v5, -0x2

    invoke-static {v6, v10, v6, v4, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 309
    add-int/lit8 v8, v5, -0x2

    aput v4, v6, v8

    .line 310
    add-int/lit8 v8, v5, -0x1

    aput v4, v6, v8

    .line 311
    add-int/lit8 v1, v1, -0x1

    .line 315
    :goto_2
    aput v3, v6, v1

    .line 316
    if-nez v2, :cond_3

    move v2, v3

    goto :goto_1

    .line 313
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_3
    move v2, v4

    .line 316
    goto :goto_1

    .line 319
    :cond_4
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0
.end method

.method private static skipWhiteSpace(Lcom/google/zxing/common/BitArray;)I
    .locals 2

    .prologue
    .line 232
    invoke-virtual {p0}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v0

    .line 233
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/google/zxing/common/BitArray;->getNextSet(I)I

    move-result v1

    .line 234
    if-ne v1, v0, :cond_0

    .line 235
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 238
    :cond_0
    return v1
.end method

.method private validateQuietZone(Lcom/google/zxing/common/BitArray;I)V
    .locals 4

    .prologue
    .line 207
    iget v0, p0, Lcom/google/zxing/oned/ITFReader;->narrowLineWidth:I

    mul-int/lit8 v0, v0, 0xa

    .line 210
    if-ge v0, p2, :cond_1

    .line 212
    :goto_0
    add-int/lit8 v1, p2, -0x1

    move v3, v1

    move v1, v0

    move v0, v3

    :goto_1
    if-lez v1, :cond_0

    if-ltz v0, :cond_0

    .line 213
    invoke-virtual {p1, v0}, Lcom/google/zxing/common/BitArray;->get(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 218
    :cond_0
    if-eqz v1, :cond_3

    .line 220
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_1
    move v0, p2

    .line 210
    goto :goto_0

    .line 216
    :cond_2
    add-int/lit8 v1, v1, -0x1

    .line 212
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 222
    :cond_3
    return-void
.end method


# virtual methods
.method decodeEnd(Lcom/google/zxing/common/BitArray;)[I
    .locals 5

    .prologue
    .line 253
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->reverse()V

    .line 255
    :try_start_0
    invoke-static {p1}, Lcom/google/zxing/oned/ITFReader;->skipWhiteSpace(Lcom/google/zxing/common/BitArray;)I

    move-result v0

    .line 256
    sget-object v1, Lcom/google/zxing/oned/ITFReader;->END_PATTERN_REVERSED:[I

    invoke-static {p1, v0, v1}, Lcom/google/zxing/oned/ITFReader;->findGuardPattern(Lcom/google/zxing/common/BitArray;I[I)[I

    move-result-object v0

    .line 261
    const/4 v1, 0x0

    aget v1, v0, v1

    invoke-direct {p0, p1, v1}, Lcom/google/zxing/oned/ITFReader;->validateQuietZone(Lcom/google/zxing/common/BitArray;I)V

    .line 266
    const/4 v1, 0x0

    aget v1, v0, v1

    .line 267
    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v3

    const/4 v4, 0x1

    aget v4, v0, v4

    sub-int/2addr v3, v4

    aput v3, v0, v2

    .line 268
    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v3

    sub-int v1, v3, v1

    aput v1, v0, v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 273
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->reverse()V

    return-object v0

    :catchall_0
    move-exception v0

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->reverse()V

    throw v0
.end method

.method public decodeRow(ILcom/google/zxing/common/BitArray;Ljava/util/Map;)Lcom/google/zxing/Result;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/google/zxing/common/BitArray;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;)",
            "Lcom/google/zxing/Result;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 88
    invoke-virtual {p0, p2}, Lcom/google/zxing/oned/ITFReader;->decodeStart(Lcom/google/zxing/common/BitArray;)[I

    move-result-object v5

    .line 89
    invoke-virtual {p0, p2}, Lcom/google/zxing/oned/ITFReader;->decodeEnd(Lcom/google/zxing/common/BitArray;)[I

    move-result-object v6

    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v3, 0x14

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 92
    aget v3, v5, v1

    aget v7, v6, v2

    invoke-static {p2, v3, v7, v0}, Lcom/google/zxing/oned/ITFReader;->decodeMiddle(Lcom/google/zxing/common/BitArray;IILjava/lang/StringBuilder;)V

    .line 93
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 96
    if-eqz p3, :cond_4

    .line 97
    sget-object v0, Lcom/google/zxing/DecodeHintType;->ALLOWED_LENGTHS:Lcom/google/zxing/DecodeHintType;

    invoke-interface {p3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    check-cast v0, [I

    .line 100
    :goto_0
    if-nez v0, :cond_0

    .line 101
    sget-object v0, Lcom/google/zxing/oned/ITFReader;->DEFAULT_ALLOWED_LENGTHS:[I

    .line 106
    :cond_0
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v8

    .line 108
    array-length v9, v0

    move v3, v2

    :goto_1
    if-ge v3, v9, :cond_3

    aget v10, v0, v3

    .line 109
    if-ne v8, v10, :cond_1

    move v0, v1

    .line 114
    :goto_2
    if-nez v0, :cond_2

    .line 115
    invoke-static {}, Lcom/google/zxing/FormatException;->getFormatInstance()Lcom/google/zxing/FormatException;

    move-result-object v0

    throw v0

    .line 108
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 118
    :cond_2
    new-instance v0, Lcom/google/zxing/Result;

    const/4 v3, 0x2

    new-array v3, v3, [Lcom/google/zxing/ResultPoint;

    new-instance v8, Lcom/google/zxing/ResultPoint;

    aget v5, v5, v1

    int-to-float v5, v5

    int-to-float v9, p1

    invoke-direct {v8, v5, v9}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v8, v3, v2

    new-instance v5, Lcom/google/zxing/ResultPoint;

    aget v2, v6, v2

    int-to-float v2, v2

    int-to-float v6, p1

    invoke-direct {v5, v2, v6}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v5, v3, v1

    sget-object v1, Lcom/google/zxing/BarcodeFormat;->ITF:Lcom/google/zxing/BarcodeFormat;

    invoke-direct {v0, v7, v4, v3, v1}, Lcom/google/zxing/Result;-><init>(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V

    return-object v0

    :cond_3
    move v0, v2

    goto :goto_2

    :cond_4
    move-object v0, v4

    goto :goto_0
.end method

.method decodeStart(Lcom/google/zxing/common/BitArray;)[I
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 177
    invoke-static {p1}, Lcom/google/zxing/oned/ITFReader;->skipWhiteSpace(Lcom/google/zxing/common/BitArray;)I

    move-result v0

    .line 178
    sget-object v1, Lcom/google/zxing/oned/ITFReader;->START_PATTERN:[I

    invoke-static {p1, v0, v1}, Lcom/google/zxing/oned/ITFReader;->findGuardPattern(Lcom/google/zxing/common/BitArray;I[I)[I

    move-result-object v0

    .line 183
    const/4 v1, 0x1

    aget v1, v0, v1

    aget v2, v0, v3

    sub-int/2addr v1, v2

    shr-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/google/zxing/oned/ITFReader;->narrowLineWidth:I

    .line 185
    aget v1, v0, v3

    invoke-direct {p0, p1, v1}, Lcom/google/zxing/oned/ITFReader;->validateQuietZone(Lcom/google/zxing/common/BitArray;I)V

    .line 187
    return-object v0
.end method
