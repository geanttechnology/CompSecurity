.class public Lcom/poshmark/utils/PMGestureDetector;
.super Ljava/lang/Object;
.source "PMGestureDetector.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/PMGestureDetector$STATE;
    }
.end annotation


# instance fields
.field gestureStartTimestamp:J

.field gestureStopTimestamp:J

.field gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

.field listener:Lcom/poshmark/utils/PMGestureDetectorListener;

.field majorPointCurrent:Landroid/graphics/Point;

.field majorPointPrev:Landroid/graphics/Point;

.field majorPointerId:I

.field majorStartPoint:Landroid/graphics/Point;

.field minorPointCurrent:Landroid/graphics/Point;

.field minorPointPrev:Landroid/graphics/Point;

.field minorPointerId:I

.field view:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;Lcom/poshmark/utils/PMGestureDetectorListener;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "listener"    # Lcom/poshmark/utils/PMGestureDetectorListener;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    sget-object v0, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 23
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    .line 24
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    .line 25
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    .line 26
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    .line 30
    iput-object p2, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    .line 31
    iput-object p1, p0, Lcom/poshmark/utils/PMGestureDetector;->view:Landroid/view/View;

    .line 32
    iget-object v0, p0, Lcom/poshmark/utils/PMGestureDetector;->view:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 33
    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v10, 0x2

    const/4 v11, 0x0

    const/4 v5, 0x1

    .line 37
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 39
    .local v0, "action":I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    .line 40
    .local v1, "count":I
    const-string v6, "PMGesture"

    const-string v7, "pointerCOunt = %s"

    new-array v8, v5, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 41
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->view:Landroid/view/View;

    if-eq p1, v6, :cond_0

    .line 42
    const-string v6, "PMGesture"

    const-string v7, "gesture on another view!"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 44
    :cond_0
    packed-switch v0, :pswitch_data_0

    .line 182
    invoke-virtual {p1, p2}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v5

    :cond_1
    :goto_0
    return v5

    .line 47
    :pswitch_0
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gestureStartTimestamp:J

    .line 48
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 49
    const/4 v6, 0x0

    invoke-virtual {p2, v6}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v6

    iput v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    .line 50
    const-string v6, "PMGesture"

    const-string v7, "Major Index %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget v10, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 53
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 54
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorStartPoint:Landroid/graphics/Point;

    if-nez v6, :cond_2

    .line 55
    new-instance v6, Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v8, v8, Landroid/graphics/Point;->y:I

    invoke-direct {v6, v7, v8}, Landroid/graphics/Point;-><init>(II)V

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorStartPoint:Landroid/graphics/Point;

    .line 57
    :cond_2
    const-string v6, "PMGesture"

    const-string v7, "Primary Point Down : %s, %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->x:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->y:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 59
    :catch_0
    move-exception v2

    .line 60
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    goto :goto_0

    .line 65
    .end local v2    # "e":Ljava/lang/IllegalArgumentException;
    :pswitch_1
    :try_start_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gestureStartTimestamp:J

    .line 66
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 67
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v3

    .line 68
    .local v3, "index":I
    invoke-virtual {p2, v3}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v6

    iput v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    .line 69
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 70
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 72
    const-string v6, "PMGesture"

    const-string v7, "Second Point Down : %s, %s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->x:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->y:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 74
    .end local v3    # "index":I
    :catch_1
    move-exception v2

    .line 75
    .restart local v2    # "e":Ljava/lang/IllegalArgumentException;
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    goto/16 :goto_0

    .line 80
    .end local v2    # "e":Ljava/lang/IllegalArgumentException;
    :pswitch_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gestureStartTimestamp:J

    .line 81
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 82
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v3

    .line 83
    .restart local v3    # "index":I
    invoke-virtual {p2, v3}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v4

    .line 84
    .local v4, "newId":I
    iget v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    if-ne v4, v6, :cond_3

    .line 86
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 87
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 88
    const-string v6, "PMGesture"

    const-string v7, "New PREVIOUS  Point : %s, %s"

    new-array v8, v10, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->y:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    :cond_3
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v6

    if-ge v6, v10, :cond_1

    .line 91
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    invoke-interface {v6}, Lcom/poshmark/utils/PMGestureDetectorListener;->onPinchZoomEnd()V

    goto/16 :goto_0

    .line 96
    .end local v3    # "index":I
    .end local v4    # "newId":I
    :pswitch_3
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_4

    .line 98
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 99
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 100
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 101
    const-string v6, "PMGesture"

    const-string v7, "Dragging"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    const-string v6, "PMGesture"

    const-string v7, "New Primary Point : %s, %s"

    new-array v8, v10, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->y:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    invoke-interface {v6, v7}, Lcom/poshmark/utils/PMGestureDetectorListener;->onDragStart(Landroid/graphics/Point;)V

    .line 104
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    invoke-interface {v6, v7, v8}, Lcom/poshmark/utils/PMGestureDetectorListener;->onDrag(Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 105
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 106
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    goto/16 :goto_0

    .line 108
    :cond_4
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_6

    .line 110
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_5

    .line 111
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    invoke-interface {v6}, Lcom/poshmark/utils/PMGestureDetectorListener;->onDragEnd()V

    .line 113
    :cond_5
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 114
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 115
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 116
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 117
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 121
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    invoke-interface {v6, v7, v8}, Lcom/poshmark/utils/PMGestureDetectorListener;->onPinchZoomStart(Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 122
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    invoke-interface {v6, v7, v8, v9, v10}, Lcom/poshmark/utils/PMGestureDetectorListener;->onPinchZoom(Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 124
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 125
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 126
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 127
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 128
    const-string v6, "PMGesture"

    const-string v7, "Pinch-Zooming Start"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 129
    :cond_6
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_7

    .line 131
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 132
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 133
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 134
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 136
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    invoke-interface {v6, v7, v8, v9, v10}, Lcom/poshmark/utils/PMGestureDetectorListener;->onPinchZoom(Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 138
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 139
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 140
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 141
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->minorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 142
    const-string v6, "PMGesture"

    const-string v7, "Pinch-Zooming"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 143
    :cond_7
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_1

    .line 144
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 145
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointerId:I

    invoke-virtual {p2, v7}, Landroid/view/MotionEvent;->getY(I)F

    move-result v7

    float-to-int v7, v7

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 146
    const-string v6, "PMGesture"

    const-string v7, "New Point offset : %s, %s"

    new-array v8, v10, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->x:I

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->x:I

    sub-int/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    iget-object v9, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v9, v9, Landroid/graphics/Point;->y:I

    iget-object v10, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget v10, v10, Landroid/graphics/Point;->y:I

    sub-int/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v5

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v8, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    invoke-interface {v6, v7, v8}, Lcom/poshmark/utils/PMGestureDetectorListener;->onDrag(Landroid/graphics/Point;Landroid/graphics/Point;)V

    .line 150
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->x:I

    iput v7, v6, Landroid/graphics/Point;->x:I

    .line 151
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointPrev:Landroid/graphics/Point;

    iget-object v7, p0, Lcom/poshmark/utils/PMGestureDetector;->majorPointCurrent:Landroid/graphics/Point;

    iget v7, v7, Landroid/graphics/Point;->y:I

    iput v7, v6, Landroid/graphics/Point;->y:I

    .line 152
    const-string v6, "PMGesture"

    const-string v7, "Dragging"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 156
    :pswitch_4
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_9

    .line 158
    const-string v6, "PMGesture"

    const-string v7, "Single Tap"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 171
    :cond_8
    :goto_1
    sget-object v6, Lcom/poshmark/utils/PMGestureDetector$STATE;->NONE:Lcom/poshmark/utils/PMGestureDetector$STATE;

    iput-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    .line 172
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    invoke-interface {v6}, Lcom/poshmark/utils/PMGestureDetectorListener;->onActionEnd()V

    goto/16 :goto_0

    .line 160
    :cond_9
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_TAP_START:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_a

    .line 162
    const-string v6, "PMGesture"

    const-string v7, "Multi Tap"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 163
    :cond_a
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->MULTI_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_b

    .line 165
    const-string v6, "PMGesture"

    const-string v7, "Pinch-Zooming DONE"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 166
    :cond_b
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->gesture_state:Lcom/poshmark/utils/PMGestureDetector$STATE;

    sget-object v7, Lcom/poshmark/utils/PMGestureDetector$STATE;->SINGLE_FINGER_DRAG:Lcom/poshmark/utils/PMGestureDetector$STATE;

    if-ne v6, v7, :cond_8

    .line 168
    iget-object v6, p0, Lcom/poshmark/utils/PMGestureDetector;->listener:Lcom/poshmark/utils/PMGestureDetectorListener;

    invoke-interface {v6}, Lcom/poshmark/utils/PMGestureDetectorListener;->onDragEnd()V

    .line 169
    const-string v6, "PMGesture"

    const-string v7, "Dragging DOne"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 175
    :pswitch_5
    const-string v6, "PMGesture"

    const-string v7, "Action was CANCEL"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 178
    :pswitch_6
    const-string v6, "PMGesture"

    const-string v7, "Movement occurred outside bounds of current screen element"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 44
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_4
        :pswitch_3
        :pswitch_5
        :pswitch_6
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
