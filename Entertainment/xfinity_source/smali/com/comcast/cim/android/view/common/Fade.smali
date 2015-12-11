.class public Lcom/comcast/cim/android/view/common/Fade;
.super Ljava/lang/Object;
.source "Fade.java"


# instance fields
.field private mDuration:J

.field private mDurationSet:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/Fade;->mDurationSet:Z

    .line 16
    const-wide/16 v0, 0x12c

    iput-wide v0, p0, Lcom/comcast/cim/android/view/common/Fade;->mDuration:J

    return-void
.end method


# virtual methods
.method public hide(Landroid/view/View;I)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "visibility"    # I

    .prologue
    .line 100
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_2

    const/4 v1, 0x4

    if-eq p2, v1, :cond_0

    const/16 v1, 0x8

    if-ne p2, v1, :cond_2

    .line 102
    :cond_0
    const-string v1, "alpha"

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_0

    invoke-static {p1, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 103
    .local v0, "animator":Landroid/animation/ObjectAnimator;
    iget-boolean v1, p0, Lcom/comcast/cim/android/view/common/Fade;->mDurationSet:Z

    if-eqz v1, :cond_1

    .line 104
    iget-wide v2, p0, Lcom/comcast/cim/android/view/common/Fade;->mDuration:J

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 106
    :cond_1
    new-instance v1, Lcom/comcast/cim/android/view/common/Fade$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/cim/android/view/common/Fade$2;-><init>(Lcom/comcast/cim/android/view/common/Fade;Landroid/view/View;I)V

    invoke-virtual {v0, v1}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 113
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 115
    .end local v0    # "animator":Landroid/animation/ObjectAnimator;
    :cond_2
    return-void

    .line 102
    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method public setDuration(J)V
    .locals 3
    .param p1, "duration"    # J

    .prologue
    .line 24
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 25
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/Fade;->mDurationSet:Z

    .line 26
    iput-wide p1, p0, Lcom/comcast/cim/android/view/common/Fade;->mDuration:J

    .line 28
    :cond_0
    return-void
.end method

.method public show(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 124
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_1

    .line 125
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/view/View;->setAlpha(F)V

    .line 126
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 127
    const-string v1, "alpha"

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_0

    invoke-static {p1, v1, v2}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    .line 128
    .local v0, "animator":Landroid/animation/ObjectAnimator;
    iget-boolean v1, p0, Lcom/comcast/cim/android/view/common/Fade;->mDurationSet:Z

    if-eqz v1, :cond_0

    .line 129
    iget-wide v2, p0, Lcom/comcast/cim/android/view/common/Fade;->mDuration:J

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 131
    :cond_0
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 133
    .end local v0    # "animator":Landroid/animation/ObjectAnimator;
    :cond_1
    return-void

    .line 127
    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method
