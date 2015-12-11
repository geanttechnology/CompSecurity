.class public Lcom/poshmark/utils/GestureViewUtils;
.super Ljava/lang/Object;
.source "GestureViewUtils.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "GESTURE VIEW UTIL"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getInitialScaledBitmap(Landroid/graphics/Rect;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 11
    .param p1, "viewPort"    # Landroid/graphics/Rect;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v10, 0x0

    .line 23
    const-string v6, "GESTURE VIEW UTIL"

    const-string v7, "Initial Scalling fo bitmap"

    new-array v8, v10, [Ljava/lang/Object;

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 25
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    int-to-float v3, v6

    .line 26
    .local v3, "originalWidth":F
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    int-to-float v2, v6

    .line 28
    .local v2, "originalHeight":F
    invoke-virtual {p1}, Landroid/graphics/Rect;->width()I

    move-result v6

    int-to-float v1, v6

    .line 29
    .local v1, "expectedWidth":F
    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v6

    int-to-float v0, v6

    .line 31
    .local v0, "expectedHeight":F
    cmpl-float v6, v3, v2

    if-lez v6, :cond_0

    .line 32
    div-float v4, v0, v2

    .line 38
    .local v4, "scale":F
    :goto_0
    const-string v6, "GESTURE VIEW UTIL"

    const-string v7, "Scale Value : %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 39
    mul-float v6, v3, v4

    float-to-int v6, v6

    mul-float v7, v2, v4

    float-to-int v7, v7

    invoke-static {p2, v6, v7, v10}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 41
    .local v5, "scaled":Landroid/graphics/Bitmap;
    return-object v5

    .line 33
    .end local v4    # "scale":F
    .end local v5    # "scaled":Landroid/graphics/Bitmap;
    :cond_0
    cmpl-float v6, v2, v3

    if-lez v6, :cond_1

    .line 34
    div-float v4, v1, v3

    .restart local v4    # "scale":F
    goto :goto_0

    .line 36
    .end local v4    # "scale":F
    :cond_1
    div-float v4, v0, v2

    .restart local v4    # "scale":F
    goto :goto_0
.end method

.method public startScaleAnimation(FFLcom/poshmark/ui/customviews/GestureView;)V
    .locals 6
    .param p1, "from"    # F
    .param p2, "to"    # F
    .param p3, "v"    # Lcom/poshmark/ui/customviews/GestureView;

    .prologue
    const/4 v5, 0x0

    .line 94
    const-string v2, "GESTURE VIEW UTIL"

    const-string v3, "Starting Scale animation"

    new-array v4, v5, [Ljava/lang/Object;

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    new-instance v1, Landroid/animation/AnimatorSet;

    invoke-direct {v1}, Landroid/animation/AnimatorSet;-><init>()V

    .line 96
    .local v1, "set":Landroid/animation/AnimatorSet;
    const/4 v2, 0x2

    new-array v2, v2, [F

    aput p1, v2, v5

    const/4 v3, 0x1

    aput p2, v2, v3

    invoke-static {v2}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 97
    .local v0, "scaling":Landroid/animation/ValueAnimator;
    const-wide/16 v2, 0x96

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 98
    new-instance v2, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v2}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {v0, v2}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 99
    new-instance v2, Lcom/poshmark/utils/GestureViewUtils$3;

    invoke-direct {v2, p0, p3}, Lcom/poshmark/utils/GestureViewUtils$3;-><init>(Lcom/poshmark/utils/GestureViewUtils;Lcom/poshmark/ui/customviews/GestureView;)V

    invoke-virtual {v0, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 107
    const-string v2, "GESTURE VIEW UTIL"

    const-string v3, "Performing Scale animation"

    new-array v4, v5, [Ljava/lang/Object;

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    invoke-virtual {v1, v0}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 109
    invoke-virtual {v1}, Landroid/animation/AnimatorSet;->start()V

    .line 110
    return-void
.end method

.method public startTranslationAnimation(Landroid/graphics/Point;Landroid/graphics/Point;Lcom/poshmark/ui/customviews/GestureView;)V
    .locals 17
    .param p1, "from"    # Landroid/graphics/Point;
    .param p2, "to"    # Landroid/graphics/Point;
    .param p3, "v"    # Lcom/poshmark/ui/customviews/GestureView;

    .prologue
    .line 49
    const/4 v3, 0x2

    new-array v13, v3, [F

    .line 50
    .local v13, "pos":[F
    const/4 v3, 0x2

    new-array v15, v3, [F

    .line 51
    .local v15, "tan":[F
    new-instance v14, Landroid/animation/AnimatorSet;

    invoke-direct {v14}, Landroid/animation/AnimatorSet;-><init>()V

    .line 52
    .local v14, "set":Landroid/animation/AnimatorSet;
    new-instance v16, Landroid/animation/ValueAnimator;

    invoke-direct/range {v16 .. v16}, Landroid/animation/ValueAnimator;-><init>()V

    .line 54
    .local v16, "translation":Landroid/animation/ValueAnimator;
    new-instance v2, Landroid/graphics/Path;

    invoke-direct {v2}, Landroid/graphics/Path;-><init>()V

    .line 55
    .local v2, "path":Landroid/graphics/Path;
    move-object/from16 v0, p1

    iget v3, v0, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    move-object/from16 v0, p1

    iget v4, v0, Landroid/graphics/Point;->y:I

    int-to-float v4, v4

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Path;->moveTo(FF)V

    .line 56
    move-object/from16 v0, p1

    iget v3, v0, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    move-object/from16 v0, p1

    iget v4, v0, Landroid/graphics/Point;->y:I

    int-to-float v4, v4

    move-object/from16 v0, p2

    iget v5, v0, Landroid/graphics/Point;->x:I

    int-to-float v5, v5

    move-object/from16 v0, p2

    iget v6, v0, Landroid/graphics/Point;->y:I

    int-to-float v6, v6

    move-object/from16 v0, p2

    iget v7, v0, Landroid/graphics/Point;->x:I

    int-to-float v7, v7

    move-object/from16 v0, p2

    iget v8, v0, Landroid/graphics/Point;->y:I

    int-to-float v8, v8

    invoke-virtual/range {v2 .. v8}, Landroid/graphics/Path;->cubicTo(FFFFFF)V

    .line 57
    new-instance v11, Landroid/graphics/PathMeasure;

    const/4 v3, 0x0

    invoke-direct {v11, v2, v3}, Landroid/graphics/PathMeasure;-><init>(Landroid/graphics/Path;Z)V

    .line 58
    .local v11, "measure":Landroid/graphics/PathMeasure;
    invoke-virtual {v11}, Landroid/graphics/PathMeasure;->getLength()F

    move-result v3

    float-to-int v3, v3

    new-array v12, v3, [Landroid/graphics/Point;

    .line 59
    .local v12, "points":[Landroid/graphics/Point;
    invoke-virtual {v11}, Landroid/graphics/PathMeasure;->getLength()F

    move-result v3

    float-to-int v10, v3

    .line 60
    .local v10, "length":I
    const-string v3, "GESTURE VIEW UTIL"

    const-string v4, "Points Length: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v11}, Landroid/graphics/PathMeasure;->getLength()F

    move-result v7

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 62
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    if-ge v9, v10, :cond_0

    .line 63
    int-to-float v3, v9

    invoke-virtual {v11, v3, v13, v15}, Landroid/graphics/PathMeasure;->getPosTan(F[F[F)Z

    .line 64
    new-instance v3, Landroid/graphics/Point;

    invoke-direct {v3}, Landroid/graphics/Point;-><init>()V

    aput-object v3, v12, v9

    .line 65
    aget-object v3, v12, v9

    const/4 v4, 0x0

    aget v4, v13, v4

    float-to-int v4, v4

    iput v4, v3, Landroid/graphics/Point;->x:I

    .line 66
    aget-object v3, v12, v9

    const/4 v4, 0x1

    aget v4, v13, v4

    float-to-int v4, v4

    iput v4, v3, Landroid/graphics/Point;->y:I

    .line 62
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 68
    :cond_0
    const-string v3, "GESTURE VIEW UTIL"

    const-string v4, "Starting translation animation"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Landroid/animation/ValueAnimator;->setObjectValues([Ljava/lang/Object;)V

    .line 70
    const-wide/16 v4, 0x96

    move-object/from16 v0, v16

    invoke-virtual {v0, v4, v5}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 71
    new-instance v3, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v3}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 72
    new-instance v3, Lcom/poshmark/utils/GestureViewUtils$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v3, v0, v1}, Lcom/poshmark/utils/GestureViewUtils$1;-><init>(Lcom/poshmark/utils/GestureViewUtils;Lcom/poshmark/ui/customviews/GestureView;)V

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 79
    new-instance v3, Lcom/poshmark/utils/GestureViewUtils$2;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/poshmark/utils/GestureViewUtils$2;-><init>(Lcom/poshmark/utils/GestureViewUtils;)V

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/animation/ValueAnimator;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    .line 86
    const-string v3, "GESTURE VIEW UTIL"

    const-string v4, "Points Length : %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    array-length v7, v12

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 87
    array-length v3, v12

    if-lez v3, :cond_1

    .line 88
    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 89
    invoke-virtual {v14}, Landroid/animation/AnimatorSet;->start()V

    .line 91
    :cond_1
    return-void
.end method
