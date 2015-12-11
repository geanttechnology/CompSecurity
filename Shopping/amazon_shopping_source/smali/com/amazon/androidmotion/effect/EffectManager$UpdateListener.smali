.class Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;
.super Ljava/lang/Object;
.source "EffectManager.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/androidmotion/effect/EffectManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UpdateListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/androidmotion/effect/EffectManager;


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 5
    .param p1, "animation"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 68
    iget-object v3, p0, Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;->this$0:Lcom/amazon/androidmotion/effect/EffectManager;

    # getter for: Lcom/amazon/androidmotion/effect/EffectManager;->mEffect:Lcom/amazon/androidmotion/effect/Effect;
    invoke-static {v3}, Lcom/amazon/androidmotion/effect/EffectManager;->access$200(Lcom/amazon/androidmotion/effect/EffectManager;)Lcom/amazon/androidmotion/effect/Effect;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;->this$0:Lcom/amazon/androidmotion/effect/EffectManager;

    # getter for: Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;
    invoke-static {v4}, Lcom/amazon/androidmotion/effect/EffectManager;->access$100(Lcom/amazon/androidmotion/effect/EffectManager;)Landroid/animation/ValueAnimator;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/androidmotion/effect/Effect;->getFraction(Landroid/animation/ValueAnimator;)F

    move-result v1

    .line 69
    .local v1, "fraction":F
    iget-object v3, p0, Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;->this$0:Lcom/amazon/androidmotion/effect/EffectManager;

    # getter for: Lcom/amazon/androidmotion/effect/EffectManager;->mEffect:Lcom/amazon/androidmotion/effect/Effect;
    invoke-static {v3}, Lcom/amazon/androidmotion/effect/EffectManager;->access$200(Lcom/amazon/androidmotion/effect/EffectManager;)Lcom/amazon/androidmotion/effect/Effect;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/androidmotion/effect/Effect;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v2

    .line 70
    .local v2, "interpolator":Landroid/animation/TimeInterpolator;
    if-nez v2, :cond_0

    .line 71
    sget-object v2, Lcom/amazon/androidmotion/effect/EffectManager;->DEFAULT_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    .line 73
    :cond_0
    invoke-interface {v2, v1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result v0

    .line 74
    .local v0, "animatedFraction":F
    iget-object v3, p0, Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;->this$0:Lcom/amazon/androidmotion/effect/EffectManager;

    # getter for: Lcom/amazon/androidmotion/effect/EffectManager;->mEffect:Lcom/amazon/androidmotion/effect/Effect;
    invoke-static {v3}, Lcom/amazon/androidmotion/effect/EffectManager;->access$200(Lcom/amazon/androidmotion/effect/EffectManager;)Lcom/amazon/androidmotion/effect/Effect;

    move-result-object v3

    invoke-interface {v3, v0}, Lcom/amazon/androidmotion/effect/Effect;->update(F)V

    .line 75
    return-void
.end method
