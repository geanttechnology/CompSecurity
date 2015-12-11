.class public final Lcom/google/zxing/pdf417/detector/Detector;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final BARCODE_MIN_HEIGHT:I = 0xa

.field private static final INDEXES_START_PATTERN:[I

.field private static final INDEXES_STOP_PATTERN:[I

.field private static final INTEGER_MATH_SHIFT:I = 0x8

.field private static final MAX_AVG_VARIANCE:I = 0x6b

.field private static final MAX_INDIVIDUAL_VARIANCE:I = 0xcc

.field private static final MAX_PATTERN_DRIFT:I = 0x5

.field private static final MAX_PIXEL_DRIFT:I = 0x3

.field private static final PATTERN_MATCH_RESULT_SCALE_FACTOR:I = 0x100

.field private static final ROW_STEP:I = 0x5

.field private static final SKIPPED_ROW_COUNT_MAX:I = 0x19

.field private static final START_PATTERN:[I

.field private static final STOP_PATTERN:[I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 41
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/zxing/pdf417/detector/Detector;->INDEXES_START_PATTERN:[I

    .line 42
    new-array v0, v1, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/zxing/pdf417/detector/Detector;->INDEXES_STOP_PATTERN:[I

    .line 50
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcom/google/zxing/pdf417/detector/Detector;->START_PATTERN:[I

    .line 52
    const/16 v0, 0x9

    new-array v0, v0, [I

    fill-array-data v0, :array_3

    sput-object v0, Lcom/google/zxing/pdf417/detector/Detector;->STOP_PATTERN:[I

    return-void

    .line 41
    :array_0
    .array-data 4
        0x0
        0x4
        0x1
        0x5
    .end array-data

    .line 42
    :array_1
    .array-data 4
        0x6
        0x2
        0x7
        0x3
    .end array-data

    .line 50
    :array_2
    .array-data 4
        0x8
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x3
    .end array-data

    .line 52
    :array_3
    .array-data 4
        0x7
        0x1
        0x1
        0x3
        0x1
        0x1
        0x1
        0x2
        0x1
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    return-void
.end method

.method private static copyToResult([Lcom/google/zxing/ResultPoint;[Lcom/google/zxing/ResultPoint;[I)V
    .locals 3

    .prologue
    .line 210
    const/4 v0, 0x0

    :goto_0
    array-length v1, p2

    if-ge v0, v1, :cond_0

    .line 211
    aget v1, p2, v0

    aget-object v2, p1, v0

    aput-object v2, p0, v1

    .line 210
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 213
    :cond_0
    return-void
.end method

.method public static detect(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Z)Lcom/google/zxing/pdf417/detector/PDF417DetectorResult;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/zxing/BinaryBitmap;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;Z)",
            "Lcom/google/zxing/pdf417/detector/PDF417DetectorResult;"
        }
    .end annotation

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/google/zxing/BinaryBitmap;->getBlackMatrix()Lcom/google/zxing/common/BitMatrix;

    move-result-object v1

    .line 83
    invoke-static {p2, v1}, Lcom/google/zxing/pdf417/detector/Detector;->detect(ZLcom/google/zxing/common/BitMatrix;)Ljava/util/List;

    move-result-object v0

    .line 84
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 85
    invoke-static {v1}, Lcom/google/zxing/pdf417/detector/Detector;->rotate180(Lcom/google/zxing/common/BitMatrix;)V

    .line 86
    invoke-static {p2, v1}, Lcom/google/zxing/pdf417/detector/Detector;->detect(ZLcom/google/zxing/common/BitMatrix;)Ljava/util/List;

    move-result-object v0

    .line 88
    :cond_0
    new-instance v2, Lcom/google/zxing/pdf417/detector/PDF417DetectorResult;

    invoke-direct {v2, v1, v0}, Lcom/google/zxing/pdf417/detector/PDF417DetectorResult;-><init>(Lcom/google/zxing/common/BitMatrix;Ljava/util/List;)V

    return-object v2
.end method

.method private static detect(ZLcom/google/zxing/common/BitMatrix;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lcom/google/zxing/common/BitMatrix;",
            ")",
            "Ljava/util/List",
            "<[",
            "Lcom/google/zxing/ResultPoint;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 99
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    move v3, v1

    move v4, v1

    .line 103
    :goto_0
    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v6

    if-ge v4, v6, :cond_0

    .line 104
    invoke-static {p1, v4, v3}, Lcom/google/zxing/pdf417/detector/Detector;->findVertices(Lcom/google/zxing/common/BitMatrix;II)[Lcom/google/zxing/ResultPoint;

    move-result-object v3

    .line 106
    aget-object v6, v3, v1

    if-nez v6, :cond_5

    aget-object v6, v3, v8

    if-nez v6, :cond_5

    .line 107
    if-nez v0, :cond_1

    .line 141
    :cond_0
    return-object v5

    .line 115
    :cond_1
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/zxing/ResultPoint;

    .line 116
    aget-object v6, v0, v2

    if-eqz v6, :cond_3

    .line 117
    int-to-float v4, v4

    aget-object v6, v0, v2

    invoke-virtual {v6}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v6

    invoke-static {v4, v6}, Ljava/lang/Math;->max(FF)F

    move-result v4

    float-to-int v4, v4

    .line 119
    :cond_3
    aget-object v6, v0, v8

    if-eqz v6, :cond_2

    .line 120
    aget-object v0, v0, v8

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v0

    float-to-int v0, v0

    invoke-static {v4, v0}, Ljava/lang/Math;->max(II)I

    move-result v4

    goto :goto_1

    .line 123
    :cond_4
    add-int/lit8 v0, v4, 0x5

    move v3, v1

    move v4, v0

    move v0, v1

    .line 124
    goto :goto_0

    .line 127
    :cond_5
    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 128
    if-eqz p0, :cond_0

    .line 133
    aget-object v0, v3, v7

    if-eqz v0, :cond_6

    .line 134
    aget-object v0, v3, v7

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v0

    float-to-int v0, v0

    .line 135
    aget-object v3, v3, v7

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v3

    float-to-int v3, v3

    :goto_2
    move v4, v3

    move v3, v0

    move v0, v2

    .line 140
    goto :goto_0

    .line 137
    :cond_6
    aget-object v0, v3, v9

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v0

    float-to-int v0, v0

    .line 138
    aget-object v3, v3, v9

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v3

    float-to-int v3, v3

    goto :goto_2
.end method

.method private static findGuardPattern(Lcom/google/zxing/common/BitMatrix;IIIZ[I[I)[I
    .locals 7

    .prologue
    .line 295
    const/4 v0, 0x0

    array-length v1, p6

    const/4 v2, 0x0

    invoke-static {p6, v0, v1, v2}, Ljava/util/Arrays;->fill([IIII)V

    .line 296
    array-length v3, p5

    .line 299
    const/4 v0, 0x0

    .line 302
    :goto_0
    invoke-virtual {p0, p1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v1

    if-eqz v1, :cond_0

    if-lez p1, :cond_0

    add-int/lit8 v1, v0, 0x1

    const/4 v2, 0x3

    if-ge v0, v2, :cond_0

    .line 303
    add-int/lit8 p1, p1, -0x1

    move v0, v1

    goto :goto_0

    .line 306
    :cond_0
    const/4 v0, 0x0

    move v1, p1

    move v2, p4

    .line 307
    :goto_1
    if-ge p1, p3, :cond_5

    .line 308
    invoke-virtual {p0, p1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v4

    .line 309
    xor-int/2addr v4, v2

    if-eqz v4, :cond_1

    .line 310
    aget v4, p6, v0

    add-int/lit8 v4, v4, 0x1

    aput v4, p6, v0

    .line 307
    :goto_2
    add-int/lit8 p1, p1, 0x1

    goto :goto_1

    .line 312
    :cond_1
    add-int/lit8 v4, v3, -0x1

    if-ne v0, v4, :cond_3

    .line 313
    const/16 v4, 0xcc

    invoke-static {p6, p5, v4}, Lcom/google/zxing/pdf417/detector/Detector;->patternMatchVariance([I[II)I

    move-result v4

    const/16 v5, 0x6b

    if-ge v4, v5, :cond_2

    .line 314
    const/4 v0, 0x2

    new-array v0, v0, [I

    const/4 v2, 0x0

    aput v1, v0, v2

    const/4 v1, 0x1

    aput p1, v0, v1

    .line 333
    :goto_3
    return-object v0

    .line 316
    :cond_2
    const/4 v4, 0x0

    aget v4, p6, v4

    const/4 v5, 0x1

    aget v5, p6, v5

    add-int/2addr v4, v5

    add-int/2addr v1, v4

    .line 317
    const/4 v4, 0x2

    const/4 v5, 0x0

    add-int/lit8 v6, v3, -0x2

    invoke-static {p6, v4, p6, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 318
    add-int/lit8 v4, v3, -0x2

    const/4 v5, 0x0

    aput v5, p6, v4

    .line 319
    add-int/lit8 v4, v3, -0x1

    const/4 v5, 0x0

    aput v5, p6, v4

    .line 320
    add-int/lit8 v0, v0, -0x1

    .line 324
    :goto_4
    const/4 v4, 0x1

    aput v4, p6, v0

    .line 325
    if-nez v2, :cond_4

    const/4 v2, 0x1

    goto :goto_2

    .line 322
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 325
    :cond_4
    const/4 v2, 0x0

    goto :goto_2

    .line 328
    :cond_5
    add-int/lit8 v2, v3, -0x1

    if-ne v0, v2, :cond_6

    .line 329
    const/16 v0, 0xcc

    invoke-static {p6, p5, v0}, Lcom/google/zxing/pdf417/detector/Detector;->patternMatchVariance([I[II)I

    move-result v0

    const/16 v2, 0x6b

    if-ge v0, v2, :cond_6

    .line 330
    const/4 v0, 0x2

    new-array v0, v0, [I

    const/4 v2, 0x0

    aput v1, v0, v2

    const/4 v1, 0x1

    add-int/lit8 v2, p1, -0x1

    aput v2, v0, v1

    goto :goto_3

    .line 333
    :cond_6
    const/4 v0, 0x0

    goto :goto_3
.end method

.method private static findRowsWithPattern(Lcom/google/zxing/common/BitMatrix;IIII[I)[Lcom/google/zxing/ResultPoint;
    .locals 12

    .prologue
    .line 221
    const/4 v1, 0x4

    new-array v11, v1, [Lcom/google/zxing/ResultPoint;

    .line 222
    const/4 v8, 0x0

    .line 223
    move-object/from16 v0, p5

    array-length v1, v0

    new-array v7, v1, [I

    move v3, p3

    .line 224
    :goto_0
    if-ge v3, p1, :cond_8

    .line 225
    const/4 v5, 0x0

    move-object v1, p0

    move/from16 v2, p4

    move v4, p2

    move-object/from16 v6, p5

    invoke-static/range {v1 .. v7}, Lcom/google/zxing/pdf417/detector/Detector;->findGuardPattern(Lcom/google/zxing/common/BitMatrix;IIIZ[I[I)[I

    move-result-object v1

    .line 226
    if-eqz v1, :cond_2

    move-object v8, v1

    move v1, v3

    .line 227
    :goto_1
    if-lez v1, :cond_1

    .line 228
    add-int/lit8 v3, v1, -0x1

    const/4 v5, 0x0

    move-object v1, p0

    move/from16 v2, p4

    move v4, p2

    move-object/from16 v6, p5

    invoke-static/range {v1 .. v7}, Lcom/google/zxing/pdf417/detector/Detector;->findGuardPattern(Lcom/google/zxing/common/BitMatrix;IIIZ[I[I)[I

    move-result-object v1

    .line 229
    if-eqz v1, :cond_0

    move-object v8, v1

    move v1, v3

    .line 235
    goto :goto_1

    .line 232
    :cond_0
    add-int/lit8 v1, v3, 0x1

    .line 236
    :cond_1
    const/4 v2, 0x0

    new-instance v3, Lcom/google/zxing/ResultPoint;

    const/4 v4, 0x0

    aget v4, v8, v4

    int-to-float v4, v4

    int-to-float v5, v1

    invoke-direct {v3, v4, v5}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v3, v11, v2

    .line 237
    const/4 v2, 0x1

    new-instance v3, Lcom/google/zxing/ResultPoint;

    const/4 v4, 0x1

    aget v4, v8, v4

    int-to-float v4, v4

    int-to-float v5, v1

    invoke-direct {v3, v4, v5}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v3, v11, v2

    .line 238
    const/4 v2, 0x1

    move v10, v1

    .line 242
    :goto_2
    add-int/lit8 v1, v10, 0x1

    .line 244
    if-eqz v2, :cond_5

    .line 245
    const/4 v2, 0x0

    .line 246
    const/4 v3, 0x2

    new-array v8, v3, [I

    const/4 v3, 0x0

    const/4 v4, 0x0

    aget-object v4, v11, v4

    invoke-virtual {v4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v4

    float-to-int v4, v4

    aput v4, v8, v3

    const/4 v3, 0x1

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v4

    float-to-int v4, v4

    aput v4, v8, v3

    move v9, v2

    move v3, v1

    .line 247
    :goto_3
    if-ge v3, p1, :cond_4

    .line 248
    const/4 v1, 0x0

    aget v2, v8, v1

    const/4 v5, 0x0

    move-object v1, p0

    move v4, p2

    move-object/from16 v6, p5

    invoke-static/range {v1 .. v7}, Lcom/google/zxing/pdf417/detector/Detector;->findGuardPattern(Lcom/google/zxing/common/BitMatrix;IIIZ[I[I)[I

    move-result-object v1

    .line 253
    if-eqz v1, :cond_3

    const/4 v2, 0x0

    aget v2, v8, v2

    const/4 v4, 0x0

    aget v4, v1, v4

    sub-int/2addr v2, v4

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    const/4 v4, 0x5

    if-ge v2, v4, :cond_3

    const/4 v2, 0x1

    aget v2, v8, v2

    const/4 v4, 0x1

    aget v4, v1, v4

    sub-int/2addr v2, v4

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    const/4 v4, 0x5

    if-ge v2, v4, :cond_3

    .line 257
    const/4 v2, 0x0

    .line 247
    :goto_4
    add-int/lit8 v3, v3, 0x1

    move-object v8, v1

    move v9, v2

    goto :goto_3

    .line 224
    :cond_2
    add-int/lit8 v3, v3, 0x5

    goto/16 :goto_0

    .line 259
    :cond_3
    const/16 v1, 0x19

    if-le v9, v1, :cond_6

    .line 266
    :cond_4
    add-int/lit8 v1, v9, 0x1

    sub-int v1, v3, v1

    .line 267
    const/4 v2, 0x2

    new-instance v3, Lcom/google/zxing/ResultPoint;

    const/4 v4, 0x0

    aget v4, v8, v4

    int-to-float v4, v4

    int-to-float v5, v1

    invoke-direct {v3, v4, v5}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v3, v11, v2

    .line 268
    const/4 v2, 0x3

    new-instance v3, Lcom/google/zxing/ResultPoint;

    const/4 v4, 0x1

    aget v4, v8, v4

    int-to-float v4, v4

    int-to-float v5, v1

    invoke-direct {v3, v4, v5}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v3, v11, v2

    .line 270
    :cond_5
    sub-int/2addr v1, v10

    const/16 v2, 0xa

    if-ge v1, v2, :cond_7

    .line 271
    const/4 v1, 0x0

    :goto_5
    array-length v2, v11

    if-ge v1, v2, :cond_7

    .line 272
    const/4 v2, 0x0

    aput-object v2, v11, v1

    .line 271
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 262
    :cond_6
    add-int/lit8 v1, v9, 0x1

    move v2, v1

    move-object v1, v8

    goto :goto_4

    .line 275
    :cond_7
    return-object v11

    :cond_8
    move v2, v8

    move v10, v3

    goto/16 :goto_2
.end method

.method private static findVertices(Lcom/google/zxing/common/BitMatrix;II)[Lcom/google/zxing/ResultPoint;
    .locals 8

    .prologue
    const/4 v7, 0x4

    .line 193
    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v1

    .line 194
    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v2

    .line 196
    const/16 v0, 0x8

    new-array v6, v0, [Lcom/google/zxing/ResultPoint;

    .line 197
    sget-object v5, Lcom/google/zxing/pdf417/detector/Detector;->START_PATTERN:[I

    move-object v0, p0

    move v3, p1

    move v4, p2

    invoke-static/range {v0 .. v5}, Lcom/google/zxing/pdf417/detector/Detector;->findRowsWithPattern(Lcom/google/zxing/common/BitMatrix;IIII[I)[Lcom/google/zxing/ResultPoint;

    move-result-object v0

    sget-object v3, Lcom/google/zxing/pdf417/detector/Detector;->INDEXES_START_PATTERN:[I

    invoke-static {v6, v0, v3}, Lcom/google/zxing/pdf417/detector/Detector;->copyToResult([Lcom/google/zxing/ResultPoint;[Lcom/google/zxing/ResultPoint;[I)V

    .line 200
    aget-object v0, v6, v7

    if-eqz v0, :cond_0

    .line 201
    aget-object v0, v6, v7

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v0

    float-to-int v4, v0

    .line 202
    aget-object v0, v6, v7

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v0

    float-to-int v3, v0

    .line 204
    :goto_0
    sget-object v5, Lcom/google/zxing/pdf417/detector/Detector;->STOP_PATTERN:[I

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lcom/google/zxing/pdf417/detector/Detector;->findRowsWithPattern(Lcom/google/zxing/common/BitMatrix;IIII[I)[Lcom/google/zxing/ResultPoint;

    move-result-object v0

    sget-object v1, Lcom/google/zxing/pdf417/detector/Detector;->INDEXES_STOP_PATTERN:[I

    invoke-static {v6, v0, v1}, Lcom/google/zxing/pdf417/detector/Detector;->copyToResult([Lcom/google/zxing/ResultPoint;[Lcom/google/zxing/ResultPoint;[I)V

    .line 206
    return-object v6

    :cond_0
    move v4, p2

    move v3, p1

    goto :goto_0
.end method

.method static mirror(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/common/BitArray;)Lcom/google/zxing/common/BitArray;
    .locals 3

    .prologue
    .line 167
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->clear()V

    .line 168
    invoke-virtual {p0}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v1

    .line 169
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    .line 170
    invoke-virtual {p0, v0}, Lcom/google/zxing/common/BitArray;->get(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 171
    add-int/lit8 v2, v1, -0x1

    sub-int/2addr v2, v0

    invoke-virtual {p1, v2}, Lcom/google/zxing/common/BitArray;->set(I)V

    .line 169
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 174
    :cond_1
    return-object p1
.end method

.method private static patternMatchVariance([I[II)I
    .locals 9

    .prologue
    const v0, 0x7fffffff

    const/4 v1, 0x0

    .line 352
    array-length v5, p0

    move v2, v1

    move v3, v1

    move v4, v1

    .line 355
    :goto_0
    if-ge v2, v5, :cond_0

    .line 356
    aget v6, p0, v2

    add-int/2addr v4, v6

    .line 357
    aget v6, p1, v2

    add-int/2addr v3, v6

    .line 355
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 359
    :cond_0
    if-ge v4, v3, :cond_2

    .line 380
    :cond_1
    :goto_1
    return v0

    .line 367
    :cond_2
    shl-int/lit8 v2, v4, 0x8

    div-int v6, v2, v3

    .line 368
    mul-int v2, p2, v6

    shr-int/lit8 v7, v2, 0x8

    move v2, v1

    move v3, v1

    .line 371
    :goto_2
    if-ge v2, v5, :cond_4

    .line 372
    aget v1, p0, v2

    shl-int/lit8 v1, v1, 0x8

    .line 373
    aget v8, p1, v2

    mul-int/2addr v8, v6

    .line 374
    if-le v1, v8, :cond_3

    sub-int/2addr v1, v8

    .line 375
    :goto_3
    if-gt v1, v7, :cond_1

    .line 378
    add-int/2addr v3, v1

    .line 371
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_2

    .line 374
    :cond_3
    sub-int v1, v8, v1

    goto :goto_3

    .line 380
    :cond_4
    div-int v0, v3, v4

    goto :goto_1
.end method

.method static rotate180(Lcom/google/zxing/common/BitMatrix;)V
    .locals 7

    .prologue
    .line 151
    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v0

    .line 152
    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v2

    .line 153
    new-instance v1, Lcom/google/zxing/common/BitArray;

    invoke-direct {v1, v0}, Lcom/google/zxing/common/BitArray;-><init>(I)V

    .line 154
    new-instance v3, Lcom/google/zxing/common/BitArray;

    invoke-direct {v3, v0}, Lcom/google/zxing/common/BitArray;-><init>(I)V

    .line 155
    new-instance v4, Lcom/google/zxing/common/BitArray;

    invoke-direct {v4, v0}, Lcom/google/zxing/common/BitArray;-><init>(I)V

    .line 156
    const/4 v0, 0x0

    :goto_0
    add-int/lit8 v5, v2, 0x1

    shr-int/lit8 v5, v5, 0x1

    if-ge v0, v5, :cond_0

    .line 157
    invoke-virtual {p0, v0, v1}, Lcom/google/zxing/common/BitMatrix;->getRow(ILcom/google/zxing/common/BitArray;)Lcom/google/zxing/common/BitArray;

    move-result-object v1

    .line 158
    add-int/lit8 v5, v2, -0x1

    sub-int/2addr v5, v0

    invoke-virtual {p0, v5, v3}, Lcom/google/zxing/common/BitMatrix;->getRow(ILcom/google/zxing/common/BitArray;)Lcom/google/zxing/common/BitArray;

    move-result-object v5

    invoke-static {v5, v4}, Lcom/google/zxing/pdf417/detector/Detector;->mirror(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/common/BitArray;)Lcom/google/zxing/common/BitArray;

    move-result-object v5

    invoke-virtual {p0, v0, v5}, Lcom/google/zxing/common/BitMatrix;->setRow(ILcom/google/zxing/common/BitArray;)V

    .line 159
    add-int/lit8 v5, v2, -0x1

    sub-int/2addr v5, v0

    invoke-static {v1, v4}, Lcom/google/zxing/pdf417/detector/Detector;->mirror(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/common/BitArray;)Lcom/google/zxing/common/BitArray;

    move-result-object v6

    invoke-virtual {p0, v5, v6}, Lcom/google/zxing/common/BitMatrix;->setRow(ILcom/google/zxing/common/BitArray;)V

    .line 156
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 161
    :cond_0
    return-void
.end method
