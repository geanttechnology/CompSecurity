.class public final Lcom/google/zxing/common/detector/WhiteRectangleDetector;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final CORR:I = 0x1

.field private static final INIT_SIZE:I = 0x1e


# instance fields
.field private final downInit:I

.field private final height:I

.field private final image:Lcom/google/zxing/common/BitMatrix;

.field private final leftInit:I

.field private final rightInit:I

.field private final upInit:I

.field private final width:I


# direct methods
.method public constructor <init>(Lcom/google/zxing/common/BitMatrix;)V
    .locals 2

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->image:Lcom/google/zxing/common/BitMatrix;

    .line 51
    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    .line 52
    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v0

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    .line 53
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    add-int/lit8 v0, v0, -0x1e

    shr-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->leftInit:I

    .line 54
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    add-int/lit8 v0, v0, 0x1e

    shr-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->rightInit:I

    .line 55
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    add-int/lit8 v0, v0, -0x1e

    shr-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->upInit:I

    .line 56
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    add-int/lit8 v0, v0, 0x1e

    shr-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->downInit:I

    .line 57
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->upInit:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->leftInit:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->downInit:I

    iget v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    if-ge v0, v1, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->rightInit:I

    iget v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    if-lt v0, v1, :cond_1

    .line 58
    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 60
    :cond_1
    return-void
.end method

.method public constructor <init>(Lcom/google/zxing/common/BitMatrix;III)V
    .locals 2

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->image:Lcom/google/zxing/common/BitMatrix;

    .line 67
    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    .line 68
    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v0

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    .line 69
    shr-int/lit8 v0, p2, 0x1

    .line 70
    sub-int v1, p3, v0

    iput v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->leftInit:I

    .line 71
    add-int v1, p3, v0

    iput v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->rightInit:I

    .line 72
    sub-int v1, p4, v0

    iput v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->upInit:I

    .line 73
    add-int/2addr v0, p4

    iput v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->downInit:I

    .line 74
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->upInit:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->leftInit:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->downInit:I

    iget v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    if-ge v0, v1, :cond_0

    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->rightInit:I

    iget v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    if-lt v0, v1, :cond_1

    .line 75
    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 77
    :cond_1
    return-void
.end method

.method private centerEdges(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)[Lcom/google/zxing/ResultPoint;
    .locals 12

    .prologue
    .line 281
    invoke-virtual {p1}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v1

    .line 282
    invoke-virtual {p1}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v2

    .line 283
    invoke-virtual {p2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v3

    .line 284
    invoke-virtual {p2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v4

    .line 285
    invoke-virtual {p3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    .line 286
    invoke-virtual {p3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v6

    .line 287
    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v7

    .line 288
    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v8

    .line 290
    iget v0, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    int-to-float v0, v0

    const/high16 v9, 0x40000000    # 2.0f

    div-float/2addr v0, v9

    cmpg-float v0, v1, v0

    if-gez v0, :cond_0

    .line 291
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/google/zxing/ResultPoint;

    const/4 v9, 0x0

    new-instance v10, Lcom/google/zxing/ResultPoint;

    const/high16 v11, 0x3f800000    # 1.0f

    sub-float/2addr v7, v11

    const/high16 v11, 0x3f800000    # 1.0f

    add-float/2addr v8, v11

    invoke-direct {v10, v7, v8}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v10, v0, v9

    const/4 v7, 0x1

    new-instance v8, Lcom/google/zxing/ResultPoint;

    const/high16 v9, 0x3f800000    # 1.0f

    add-float/2addr v3, v9

    const/high16 v9, 0x3f800000    # 1.0f

    add-float/2addr v4, v9

    invoke-direct {v8, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v8, v0, v7

    const/4 v3, 0x2

    new-instance v4, Lcom/google/zxing/ResultPoint;

    const/high16 v7, 0x3f800000    # 1.0f

    sub-float/2addr v5, v7

    const/high16 v7, 0x3f800000    # 1.0f

    sub-float/2addr v6, v7

    invoke-direct {v4, v5, v6}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v4, v0, v3

    const/4 v3, 0x3

    new-instance v4, Lcom/google/zxing/ResultPoint;

    const/high16 v5, 0x3f800000    # 1.0f

    add-float/2addr v1, v5

    const/high16 v5, 0x3f800000    # 1.0f

    sub-float/2addr v2, v5

    invoke-direct {v4, v1, v2}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v4, v0, v3

    .line 297
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/google/zxing/ResultPoint;

    const/4 v9, 0x0

    new-instance v10, Lcom/google/zxing/ResultPoint;

    const/high16 v11, 0x3f800000    # 1.0f

    add-float/2addr v7, v11

    const/high16 v11, 0x3f800000    # 1.0f

    add-float/2addr v8, v11

    invoke-direct {v10, v7, v8}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v10, v0, v9

    const/4 v7, 0x1

    new-instance v8, Lcom/google/zxing/ResultPoint;

    const/high16 v9, 0x3f800000    # 1.0f

    add-float/2addr v3, v9

    const/high16 v9, 0x3f800000    # 1.0f

    sub-float/2addr v4, v9

    invoke-direct {v8, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v8, v0, v7

    const/4 v3, 0x2

    new-instance v4, Lcom/google/zxing/ResultPoint;

    const/high16 v7, 0x3f800000    # 1.0f

    sub-float/2addr v5, v7

    const/high16 v7, 0x3f800000    # 1.0f

    add-float/2addr v6, v7

    invoke-direct {v4, v5, v6}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v4, v0, v3

    const/4 v3, 0x3

    new-instance v4, Lcom/google/zxing/ResultPoint;

    const/high16 v5, 0x3f800000    # 1.0f

    sub-float/2addr v1, v5

    const/high16 v5, 0x3f800000    # 1.0f

    sub-float/2addr v2, v5

    invoke-direct {v4, v1, v2}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v4, v0, v3

    goto :goto_0
.end method

.method private containsBlackPoint(IIIZ)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 316
    if-eqz p4, :cond_2

    .line 317
    :goto_0
    if-gt p1, p2, :cond_3

    .line 318
    iget-object v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->image:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1, p1, p3}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 330
    :goto_1
    return v0

    .line 317
    :cond_0
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 323
    :cond_1
    add-int/lit8 p1, p1, 0x1

    :cond_2
    if-gt p1, p2, :cond_3

    .line 324
    iget-object v1, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->image:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1, p3, p1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v1

    if-eqz v1, :cond_1

    goto :goto_1

    .line 330
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private getBlackPointOnSegment(FFFF)Lcom/google/zxing/ResultPoint;
    .locals 7

    .prologue
    .line 244
    invoke-static {p1, p2, p3, p4}, Lcom/google/zxing/common/detector/MathUtils;->distance(FFFF)F

    move-result v0

    invoke-static {v0}, Lcom/google/zxing/common/detector/MathUtils;->round(F)I

    move-result v1

    .line 245
    sub-float v0, p3, p1

    int-to-float v2, v1

    div-float v2, v0, v2

    .line 246
    sub-float v0, p4, p2

    int-to-float v3, v1

    div-float v3, v0, v3

    .line 248
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    .line 249
    int-to-float v4, v0

    mul-float/2addr v4, v2

    add-float/2addr v4, p1

    invoke-static {v4}, Lcom/google/zxing/common/detector/MathUtils;->round(F)I

    move-result v4

    .line 250
    int-to-float v5, v0

    mul-float/2addr v5, v3

    add-float/2addr v5, p2

    invoke-static {v5}, Lcom/google/zxing/common/detector/MathUtils;->round(F)I

    move-result v5

    .line 251
    iget-object v6, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->image:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v6, v4, v5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 252
    new-instance v0, Lcom/google/zxing/ResultPoint;

    int-to-float v1, v4

    int-to-float v2, v5

    invoke-direct {v0, v1, v2}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    .line 255
    :goto_1
    return-object v0

    .line 248
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 255
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public detect()[Lcom/google/zxing/ResultPoint;
    .locals 13

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 95
    iget v7, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->leftInit:I

    .line 96
    iget v6, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->rightInit:I

    .line 97
    iget v5, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->upInit:I

    .line 98
    iget v4, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->downInit:I

    move v0, v3

    move v9, v1

    .line 103
    :cond_0
    :goto_0
    if-eqz v9, :cond_1a

    move v9, v1

    move v8, v3

    .line 111
    :cond_1
    :goto_1
    if-eqz v9, :cond_2

    iget v9, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    if-ge v6, v9, :cond_2

    .line 112
    invoke-direct {p0, v5, v4, v6, v3}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->containsBlackPoint(IIIZ)Z

    move-result v9

    .line 113
    if-eqz v9, :cond_1

    .line 114
    add-int/lit8 v6, v6, 0x1

    move v8, v1

    .line 115
    goto :goto_1

    .line 119
    :cond_2
    iget v9, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->width:I

    if-lt v6, v9, :cond_3

    move v3, v1

    move v8, v6

    move v6, v4

    move v4, v7

    move v7, v5

    .line 181
    :goto_2
    if-nez v3, :cond_16

    if-eqz v0, :cond_16

    .line 183
    sub-int v9, v8, v4

    move v3, v1

    move-object v0, v2

    .line 186
    :goto_3
    if-ge v3, v9, :cond_19

    .line 187
    int-to-float v0, v4

    sub-int v5, v6, v3

    int-to-float v5, v5

    add-int v10, v4, v3

    int-to-float v10, v10

    int-to-float v11, v6

    invoke-direct {p0, v0, v5, v10, v11}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->getBlackPointOnSegment(FFFF)Lcom/google/zxing/ResultPoint;

    move-result-object v0

    .line 188
    if-eqz v0, :cond_d

    move-object v5, v0

    .line 193
    :goto_4
    if-nez v5, :cond_e

    .line 194
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_3
    move v9, v1

    .line 128
    :cond_4
    :goto_5
    if-eqz v9, :cond_5

    iget v9, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    if-ge v4, v9, :cond_5

    .line 129
    invoke-direct {p0, v7, v6, v4, v1}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->containsBlackPoint(IIIZ)Z

    move-result v9

    .line 130
    if-eqz v9, :cond_4

    .line 131
    add-int/lit8 v4, v4, 0x1

    move v8, v1

    .line 132
    goto :goto_5

    .line 136
    :cond_5
    iget v9, p0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->height:I

    if-lt v4, v9, :cond_6

    move v3, v1

    move v8, v6

    move v6, v4

    move v4, v7

    move v7, v5

    .line 138
    goto :goto_2

    :cond_6
    move v9, v1

    .line 145
    :cond_7
    :goto_6
    if-eqz v9, :cond_8

    if-ltz v7, :cond_8

    .line 146
    invoke-direct {p0, v5, v4, v7, v3}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->containsBlackPoint(IIIZ)Z

    move-result v9

    .line 147
    if-eqz v9, :cond_7

    .line 148
    add-int/lit8 v7, v7, -0x1

    move v8, v1

    .line 149
    goto :goto_6

    .line 153
    :cond_8
    if-gez v7, :cond_9

    move v3, v1

    move v8, v6

    move v6, v4

    move v4, v7

    move v7, v5

    .line 155
    goto :goto_2

    :cond_9
    move v9, v8

    move v8, v1

    .line 162
    :cond_a
    :goto_7
    if-eqz v8, :cond_b

    if-ltz v5, :cond_b

    .line 163
    invoke-direct {p0, v7, v6, v5, v1}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->containsBlackPoint(IIIZ)Z

    move-result v8

    .line 164
    if-eqz v8, :cond_a

    .line 165
    add-int/lit8 v5, v5, -0x1

    move v9, v1

    .line 166
    goto :goto_7

    .line 170
    :cond_b
    if-gez v5, :cond_c

    move v3, v1

    move v8, v6

    move v6, v4

    move v4, v7

    move v7, v5

    .line 172
    goto :goto_2

    .line 175
    :cond_c
    if-eqz v9, :cond_0

    move v0, v1

    .line 176
    goto/16 :goto_0

    .line 186
    :cond_d
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    :cond_e
    move v3, v1

    move-object v0, v2

    .line 199
    :goto_8
    if-ge v3, v9, :cond_18

    .line 200
    int-to-float v0, v4

    add-int v10, v7, v3

    int-to-float v10, v10

    add-int v11, v4, v3

    int-to-float v11, v11

    int-to-float v12, v7

    invoke-direct {p0, v0, v10, v11, v12}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->getBlackPointOnSegment(FFFF)Lcom/google/zxing/ResultPoint;

    move-result-object v0

    .line 201
    if-eqz v0, :cond_f

    move-object v4, v0

    .line 206
    :goto_9
    if-nez v4, :cond_10

    .line 207
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 199
    :cond_f
    add-int/lit8 v3, v3, 0x1

    goto :goto_8

    :cond_10
    move v3, v1

    move-object v0, v2

    .line 212
    :goto_a
    if-ge v3, v9, :cond_17

    .line 213
    int-to-float v0, v8

    add-int v10, v7, v3

    int-to-float v10, v10

    sub-int v11, v8, v3

    int-to-float v11, v11

    int-to-float v12, v7

    invoke-direct {p0, v0, v10, v11, v12}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->getBlackPointOnSegment(FFFF)Lcom/google/zxing/ResultPoint;

    move-result-object v0

    .line 214
    if-eqz v0, :cond_11

    move-object v3, v0

    .line 219
    :goto_b
    if-nez v3, :cond_12

    .line 220
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 212
    :cond_11
    add-int/lit8 v3, v3, 0x1

    goto :goto_a

    :cond_12
    move-object v0, v2

    .line 225
    :goto_c
    if-ge v1, v9, :cond_13

    .line 226
    int-to-float v0, v8

    sub-int v2, v6, v1

    int-to-float v2, v2

    sub-int v7, v8, v1

    int-to-float v7, v7

    int-to-float v10, v6

    invoke-direct {p0, v0, v2, v7, v10}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->getBlackPointOnSegment(FFFF)Lcom/google/zxing/ResultPoint;

    move-result-object v0

    .line 227
    if-eqz v0, :cond_14

    .line 232
    :cond_13
    if-nez v0, :cond_15

    .line 233
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    .line 225
    :cond_14
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 236
    :cond_15
    invoke-direct {p0, v0, v5, v3, v4}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->centerEdges(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)[Lcom/google/zxing/ResultPoint;

    move-result-object v0

    return-object v0

    .line 239
    :cond_16
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_17
    move-object v3, v0

    goto :goto_b

    :cond_18
    move-object v4, v0

    goto :goto_9

    :cond_19
    move-object v5, v0

    goto/16 :goto_4

    :cond_1a
    move v8, v6

    move v6, v4

    move v4, v7

    move v7, v5

    goto/16 :goto_2
.end method
