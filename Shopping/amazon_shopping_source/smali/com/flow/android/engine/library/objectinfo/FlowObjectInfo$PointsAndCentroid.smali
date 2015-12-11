.class public Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;
.super Ljava/lang/Object;
.source "FlowObjectInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PointsAndCentroid"
.end annotation


# instance fields
.field public m_centroid:Landroid/graphics/PointF;

.field public m_points:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_points:Ljava/util/ArrayList;

    .line 31
    return-void
.end method
