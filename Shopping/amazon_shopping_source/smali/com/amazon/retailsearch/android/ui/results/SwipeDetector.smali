.class public Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;
.super Ljava/lang/Object;
.source "SwipeDetector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;
    }
.end annotation


# static fields
.field private static final MAX_Y_DISTANCE:I = 0x96

.field private static final MIN_X_DISTANCE:I = 0x14


# instance fields
.field private final callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

.field private final density:F

.field downX:F

.field downY:F

.field private final maxDistanceY:F

.field private final maxVelocity:I

.field private final minDistanceX:F

.field private final minVelocity:I

.field private final slop:I

.field swiping:Z

.field velocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    .prologue
    const/high16 v3, 0x3f000000    # 0.5f

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->density:F

    .line 26
    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, v3

    float-to-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->minDistanceX:F

    .line 27
    const/high16 v1, 0x43160000    # 150.0f

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, v3

    float-to-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->maxDistanceY:F

    .line 29
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 30
    .local v0, "configuration":Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v1

    div-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->minVelocity:I

    .line 31
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->maxVelocity:I

    .line 32
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->slop:I

    .line 33
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 136
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    .line 137
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    .line 139
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    .line 141
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    .line 144
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->swiping:Z

    .line 145
    return-void
.end method

.method public isSwiping()Z
    .locals 1

    .prologue
    .line 132
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->swiping:Z

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 21
    .param p1, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    .line 36
    const/16 v20, 0x0

    .line 38
    .local v20, "res":Z
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 128
    :cond_0
    :goto_0
    return v20

    .line 40
    :pswitch_0
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    .line 41
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    .line 42
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    .line 43
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 44
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->swiping:Z

    .line 46
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    if-nez v1, :cond_1

    .line 47
    const/16 v20, 0x0

    goto :goto_0

    .line 49
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    move-object/from16 v0, p1

    invoke-interface {v1, v0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;->onDown(Landroid/view/MotionEvent;)Z

    move-result v20

    .line 51
    if-nez v20, :cond_0

    .line 52
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->clear()V

    goto :goto_0

    .line 60
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    if-eqz v1, :cond_0

    .line 64
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    sub-float v18, v1, v2

    .line 65
    .local v18, "distanceX":F
    invoke-static/range {v18 .. v18}, Ljava/lang/Math;->abs(F)F

    move-result v13

    .line 67
    .local v13, "absDistanceX":F
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    sub-float v19, v1, v2

    .line 68
    .local v19, "distanceY":F
    invoke-static/range {v19 .. v19}, Ljava/lang/Math;->abs(F)F

    move-result v14

    .line 70
    .local v14, "absDistanceY":F
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 71
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    .line 73
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v1}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v5

    .line 74
    .local v5, "velocityX":F
    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v15

    .line 76
    .local v15, "absVelocityX":F
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v1}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v6

    .line 78
    .local v6, "velocityY":F
    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->maxDistanceY:F

    cmpl-float v1, v14, v1

    if-lez v1, :cond_3

    .line 79
    const/16 v20, 0x0

    .line 89
    :cond_2
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->clear()V

    goto/16 :goto_0

    .line 80
    :cond_3
    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->minDistanceX:F

    cmpl-float v1, v13, v1

    if-lez v1, :cond_2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->minVelocity:I

    int-to-float v1, v1

    cmpl-float v1, v15, v1

    if-lez v1, :cond_2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->maxVelocity:I

    int-to-float v1, v1

    cmpg-float v1, v15, v1

    if-gez v1, :cond_2

    .line 82
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    if-nez v1, :cond_4

    .line 83
    const/16 v20, 0x0

    goto :goto_1

    .line 85
    :cond_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    move-object/from16 v0, p0

    iget v3, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    move-object/from16 v4, p1

    invoke-interface/range {v1 .. v6}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;->onSwipe(FFLandroid/view/MotionEvent;FF)Z

    move-result v20

    goto :goto_1

    .line 94
    .end local v5    # "velocityX":F
    .end local v6    # "velocityY":F
    .end local v13    # "absDistanceX":F
    .end local v14    # "absDistanceY":F
    .end local v15    # "absVelocityX":F
    .end local v18    # "distanceX":F
    .end local v19    # "distanceY":F
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->clear()V

    goto/16 :goto_0

    .line 99
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    if-eqz v1, :cond_0

    .line 103
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 104
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v1

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    sub-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v16

    .line 105
    .local v16, "absX":F
    invoke-virtual/range {p1 .. p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    sub-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v17

    .line 107
    .local v17, "absY":F
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->swiping:Z

    move/from16 v20, v0

    .line 109
    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->slop:I

    int-to-float v1, v1

    cmpl-float v1, v16, v1

    if-lez v1, :cond_0

    cmpl-float v1, v16, v17

    if-lez v1, :cond_0

    .line 110
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->swiping:Z

    .line 112
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    if-nez v1, :cond_5

    .line 113
    const/16 v20, 0x0

    goto/16 :goto_0

    .line 115
    :cond_5
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->callback:Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;

    move-object/from16 v0, p0

    iget v8, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downX:F

    move-object/from16 v0, p0

    iget v9, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->downY:F

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v1}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v11

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->velocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v1}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v12

    move-object/from16 v10, p1

    invoke-interface/range {v7 .. v12}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector$Listener;->onMove(FFLandroid/view/MotionEvent;FF)Z

    move-result v20

    .line 118
    if-nez v20, :cond_0

    .line 119
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/retailsearch/android/ui/results/SwipeDetector;->clear()V

    goto/16 :goto_0

    .line 38
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method
