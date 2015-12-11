.class public Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;
.super Ljava/lang/Object;
.source "SwipeDismissListViewTouchListener.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "Recycle"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;
    }
.end annotation


# instance fields
.field private mAnimationTime:J

.field private mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

.field private mDismissAnimationRefCount:I

.field private mDownPosition:I

.field private mDownView:Landroid/view/View;

.field private mDownX:F

.field private mDownY:F

.field private mListView:Landroid/widget/ListView;

.field private mMaxFlingVelocity:I

.field private mMinFlingVelocity:I

.field private mPaused:Z

.field private mPendingDismisses:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;",
            ">;"
        }
    .end annotation
.end field

.field private mSlop:I

.field private mSwiping:Z

.field private mVelocityTracker:Landroid/view/VelocityTracker;

.field private mViewWidth:I


# direct methods
.method public constructor <init>(Landroid/widget/ListView;Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;)V
    .locals 3
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "callback"    # Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    const/4 v1, 0x1

    iput v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    .line 79
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;

    .line 80
    const/4 v1, 0x0

    iput v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I

    .line 99
    invoke-virtual {p1}, Landroid/widget/ListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    .line 100
    .local v0, "vc":Landroid/view/ViewConfiguration;
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    iput v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mSlop:I

    .line 101
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v1

    iput v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mMinFlingVelocity:I

    .line 102
    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v1

    iput v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mMaxFlingVelocity:I

    .line 103
    invoke-virtual {p1}, Landroid/widget/ListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x10e0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    int-to-long v1, v1

    iput-wide v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mAnimationTime:J

    .line 104
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    .line 105
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .line 106
    return-void
.end method

.method static synthetic access$0(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/View;I)V
    .locals 0

    .prologue
    .line 241
    invoke-direct {p0, p1, p2}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->performDismiss(Landroid/view/View;I)V

    return-void
.end method

.method static synthetic access$1(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)I
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I

    return v0
.end method

.method static synthetic access$2(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I

    return-void
.end method

.method static synthetic access$3(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Ljava/util/List;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$4(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    return-object v0
.end method

.method static synthetic access$5(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    return-object v0
.end method

.method private performDismiss(Landroid/view/View;I)V
    .locals 6
    .param p1, "dismissView"    # Landroid/view/View;
    .param p2, "dismissPosition"    # I

    .prologue
    const/4 v5, 0x1

    .line 250
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 251
    .local v1, "lp":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v2

    .line 253
    .local v2, "originalHeight":I
    const/4 v3, 0x2

    new-array v3, v3, [I

    const/4 v4, 0x0

    aput v2, v3, v4

    aput v5, v3, v5

    invoke-static {v3}, Lcom/nineoldandroids/animation/ValueAnimator;->ofInt([I)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v3

    iget-wide v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mAnimationTime:J

    invoke-virtual {v3, v4, v5}, Lcom/nineoldandroids/animation/ValueAnimator;->setDuration(J)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v0

    .line 255
    .local v0, "animator":Lcom/nineoldandroids/animation/ValueAnimator;
    new-instance v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;

    invoke-direct {v3, p0}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$2;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;)V

    invoke-virtual {v0, v3}, Lcom/nineoldandroids/animation/ValueAnimator;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    .line 285
    new-instance v3, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;

    invoke-direct {v3, p0, v1, p1}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V

    invoke-virtual {v0, v3}, Lcom/nineoldandroids/animation/ValueAnimator;->addUpdateListener(Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 293
    iget-object v3, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPendingDismisses:Ljava/util/List;

    new-instance v4, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;

    invoke-direct {v4, p0, p2, p1}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$PendingDismissData;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;ILandroid/view/View;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 294
    invoke-virtual {v0}, Lcom/nineoldandroids/animation/ValueAnimator;->start()V

    .line 295
    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 24
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    .line 110
    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    move/from16 v18, v0

    const/16 v19, 0x2

    move/from16 v0, v18

    move/from16 v1, v19

    if-ge v0, v1, :cond_0

    .line 111
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/widget/ListView;->getWidth()I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    .line 114
    :cond_0
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v18

    packed-switch v18, :pswitch_data_0

    .line 222
    :cond_1
    :goto_0
    const/16 v18, 0x0

    :goto_1
    return v18

    .line 116
    :pswitch_0
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPaused:Z

    move/from16 v18, v0

    if-eqz v18, :cond_2

    .line 117
    const/16 v18, 0x0

    goto :goto_1

    .line 123
    :cond_2
    new-instance v13, Landroid/graphics/Rect;

    invoke-direct {v13}, Landroid/graphics/Rect;-><init>()V

    .line 124
    .local v13, "rect":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/widget/ListView;->getChildCount()I

    move-result v4

    .line 125
    .local v4, "childCount":I
    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v12, v0, [I

    .line 126
    .local v12, "listViewCoords":[I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Landroid/widget/ListView;->getLocationOnScreen([I)V

    .line 127
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v18

    move/from16 v0, v18

    float-to-int v0, v0

    move/from16 v18, v0

    const/16 v19, 0x0

    aget v19, v12, v19

    sub-int v16, v18, v19

    .line 128
    .local v16, "x":I
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v18

    move/from16 v0, v18

    float-to-int v0, v0

    move/from16 v18, v0

    const/16 v19, 0x1

    aget v19, v12, v19

    sub-int v17, v18, v19

    .line 130
    .local v17, "y":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_2
    if-lt v11, v4, :cond_4

    .line 139
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v18, v0

    if-eqz v18, :cond_3

    .line 140
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownX:F

    .line 141
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownY:F

    .line 142
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Landroid/widget/ListView;->getPositionForView(Landroid/view/View;)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownPosition:I

    .line 144
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 145
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 147
    :cond_3
    invoke-virtual/range {p1 .. p2}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 148
    const/16 v18, 0x1

    goto/16 :goto_1

    .line 131
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v11}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 132
    .local v3, "child":Landroid/view/View;
    invoke-virtual {v3, v13}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 133
    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v13, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 134
    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    goto :goto_3

    .line 130
    :cond_5
    add-int/lit8 v11, v11, 0x1

    goto :goto_2

    .line 152
    .end local v3    # "child":Landroid/view/View;
    .end local v4    # "childCount":I
    .end local v11    # "i":I
    .end local v12    # "listViewCoords":[I
    .end local v13    # "rect":Landroid/graphics/Rect;
    .end local v16    # "x":I
    .end local v17    # "y":I
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    if-eqz v18, :cond_1

    .line 156
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownX:F

    move/from16 v19, v0

    sub-float v5, v18, v19

    .line 157
    .local v5, "deltaX":F
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 158
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    const/16 v19, 0x3e8

    invoke-virtual/range {v18 .. v19}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    .line 159
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Math;->abs(F)F

    move-result v14

    .line 160
    .local v14, "velocityX":F
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/view/VelocityTracker;->getYVelocity()F

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Math;->abs(F)F

    move-result v15

    .line 161
    .local v15, "velocityY":F
    const/4 v7, 0x0

    .line 162
    .local v7, "dismiss":Z
    const/4 v8, 0x0

    .line 163
    .local v8, "dismissRight":Z
    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    move/from16 v19, v0

    div-int/lit8 v19, v19, 0x2

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    cmpl-float v18, v18, v19

    if-lez v18, :cond_8

    .line 164
    const/4 v7, 0x1

    .line 165
    const/16 v18, 0x0

    cmpl-float v18, v5, v18

    if-lez v18, :cond_7

    const/4 v8, 0x1

    .line 170
    :cond_6
    :goto_4
    if-eqz v7, :cond_b

    .line 172
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    .line 176
    .local v10, "downView":Landroid/view/View;
    move-object/from16 v0, p0

    iget v9, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownPosition:I

    .line 177
    .local v9, "downPosition":I
    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I

    move/from16 v18, v0

    add-int/lit8 v18, v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDismissAnimationRefCount:I

    .line 178
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->animate(Landroid/view/View;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v19

    if-eqz v8, :cond_a

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    move/from16 v18, v0

    :goto_5
    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    move-object/from16 v0, v19

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->translationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->alpha(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mAnimationTime:J

    move-wide/from16 v19, v0

    invoke-virtual/range {v18 .. v20}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setDuration(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    new-instance v19, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v10, v9}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/View;I)V

    invoke-virtual/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    .line 188
    .end local v9    # "downPosition":I
    .end local v10    # "downView":Landroid/view/View;
    :goto_6
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 189
    const/16 v18, 0x0

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownX:F

    .line 190
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    .line 191
    const/16 v18, -0x1

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownPosition:I

    .line 192
    const/16 v18, 0x0

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mSwiping:Z

    goto/16 :goto_0

    .line 165
    :cond_7
    const/4 v8, 0x0

    goto :goto_4

    .line 166
    :cond_8
    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mMinFlingVelocity:I

    move/from16 v18, v0

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    cmpg-float v18, v18, v14

    if-gtz v18, :cond_6

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mMaxFlingVelocity:I

    move/from16 v18, v0

    move/from16 v0, v18

    int-to-float v0, v0

    move/from16 v18, v0

    cmpg-float v18, v14, v18

    if-gtz v18, :cond_6

    cmpg-float v18, v15, v14

    if-gez v18, :cond_6

    .line 167
    const/4 v7, 0x1

    .line 168
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v18

    const/16 v19, 0x0

    cmpl-float v18, v18, v19

    if-lez v18, :cond_9

    const/4 v8, 0x1

    :goto_7
    goto/16 :goto_4

    :cond_9
    const/4 v8, 0x0

    goto :goto_7

    .line 178
    .restart local v9    # "downPosition":I
    .restart local v10    # "downView":Landroid/view/View;
    :cond_a
    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    move/from16 v18, v0

    move/from16 v0, v18

    neg-int v0, v0

    move/from16 v18, v0

    goto/16 :goto_5

    .line 186
    .end local v9    # "downPosition":I
    .end local v10    # "downView":Landroid/view/View;
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->animate(Landroid/view/View;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->translationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    const/high16 v19, 0x3f800000    # 1.0f

    invoke-virtual/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->alpha(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mAnimationTime:J

    move-wide/from16 v19, v0

    invoke-virtual/range {v18 .. v20}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setDuration(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v18

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    goto/16 :goto_6

    .line 197
    .end local v5    # "deltaX":F
    .end local v7    # "dismiss":Z
    .end local v8    # "dismissRight":Z
    .end local v14    # "velocityX":F
    .end local v15    # "velocityY":F
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    if-eqz v18, :cond_1

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mPaused:Z

    move/from16 v18, v0

    if-nez v18, :cond_1

    .line 201
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mVelocityTracker:Landroid/view/VelocityTracker;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 202
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownX:F

    move/from16 v19, v0

    sub-float v5, v18, v19

    .line 203
    .restart local v5    # "deltaX":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownY:F

    move/from16 v19, v0

    sub-float v6, v18, v19

    .line 204
    .local v6, "deltaY":F
    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mSlop:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-float v0, v0

    move/from16 v19, v0

    cmpl-float v18, v18, v19

    if-lez v18, :cond_c

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v18

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v19

    cmpl-float v18, v18, v19

    if-lez v18, :cond_c

    .line 205
    const/16 v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mSwiping:Z

    .line 206
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    const/16 v19, 0x1

    invoke-virtual/range {v18 .. v19}, Landroid/widget/ListView;->requestDisallowInterceptTouchEvent(Z)V

    .line 209
    invoke-static/range {p2 .. p2}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v2

    .line 210
    .local v2, "cancelEvent":Landroid/view/MotionEvent;
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v18

    shl-int/lit8 v18, v18, 0x8

    or-int/lit8 v18, v18, 0x3

    move/from16 v0, v18

    invoke-virtual {v2, v0}, Landroid/view/MotionEvent;->setAction(I)V

    .line 211
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mListView:Landroid/widget/ListView;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 214
    .end local v2    # "cancelEvent":Landroid/view/MotionEvent;
    :cond_c
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mSwiping:Z

    move/from16 v18, v0

    if-eqz v18, :cond_1

    .line 215
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-static {v0, v5}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 216
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mDownView:Landroid/view/View;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    const/high16 v20, 0x3f800000    # 1.0f

    const/high16 v21, 0x3f800000    # 1.0f

    const/high16 v22, 0x40000000    # 2.0f

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v23

    mul-float v22, v22, v23

    move-object/from16 v0, p0

    iget v0, v0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->mViewWidth:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    div-float v22, v22, v23

    sub-float v21, v21, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->min(FF)F

    move-result v20

    invoke-static/range {v19 .. v20}, Ljava/lang/Math;->max(FF)F

    move-result v19

    invoke-static/range {v18 .. v19}, Lcom/nineoldandroids/view/ViewHelper;->setAlpha(Landroid/view/View;F)V

    .line 217
    const/16 v18, 0x1

    goto/16 :goto_1

    .line 114
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
