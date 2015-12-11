.class public Lco/vine/android/widget/CounterView$DigitAnimation;
.super Ljava/lang/Object;
.source "CounterView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/CounterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DigitAnimation"
.end annotation


# instance fields
.field public mAnimatingCount:J

.field public mAnimationDuration:J

.field public mAnimationStartTime:J

.field public mCurrentAnimatingToDigit:I

.field private final mDivider:D

.field public mDrawingDigit:I

.field public final mIndexFromRight:I

.field public mIsAnimating:Z

.field private final mNextDivider:D

.field final synthetic this$0:Lco/vine/android/widget/CounterView;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/CounterView;IDJ)V
    .locals 4
    .param p2, "indexFromRight"    # I
    .param p3, "velocityPerMS"    # D
    .param p5, "drawingCount"    # J

    .prologue
    .line 93
    iput-object p1, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->this$0:Lco/vine/android/widget/CounterView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput p2, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    .line 95
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    iget v2, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    int-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDivider:D

    .line 96
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    iget v2, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    add-int/lit8 v2, v2, 0x1

    int-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mNextDivider:D

    .line 97
    iget v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    if-lez v0, :cond_0

    .line 98
    long-to-double v0, p5

    iget-wide v2, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDivider:D

    div-double/2addr v0, v2

    const-wide/high16 v2, 0x4024000000000000L    # 10.0

    rem-double/2addr v0, v2

    double-to-int v0, v0

    iput v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    .line 102
    :goto_0
    iput-wide p5, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    .line 103
    const-wide/16 v0, 0x0

    cmpl-double v0, p3, v0

    if-lez v0, :cond_3

    .line 104
    # getter for: Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;
    invoke-static {p1}, Lco/vine/android/widget/CounterView;->access$000(Lco/vine/android/widget/CounterView;)Lco/vine/android/widget/CounterView$AnimationMode;

    move-result-object v0

    iget-boolean v0, v0, Lco/vine/android/widget/CounterView$AnimationMode;->continuousAnimation:Z

    if-eqz v0, :cond_2

    .line 105
    iget v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    if-lez v0, :cond_1

    .line 106
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    iget v2, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    mul-int/lit8 v2, v2, 0xa

    int-to-double v2, v2

    div-double v2, p3, v2

    div-double/2addr v0, v2

    double-to-long v0, v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    .line 116
    :goto_1
    sget-object v0, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    iget-wide v1, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    .line 117
    iget-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    # getter for: Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MAX:I
    invoke-static {}, Lco/vine/android/widget/CounterView;->access$100()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    .line 118
    iget-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    # getter for: Lco/vine/android/widget/CounterView;->ANIMATION_DURATION_MIN:I
    invoke-static {}, Lco/vine/android/widget/CounterView;->access$200()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    .line 119
    return-void

    .line 100
    :cond_0
    const-wide/16 v0, 0xa

    rem-long v0, p5, v0

    long-to-int v0, v0

    iput v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    goto :goto_0

    .line 108
    :cond_1
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    div-double/2addr v0, p3

    double-to-long v0, v0

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    goto :goto_1

    .line 111
    :cond_2
    const-wide/32 v0, 0x7fffffff

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    goto :goto_1

    .line 114
    :cond_3
    const-wide/32 v0, 0x7fffffff

    iput-wide v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    goto :goto_1
.end method


# virtual methods
.method public invalidate(JJZ)Z
    .locals 8
    .param p1, "currentTime"    # J
    .param p3, "currentCount"    # J
    .param p5, "shouldAnimate"    # Z

    .prologue
    .line 122
    iget v0, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    .line 123
    .local v0, "currentRealDigit":I
    iget-boolean v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIsAnimating:Z

    if-eqz v4, :cond_0

    .line 124
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationStartTime:J

    sub-long v4, p1, v4

    iget-wide v6, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationDuration:J

    cmp-long v4, v4, v6

    if-lez v4, :cond_0

    .line 125
    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    if-lez v4, :cond_3

    .line 126
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    long-to-double v4, v4

    iget-wide v6, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDivider:D

    div-double/2addr v4, v6

    const-wide/high16 v6, 0x4024000000000000L    # 10.0

    rem-double/2addr v4, v6

    double-to-int v0, v4

    .line 130
    :goto_0
    iget-object v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->this$0:Lco/vine/android/widget/CounterView;

    # getter for: Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;
    invoke-static {v4}, Lco/vine/android/widget/CounterView;->access$000(Lco/vine/android/widget/CounterView;)Lco/vine/android/widget/CounterView$AnimationMode;

    move-result-object v4

    iget-boolean v4, v4, Lco/vine/android/widget/CounterView$AnimationMode;->pedometerAnimation:Z

    if-eqz v4, :cond_4

    .line 131
    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    add-int/lit8 v4, v4, 0x1

    rem-int/lit8 v4, v4, 0xa

    iput v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    .line 135
    :goto_1
    const/4 v4, 0x0

    iput-boolean v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIsAnimating:Z

    .line 138
    :cond_0
    const/4 v3, 0x0

    .line 139
    .local v3, "shouldAnimateNext":Z
    if-nez p5, :cond_1

    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    if-eq v0, v4, :cond_2

    .line 140
    :cond_1
    iget-boolean v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIsAnimating:Z

    if-nez v4, :cond_2

    .line 141
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIsAnimating:Z

    .line 142
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimationStartTime:J

    .line 143
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    long-to-double v4, v4

    iget-wide v6, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mNextDivider:D

    div-double/2addr v4, v6

    double-to-int v1, v4

    .line 144
    .local v1, "currentRest":I
    long-to-double v4, p3

    iget-wide v6, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mNextDivider:D

    div-double/2addr v4, v6

    double-to-int v2, v4

    .line 145
    .local v2, "nextRest":I
    if-eq v1, v2, :cond_5

    const/4 v3, 0x1

    .line 146
    :goto_2
    iput-wide p3, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    .line 147
    iget-object v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->this$0:Lco/vine/android/widget/CounterView;

    # getter for: Lco/vine/android/widget/CounterView;->mAnimationMode:Lco/vine/android/widget/CounterView$AnimationMode;
    invoke-static {v4}, Lco/vine/android/widget/CounterView;->access$000(Lco/vine/android/widget/CounterView;)Lco/vine/android/widget/CounterView$AnimationMode;

    move-result-object v4

    iget-boolean v4, v4, Lco/vine/android/widget/CounterView$AnimationMode;->pedometerAnimation:Z

    if-eqz v4, :cond_6

    .line 148
    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    add-int/lit8 v4, v4, 0x1

    rem-int/lit8 v4, v4, 0xa

    iput v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    .line 158
    .end local v1    # "currentRest":I
    .end local v2    # "nextRest":I
    :cond_2
    :goto_3
    return v3

    .line 128
    .end local v3    # "shouldAnimateNext":Z
    :cond_3
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    const-wide/16 v6, 0xa

    rem-long/2addr v4, v6

    long-to-int v0, v4

    goto :goto_0

    .line 133
    :cond_4
    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    iput v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDrawingDigit:I

    goto :goto_1

    .line 145
    .restart local v1    # "currentRest":I
    .restart local v2    # "nextRest":I
    .restart local v3    # "shouldAnimateNext":Z
    :cond_5
    const/4 v3, 0x0

    goto :goto_2

    .line 150
    :cond_6
    iget v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mIndexFromRight:I

    if-lez v4, :cond_7

    .line 151
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    long-to-double v4, v4

    iget-wide v6, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mDivider:D

    div-double/2addr v4, v6

    const-wide/high16 v6, 0x4024000000000000L    # 10.0

    rem-double/2addr v4, v6

    double-to-int v4, v4

    iput v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    goto :goto_3

    .line 153
    :cond_7
    iget-wide v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mAnimatingCount:J

    const-wide/16 v6, 0xa

    rem-long/2addr v4, v6

    long-to-int v4, v4

    iput v4, p0, Lco/vine/android/widget/CounterView$DigitAnimation;->mCurrentAnimatingToDigit:I

    goto :goto_3
.end method
