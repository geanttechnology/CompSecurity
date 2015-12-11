.class public Lnet/tsz/afinal/core/Arrays;
.super Ljava/lang/Object;
.source "Arrays.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/core/Arrays$ArrayList;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lnet/tsz/afinal/core/Arrays;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lnet/tsz/afinal/core/Arrays;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 146
    return-void
.end method

.method public static varargs asList([Ljava/lang/Object;)Ljava/util/List;
    .locals 1
    .param p0, "array"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 159
    new-instance v0, Lnet/tsz/afinal/core/Arrays$ArrayList;

    invoke-direct {v0, p0}, Lnet/tsz/afinal/core/Arrays$ArrayList;-><init>([Ljava/lang/Object;)V

    return-object v0
.end method

.method public static binarySearch([BB)I
    .locals 2
    .param p0, "array"    # [B
    .param p1, "value"    # B

    .prologue
    .line 173
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([BIIB)I

    move-result v0

    return v0
.end method

.method public static binarySearch([BIIB)I
    .locals 5
    .param p0, "array"    # [B
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # B

    .prologue
    .line 193
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 194
    move v1, p1

    .line 195
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 197
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 209
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 198
    :cond_1
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 199
    .local v2, "mid":I
    aget-byte v3, p0, v2

    .line 201
    .local v3, "midVal":B
    if-ge v3, p3, :cond_2

    .line 202
    add-int/lit8 v1, v2, 0x1

    .line 203
    goto :goto_0

    :cond_2
    if-le v3, p3, :cond_0

    .line 204
    add-int/lit8 v0, v2, -0x1

    .line 205
    goto :goto_0
.end method

.method public static binarySearch([CC)I
    .locals 2
    .param p0, "array"    # [C
    .param p1, "value"    # C

    .prologue
    .line 223
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([CIIC)I

    move-result v0

    return v0
.end method

.method public static binarySearch([CIIC)I
    .locals 5
    .param p0, "array"    # [C
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # C

    .prologue
    .line 243
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 244
    move v1, p1

    .line 245
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 247
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 263
    :goto_1
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 248
    :cond_1
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 249
    .local v2, "mid":I
    :try_start_0
    aget-char v3, p0, v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 251
    .local v3, "midVal":C
    if-ge v3, p3, :cond_2

    .line 252
    add-int/lit8 v1, v2, 0x1

    .line 253
    goto :goto_0

    :cond_2
    if-le v3, p3, :cond_0

    .line 254
    add-int/lit8 v0, v2, -0x1

    .line 255
    goto :goto_0

    .line 259
    .end local v3    # "midVal":C
    :catch_0
    move-exception v4

    goto :goto_1
.end method

.method public static binarySearch([DD)I
    .locals 2
    .param p0, "array"    # [D
    .param p1, "value"    # D

    .prologue
    .line 277
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1, p2}, Lnet/tsz/afinal/core/Arrays;->binarySearch([DIID)I

    move-result v0

    return v0
.end method

.method public static binarySearch([DIID)I
    .locals 11
    .param p0, "array"    # [D
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # D

    .prologue
    .line 297
    array-length v9, p0

    invoke-static {p1, p2, v9}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 298
    move v1, p1

    .line 299
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 301
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 324
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 302
    :cond_1
    add-int v9, v1, v0

    ushr-int/lit8 v2, v9, 0x1

    .line 303
    .local v2, "mid":I
    aget-wide v3, p0, v2

    .line 305
    .local v3, "midVal":D
    cmpg-double v9, v3, p3

    if-gez v9, :cond_2

    .line 306
    add-int/lit8 v1, v2, 0x1

    .line 307
    goto :goto_0

    :cond_2
    cmpl-double v9, v3, p3

    if-lez v9, :cond_3

    .line 308
    add-int/lit8 v0, v2, -0x1

    .line 309
    goto :goto_0

    :cond_3
    const-wide/16 v9, 0x0

    cmpl-double v9, v3, v9

    if-eqz v9, :cond_4

    cmpl-double v9, v3, p3

    if-eqz v9, :cond_0

    .line 312
    :cond_4
    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    .line 313
    .local v5, "midValBits":J
    invoke-static {p3, p4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v7

    .line 315
    .local v7, "valueBits":J
    cmp-long v9, v5, v7

    if-gez v9, :cond_5

    .line 316
    add-int/lit8 v1, v2, 0x1

    .line 317
    goto :goto_0

    :cond_5
    cmp-long v9, v5, v7

    if-lez v9, :cond_0

    .line 318
    add-int/lit8 v0, v2, -0x1

    .line 319
    goto :goto_0
.end method

.method public static binarySearch([FF)I
    .locals 2
    .param p0, "array"    # [F
    .param p1, "value"    # F

    .prologue
    .line 338
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([FIIF)I

    move-result v0

    return v0
.end method

.method public static binarySearch([FIIF)I
    .locals 7
    .param p0, "array"    # [F
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # F

    .prologue
    .line 358
    array-length v6, p0

    invoke-static {p1, p2, v6}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 359
    move v1, p1

    .line 360
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 362
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 385
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 363
    :cond_1
    add-int v6, v1, v0

    ushr-int/lit8 v2, v6, 0x1

    .line 364
    .local v2, "mid":I
    aget v3, p0, v2

    .line 366
    .local v3, "midVal":F
    cmpg-float v6, v3, p3

    if-gez v6, :cond_2

    .line 367
    add-int/lit8 v1, v2, 0x1

    .line 368
    goto :goto_0

    :cond_2
    cmpl-float v6, v3, p3

    if-lez v6, :cond_3

    .line 369
    add-int/lit8 v0, v2, -0x1

    .line 370
    goto :goto_0

    :cond_3
    const/4 v6, 0x0

    cmpl-float v6, v3, v6

    if-eqz v6, :cond_4

    cmpl-float v6, v3, p3

    if-eqz v6, :cond_0

    .line 373
    :cond_4
    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    .line 374
    .local v4, "midValBits":I
    invoke-static {p3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v5

    .line 376
    .local v5, "valueBits":I
    if-ge v4, v5, :cond_5

    .line 377
    add-int/lit8 v1, v2, 0x1

    .line 378
    goto :goto_0

    :cond_5
    if-le v4, v5, :cond_0

    .line 379
    add-int/lit8 v0, v2, -0x1

    .line 380
    goto :goto_0
.end method

.method public static binarySearch([II)I
    .locals 2
    .param p0, "array"    # [I
    .param p1, "value"    # I

    .prologue
    .line 399
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([IIII)I

    move-result v0

    return v0
.end method

.method public static binarySearch([IIII)I
    .locals 5
    .param p0, "array"    # [I
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # I

    .prologue
    .line 419
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 420
    move v1, p1

    .line 421
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 423
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 435
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 424
    :cond_1
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 425
    .local v2, "mid":I
    aget v3, p0, v2

    .line 427
    .local v3, "midVal":I
    if-ge v3, p3, :cond_2

    .line 428
    add-int/lit8 v1, v2, 0x1

    .line 429
    goto :goto_0

    :cond_2
    if-le v3, p3, :cond_0

    .line 430
    add-int/lit8 v0, v2, -0x1

    .line 431
    goto :goto_0
.end method

.method public static binarySearch([JIIJ)I
    .locals 6
    .param p0, "array"    # [J
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # J

    .prologue
    .line 469
    array-length v5, p0

    invoke-static {p1, p2, v5}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 470
    move v1, p1

    .line 471
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 473
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 485
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 474
    :cond_1
    add-int v5, v1, v0

    ushr-int/lit8 v2, v5, 0x1

    .line 475
    .local v2, "mid":I
    aget-wide v3, p0, v2

    .line 477
    .local v3, "midVal":J
    cmp-long v5, v3, p3

    if-gez v5, :cond_2

    .line 478
    add-int/lit8 v1, v2, 0x1

    .line 479
    goto :goto_0

    :cond_2
    cmp-long v5, v3, p3

    if-lez v5, :cond_0

    .line 480
    add-int/lit8 v0, v2, -0x1

    .line 481
    goto :goto_0
.end method

.method public static binarySearch([JJ)I
    .locals 2
    .param p0, "array"    # [J
    .param p1, "value"    # J

    .prologue
    .line 449
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1, p2}, Lnet/tsz/afinal/core/Arrays;->binarySearch([JIIJ)I

    move-result v0

    return v0
.end method

.method public static binarySearch([Ljava/lang/Object;IILjava/lang/Object;)I
    .locals 5
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 526
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 527
    move v1, p1

    .line 528
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 530
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 543
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 531
    :cond_1
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 533
    .local v2, "mid":I
    aget-object v4, p0, v2

    check-cast v4, Ljava/lang/Comparable;

    invoke-interface {v4, p3}, Ljava/lang/Comparable;->compareTo(Ljava/lang/Object;)I

    move-result v3

    .line 535
    .local v3, "midValCmp":I
    if-gez v3, :cond_2

    .line 536
    add-int/lit8 v1, v2, 0x1

    .line 537
    goto :goto_0

    :cond_2
    if-lez v3, :cond_0

    .line 538
    add-int/lit8 v0, v2, -0x1

    .line 539
    goto :goto_0
.end method

.method public static binarySearch([Ljava/lang/Object;IILjava/lang/Object;Ljava/util/Comparator;)I
    .locals 5
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;IITT;",
            "Ljava/util/Comparator",
            "<-TT;>;)I"
        }
    .end annotation

    .prologue
    .line 588
    .local p3, "value":Ljava/lang/Object;, "TT;"
    .local p4, "comparator":Ljava/util/Comparator;, "Ljava/util/Comparator<-TT;>;"
    if-nez p4, :cond_1

    .line 589
    invoke-static {p0, p1, p2, p3}, Lnet/tsz/afinal/core/Arrays;->binarySearch([Ljava/lang/Object;IILjava/lang/Object;)I

    move-result v2

    .line 608
    :cond_0
    :goto_0
    return v2

    .line 592
    :cond_1
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 593
    move v1, p1

    .line 594
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 596
    .local v0, "hi":I
    :goto_1
    if-le v1, v0, :cond_2

    .line 608
    xor-int/lit8 v2, v1, -0x1

    goto :goto_0

    .line 597
    :cond_2
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 598
    .local v2, "mid":I
    aget-object v4, p0, v2

    invoke-interface {p4, v4, p3}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v3

    .line 600
    .local v3, "midValCmp":I
    if-gez v3, :cond_3

    .line 601
    add-int/lit8 v1, v2, 0x1

    .line 602
    goto :goto_1

    :cond_3
    if-lez v3, :cond_0

    .line 603
    add-int/lit8 v0, v2, -0x1

    .line 604
    goto :goto_1
.end method

.method public static binarySearch([Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 502
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([Ljava/lang/Object;IILjava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public static binarySearch([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)I
    .locals 2
    .param p0, "array"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;TT;",
            "Ljava/util/Comparator",
            "<-TT;>;)I"
        }
    .end annotation

    .prologue
    .line 562
    .local p1, "value":Ljava/lang/Object;, "TT;"
    .local p2, "comparator":Ljava/util/Comparator;, "Ljava/util/Comparator<-TT;>;"
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1, p2}, Lnet/tsz/afinal/core/Arrays;->binarySearch([Ljava/lang/Object;IILjava/lang/Object;Ljava/util/Comparator;)I

    move-result v0

    return v0
.end method

.method public static binarySearch([SIIS)I
    .locals 5
    .param p0, "array"    # [S
    .param p1, "startIndex"    # I
    .param p2, "endIndex"    # I
    .param p3, "value"    # S

    .prologue
    .line 642
    array-length v4, p0

    invoke-static {p1, p2, v4}, Lnet/tsz/afinal/core/Arrays;->checkBinarySearchBounds(III)V

    .line 643
    move v1, p1

    .line 644
    .local v1, "lo":I
    add-int/lit8 v0, p2, -0x1

    .line 646
    .local v0, "hi":I
    :goto_0
    if-le v1, v0, :cond_1

    .line 658
    xor-int/lit8 v2, v1, -0x1

    :cond_0
    return v2

    .line 647
    :cond_1
    add-int v4, v1, v0

    ushr-int/lit8 v2, v4, 0x1

    .line 648
    .local v2, "mid":I
    aget-short v3, p0, v2

    .line 650
    .local v3, "midVal":S
    if-ge v3, p3, :cond_2

    .line 651
    add-int/lit8 v1, v2, 0x1

    .line 652
    goto :goto_0

    :cond_2
    if-le v3, p3, :cond_0

    .line 653
    add-int/lit8 v0, v2, -0x1

    .line 654
    goto :goto_0
.end method

.method public static binarySearch([SS)I
    .locals 2
    .param p0, "array"    # [S
    .param p1, "value"    # S

    .prologue
    .line 622
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1, p1}, Lnet/tsz/afinal/core/Arrays;->binarySearch([SIIS)I

    move-result v0

    return v0
.end method

.method private static checkBinarySearchBounds(III)V
    .locals 1
    .param p0, "startIndex"    # I
    .param p1, "endIndex"    # I
    .param p2, "length"    # I

    .prologue
    .line 662
    if-le p0, p1, :cond_0

    .line 663
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 665
    :cond_0
    if-ltz p0, :cond_1

    if-le p1, p2, :cond_2

    .line 666
    :cond_1
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 668
    :cond_2
    return-void
.end method

.method public static copyOf([BI)[B
    .locals 1
    .param p0, "original"    # [B
    .param p1, "newLength"    # I

    .prologue
    .line 1893
    if-gez p1, :cond_0

    .line 1894
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1896
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([CI)[C
    .locals 1
    .param p0, "original"    # [C
    .param p1, "newLength"    # I

    .prologue
    .line 1912
    if-gez p1, :cond_0

    .line 1913
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1915
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([CII)[C

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([DI)[D
    .locals 1
    .param p0, "original"    # [D
    .param p1, "newLength"    # I

    .prologue
    .line 1931
    if-gez p1, :cond_0

    .line 1932
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1934
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([DII)[D

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([FI)[F
    .locals 1
    .param p0, "original"    # [F
    .param p1, "newLength"    # I

    .prologue
    .line 1950
    if-gez p1, :cond_0

    .line 1951
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1953
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([FII)[F

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([II)[I
    .locals 1
    .param p0, "original"    # [I
    .param p1, "newLength"    # I

    .prologue
    .line 1969
    if-gez p1, :cond_0

    .line 1970
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1972
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([III)[I

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([JI)[J
    .locals 1
    .param p0, "original"    # [J
    .param p1, "newLength"    # I

    .prologue
    .line 1988
    if-gez p1, :cond_0

    .line 1989
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1991
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([JII)[J

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;
    .locals 1
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "newLength"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;I)[TT;"
        }
    .end annotation

    .prologue
    .line 2026
    if-nez p0, :cond_0

    .line 2027
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 2029
    :cond_0
    if-gez p1, :cond_1

    .line 2030
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 2032
    :cond_1
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([Ljava/lang/Object;ILjava/lang/Class;)[Ljava/lang/Object;
    .locals 1
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "newLength"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "U:",
            "Ljava/lang/Object;",
            ">([TU;I",
            "Ljava/lang/Class",
            "<+[TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .line 2051
    .local p2, "newType":Ljava/lang/Class;, "Ljava/lang/Class<+[TT;>;"
    if-gez p1, :cond_0

    .line 2052
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 2054
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1, p2}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([Ljava/lang/Object;IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([SI)[S
    .locals 1
    .param p0, "original"    # [S
    .param p1, "newLength"    # I

    .prologue
    .line 2007
    if-gez p1, :cond_0

    .line 2008
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 2010
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([SII)[S

    move-result-object v0

    return-object v0
.end method

.method public static copyOf([ZI)[Z
    .locals 1
    .param p0, "original"    # [Z
    .param p1, "newLength"    # I

    .prologue
    .line 1874
    if-gez p1, :cond_0

    .line 1875
    new-instance v0, Ljava/lang/NegativeArraySizeException;

    invoke-direct {v0}, Ljava/lang/NegativeArraySizeException;-><init>()V

    throw v0

    .line 1877
    :cond_0
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lnet/tsz/afinal/core/Arrays;->copyOfRange([ZII)[Z

    move-result-object v0

    return-object v0
.end method

.method public static copyOfRange([BII)[B
    .locals 5
    .param p0, "original"    # [B
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2103
    if-le p1, p2, :cond_0

    .line 2104
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2106
    :cond_0
    array-length v1, p0

    .line 2107
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2108
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2110
    :cond_2
    sub-int v3, p2, p1

    .line 2111
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2112
    .local v0, "copyLength":I
    new-array v2, v3, [B

    .line 2113
    .local v2, "result":[B
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2114
    return-object v2
.end method

.method public static copyOfRange([CII)[C
    .locals 5
    .param p0, "original"    # [C
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2133
    if-le p1, p2, :cond_0

    .line 2134
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2136
    :cond_0
    array-length v1, p0

    .line 2137
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2138
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2140
    :cond_2
    sub-int v3, p2, p1

    .line 2141
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2142
    .local v0, "copyLength":I
    new-array v2, v3, [C

    .line 2143
    .local v2, "result":[C
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2144
    return-object v2
.end method

.method public static copyOfRange([DII)[D
    .locals 5
    .param p0, "original"    # [D
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2163
    if-le p1, p2, :cond_0

    .line 2164
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2166
    :cond_0
    array-length v1, p0

    .line 2167
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2168
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2170
    :cond_2
    sub-int v3, p2, p1

    .line 2171
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2172
    .local v0, "copyLength":I
    new-array v2, v3, [D

    .line 2173
    .local v2, "result":[D
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2174
    return-object v2
.end method

.method public static copyOfRange([FII)[F
    .locals 5
    .param p0, "original"    # [F
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2193
    if-le p1, p2, :cond_0

    .line 2194
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2196
    :cond_0
    array-length v1, p0

    .line 2197
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2198
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2200
    :cond_2
    sub-int v3, p2, p1

    .line 2201
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2202
    .local v0, "copyLength":I
    new-array v2, v3, [F

    .line 2203
    .local v2, "result":[F
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2204
    return-object v2
.end method

.method public static copyOfRange([III)[I
    .locals 5
    .param p0, "original"    # [I
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2223
    if-le p1, p2, :cond_0

    .line 2224
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2226
    :cond_0
    array-length v1, p0

    .line 2227
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2228
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2230
    :cond_2
    sub-int v3, p2, p1

    .line 2231
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2232
    .local v0, "copyLength":I
    new-array v2, v3, [I

    .line 2233
    .local v2, "result":[I
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2234
    return-object v2
.end method

.method public static copyOfRange([JII)[J
    .locals 5
    .param p0, "original"    # [J
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2253
    if-le p1, p2, :cond_0

    .line 2254
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2256
    :cond_0
    array-length v1, p0

    .line 2257
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2258
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2260
    :cond_2
    sub-int v3, p2, p1

    .line 2261
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2262
    .local v0, "copyLength":I
    new-array v2, v3, [J

    .line 2263
    .local v2, "result":[J
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2264
    return-object v2
.end method

.method public static copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;
    .locals 5
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;II)[TT;"
        }
    .end annotation

    .prologue
    .line 2314
    array-length v1, p0

    .line 2315
    .local v1, "originalLength":I
    if-le p1, p2, :cond_0

    .line 2316
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2318
    :cond_0
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2319
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2321
    :cond_2
    sub-int v3, p2, p1

    .line 2322
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2323
    .local v0, "copyLength":I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    .line 2324
    .local v2, "result":[Ljava/lang/Object;
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2325
    return-object v2
.end method

.method public static copyOfRange([Ljava/lang/Object;IILjava/lang/Class;)[Ljava/lang/Object;
    .locals 5
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "U:",
            "Ljava/lang/Object;",
            ">([TU;II",
            "Ljava/lang/Class",
            "<+[TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .line 2346
    .local p3, "newType":Ljava/lang/Class;, "Ljava/lang/Class<+[TT;>;"
    if-le p1, p2, :cond_0

    .line 2347
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2349
    :cond_0
    array-length v1, p0

    .line 2350
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2351
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2353
    :cond_2
    sub-int v3, p2, p1

    .line 2354
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2355
    .local v0, "copyLength":I
    invoke-virtual {p3}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    .line 2356
    .local v2, "result":[Ljava/lang/Object;
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2357
    return-object v2
.end method

.method public static copyOfRange([SII)[S
    .locals 5
    .param p0, "original"    # [S
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2283
    if-le p1, p2, :cond_0

    .line 2284
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2286
    :cond_0
    array-length v1, p0

    .line 2287
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2288
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2290
    :cond_2
    sub-int v3, p2, p1

    .line 2291
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2292
    .local v0, "copyLength":I
    new-array v2, v3, [S

    .line 2293
    .local v2, "result":[S
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2294
    return-object v2
.end method

.method public static copyOfRange([ZII)[Z
    .locals 5
    .param p0, "original"    # [Z
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 2073
    if-le p1, p2, :cond_0

    .line 2074
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 2076
    :cond_0
    array-length v1, p0

    .line 2077
    .local v1, "originalLength":I
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 2078
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 2080
    :cond_2
    sub-int v3, p2, p1

    .line 2081
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 2082
    .local v0, "copyLength":I
    new-array v2, v3, [Z

    .line 2083
    .local v2, "result":[Z
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2084
    return-object v2
.end method

.method public static deepEquals([Ljava/lang/Object;[Ljava/lang/Object;)Z
    .locals 7
    .param p0, "array1"    # [Ljava/lang/Object;
    .param p1, "array2"    # [Ljava/lang/Object;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1367
    if-ne p0, p1, :cond_1

    .line 1380
    :cond_0
    :goto_0
    return v3

    .line 1370
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v5, p0

    array-length v6, p1

    if-eq v5, v6, :cond_3

    :cond_2
    move v3, v4

    .line 1371
    goto :goto_0

    .line 1373
    :cond_3
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v5, p0

    if-ge v2, v5, :cond_0

    .line 1374
    aget-object v0, p0, v2

    .local v0, "e1":Ljava/lang/Object;
    aget-object v1, p1, v2

    .line 1376
    .local v1, "e2":Ljava/lang/Object;
    invoke-static {v0, v1}, Lnet/tsz/afinal/core/Arrays;->deepEqualsElements(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_4

    move v3, v4

    .line 1377
    goto :goto_0

    .line 1373
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private static deepEqualsElements(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 4
    .param p0, "e1"    # Ljava/lang/Object;
    .param p1, "e2"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x0

    .line 1386
    if-ne p0, p1, :cond_1

    .line 1387
    const/4 v2, 0x1

    .line 1433
    .end local p0    # "e1":Ljava/lang/Object;
    .end local p1    # "e2":Ljava/lang/Object;
    .local v0, "cl1":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .local v1, "cl2":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_0
    :goto_0
    return v2

    .line 1390
    .end local v0    # "cl1":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "cl2":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_1
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    .line 1394
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    .line 1395
    .restart local v0    # "cl1":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    .line 1397
    .restart local v1    # "cl2":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-ne v0, v1, :cond_0

    .line 1401
    if-nez v0, :cond_2

    .line 1402
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    goto :goto_0

    .line 1408
    :cond_2
    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v2

    if-nez v2, :cond_3

    .line 1409
    check-cast p0, [Ljava/lang/Object;

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->deepEquals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v2

    goto :goto_0

    .line 1412
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_3
    sget-object v2, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1413
    check-cast p0, [I

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [I

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([I[I)Z

    move-result v2

    goto :goto_0

    .line 1415
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_4
    sget-object v2, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1416
    check-cast p0, [C

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [C

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([C[C)Z

    move-result v2

    goto :goto_0

    .line 1418
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_5
    sget-object v2, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1419
    check-cast p0, [Z

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [Z

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([Z[Z)Z

    move-result v2

    goto :goto_0

    .line 1421
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_6
    sget-object v2, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 1422
    check-cast p0, [B

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [B

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([B[B)Z

    move-result v2

    goto :goto_0

    .line 1424
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_7
    sget-object v2, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 1425
    check-cast p0, [J

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [J

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([J[J)Z

    move-result v2

    goto/16 :goto_0

    .line 1427
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_8
    sget-object v2, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 1428
    check-cast p0, [F

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [F

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([F[F)Z

    move-result v2

    goto/16 :goto_0

    .line 1430
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_9
    sget-object v2, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1431
    check-cast p0, [D

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [D

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([D[D)Z

    move-result v2

    goto/16 :goto_0

    .line 1433
    .restart local p0    # "e1":Ljava/lang/Object;
    .restart local p1    # "e2":Ljava/lang/Object;
    :cond_a
    check-cast p0, [S

    .end local p0    # "e1":Ljava/lang/Object;
    check-cast p1, [S

    .end local p1    # "e2":Ljava/lang/Object;
    invoke-static {p0, p1}, Lnet/tsz/afinal/core/Arrays;->equals([S[S)Z

    move-result v2

    goto/16 :goto_0
.end method

.method public static deepHashCode([Ljava/lang/Object;)I
    .locals 6
    .param p0, "array"    # [Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 1036
    if-nez p0, :cond_1

    move v2, v3

    .line 1044
    :cond_0
    return v2

    .line 1039
    :cond_1
    const/4 v2, 0x1

    .line 1040
    .local v2, "hashCode":I
    array-length v4, p0

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, p0, v3

    .line 1041
    .local v0, "element":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->deepHashCodeElement(Ljava/lang/Object;)I

    move-result v1

    .line 1042
    .local v1, "elementHashCode":I
    mul-int/lit8 v5, v2, 0x1f

    add-int v2, v5, v1

    .line 1040
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method private static deepHashCodeElement(Ljava/lang/Object;)I
    .locals 2
    .param p0, "element"    # Ljava/lang/Object;

    .prologue
    .line 1049
    if-nez p0, :cond_0

    .line 1050
    const/4 v1, 0x0

    .line 1086
    .end local p0    # "element":Ljava/lang/Object;
    .local v0, "cl":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    return v1

    .line 1053
    .end local v0    # "cl":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    .line 1055
    .restart local v0    # "cl":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v0, :cond_1

    .line 1056
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_0

    .line 1062
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Class;->isPrimitive()Z

    move-result v1

    if-nez v1, :cond_2

    .line 1063
    check-cast p0, [Ljava/lang/Object;

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->deepHashCode([Ljava/lang/Object;)I

    move-result v1

    goto :goto_0

    .line 1065
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_2
    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1066
    check-cast p0, [I

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([I)I

    move-result v1

    goto :goto_0

    .line 1068
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_3
    sget-object v1, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1069
    check-cast p0, [C

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([C)I

    move-result v1

    goto :goto_0

    .line 1071
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_4
    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 1072
    check-cast p0, [Z

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([Z)I

    move-result v1

    goto :goto_0

    .line 1074
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_5
    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 1075
    check-cast p0, [B

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([B)I

    move-result v1

    goto :goto_0

    .line 1077
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_6
    sget-object v1, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 1078
    check-cast p0, [J

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([J)I

    move-result v1

    goto :goto_0

    .line 1080
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_7
    sget-object v1, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 1081
    check-cast p0, [F

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([F)I

    move-result v1

    goto :goto_0

    .line 1083
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_8
    sget-object v1, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 1084
    check-cast p0, [D

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([D)I

    move-result v1

    goto/16 :goto_0

    .line 1086
    .restart local p0    # "element":Ljava/lang/Object;
    :cond_9
    check-cast p0, [S

    .end local p0    # "element":Ljava/lang/Object;
    invoke-static {p0}, Lnet/tsz/afinal/core/Arrays;->hashCode([S)I

    move-result v1

    goto/16 :goto_0
.end method

.method public static deepToString([Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [Ljava/lang/Object;

    .prologue
    .line 1743
    if-nez p0, :cond_0

    .line 1744
    const-string v1, "null"

    .line 1749
    :goto_0
    return-object v1

    .line 1747
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    array-length v1, p0

    mul-int/lit8 v1, v1, 0x9

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1748
    .local v0, "buf":Ljava/lang/StringBuilder;
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {p0, v1, v0}, Lnet/tsz/afinal/core/Arrays;->deepToStringImpl([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    .line 1749
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private static deepToStringImpl([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/StringBuilder;)V
    .locals 8
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "origArrays"    # [Ljava/lang/Object;
    .param p2, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v7, 0x0

    .line 1768
    if-nez p0, :cond_0

    .line 1769
    const-string v6, "null"

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1835
    :goto_0
    return-void

    .line 1773
    :cond_0
    const/16 v6, 0x5b

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1775
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v6, p0

    if-lt v3, v6, :cond_1

    .line 1834
    const/16 v6, 0x5d

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 1776
    :cond_1
    if-eqz v3, :cond_2

    .line 1777
    const-string v6, ", "

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1780
    :cond_2
    aget-object v0, p0, v3

    .line 1781
    .local v0, "elem":Ljava/lang/Object;
    if-nez v0, :cond_3

    .line 1783
    const-string v6, "null"

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1775
    .end local v0    # "elem":Ljava/lang/Object;
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 1786
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_3
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 1787
    .local v1, "elemClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v1}, Ljava/lang/Class;->isArray()Z

    move-result v6

    if-eqz v6, :cond_f

    .line 1791
    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    .line 1792
    .local v2, "elemElemClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->isPrimitive()Z

    move-result v6

    if-eqz v6, :cond_c

    .line 1794
    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 1795
    check-cast v0, [Z

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([Z)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1796
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_4
    sget-object v6, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 1797
    check-cast v0, [B

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([B)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1798
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_5
    sget-object v6, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 1799
    check-cast v0, [C

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([C)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1800
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_6
    sget-object v6, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 1801
    check-cast v0, [D

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([D)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1802
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_7
    sget-object v6, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 1803
    check-cast v0, [F

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([F)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1804
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_8
    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 1805
    check-cast v0, [I

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 1806
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_9
    sget-object v6, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 1807
    check-cast v0, [J

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 1808
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_a
    sget-object v6, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-virtual {v6, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 1809
    check-cast v0, [S

    .end local v0    # "elem":Ljava/lang/Object;
    invoke-static {v0}, Lnet/tsz/afinal/core/Arrays;->toString([S)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 1812
    .restart local v0    # "elem":Ljava/lang/Object;
    :cond_b
    new-instance v6, Ljava/lang/AssertionError;

    invoke-direct {v6}, Ljava/lang/AssertionError;-><init>()V

    throw v6

    .line 1816
    :cond_c
    sget-boolean v6, Lnet/tsz/afinal/core/Arrays;->$assertionsDisabled:Z

    if-nez v6, :cond_d

    instance-of v6, v0, [Ljava/lang/Object;

    if-nez v6, :cond_d

    new-instance v6, Ljava/lang/AssertionError;

    invoke-direct {v6}, Ljava/lang/AssertionError;-><init>()V

    throw v6

    .line 1817
    :cond_d
    invoke-static {p1, v0}, Lnet/tsz/afinal/core/Arrays;->deepToStringImplContains([Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 1818
    const-string v6, "[...]"

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    :cond_e
    move-object v4, v0

    .line 1820
    check-cast v4, [Ljava/lang/Object;

    .line 1821
    .local v4, "newArray":[Ljava/lang/Object;
    array-length v6, p1

    add-int/lit8 v6, v6, 0x1

    new-array v5, v6, [Ljava/lang/Object;

    .line 1823
    .local v5, "newOrigArrays":[Ljava/lang/Object;
    array-length v6, p1

    .line 1822
    invoke-static {p1, v7, v5, v7, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1824
    array-length v6, p1

    aput-object v4, v5, v6

    .line 1826
    invoke-static {v4, v5, p2}, Lnet/tsz/afinal/core/Arrays;->deepToStringImpl([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    goto/16 :goto_2

    .line 1830
    .end local v2    # "elemElemClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "newArray":[Ljava/lang/Object;
    .end local v5    # "newOrigArrays":[Ljava/lang/Object;
    :cond_f
    aget-object v6, p0, v3

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto/16 :goto_2
.end method

.method private static deepToStringImplContains([Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 4
    .param p0, "origArrays"    # [Ljava/lang/Object;
    .param p1, "array"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 1850
    if-eqz p0, :cond_0

    array-length v2, p0

    if-nez v2, :cond_1

    .line 1858
    :cond_0
    :goto_0
    return v1

    .line 1853
    :cond_1
    array-length v3, p0

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_0

    aget-object v0, p0, v2

    .line 1854
    .local v0, "element":Ljava/lang/Object;
    if-ne v0, p1, :cond_2

    .line 1855
    const/4 v1, 0x1

    goto :goto_0

    .line 1853
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public static equals([B[B)Z
    .locals 5
    .param p0, "array1"    # [B
    .param p1, "array2"    # [B

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1101
    if-ne p0, p1, :cond_1

    .line 1112
    :cond_0
    :goto_0
    return v1

    .line 1104
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1105
    goto :goto_0

    .line 1107
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1108
    aget-byte v3, p0, v0

    aget-byte v4, p1, v0

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1109
    goto :goto_0

    .line 1107
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([C[C)Z
    .locals 5
    .param p0, "array1"    # [C
    .param p1, "array2"    # [C

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1153
    if-ne p0, p1, :cond_1

    .line 1164
    :cond_0
    :goto_0
    return v1

    .line 1156
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1157
    goto :goto_0

    .line 1159
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1160
    aget-char v3, p0, v0

    aget-char v4, p1, v0

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1161
    goto :goto_0

    .line 1159
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([D[D)Z
    .locals 7
    .param p0, "array1"    # [D
    .param p1, "array2"    # [D

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1262
    if-ne p0, p1, :cond_1

    .line 1274
    :cond_0
    :goto_0
    return v1

    .line 1265
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1266
    goto :goto_0

    .line 1268
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1269
    aget-wide v3, p0, v0

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    .line 1270
    aget-wide v5, p1, v0

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    .line 1269
    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    move v1, v2

    .line 1271
    goto :goto_0

    .line 1268
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([F[F)Z
    .locals 5
    .param p0, "array1"    # [F
    .param p1, "array2"    # [F

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1233
    if-ne p0, p1, :cond_1

    .line 1245
    :cond_0
    :goto_0
    return v1

    .line 1236
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1237
    goto :goto_0

    .line 1239
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1240
    aget v3, p0, v0

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    .line 1241
    aget v4, p1, v0

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    .line 1240
    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1242
    goto :goto_0

    .line 1239
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([I[I)Z
    .locals 5
    .param p0, "array1"    # [I
    .param p1, "array2"    # [I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1179
    if-ne p0, p1, :cond_1

    .line 1190
    :cond_0
    :goto_0
    return v1

    .line 1182
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1183
    goto :goto_0

    .line 1185
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1186
    aget v3, p0, v0

    aget v4, p1, v0

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1187
    goto :goto_0

    .line 1185
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([J[J)Z
    .locals 7
    .param p0, "array1"    # [J
    .param p1, "array2"    # [J

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1205
    if-ne p0, p1, :cond_1

    .line 1216
    :cond_0
    :goto_0
    return v1

    .line 1208
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1209
    goto :goto_0

    .line 1211
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1212
    aget-wide v3, p0, v0

    aget-wide v5, p1, v0

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    move v1, v2

    .line 1213
    goto :goto_0

    .line 1211
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([Ljava/lang/Object;[Ljava/lang/Object;)Z
    .locals 7
    .param p0, "array1"    # [Ljava/lang/Object;
    .param p1, "array2"    # [Ljava/lang/Object;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1315
    if-ne p0, p1, :cond_1

    .line 1327
    :cond_0
    :goto_0
    return v3

    .line 1318
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v5, p0

    array-length v6, p1

    if-eq v5, v6, :cond_3

    :cond_2
    move v3, v4

    .line 1319
    goto :goto_0

    .line 1321
    :cond_3
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v5, p0

    if-ge v2, v5, :cond_0

    .line 1322
    aget-object v0, p0, v2

    .local v0, "e1":Ljava/lang/Object;
    aget-object v1, p1, v2

    .line 1323
    .local v1, "e2":Ljava/lang/Object;
    if-nez v0, :cond_5

    if-eqz v1, :cond_6

    :cond_4
    move v3, v4

    .line 1324
    goto :goto_0

    .line 1323
    :cond_5
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1321
    :cond_6
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public static equals([S[S)Z
    .locals 5
    .param p0, "array1"    # [S
    .param p1, "array2"    # [S

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1127
    if-ne p0, p1, :cond_1

    .line 1138
    :cond_0
    :goto_0
    return v1

    .line 1130
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1131
    goto :goto_0

    .line 1133
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1134
    aget-short v3, p0, v0

    aget-short v4, p1, v0

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1135
    goto :goto_0

    .line 1133
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static equals([Z[Z)Z
    .locals 5
    .param p0, "array1"    # [Z
    .param p1, "array2"    # [Z

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1289
    if-ne p0, p1, :cond_1

    .line 1300
    :cond_0
    :goto_0
    return v1

    .line 1292
    :cond_1
    if-eqz p0, :cond_2

    if-eqz p1, :cond_2

    array-length v3, p0

    array-length v4, p1

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 1293
    goto :goto_0

    .line 1295
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 1296
    aget-boolean v3, p0, v0

    aget-boolean v4, p1, v0

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 1297
    goto :goto_0

    .line 1295
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static fill([BB)V
    .locals 2
    .param p0, "array"    # [B
    .param p1, "value"    # B

    .prologue
    .line 679
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-lt v0, v1, :cond_0

    .line 682
    return-void

    .line 680
    :cond_0
    aput-byte p1, p0, v0

    .line 679
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static fill([II)V
    .locals 2
    .param p0, "array"    # [I
    .param p1, "value"    # I

    .prologue
    .line 695
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-lt v0, v1, :cond_0

    .line 698
    return-void

    .line 696
    :cond_0
    aput p1, p0, v0

    .line 695
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static fill([Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .param p0, "array"    # [Ljava/lang/Object;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 727
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-lt v0, v1, :cond_0

    .line 730
    return-void

    .line 728
    :cond_0
    aput-object p1, p0, v0

    .line 727
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static fill([ZZ)V
    .locals 2
    .param p0, "array"    # [Z
    .param p1, "value"    # Z

    .prologue
    .line 711
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-lt v0, v1, :cond_0

    .line 714
    return-void

    .line 712
    :cond_0
    aput-boolean p1, p0, v0

    .line 711
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static hashCode([B)I
    .locals 5
    .param p0, "array"    # [B

    .prologue
    const/4 v2, 0x0

    .line 863
    if-nez p0, :cond_1

    move v1, v2

    .line 871
    :cond_0
    return v1

    .line 866
    :cond_1
    const/4 v1, 0x1

    .line 867
    .local v1, "hashCode":I
    array-length v3, p0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-byte v0, p0, v2

    .line 869
    .local v0, "element":B
    mul-int/lit8 v4, v1, 0x1f

    add-int v1, v4, v0

    .line 867
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static hashCode([C)I
    .locals 5
    .param p0, "array"    # [C

    .prologue
    const/4 v2, 0x0

    .line 835
    if-nez p0, :cond_1

    move v1, v2

    .line 843
    :cond_0
    return v1

    .line 838
    :cond_1
    const/4 v1, 0x1

    .line 839
    .local v1, "hashCode":I
    array-length v3, p0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-char v0, p0, v2

    .line 841
    .local v0, "element":C
    mul-int/lit8 v4, v1, 0x1f

    add-int v1, v4, v0

    .line 839
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static hashCode([D)I
    .locals 10
    .param p0, "array"    # [D

    .prologue
    const/4 v5, 0x0

    .line 954
    if-nez p0, :cond_1

    move v2, v5

    .line 967
    :cond_0
    return v2

    .line 957
    :cond_1
    const/4 v2, 0x1

    .line 959
    .local v2, "hashCode":I
    array-length v6, p0

    :goto_0
    if-ge v5, v6, :cond_0

    aget-wide v0, p0, v5

    .line 960
    .local v0, "element":D
    invoke-static {v0, v1}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    .line 965
    .local v3, "v":J
    mul-int/lit8 v7, v2, 0x1f

    const/16 v8, 0x20

    ushr-long v8, v3, v8

    xor-long/2addr v8, v3

    long-to-int v8, v8

    add-int v2, v7, v8

    .line 959
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method

.method public static hashCode([F)I
    .locals 6
    .param p0, "array"    # [F

    .prologue
    const/4 v2, 0x0

    .line 923
    if-nez p0, :cond_1

    move v1, v2

    .line 934
    :cond_0
    return v1

    .line 926
    :cond_1
    const/4 v1, 0x1

    .line 927
    .local v1, "hashCode":I
    array-length v3, p0

    :goto_0
    if-ge v2, v3, :cond_0

    aget v0, p0, v2

    .line 932
    .local v0, "element":F
    mul-int/lit8 v4, v1, 0x1f

    invoke-static {v0}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v5

    add-int v1, v4, v5

    .line 927
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static hashCode([I)I
    .locals 5
    .param p0, "array"    # [I

    .prologue
    const/4 v2, 0x0

    .line 779
    if-nez p0, :cond_1

    move v1, v2

    .line 787
    :cond_0
    return v1

    .line 782
    :cond_1
    const/4 v1, 0x1

    .line 783
    .local v1, "hashCode":I
    array-length v3, p0

    :goto_0
    if-ge v2, v3, :cond_0

    aget v0, p0, v2

    .line 785
    .local v0, "element":I
    mul-int/lit8 v4, v1, 0x1f

    add-int v1, v4, v0

    .line 783
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static hashCode([J)I
    .locals 8
    .param p0, "array"    # [J

    .prologue
    const/4 v3, 0x0

    .line 891
    if-nez p0, :cond_1

    move v2, v3

    .line 903
    :cond_0
    return v2

    .line 894
    :cond_1
    const/4 v2, 0x1

    .line 895
    .local v2, "hashCode":I
    array-length v4, p0

    :goto_0
    if-ge v3, v4, :cond_0

    aget-wide v0, p0, v3

    .line 900
    .local v0, "elementValue":J
    mul-int/lit8 v5, v2, 0x1f

    .line 901
    const/16 v6, 0x20

    ushr-long v6, v0, v6

    xor-long/2addr v6, v0

    long-to-int v6, v6

    .line 900
    add-int v2, v5, v6

    .line 895
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public static hashCode([Ljava/lang/Object;)I
    .locals 6
    .param p0, "array"    # [Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 991
    if-nez p0, :cond_1

    move v2, v3

    .line 1005
    :cond_0
    return v2

    .line 994
    :cond_1
    const/4 v2, 0x1

    .line 995
    .local v2, "hashCode":I
    array-length v4, p0

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, p0, v3

    .line 998
    .local v0, "element":Ljava/lang/Object;
    if-nez v0, :cond_2

    .line 999
    const/4 v1, 0x0

    .line 1003
    .local v1, "elementHashCode":I
    :goto_1
    mul-int/lit8 v5, v2, 0x1f

    add-int v2, v5, v1

    .line 995
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1001
    .end local v1    # "elementHashCode":I
    :cond_2
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    .restart local v1    # "elementHashCode":I
    goto :goto_1
.end method

.method public static hashCode([S)I
    .locals 5
    .param p0, "array"    # [S

    .prologue
    const/4 v2, 0x0

    .line 807
    if-nez p0, :cond_1

    move v1, v2

    .line 815
    :cond_0
    return v1

    .line 810
    :cond_1
    const/4 v1, 0x1

    .line 811
    .local v1, "hashCode":I
    array-length v3, p0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-short v0, p0, v2

    .line 813
    .local v0, "element":S
    mul-int/lit8 v4, v1, 0x1f

    add-int v1, v4, v0

    .line 811
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static hashCode([Z)I
    .locals 6
    .param p0, "array"    # [Z

    .prologue
    const/4 v2, 0x0

    .line 751
    if-nez p0, :cond_1

    move v1, v2

    .line 759
    :cond_0
    return v1

    .line 754
    :cond_1
    const/4 v1, 0x1

    .line 755
    .local v1, "hashCode":I
    array-length v4, p0

    move v3, v2

    :goto_0
    if-ge v3, v4, :cond_0

    aget-boolean v0, p0, v3

    .line 757
    .local v0, "element":Z
    mul-int/lit8 v5, v1, 0x1f

    if-eqz v0, :cond_2

    const/16 v2, 0x4cf

    :goto_1
    add-int v1, v5, v2

    .line 755
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_0

    .line 757
    :cond_2
    const/16 v2, 0x4d5

    goto :goto_1
.end method

.method public static toString([B)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [B

    .prologue
    .line 1497
    if-nez p0, :cond_0

    .line 1498
    const-string v2, "null"

    .line 1511
    :goto_0
    return-object v2

    .line 1500
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1501
    const-string v2, "[]"

    goto :goto_0

    .line 1503
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x6

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1504
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1505
    const/4 v2, 0x0

    aget-byte v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1506
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1510
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1511
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1507
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1508
    aget-byte v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1506
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([C)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [C

    .prologue
    .line 1527
    if-nez p0, :cond_0

    .line 1528
    const-string v2, "null"

    .line 1541
    :goto_0
    return-object v2

    .line 1530
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1531
    const-string v2, "[]"

    goto :goto_0

    .line 1533
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1534
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1535
    const/4 v2, 0x0

    aget-char v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1536
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1540
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1541
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1537
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1538
    aget-char v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1536
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([D)Ljava/lang/String;
    .locals 4
    .param p0, "array"    # [D

    .prologue
    .line 1557
    if-nez p0, :cond_0

    .line 1558
    const-string v2, "null"

    .line 1571
    :goto_0
    return-object v2

    .line 1560
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1561
    const-string v2, "[]"

    goto :goto_0

    .line 1563
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x7

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1564
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1565
    const/4 v2, 0x0

    aget-wide v2, p0, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 1566
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1570
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1571
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1567
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1568
    aget-wide v2, p0, v0

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 1566
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([F)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [F

    .prologue
    .line 1587
    if-nez p0, :cond_0

    .line 1588
    const-string v2, "null"

    .line 1601
    :goto_0
    return-object v2

    .line 1590
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1591
    const-string v2, "[]"

    goto :goto_0

    .line 1593
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x7

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1594
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1595
    const/4 v2, 0x0

    aget v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 1596
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1600
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1601
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1597
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1598
    aget v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 1596
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([I)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [I

    .prologue
    .line 1617
    if-nez p0, :cond_0

    .line 1618
    const-string v2, "null"

    .line 1631
    :goto_0
    return-object v2

    .line 1620
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1621
    const-string v2, "[]"

    goto :goto_0

    .line 1623
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x6

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1624
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1625
    const/4 v2, 0x0

    aget v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1626
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1630
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1631
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1627
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1628
    aget v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1626
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([J)Ljava/lang/String;
    .locals 4
    .param p0, "array"    # [J

    .prologue
    .line 1647
    if-nez p0, :cond_0

    .line 1648
    const-string v2, "null"

    .line 1661
    :goto_0
    return-object v2

    .line 1650
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1651
    const-string v2, "[]"

    goto :goto_0

    .line 1653
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x6

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1654
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1655
    const/4 v2, 0x0

    aget-wide v2, p0, v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 1656
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1660
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1661
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1657
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1658
    aget-wide v2, p0, v0

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 1656
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [Ljava/lang/Object;

    .prologue
    .line 1707
    if-nez p0, :cond_0

    .line 1708
    const-string v2, "null"

    .line 1721
    :goto_0
    return-object v2

    .line 1710
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1711
    const-string v2, "[]"

    goto :goto_0

    .line 1713
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x7

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1714
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1715
    const/4 v2, 0x0

    aget-object v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 1716
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1720
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1721
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1717
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1718
    aget-object v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 1716
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([S)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [S

    .prologue
    .line 1677
    if-nez p0, :cond_0

    .line 1678
    const-string v2, "null"

    .line 1691
    :goto_0
    return-object v2

    .line 1680
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1681
    const-string v2, "[]"

    goto :goto_0

    .line 1683
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x6

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1684
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1685
    const/4 v2, 0x0

    aget-short v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1686
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1690
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1691
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1687
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1688
    aget-short v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1686
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static toString([Z)Ljava/lang/String;
    .locals 3
    .param p0, "array"    # [Z

    .prologue
    .line 1467
    if-nez p0, :cond_0

    .line 1468
    const-string v2, "null"

    .line 1481
    :goto_0
    return-object v2

    .line 1470
    :cond_0
    array-length v2, p0

    if-nez v2, :cond_1

    .line 1471
    const-string v2, "[]"

    goto :goto_0

    .line 1473
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v2, p0

    mul-int/lit8 v2, v2, 0x7

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1474
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/16 v2, 0x5b

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1475
    const/4 v2, 0x0

    aget-boolean v2, p0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 1476
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    array-length v2, p0

    if-lt v0, v2, :cond_2

    .line 1480
    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1481
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1477
    :cond_2
    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1478
    aget-boolean v2, p0, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 1476
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method
