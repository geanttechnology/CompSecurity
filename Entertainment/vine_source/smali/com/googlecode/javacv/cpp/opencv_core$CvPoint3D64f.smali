.class public Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvPoint3D64f"
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 2134
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2135
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->allocate()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2136
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2137
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method public varargs constructor <init>([D)V
    .locals 2
    .param p1, "pts"    # [D

    .prologue
    .line 2150
    const/4 v0, 0x0

    array-length v1, p1

    invoke-direct {p0, p1, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;-><init>([DII)V

    .line 2151
    return-void
.end method

.method public constructor <init>([DII)V
    .locals 1
    .param p1, "pts"    # [D
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 2146
    div-int/lit8 v0, p3, 0x3

    invoke-direct {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;-><init>(I)V

    .line 2147
    invoke-virtual {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->put([DII)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    .line 2148
    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public get([D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 2
    .param p1, "pts"    # [D

    .prologue
    .line 2163
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->get([DII)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public get([DII)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 4
    .param p1, "pts"    # [D
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 2166
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    div-int/lit8 v1, p3, 0x3

    if-ge v0, v1, :cond_0

    .line 2167
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    .line 2168
    mul-int/lit8 v1, v0, 0x3

    add-int/2addr v1, p2

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x()D

    move-result-wide v2

    aput-wide v2, p1, v1

    .line 2169
    mul-int/lit8 v1, v0, 0x3

    add-int/2addr v1, p2

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y()D

    move-result-wide v2

    aput-wide v2, p1, v1

    .line 2170
    mul-int/lit8 v1, v0, 0x3

    add-int/2addr v1, p2

    add-int/lit8 v1, v1, 0x2

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z()D

    move-result-wide v2

    aput-wide v2, p1, v1

    .line 2166
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2172
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v1

    return-object v1
.end method

.method public get()[D
    .locals 2

    .prologue
    .line 2158
    iget v1, p0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->capacity:I

    if-nez v1, :cond_0

    const/4 v1, 0x3

    :goto_0
    new-array v0, v1, [D

    .line 2159
    .local v0, "pts":[D
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->get([D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    .line 2160
    return-object v0

    .line 2158
    .end local v0    # "pts":[D
    :cond_0
    iget v1, p0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->capacity:I

    mul-int/lit8 v1, v1, 0x3

    goto :goto_0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2133
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2142
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    return-object v0
.end method

.method public put(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 3
    .param p1, "x"    # D
    .param p3, "y"    # D
    .param p5, "z"    # D

    .prologue
    .line 2186
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x()D

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public put(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 3
    .param p1, "o"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;

    .prologue
    .line 2192
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->x()F

    move-result v0

    float-to-double v0, v0

    invoke-virtual {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D32f;->y()F

    move-result v1

    float-to-double v1, v1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    const-wide/16 v1, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public put(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 3
    .param p1, "o"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;

    .prologue
    .line 2195
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;->x()D

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint2D64f;->y()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    const-wide/16 v1, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public put(Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 3
    .param p1, "o"    # Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;

    .prologue
    .line 2189
    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->x()I

    move-result v0

    int-to-double v0, v0

    invoke-virtual {p0, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    invoke-virtual {p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint;->y()I

    move-result v1

    int-to-double v1, v1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    const-wide/16 v1, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public final varargs put([D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 2
    .param p1, "pts"    # [D

    .prologue
    .line 2182
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->put([DII)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public final put([DII)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
    .locals 8
    .param p1, "pts"    # [D
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 2176
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    div-int/lit8 v0, p3, 0x3

    if-ge v7, v0, :cond_0

    .line 2177
    invoke-virtual {p0, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    mul-int/lit8 v1, v7, 0x3

    add-int/2addr v1, p2

    aget-wide v1, p1, v1

    mul-int/lit8 v3, v7, 0x3

    add-int/2addr v3, p2

    add-int/lit8 v3, v3, 0x1

    aget-wide v3, p1, v3

    mul-int/lit8 v5, v7, 0x3

    add-int/2addr v5, p2

    add-int/lit8 v5, v5, 0x2

    aget-wide v5, p1, v5

    invoke-virtual/range {v0 .. v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->put(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    .line 2176
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 2179
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 2199
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->isNull()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2200
    invoke-super {p0}, Lcom/googlecode/javacpp/Pointer;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2212
    :goto_0
    return-object v2

    .line 2202
    :cond_0
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->capacity()I

    move-result v3

    if-nez v3, :cond_1

    .line 2203
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 2205
    :cond_1
    const-string v2, ""

    .line 2206
    .local v2, "s":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position()I

    move-result v1

    .line 2207
    .local v1, "p":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->capacity()I

    move-result v3

    if-ge v0, v3, :cond_3

    .line 2208
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    .line 2209
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-nez v0, :cond_2

    const-string v3, "("

    :goto_2
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->x()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->y()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->z()D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2207
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2209
    :cond_2
    const-string v3, " ("

    goto :goto_2

    .line 2211
    :cond_3
    invoke-virtual {p0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;

    goto/16 :goto_0
.end method

.method public native x()D
.end method

.method public native x(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
.end method

.method public native y()D
.end method

.method public native y(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
.end method

.method public native z()D
.end method

.method public native z(D)Lcom/googlecode/javacv/cpp/opencv_core$CvPoint3D64f;
.end method
