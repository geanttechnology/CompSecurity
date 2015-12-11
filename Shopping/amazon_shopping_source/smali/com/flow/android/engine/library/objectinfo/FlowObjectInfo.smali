.class public Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.super Ljava/lang/Object;
.source "FlowObjectInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;
    }
.end annotation


# instance fields
.field protected m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

.field private m_pointsAndCentroid:Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 1
    .param p1, "a_objectInfo"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;->m_pointsAndCentroid:Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;

    .line 35
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .line 36
    return-void
.end method

.method protected static getListOfStrings(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)Ljava/util/List;
    .locals 6
    .param p0, "strVec"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 107
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 108
    .local v1, "strList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    int-to-long v2, v0

    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 109
    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 108
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 111
    :cond_0
    return-object v1
.end method

.method public static getPoints(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)Ljava/util/ArrayList;
    .locals 7
    .param p0, "points"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;"
        }
    .end annotation

    .prologue
    .line 120
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 121
    .local v1, "locs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/graphics/PointF;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    int-to-long v3, v0

    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->size()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 122
    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->get(I)Lcom/a9/vs/mobile/library/impl/jni/Point2f;

    move-result-object v2

    .line 123
    .local v2, "p":Lcom/a9/vs/mobile/library/impl/jni/Point2f;
    new-instance v3, Landroid/graphics/PointF;

    invoke-virtual {v2}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getX()F

    move-result v4

    invoke-virtual {v2}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getY()F

    move-result v5

    invoke-direct {v3, v4, v5}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 121
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 125
    .end local v2    # "p":Lcom/a9/vs/mobile/library/impl/jni/Point2f;
    :cond_0
    return-object v1
.end method

.method public static getPointsAndCentroid(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;
    .locals 11
    .param p0, "points"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    const/high16 v10, 0x3f800000    # 1.0f

    const/high16 v9, -0x40800000    # -1.0f

    .line 81
    new-instance v2, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;

    invoke-direct {v2}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;-><init>()V

    .line 82
    .local v2, "pc":Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;
    const/4 v3, 0x0

    .local v3, "x":F
    const/4 v4, 0x0

    .line 83
    .local v4, "y":F
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    int-to-long v5, v0

    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->size()J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-gez v5, :cond_0

    .line 84
    invoke-virtual {p0, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->get(I)Lcom/a9/vs/mobile/library/impl/jni/Point2f;

    move-result-object v1

    .line 85
    .local v1, "p":Lcom/a9/vs/mobile/library/impl/jni/Point2f;
    iget-object v5, v2, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_points:Ljava/util/ArrayList;

    new-instance v6, Landroid/graphics/PointF;

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getX()F

    move-result v7

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getY()F

    move-result v8

    invoke-direct {v6, v7, v8}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getX()F

    move-result v5

    add-float/2addr v3, v5

    .line 87
    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/Point2f;->getY()F

    move-result v5

    add-float/2addr v4, v5

    .line 83
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 89
    .end local v1    # "p":Lcom/a9/vs/mobile/library/impl/jni/Point2f;
    :cond_0
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->size()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-lez v5, :cond_1

    .line 90
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->size()J

    move-result-wide v5

    long-to-float v5, v5

    div-float v5, v10, v5

    mul-float/2addr v3, v5

    .line 91
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->size()J

    move-result-wide v5

    long-to-float v5, v5

    div-float v5, v10, v5

    mul-float/2addr v4, v5

    .line 92
    new-instance v5, Landroid/graphics/PointF;

    invoke-direct {v5, v3, v4}, Landroid/graphics/PointF;-><init>(FF)V

    iput-object v5, v2, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_centroid:Landroid/graphics/PointF;

    .line 96
    :goto_1
    return-object v2

    .line 94
    :cond_1
    new-instance v5, Landroid/graphics/PointF;

    invoke-direct {v5, v9, v9}, Landroid/graphics/PointF;-><init>(FF)V

    iput-object v5, v2, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_centroid:Landroid/graphics/PointF;

    goto :goto_1
.end method
