.class public Lcom/amazon/mShop/util/CameraUtils;
.super Ljava/lang/Object;
.source "CameraUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBestMatchedSize(Ljava/util/List;IIZ)Landroid/hardware/Camera$Size;
    .locals 17
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "mustBiggerThanTarget"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/hardware/Camera$Size;",
            ">;IIZ)",
            "Landroid/hardware/Camera$Size;"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    move/from16 v0, p1

    int-to-double v13, v0

    move/from16 v0, p2

    int-to-double v15, v0

    div-double v11, v13, v15

    .line 22
    .local v11, "targetRatio":D
    if-eqz p0, :cond_0

    invoke-interface/range {p0 .. p0}, Ljava/util/List;->size()I

    move-result v13

    if-nez v13, :cond_2

    .line 23
    :cond_0
    const/4 v3, 0x0

    .line 52
    :cond_1
    return-object v3

    .line 26
    :cond_2
    const/4 v3, 0x0

    .line 27
    .local v3, "bestMatchedSize":Landroid/hardware/Camera$Size;
    const-wide v5, 0x7fefffffffffffffL    # Double.MAX_VALUE

    .line 29
    .local v5, "minDiff":D
    move/from16 v10, p2

    .line 33
    .local v10, "targetHeight":I
    const-wide v1, 0x3fb999999999999aL    # 0.1

    .local v1, "aspectTolerance":D
    :goto_0
    if-nez v3, :cond_1

    .line 35
    invoke-interface/range {p0 .. p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/hardware/Camera$Size;

    .line 36
    .local v9, "size":Landroid/hardware/Camera$Size;
    iget v13, v9, Landroid/hardware/Camera$Size;->width:I

    int-to-double v13, v13

    iget v15, v9, Landroid/hardware/Camera$Size;->height:I

    int-to-double v15, v15

    div-double v7, v13, v15

    .line 37
    .local v7, "ratio":D
    sub-double v13, v7, v11

    invoke-static {v13, v14}, Ljava/lang/Math;->abs(D)D

    move-result-wide v13

    cmpl-double v13, v13, v1

    if-gtz v13, :cond_3

    .line 38
    if-eqz p3, :cond_4

    .line 39
    iget v13, v9, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v13, v10

    int-to-double v13, v13

    cmpg-double v13, v13, v5

    if-gez v13, :cond_3

    iget v13, v9, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v13, v10

    if-lez v13, :cond_3

    .line 40
    move-object v3, v9

    .line 41
    iget v13, v9, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v13, v10

    invoke-static {v13}, Ljava/lang/Math;->abs(I)I

    move-result v13

    int-to-double v5, v13

    goto :goto_1

    .line 44
    :cond_4
    iget v13, v9, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v13, v10

    invoke-static {v13}, Ljava/lang/Math;->abs(I)I

    move-result v13

    int-to-double v13, v13

    cmpg-double v13, v13, v5

    if-gez v13, :cond_3

    .line 45
    move-object v3, v9

    .line 46
    iget v13, v9, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v13, v10

    invoke-static {v13}, Ljava/lang/Math;->abs(I)I

    move-result v13

    int-to-double v5, v13

    goto :goto_1

    .line 33
    .end local v7    # "ratio":D
    .end local v9    # "size":Landroid/hardware/Camera$Size;
    :cond_5
    const-wide v13, 0x3fb999999999999aL    # 0.1

    add-double/2addr v1, v13

    goto :goto_0
.end method
