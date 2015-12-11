.class public Lcom/amazon/androidmotion/lifecycle/AnimatorManager;
.super Ljava/lang/Object;
.source "AnimatorManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;
    }
.end annotation


# instance fields
.field private mAnimator:Landroid/animation/ValueAnimator;

.field private final mClearOnEndListener:Landroid/animation/AnimatorListenerAdapter;

.field private final mEffects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/androidmotion/effect/EffectManager;",
            ">;"
        }
    .end annotation
.end field

.field private mElapsedFractionCalculator:Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;

.field private final mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/animation/Animator$AnimatorListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mUpdateListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/animation/ValueAnimator$AnimatorUpdateListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    new-instance v0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager$1;

    invoke-direct {v0, p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager$1;-><init>(Lcom/amazon/androidmotion/lifecycle/AnimatorManager;)V

    iput-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mClearOnEndListener:Landroid/animation/AnimatorListenerAdapter;

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mListeners:Ljava/util/List;

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mUpdateListeners:Ljava/util/List;

    .line 38
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mEffects:Ljava/util/List;

    .line 39
    return-void
.end method


# virtual methods
.method public cancelAnimator()V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    .line 132
    invoke-virtual {p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->clearAnimator()V

    .line 134
    :cond_0
    return-void
.end method

.method public clearAnimator()V
    .locals 5

    .prologue
    .line 106
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v3, :cond_4

    .line 107
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    iget-object v4, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mClearOnEndListener:Landroid/animation/AnimatorListenerAdapter;

    invoke-virtual {v3, v4}, Landroid/animation/ValueAnimator;->removeListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 109
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/Animator$AnimatorListener;

    .line 110
    .local v2, "listener":Landroid/animation/Animator$AnimatorListener;
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v3, v2}, Landroid/animation/ValueAnimator;->removeListener(Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0

    .line 112
    .end local v2    # "listener":Landroid/animation/Animator$AnimatorListener;
    :cond_0
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mUpdateListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    .line 113
    .local v2, "listener":Landroid/animation/ValueAnimator$AnimatorUpdateListener;
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v3, v2}, Landroid/animation/ValueAnimator;->removeUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    goto :goto_1

    .line 116
    .end local v2    # "listener":Landroid/animation/ValueAnimator$AnimatorUpdateListener;
    :cond_1
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mEffects:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/androidmotion/effect/EffectManager;

    .line 117
    .local v0, "effect":Lcom/amazon/androidmotion/effect/EffectManager;
    invoke-virtual {v0}, Lcom/amazon/androidmotion/effect/EffectManager;->getAnimator()Landroid/animation/ValueAnimator;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-ne v3, v4, :cond_2

    .line 118
    invoke-virtual {v0}, Lcom/amazon/androidmotion/effect/EffectManager;->detachFromAnimator()V

    goto :goto_2

    .line 122
    .end local v0    # "effect":Lcom/amazon/androidmotion/effect/EffectManager;
    :cond_3
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    .line 124
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_4
    return-void
.end method

.method public getElapsedFraction()F
    .locals 2

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mElapsedFractionCalculator:Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mElapsedFractionCalculator:Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;

    iget-object v1, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-interface {v0, v1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;->getElapsedFraction(Landroid/animation/ValueAnimator;)F

    move-result v0

    .line 205
    :goto_0
    return v0

    .line 201
    :cond_0
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_1

    .line 203
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getAnimatedFraction()F

    move-result v0

    goto :goto_0

    .line 205
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasAnimator()Z
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public reduceDurationByElapsed(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animator"    # Landroid/animation/Animator;

    .prologue
    .line 188
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    .line 189
    invoke-virtual {p1}, Landroid/animation/Animator;->getDuration()J

    move-result-wide v0

    long-to-float v0, v0

    invoke-virtual {p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->getElapsedFraction()F

    move-result v1

    mul-float/2addr v0, v1

    float-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 191
    :cond_0
    return-void
.end method

.method public reduceDurationByRemaining(Landroid/animation/Animator;)V
    .locals 3
    .param p1, "animator"    # Landroid/animation/Animator;

    .prologue
    .line 178
    iget-object v0, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    .line 179
    invoke-virtual {p1}, Landroid/animation/Animator;->getDuration()J

    move-result-wide v0

    long-to-float v0, v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->getElapsedFraction()F

    move-result v2

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    float-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    .line 181
    :cond_0
    return-void
.end method

.method public runAnimator(Landroid/animation/ValueAnimator;)V
    .locals 0
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 159
    invoke-virtual {p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->cancelAnimator()V

    .line 160
    invoke-virtual {p0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->setAnimator(Landroid/animation/ValueAnimator;)V

    .line 161
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->start()V

    .line 162
    return-void
.end method

.method public runAnimatorForElapsed(Landroid/animation/ValueAnimator;)V
    .locals 0
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 151
    invoke-virtual {p0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->reduceDurationByElapsed(Landroid/animation/Animator;)V

    .line 152
    invoke-virtual {p0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->runAnimator(Landroid/animation/ValueAnimator;)V

    .line 153
    return-void
.end method

.method public runAnimatorForRemaining(Landroid/animation/ValueAnimator;)V
    .locals 0
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 141
    invoke-virtual {p0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->reduceDurationByRemaining(Landroid/animation/Animator;)V

    .line 142
    invoke-virtual {p0, p1}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->runAnimator(Landroid/animation/ValueAnimator;)V

    .line 143
    return-void
.end method

.method public setAnimator(Landroid/animation/ValueAnimator;)V
    .locals 5
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 83
    invoke-virtual {p0}, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->clearAnimator()V

    .line 85
    if-eqz p1, :cond_2

    .line 86
    iput-object p1, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    .line 87
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    iget-object v4, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mClearOnEndListener:Landroid/animation/AnimatorListenerAdapter;

    invoke-virtual {v3, v4}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 89
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/Animator$AnimatorListener;

    .line 90
    .local v2, "listener":Landroid/animation/Animator$AnimatorListener;
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v3, v2}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0

    .line 92
    .end local v2    # "listener":Landroid/animation/Animator$AnimatorListener;
    :cond_0
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mUpdateListeners:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    .line 93
    .local v2, "listener":Landroid/animation/ValueAnimator$AnimatorUpdateListener;
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v3, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    goto :goto_1

    .line 96
    .end local v2    # "listener":Landroid/animation/ValueAnimator$AnimatorUpdateListener;
    :cond_1
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mEffects:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/androidmotion/effect/EffectManager;

    .line 97
    .local v0, "effect":Lcom/amazon/androidmotion/effect/EffectManager;
    iget-object v3, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, v3}, Lcom/amazon/androidmotion/effect/EffectManager;->setAnimator(Landroid/animation/ValueAnimator;)V

    goto :goto_2

    .line 100
    .end local v0    # "effect":Lcom/amazon/androidmotion/effect/EffectManager;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    return-void
.end method

.method public setElapsedFractionCalculator(Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;)V
    .locals 0
    .param p1, "elapsedFractionCalculator"    # Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/androidmotion/lifecycle/AnimatorManager;->mElapsedFractionCalculator:Lcom/amazon/androidmotion/lifecycle/AnimatorManager$ElapsedFractionCalculator;

    .line 62
    return-void
.end method
