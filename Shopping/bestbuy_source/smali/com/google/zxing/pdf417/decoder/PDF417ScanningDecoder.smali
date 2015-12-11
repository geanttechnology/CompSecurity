.class public final Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CODEWORD_SKEW_SIZE:I = 0x2

.field private static final MAX_EC_CODEWORDS:I = 0x200

.field private static final MAX_ERRORS:I = 0x3

.field private static final errorCorrection:Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;

    invoke-direct {v0}, Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;-><init>()V

    sput-object v0, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->errorCorrection:Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method private static adjustBoundingBox(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/BoundingBox;
    .locals 9

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 143
    if-nez p0, :cond_1

    .line 172
    :cond_0
    :goto_0
    return-object v0

    .line 146
    :cond_1
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getRowHeights()[I

    move-result-object v3

    .line 147
    if-eqz v3, :cond_0

    .line 150
    invoke-static {v3}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getMax([I)I

    move-result v4

    .line 152
    array-length v5, v3

    move v2, v1

    move v0, v1

    :goto_1
    if-ge v2, v5, :cond_2

    aget v6, v3, v2

    .line 153
    sub-int v7, v4, v6

    add-int/2addr v0, v7

    .line 154
    if-lez v6, :cond_3

    .line 158
    :cond_2
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getCodewords()[Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v5

    move v2, v0

    move v0, v1

    .line 159
    :goto_2
    if-lez v2, :cond_4

    aget-object v6, v5, v0

    if-nez v6, :cond_4

    .line 160
    add-int/lit8 v2, v2, -0x1

    .line 159
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 152
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 163
    :cond_4
    array-length v0, v3

    add-int/lit8 v0, v0, -0x1

    move v8, v0

    move v0, v1

    move v1, v8

    :goto_3
    if-ltz v1, :cond_5

    .line 164
    aget v6, v3, v1

    sub-int v6, v4, v6

    add-int/2addr v0, v6

    .line 165
    aget v6, v3, v1

    if-lez v6, :cond_6

    .line 169
    :cond_5
    array-length v1, v5

    add-int/lit8 v1, v1, -0x1

    move v8, v1

    move v1, v0

    move v0, v8

    :goto_4
    if-lez v1, :cond_7

    aget-object v3, v5, v0

    if-nez v3, :cond_7

    .line 170
    add-int/lit8 v1, v1, -0x1

    .line 169
    add-int/lit8 v0, v0, -0x1

    goto :goto_4

    .line 163
    :cond_6
    add-int/lit8 v1, v1, -0x1

    goto :goto_3

    .line 172
    :cond_7
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->isLeft()Z

    move-result v3

    invoke-virtual {v0, v2, v1, v3}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->addMissingRows(IIZ)Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v0

    goto :goto_0
.end method

.method private static adjustCodewordCount(Lcom/google/zxing/pdf417/decoder/DetectionResult;[[Lcom/google/zxing/pdf417/decoder/BarcodeValue;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 233
    aget-object v0, p1, v3

    aget-object v0, v0, v4

    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getValue()[I

    move-result-object v0

    .line 234
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v1

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeRowCount()I

    move-result v2

    mul-int/2addr v1, v2

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeECLevel()I

    move-result v2

    invoke-static {v2}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getNumberOfECCodeWords(I)I

    move-result v2

    sub-int/2addr v1, v2

    .line 237
    array-length v2, v0

    if-nez v2, :cond_3

    .line 238
    if-lt v1, v4, :cond_0

    const/16 v0, 0x3a0

    if-le v1, v0, :cond_1

    .line 239
    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 241
    :cond_1
    aget-object v0, p1, v3

    aget-object v0, v0, v4

    invoke-virtual {v0, v1}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->setValue(I)V

    .line 246
    :cond_2
    :goto_0
    return-void

    .line 242
    :cond_3
    aget v0, v0, v3

    if-eq v0, v1, :cond_2

    .line 244
    aget-object v0, p1, v3

    aget-object v0, v0, v4

    invoke-virtual {v0, v1}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->setValue(I)V

    goto :goto_0
.end method

.method private static adjustCodewordStartColumn(Lcom/google/zxing/common/BitMatrix;IIZII)I
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 491
    .line 492
    if-eqz p3, :cond_2

    const/4 v0, -0x1

    :goto_0
    move v4, v2

    move v5, v0

    move v0, p4

    .line 494
    :goto_1
    if-ge v4, v6, :cond_6

    move v3, v0

    .line 495
    :goto_2
    if-eqz p3, :cond_0

    if-ge v3, p1, :cond_1

    :cond_0
    if-nez p3, :cond_4

    if-ge v3, p2, :cond_4

    :cond_1
    invoke-virtual {p0, v3, p5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v0

    if-ne p3, v0, :cond_4

    .line 497
    sub-int v0, p4, v3

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    if-le v0, v6, :cond_3

    .line 505
    :goto_3
    return p4

    :cond_2
    move v0, v1

    .line 492
    goto :goto_0

    .line 500
    :cond_3
    add-int v0, v3, v5

    move v3, v0

    goto :goto_2

    .line 502
    :cond_4
    neg-int v5, v5

    .line 503
    if-nez p3, :cond_5

    move v0, v1

    .line 494
    :goto_4
    add-int/lit8 v4, v4, 0x1

    move p3, v0

    move v0, v3

    goto :goto_1

    :cond_5
    move v0, v2

    .line 503
    goto :goto_4

    :cond_6
    move p4, v0

    .line 505
    goto :goto_3
.end method

.method private static checkCodewordSkew(III)Z
    .locals 1

    .prologue
    .line 509
    add-int/lit8 v0, p1, -0x2

    if-gt v0, p0, :cond_0

    add-int/lit8 v0, p2, 0x2

    if-gt p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static correctErrors([I[II)I
    .locals 2

    .prologue
    .line 540
    if-eqz p1, :cond_0

    array-length v0, p1

    div-int/lit8 v1, p2, 0x2

    add-int/lit8 v1, v1, 0x3

    if-gt v0, v1, :cond_1

    :cond_0
    if-ltz p2, :cond_1

    const/16 v0, 0x200

    if-le p2, v0, :cond_2

    .line 545
    :cond_1
    invoke-static {}, Lcom/google/zxing/ChecksumException;->getChecksumInstance()Lcom/google/zxing/ChecksumException;

    move-result-object v0

    throw v0

    .line 547
    :cond_2
    sget-object v0, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->errorCorrection:Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;

    invoke-virtual {v0, p0, p2, p1}, Lcom/google/zxing/pdf417/decoder/ec/ErrorCorrection;->decode([II[I)I

    move-result v0

    return v0
.end method

.method private static createBarcodeMatrix(Lcom/google/zxing/pdf417/decoder/DetectionResult;)[[Lcom/google/zxing/pdf417/decoder/BarcodeValue;
    .locals 12

    .prologue
    const/4 v4, -0x1

    const/4 v2, 0x0

    .line 328
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeRowCount()I

    move-result v0

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    filled-new-array {v0, v1}, [I

    move-result-object v0

    const-class v1, Lcom/google/zxing/pdf417/decoder/BarcodeValue;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Lcom/google/zxing/pdf417/decoder/BarcodeValue;

    move v1, v2

    .line 330
    :goto_0
    array-length v3, v0

    if-ge v1, v3, :cond_1

    move v3, v2

    .line 331
    :goto_1
    aget-object v5, v0, v1

    array-length v5, v5

    if-ge v3, v5, :cond_0

    .line 332
    aget-object v5, v0, v1

    new-instance v6, Lcom/google/zxing/pdf417/decoder/BarcodeValue;

    invoke-direct {v6}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;-><init>()V

    aput-object v6, v5, v3

    .line 331
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 330
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 337
    :cond_1
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumns()[Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v6

    array-length v7, v6

    move v3, v2

    move v1, v4

    :goto_2
    if-ge v3, v7, :cond_6

    aget-object v8, v6, v3

    .line 338
    add-int/lit8 v5, v1, 0x1

    .line 339
    if-nez v8, :cond_3

    .line 337
    :cond_2
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    move v1, v5

    goto :goto_2

    .line 342
    :cond_3
    invoke-virtual {v8}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->getCodewords()[Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v8

    array-length v9, v8

    move v1, v2

    :goto_3
    if-ge v1, v9, :cond_2

    aget-object v10, v8, v1

    .line 343
    if-eqz v10, :cond_4

    invoke-virtual {v10}, Lcom/google/zxing/pdf417/decoder/Codeword;->getRowNumber()I

    move-result v11

    if-ne v11, v4, :cond_5

    .line 342
    :cond_4
    :goto_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 346
    :cond_5
    invoke-virtual {v10}, Lcom/google/zxing/pdf417/decoder/Codeword;->getRowNumber()I

    move-result v11

    aget-object v11, v0, v11

    aget-object v11, v11, v5

    invoke-virtual {v10}, Lcom/google/zxing/pdf417/decoder/Codeword;->getValue()I

    move-result v10

    invoke-virtual {v11, v10}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->setValue(I)V

    goto :goto_4

    .line 349
    :cond_6
    return-object v0
.end method

.method private static createDecoderResult(Lcom/google/zxing/pdf417/decoder/DetectionResult;)Lcom/google/zxing/common/DecoderResult;
    .locals 12

    .prologue
    const/4 v1, 0x0

    .line 250
    invoke-static {p0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->createBarcodeMatrix(Lcom/google/zxing/pdf417/decoder/DetectionResult;)[[Lcom/google/zxing/pdf417/decoder/BarcodeValue;

    move-result-object v3

    .line 251
    invoke-static {p0, v3}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->adjustCodewordCount(Lcom/google/zxing/pdf417/decoder/DetectionResult;[[Lcom/google/zxing/pdf417/decoder/BarcodeValue;)V

    .line 252
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 253
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeRowCount()I

    move-result v0

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v2

    mul-int/2addr v0, v2

    new-array v5, v0, [I

    .line 254
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 255
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    move v0, v1

    .line 256
    :goto_0
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeRowCount()I

    move-result v2

    if-ge v0, v2, :cond_3

    move v2, v1

    .line 257
    :goto_1
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v8

    if-ge v2, v8, :cond_2

    .line 258
    aget-object v8, v3, v0

    add-int/lit8 v9, v2, 0x1

    aget-object v8, v8, v9

    invoke-virtual {v8}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getValue()[I

    move-result-object v8

    .line 259
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v9

    mul-int/2addr v9, v0

    add-int/2addr v9, v2

    .line 260
    array-length v10, v8

    if-nez v10, :cond_0

    .line 261
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v4, v8}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 257
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 262
    :cond_0
    array-length v10, v8

    const/4 v11, 0x1

    if-ne v10, v11, :cond_1

    .line 263
    aget v8, v8, v1

    aput v8, v5, v9

    goto :goto_2

    .line 265
    :cond_1
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v7, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 266
    invoke-interface {v6, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 256
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 270
    :cond_3
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    new-array v2, v0, [[I

    .line 271
    :goto_3
    array-length v0, v2

    if-ge v1, v0, :cond_4

    .line 272
    invoke-interface {v6, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    aput-object v0, v2, v1

    .line 271
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 274
    :cond_4
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeECLevel()I

    move-result v0

    invoke-static {v4}, Lcom/google/zxing/pdf417/PDF417Common;->toIntArray(Ljava/util/Collection;)[I

    move-result-object v1

    invoke-static {v7}, Lcom/google/zxing/pdf417/PDF417Common;->toIntArray(Ljava/util/Collection;)[I

    move-result-object v3

    invoke-static {v0, v5, v1, v3, v2}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->createDecoderResultFromAmbiguousValues(I[I[I[I[[I)Lcom/google/zxing/common/DecoderResult;

    move-result-object v0

    return-object v0
.end method

.method private static createDecoderResultFromAmbiguousValues(I[I[I[I[[I)Lcom/google/zxing/common/DecoderResult;
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 297
    array-length v0, p3

    new-array v3, v0, [I

    .line 299
    const/16 v0, 0x64

    .line 300
    :goto_0
    add-int/lit8 v2, v0, -0x1

    if-lez v0, :cond_5

    move v0, v1

    .line 301
    :goto_1
    array-length v4, v3

    if-ge v0, v4, :cond_0

    .line 302
    aget v4, p3, v0

    aget-object v5, p4, v0

    aget v6, v3, v0

    aget v5, v5, v6

    aput v5, p1, v4

    .line 301
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 305
    :cond_0
    :try_start_0
    invoke-static {p1, p0, p2}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->decodeCodewords([II[I)Lcom/google/zxing/common/DecoderResult;
    :try_end_0
    .catch Lcom/google/zxing/ChecksumException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 306
    :catch_0
    move-exception v0

    .line 309
    array-length v0, v3

    if-nez v0, :cond_1

    .line 310
    invoke-static {}, Lcom/google/zxing/ChecksumException;->getChecksumInstance()Lcom/google/zxing/ChecksumException;

    move-result-object v0

    throw v0

    :cond_1
    move v0, v1

    .line 312
    :goto_2
    array-length v4, v3

    if-ge v0, v4, :cond_2

    .line 313
    aget v4, v3, v0

    aget-object v5, p4, v0

    array-length v5, v5

    add-int/lit8 v5, v5, -0x1

    if-ge v4, v5, :cond_3

    .line 314
    aget v4, v3, v0

    add-int/lit8 v4, v4, 0x1

    aput v4, v3, v0

    :cond_2
    move v0, v2

    .line 312
    goto :goto_0

    .line 317
    :cond_3
    aput v1, v3, v0

    .line 318
    array-length v4, v3

    add-int/lit8 v4, v4, -0x1

    if-ne v0, v4, :cond_4

    .line 319
    invoke-static {}, Lcom/google/zxing/ChecksumException;->getChecksumInstance()Lcom/google/zxing/ChecksumException;

    move-result-object v0

    throw v0

    .line 312
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 324
    :cond_5
    invoke-static {}, Lcom/google/zxing/ChecksumException;->getChecksumInstance()Lcom/google/zxing/ChecksumException;

    move-result-object v0

    throw v0
.end method

.method public static decode(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;II)Lcom/google/zxing/common/DecoderResult;
    .locals 15

    .prologue
    .line 58
    new-instance v0, Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-object v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/google/zxing/pdf417/decoder/BoundingBox;-><init>(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V

    .line 59
    const/4 v7, 0x0

    .line 60
    const/4 v6, 0x0

    .line 61
    const/4 v2, 0x0

    .line 62
    const/4 v1, 0x0

    move v8, v1

    move-object v1, v0

    move-object v0, v2

    move-object v2, v7

    :goto_0
    const/4 v3, 0x2

    if-ge v8, v3, :cond_3

    .line 63
    if-eqz p1, :cond_11

    .line 64
    const/4 v3, 0x1

    move-object v0, p0

    move-object/from16 v2, p1

    move/from16 v4, p5

    move/from16 v5, p6

    invoke-static/range {v0 .. v5}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getRowIndicatorColumn(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/pdf417/decoder/BoundingBox;Lcom/google/zxing/ResultPoint;ZII)Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;

    move-result-object v7

    .line 67
    :goto_1
    if-eqz p3, :cond_10

    .line 68
    const/4 v3, 0x0

    move-object v0, p0

    move-object/from16 v2, p3

    move/from16 v4, p5

    move/from16 v5, p6

    invoke-static/range {v0 .. v5}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getRowIndicatorColumn(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/pdf417/decoder/BoundingBox;Lcom/google/zxing/ResultPoint;ZII)Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;

    move-result-object v0

    .line 71
    :goto_2
    invoke-static {v7, v0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->merge(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/DetectionResult;

    move-result-object v2

    .line 72
    if-nez v2, :cond_0

    .line 73
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 75
    :cond_0
    if-nez v8, :cond_2

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinY()I

    move-result v3

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinY()I

    move-result v4

    if-lt v3, v4, :cond_1

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxY()I

    move-result v3

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxY()I

    move-result v4

    if-le v3, v4, :cond_2

    .line 78
    :cond_1
    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v3

    .line 62
    add-int/lit8 v1, v8, 0x1

    move v8, v1

    move-object v6, v0

    move-object v0, v2

    move-object v1, v3

    move-object v2, v7

    goto :goto_0

    .line 80
    :cond_2
    invoke-virtual {v2, v1}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->setBoundingBox(Lcom/google/zxing/pdf417/decoder/BoundingBox;)V

    move-object v6, v0

    move-object v0, v2

    move-object v2, v7

    .line 84
    :cond_3
    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v3

    add-int/lit8 v14, v3, 0x1

    .line 85
    const/4 v3, 0x0

    invoke-virtual {v0, v3, v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->setDetectionResultColumn(ILcom/google/zxing/pdf417/decoder/DetectionResultColumn;)V

    .line 86
    invoke-virtual {v0, v14, v6}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->setDetectionResultColumn(ILcom/google/zxing/pdf417/decoder/DetectionResultColumn;)V

    .line 88
    if-eqz v2, :cond_5

    const/4 v5, 0x1

    .line 89
    :goto_3
    const/4 v11, 0x1

    move/from16 v9, p6

    move/from16 v8, p5

    :goto_4
    if-gt v11, v14, :cond_e

    .line 90
    if-eqz v5, :cond_6

    move v10, v11

    .line 91
    :goto_5
    invoke-virtual {v0, v10}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumn(I)Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 89
    :cond_4
    add-int/lit8 v11, v11, 0x1

    goto :goto_4

    .line 88
    :cond_5
    const/4 v5, 0x0

    goto :goto_3

    .line 90
    :cond_6
    sub-int v2, v14, v11

    move v10, v2

    goto :goto_5

    .line 96
    :cond_7
    if-eqz v10, :cond_8

    if-ne v10, v14, :cond_b

    .line 97
    :cond_8
    new-instance v3, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;

    if-nez v10, :cond_a

    const/4 v2, 0x1

    :goto_6
    invoke-direct {v3, v1, v2}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;-><init>(Lcom/google/zxing/pdf417/decoder/BoundingBox;Z)V

    move-object v12, v3

    .line 101
    :goto_7
    invoke-virtual {v0, v10, v12}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->setDetectionResultColumn(ILcom/google/zxing/pdf417/decoder/DetectionResultColumn;)V

    .line 102
    const/4 v2, -0x1

    .line 105
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinY()I

    move-result v7

    move v13, v2

    :goto_8
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxY()I

    move-result v2

    if-gt v7, v2, :cond_4

    .line 106
    invoke-static {v0, v10, v7, v5}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getStartColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;IIZ)I

    move-result v6

    .line 107
    if-ltz v6, :cond_9

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxX()I

    move-result v2

    if-le v6, v2, :cond_d

    .line 108
    :cond_9
    const/4 v2, -0x1

    if-ne v13, v2, :cond_c

    move v2, v13

    .line 105
    :goto_9
    add-int/lit8 v7, v7, 0x1

    move v13, v2

    goto :goto_8

    .line 97
    :cond_a
    const/4 v2, 0x0

    goto :goto_6

    .line 99
    :cond_b
    new-instance v2, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    invoke-direct {v2, v1}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;-><init>(Lcom/google/zxing/pdf417/decoder/BoundingBox;)V

    move-object v12, v2

    goto :goto_7

    :cond_c
    move v6, v13

    .line 113
    :cond_d
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinX()I

    move-result v3

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxX()I

    move-result v4

    move-object v2, p0

    invoke-static/range {v2 .. v9}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->detectCodeword(Lcom/google/zxing/common/BitMatrix;IIZIIII)Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v2

    .line 115
    if-eqz v2, :cond_f

    .line 116
    invoke-virtual {v12, v7, v2}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->setCodeword(ILcom/google/zxing/pdf417/decoder/Codeword;)V

    .line 118
    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/Codeword;->getWidth()I

    move-result v3

    invoke-static {v8, v3}, Ljava/lang/Math;->min(II)I

    move-result v8

    .line 119
    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/Codeword;->getWidth()I

    move-result v2

    invoke-static {v9, v2}, Ljava/lang/Math;->max(II)I

    move-result v9

    move v2, v6

    goto :goto_9

    .line 123
    :cond_e
    invoke-static {v0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->createDecoderResult(Lcom/google/zxing/pdf417/decoder/DetectionResult;)Lcom/google/zxing/common/DecoderResult;

    move-result-object v0

    return-object v0

    :cond_f
    move v2, v13

    goto :goto_9

    :cond_10
    move-object v0, v6

    goto/16 :goto_2

    :cond_11
    move-object v7, v2

    goto/16 :goto_1
.end method

.method private static decodeCodewords([II[I)Lcom/google/zxing/common/DecoderResult;
    .locals 2

    .prologue
    .line 515
    array-length v0, p0

    if-nez v0, :cond_0

    .line 516
    invoke-static {}, Lcom/google/zxing/FormatException;->getFormatInstance()Lcom/google/zxing/FormatException;

    move-result-object v0

    throw v0

    .line 519
    :cond_0
    const/4 v0, 0x1

    add-int/lit8 v1, p1, 0x1

    shl-int/2addr v0, v1

    .line 520
    invoke-static {p0, p2, v0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->correctErrors([I[II)I

    move-result v1

    .line 521
    invoke-static {p0, v0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->verifyCodewordCount([II)V

    .line 524
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser;->decode([ILjava/lang/String;)Lcom/google/zxing/common/DecoderResult;

    move-result-object v0

    .line 525
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/zxing/common/DecoderResult;->setErrorsCorrected(Ljava/lang/Integer;)V

    .line 526
    array-length v1, p2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/zxing/common/DecoderResult;->setErasures(Ljava/lang/Integer;)V

    .line 527
    return-object v0
.end method

.method private static detectCodeword(Lcom/google/zxing/common/BitMatrix;IIZIIII)Lcom/google/zxing/pdf417/decoder/Codeword;
    .locals 11

    .prologue
    .line 403
    invoke-static/range {p0 .. p5}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->adjustCodewordStartColumn(Lcom/google/zxing/common/BitMatrix;IIZII)I

    move-result v6

    move-object v2, p0

    move v3, p1

    move v4, p2

    move v5, p3

    move/from16 v7, p5

    .line 408
    invoke-static/range {v2 .. v7}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getModuleBitCount(Lcom/google/zxing/common/BitMatrix;IIZII)[I

    move-result-object v3

    .line 409
    if-nez v3, :cond_0

    .line 410
    const/4 v2, 0x0

    .line 450
    :goto_0
    return-object v2

    .line 413
    :cond_0
    invoke-static {v3}, Lcom/google/zxing/pdf417/PDF417Common;->getBitCountSum([I)I

    move-result v4

    .line 414
    if-eqz p3, :cond_1

    .line 415
    add-int v2, v6, v4

    move v10, v2

    move v2, v6

    move v6, v10

    .line 439
    :goto_1
    move/from16 v0, p6

    move/from16 v1, p7

    invoke-static {v4, v0, v1}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->checkCodewordSkew(III)Z

    move-result v4

    if-nez v4, :cond_3

    .line 442
    const/4 v2, 0x0

    goto :goto_0

    .line 417
    :cond_1
    const/4 v2, 0x0

    :goto_2
    array-length v5, v3

    shr-int/lit8 v5, v5, 0x1

    if-ge v2, v5, :cond_2

    .line 418
    aget v5, v3, v2

    .line 419
    array-length v7, v3

    add-int/lit8 v7, v7, -0x1

    sub-int/2addr v7, v2

    aget v7, v3, v7

    aput v7, v3, v2

    .line 420
    array-length v7, v3

    add-int/lit8 v7, v7, -0x1

    sub-int/2addr v7, v2

    aput v5, v3, v7

    .line 417
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 423
    :cond_2
    sub-int v2, v6, v4

    goto :goto_1

    .line 445
    :cond_3
    invoke-static {v3}, Lcom/google/zxing/pdf417/decoder/PDF417CodewordDecoder;->getDecodedValue([I)I

    move-result v4

    .line 446
    int-to-long v8, v4

    invoke-static {v8, v9}, Lcom/google/zxing/pdf417/PDF417Common;->getCodeword(J)I

    move-result v5

    .line 447
    const/4 v3, -0x1

    if-ne v5, v3, :cond_4

    .line 448
    const/4 v2, 0x0

    goto :goto_0

    .line 450
    :cond_4
    new-instance v3, Lcom/google/zxing/pdf417/decoder/Codeword;

    invoke-static {v4}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getCodewordBucketNumber(I)I

    move-result v4

    invoke-direct {v3, v2, v6, v4, v5}, Lcom/google/zxing/pdf417/decoder/Codeword;-><init>(IIII)V

    move-object v2, v3

    goto :goto_0
.end method

.method private static getBarcodeMetadata(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 186
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v1

    if-nez v1, :cond_3

    .line 187
    :cond_0
    if-nez p1, :cond_2

    .line 200
    :cond_1
    :goto_0
    return-object v0

    .line 187
    :cond_2
    invoke-virtual {p1}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v0

    goto :goto_0

    .line 189
    :cond_3
    if-eqz p1, :cond_4

    invoke-virtual {p1}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v1

    if-nez v1, :cond_5

    .line 190
    :cond_4
    if-eqz p0, :cond_1

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v0

    goto :goto_0

    .line 192
    :cond_5
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v1

    .line 193
    invoke-virtual {p1}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->getBarcodeMetadata()Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v2

    .line 195
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getColumnCount()I

    move-result v3

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getColumnCount()I

    move-result v4

    if-eq v3, v4, :cond_6

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getErrorCorrectionLevel()I

    move-result v3

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getErrorCorrectionLevel()I

    move-result v4

    if-eq v3, v4, :cond_6

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getRowCount()I

    move-result v3

    invoke-virtual {v2}, Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;->getRowCount()I

    move-result v2

    if-ne v3, v2, :cond_1

    :cond_6
    move-object v0, v1

    .line 200
    goto :goto_0
.end method

.method private static getBitCountForCodeword(I)[I
    .locals 4

    .prologue
    .line 577
    const/16 v0, 0x8

    new-array v2, v0, [I

    .line 578
    const/4 v1, 0x0

    .line 579
    array-length v0, v2

    add-int/lit8 v0, v0, -0x1

    .line 581
    :goto_0
    and-int/lit8 v3, p0, 0x1

    if-eq v3, v1, :cond_0

    .line 582
    and-int/lit8 v1, p0, 0x1

    .line 583
    add-int/lit8 v0, v0, -0x1

    .line 584
    if-gez v0, :cond_0

    .line 591
    return-object v2

    .line 588
    :cond_0
    aget v3, v2, v0

    add-int/lit8 v3, v3, 0x1

    aput v3, v2, v0

    .line 589
    shr-int/lit8 p0, p0, 0x1

    goto :goto_0
.end method

.method private static getCodewordBucketNumber(I)I
    .locals 1

    .prologue
    .line 595
    invoke-static {p0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getBitCountForCodeword(I)[I

    move-result-object v0

    invoke-static {v0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getCodewordBucketNumber([I)I

    move-result v0

    return v0
.end method

.method private static getCodewordBucketNumber([I)I
    .locals 2

    .prologue
    .line 599
    const/4 v0, 0x0

    aget v0, p0, v0

    const/4 v1, 0x2

    aget v1, p0, v1

    sub-int/2addr v0, v1

    const/4 v1, 0x4

    aget v1, p0, v1

    add-int/2addr v0, v1

    const/4 v1, 0x6

    aget v1, p0, v1

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x9

    rem-int/lit8 v0, v0, 0x9

    return v0
.end method

.method private static getMax([I)I
    .locals 4

    .prologue
    .line 177
    const/4 v1, -0x1

    .line 178
    array-length v2, p0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget v3, p0, v0

    .line 179
    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 178
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 181
    :cond_0
    return v1
.end method

.method private static getModuleBitCount(Lcom/google/zxing/common/BitMatrix;IIZII)[I
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 459
    .line 460
    const/16 v0, 0x8

    new-array v4, v0, [I

    .line 462
    if-eqz p3, :cond_2

    move v0, v1

    :goto_0
    move v2, p3

    move v5, v3

    .line 464
    :goto_1
    if-eqz p3, :cond_0

    if-lt p4, p2, :cond_1

    :cond_0
    if-nez p3, :cond_5

    if-lt p4, p1, :cond_5

    :cond_1
    array-length v6, v4

    if-ge v5, v6, :cond_5

    .line 466
    invoke-virtual {p0, p4, p5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v6

    if-ne v6, v2, :cond_3

    .line 467
    aget v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    .line 468
    add-int/2addr p4, v0

    goto :goto_1

    .line 462
    :cond_2
    const/4 v0, -0x1

    goto :goto_0

    .line 470
    :cond_3
    add-int/lit8 v5, v5, 0x1

    .line 471
    if-nez v2, :cond_4

    move v2, v1

    goto :goto_1

    :cond_4
    move v2, v3

    goto :goto_1

    .line 474
    :cond_5
    array-length v0, v4

    if-eq v5, v0, :cond_8

    if-eqz p3, :cond_6

    if-eq p4, p2, :cond_7

    :cond_6
    if-nez p3, :cond_9

    if-ne p4, p1, :cond_9

    :cond_7
    array-length v0, v4

    add-int/lit8 v0, v0, -0x1

    if-ne v5, v0, :cond_9

    :cond_8
    move-object v0, v4

    .line 478
    :goto_2
    return-object v0

    :cond_9
    const/4 v0, 0x0

    goto :goto_2
.end method

.method private static getNumberOfECCodeWords(I)I
    .locals 1

    .prologue
    .line 482
    const/4 v0, 0x2

    shl-int/2addr v0, p0

    return v0
.end method

.method private static getRowIndicatorColumn(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/pdf417/decoder/BoundingBox;Lcom/google/zxing/ResultPoint;ZII)Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;
    .locals 11

    .prologue
    .line 209
    new-instance v10, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;

    invoke-direct {v10, p1, p3}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;-><init>(Lcom/google/zxing/pdf417/decoder/BoundingBox;Z)V

    .line 211
    const/4 v0, 0x0

    move v9, v0

    :goto_0
    const/4 v0, 0x2

    if-ge v9, v0, :cond_4

    .line 212
    if-nez v9, :cond_1

    const/4 v0, 0x1

    move v8, v0

    .line 213
    :goto_1
    invoke-virtual {p2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v0

    float-to-int v4, v0

    .line 214
    invoke-virtual {p2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v0

    float-to-int v5, v0

    :goto_2
    invoke-virtual {p1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxY()I

    move-result v0

    if-gt v5, v0, :cond_3

    invoke-virtual {p1}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinY()I

    move-result v0

    if-lt v5, v0, :cond_3

    .line 216
    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v2

    move-object v0, p0

    move v3, p3

    move v6, p4

    move/from16 v7, p5

    invoke-static/range {v0 .. v7}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->detectCodeword(Lcom/google/zxing/common/BitMatrix;IIZIIII)Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v0

    .line 218
    if-eqz v0, :cond_0

    .line 219
    invoke-virtual {v10, v5, v0}, Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;->setCodeword(ILcom/google/zxing/pdf417/decoder/Codeword;)V

    .line 220
    if-eqz p3, :cond_2

    .line 221
    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v4

    .line 215
    :cond_0
    :goto_3
    add-int/2addr v5, v8

    goto :goto_2

    .line 212
    :cond_1
    const/4 v0, -0x1

    move v8, v0

    goto :goto_1

    .line 223
    :cond_2
    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v4

    goto :goto_3

    .line 211
    :cond_3
    add-int/lit8 v0, v9, 0x1

    move v9, v0

    goto :goto_0

    .line 228
    :cond_4
    return-object v10
.end method

.method private static getStartColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;IIZ)I
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 360
    if-eqz p3, :cond_1

    const/4 v0, 0x1

    .line 361
    :goto_0
    const/4 v1, 0x0

    .line 362
    sub-int v3, p1, v0

    invoke-static {p0, v3}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->isValidBarcodeColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 363
    sub-int v1, p1, v0

    invoke-virtual {p0, v1}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumn(I)Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->getCodeword(I)Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v1

    .line 365
    :cond_0
    if-eqz v1, :cond_3

    .line 366
    if-eqz p3, :cond_2

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v0

    .line 392
    :goto_1
    return v0

    .line 360
    :cond_1
    const/4 v0, -0x1

    goto :goto_0

    .line 366
    :cond_2
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v0

    goto :goto_1

    .line 368
    :cond_3
    invoke-virtual {p0, p1}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumn(I)Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->getCodewordNearby(I)Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v1

    .line 369
    if-eqz v1, :cond_5

    .line 370
    if-eqz p3, :cond_4

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v0

    goto :goto_1

    :cond_4
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v0

    goto :goto_1

    .line 372
    :cond_5
    sub-int v3, p1, v0

    invoke-static {p0, v3}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->isValidBarcodeColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;I)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 373
    sub-int v1, p1, v0

    invoke-virtual {p0, v1}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumn(I)Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->getCodewordNearby(I)Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v1

    .line 375
    :cond_6
    if-eqz v1, :cond_8

    .line 376
    if-eqz p3, :cond_7

    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v0

    goto :goto_1

    :cond_7
    invoke-virtual {v1}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v0

    goto :goto_1

    :cond_8
    move v1, v2

    .line 380
    :goto_2
    sub-int v3, p1, v0

    invoke-static {p0, v3}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->isValidBarcodeColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;I)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 381
    sub-int/2addr p1, v0

    .line 382
    invoke-virtual {p0, p1}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getDetectionResultColumn(I)Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/zxing/pdf417/decoder/DetectionResultColumn;->getCodewords()[Lcom/google/zxing/pdf417/decoder/Codeword;

    move-result-object v4

    array-length v5, v4

    move v3, v2

    :goto_3
    if-ge v3, v5, :cond_b

    aget-object v6, v4, v3

    .line 383
    if-eqz v6, :cond_a

    .line 384
    if-eqz p3, :cond_9

    invoke-virtual {v6}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v2

    :goto_4
    mul-int/2addr v0, v1

    invoke-virtual {v6}, Lcom/google/zxing/pdf417/decoder/Codeword;->getEndX()I

    move-result v1

    invoke-virtual {v6}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v3

    sub-int/2addr v1, v3

    mul-int/2addr v0, v1

    add-int/2addr v0, v2

    goto :goto_1

    :cond_9
    invoke-virtual {v6}, Lcom/google/zxing/pdf417/decoder/Codeword;->getStartX()I

    move-result v2

    goto :goto_4

    .line 382
    :cond_a
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    .line 390
    :cond_b
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 392
    :cond_c
    if-eqz p3, :cond_d

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMinX()I

    move-result v0

    goto :goto_1

    :cond_d
    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBoundingBox()Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->getMaxX()I

    move-result v0

    goto/16 :goto_1
.end method

.method private static isValidBarcodeColumn(Lcom/google/zxing/pdf417/decoder/DetectionResult;I)Z
    .locals 1

    .prologue
    .line 353
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Lcom/google/zxing/pdf417/decoder/DetectionResult;->getBarcodeColumnCount()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-gt p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static merge(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/DetectionResult;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 129
    if-nez p0, :cond_1

    if-nez p1, :cond_1

    .line 138
    :cond_0
    :goto_0
    return-object v0

    .line 132
    :cond_1
    invoke-static {p0, p1}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->getBarcodeMetadata(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;

    move-result-object v1

    .line 133
    if-eqz v1, :cond_0

    .line 136
    invoke-static {p0}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->adjustBoundingBox(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v0

    invoke-static {p1}, Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;->adjustBoundingBox(Lcom/google/zxing/pdf417/decoder/DetectionResultRowIndicatorColumn;)Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/google/zxing/pdf417/decoder/BoundingBox;->merge(Lcom/google/zxing/pdf417/decoder/BoundingBox;Lcom/google/zxing/pdf417/decoder/BoundingBox;)Lcom/google/zxing/pdf417/decoder/BoundingBox;

    move-result-object v2

    .line 138
    new-instance v0, Lcom/google/zxing/pdf417/decoder/DetectionResult;

    invoke-direct {v0, v1, v2}, Lcom/google/zxing/pdf417/decoder/DetectionResult;-><init>(Lcom/google/zxing/pdf417/decoder/BarcodeMetadata;Lcom/google/zxing/pdf417/decoder/BoundingBox;)V

    goto :goto_0
.end method

.method public static toString([[Lcom/google/zxing/pdf417/decoder/BarcodeValue;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v2, 0x0

    .line 603
    new-instance v4, Ljava/util/Formatter;

    invoke-direct {v4}, Ljava/util/Formatter;-><init>()V

    move v1, v2

    .line 604
    :goto_0
    array-length v0, p0

    if-ge v1, v0, :cond_2

    .line 605
    const-string v0, "Row %2d: "

    new-array v3, v8, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v2

    invoke-virtual {v4, v0, v3}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move v3, v2

    .line 606
    :goto_1
    aget-object v0, p0, v1

    array-length v0, v0

    if-ge v3, v0, :cond_1

    .line 607
    aget-object v0, p0, v1

    aget-object v0, v0, v3

    .line 608
    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getValue()[I

    move-result-object v5

    array-length v5, v5

    if-nez v5, :cond_0

    .line 609
    const-string v5, "        "

    const/4 v0, 0x0

    check-cast v0, [Ljava/lang/Object;

    invoke-virtual {v4, v5, v0}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 606
    :goto_2
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 611
    :cond_0
    const-string v5, "%4d(%2d)"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getValue()[I

    move-result-object v7

    aget v7, v7, v2

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v2

    invoke-virtual {v0}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getValue()[I

    move-result-object v7

    aget v7, v7, v2

    invoke-virtual {v0, v7}, Lcom/google/zxing/pdf417/decoder/BarcodeValue;->getConfidence(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v6, v8

    invoke-virtual {v4, v5, v6}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    goto :goto_2

    .line 615
    :cond_1
    const-string v0, "\n"

    new-array v3, v2, [Ljava/lang/Object;

    invoke-virtual {v4, v0, v3}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 604
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 617
    :cond_2
    invoke-virtual {v4}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v0

    .line 618
    invoke-virtual {v4}, Ljava/util/Formatter;->close()V

    .line 619
    return-object v0
.end method

.method private static verifyCodewordCount([II)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 554
    array-length v0, p0

    const/4 v1, 0x4

    if-ge v0, v1, :cond_0

    .line 557
    invoke-static {}, Lcom/google/zxing/FormatException;->getFormatInstance()Lcom/google/zxing/FormatException;

    move-result-object v0

    throw v0

    .line 562
    :cond_0
    aget v0, p0, v2

    .line 563
    array-length v1, p0

    if-le v0, v1, :cond_1

    .line 564
    invoke-static {}, Lcom/google/zxing/FormatException;->getFormatInstance()Lcom/google/zxing/FormatException;

    move-result-object v0

    throw v0

    .line 566
    :cond_1
    if-nez v0, :cond_2

    .line 568
    array-length v0, p0

    if-ge p1, v0, :cond_3

    .line 569
    array-length v0, p0

    sub-int/2addr v0, p1

    aput v0, p0, v2

    .line 574
    :cond_2
    return-void

    .line 571
    :cond_3
    invoke-static {}, Lcom/google/zxing/FormatException;->getFormatInstance()Lcom/google/zxing/FormatException;

    move-result-object v0

    throw v0
.end method
