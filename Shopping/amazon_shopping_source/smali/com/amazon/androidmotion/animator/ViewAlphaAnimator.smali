.class public Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;
.super Ljava/lang/Object;
.source "ViewAlphaAnimator.java"


# instance fields
.field private mAnimatingVisible:Z

.field private mDuration:J

.field private mInterpolator:Landroid/animation/TimeInterpolator;

.field private mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

.field private mMaxAlpha:F

.field private mMinAlpha:F

.field private mViews:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;FFJ)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "minAlpha"    # F
    .param p3, "maxAlpha"    # F
    .param p4, "duration"    # J

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mInterpolator:Landroid/animation/TimeInterpolator;

    .line 46
    invoke-virtual {p0, p2, p3, p4, p5}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->init(FFJ)V

    .line 47
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mViews:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/view/View;J)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "duration"    # J

    .prologue
    .line 38
    const/4 v2, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    move-object v0, p0

    move-object v1, p1

    move-wide v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;-><init>(Landroid/view/View;FFJ)V

    .line 39
    return-void
.end method

.method private getAlphaAnimator(F)Landroid/animation/ValueAnimator;
    .locals 4
    .param p1, "end"    # F

    .prologue
    .line 203
    const/4 v1, 0x2

    new-array v1, v1, [F

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->getAlpha()F

    move-result v3

    aput v3, v1, v2

    const/4 v2, 0x1

    aput p1, v1, v2

    invoke-static {v1}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 204
    .local v0, "animator":Landroid/animation/ValueAnimator;
    iget-wide v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mDuration:J

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 205
    iget-object v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 206
    new-instance v1, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$2;

    invoke-direct {v1, p0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$2;-><init>(Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 213
    return-object v0
.end method


# virtual methods
.method public animateHide()V
    .locals 2

    .prologue
    .line 151
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateHide(J)V

    .line 152
    return-void
.end method

.method public animateHide(J)V
    .locals 2
    .param p1, "delayMs"    # J

    .prologue
    .line 155
    iget-object v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->hasAnimator()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mAnimatingVisible:Z

    if-eqz v1, :cond_1

    .line 156
    :cond_0
    iget v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMinAlpha:F

    invoke-direct {p0, v1}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->getAlphaAnimator(F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 157
    .local v0, "animator":Landroid/animation/ValueAnimator;
    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    .line 158
    invoke-virtual {p0, v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->runHideAnimator(Landroid/animation/ValueAnimator;)V

    .line 160
    .end local v0    # "animator":Landroid/animation/ValueAnimator;
    :cond_1
    return-void
.end method

.method public animateShow()V
    .locals 2

    .prologue
    .line 139
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->animateShow(J)V

    .line 140
    return-void
.end method

.method public animateShow(J)V
    .locals 2
    .param p1, "delayMs"    # J

    .prologue
    .line 143
    iget-object v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->hasAnimator()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mAnimatingVisible:Z

    if-nez v1, :cond_1

    .line 144
    :cond_0
    iget v1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMaxAlpha:F

    invoke-direct {p0, v1}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->getAlphaAnimator(F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 145
    .local v0, "animator":Landroid/animation/ValueAnimator;
    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    .line 146
    invoke-virtual {p0, v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->runShowAnimator(Landroid/animation/ValueAnimator;)V

    .line 148
    .end local v0    # "animator":Landroid/animation/ValueAnimator;
    :cond_1
    return-void
.end method

.method public getAlpha()F
    .locals 2

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mViews:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getAlpha()F

    move-result v0

    return v0
.end method

.method public getFraction()F
    .locals 2

    .prologue
    .line 233
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mViews:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getAlpha()F

    move-result v0

    return v0
.end method

.method public hide()V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->cancelAnimator()V

    .line 127
    iget v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMinAlpha:F

    invoke-virtual {p0, v0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->setAlpha(F)V

    .line 128
    return-void
.end method

.method public init(FFJ)V
    .locals 2
    .param p1, "minAlpha"    # F
    .param p2, "maxAlpha"    # F
    .param p3, "duration"    # J

    .prologue
    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mViews:Ljava/util/List;

    .line 74
    iput p1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMinAlpha:F

    .line 75
    iput p2, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMaxAlpha:F

    .line 76
    iput-wide p3, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mDuration:J

    .line 78
    new-instance v0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-direct {v0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    .line 79
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    new-instance v1, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$1;

    invoke-direct {v1, p0}, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator$1;-><init>(Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;)V

    invoke-virtual {v0, v1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->setElapsedFractionCalculator(Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;)V

    .line 85
    return-void
.end method

.method public runHideAnimator(Landroid/animation/ValueAnimator;)V
    .locals 1
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 198
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mAnimatingVisible:Z

    .line 199
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->runAnimatorForElapsed(Landroid/animation/ValueAnimator;)V

    .line 200
    return-void
.end method

.method public runShowAnimator(Landroid/animation/ValueAnimator;)V
    .locals 1
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 193
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mAnimatingVisible:Z

    .line 194
    iget-object v0, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mManager:Lcom/amazon/androidmotion/lifecycle/AnimatorManager;

    invoke-virtual {v0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->runAnimatorForRemaining(Landroid/animation/ValueAnimator;)V

    .line 195
    return-void
.end method

.method public setAlpha(F)V
    .locals 3
    .param p1, "alpha"    # F

    .prologue
    .line 222
    iget-object v2, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mViews:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 223
    .local v1, "view":Landroid/view/View;
    invoke-virtual {v1, p1}, Landroid/view/View;->setAlpha(F)V

    .line 224
    const/4 v2, 0x0

    cmpl-float v2, p1, v2

    if-nez v2, :cond_0

    .line 225
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 227
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 230
    .end local v1    # "view":Landroid/view/View;
    :cond_1
    return-void
.end method

.method public setDuration(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 112
    iput-wide p1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mDuration:J

    .line 113
    return-void
.end method

.method public setMaxAlpha(F)V
    .locals 0
    .param p1, "alpha"    # F

    .prologue
    .line 104
    iput p1, p0, Lcom/amazon/androidmotion/animator/ViewAlphaAnimator;->mMaxAlpha:F

    .line 105
    return-void
.end method
