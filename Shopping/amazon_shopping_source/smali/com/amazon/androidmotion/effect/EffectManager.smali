.class public Lcom/amazon/androidmotion/effect/EffectManager;
.super Ljava/lang/Object;
.source "EffectManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;
    }
.end annotation


# static fields
.field public static final DEFAULT_INTERPOLATOR:Landroid/animation/TimeInterpolator;


# instance fields
.field private mAnimator:Landroid/animation/ValueAnimator;

.field private final mEffect:Lcom/amazon/androidmotion/effect/Effect;

.field private final mListener:Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    sput-object v0, Lcom/amazon/androidmotion/effect/EffectManager;->DEFAULT_INTERPOLATOR:Landroid/animation/TimeInterpolator;

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/androidmotion/effect/EffectManager;)Landroid/animation/ValueAnimator;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/androidmotion/effect/EffectManager;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/androidmotion/effect/EffectManager;)Lcom/amazon/androidmotion/effect/Effect;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/androidmotion/effect/EffectManager;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mEffect:Lcom/amazon/androidmotion/effect/Effect;

    return-object v0
.end method


# virtual methods
.method public detachFromAnimator()V
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    iget-object v1, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mListener:Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->removeUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 61
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    .line 63
    :cond_0
    return-void
.end method

.method public getAnimator()Landroid/animation/ValueAnimator;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    return-object v0
.end method

.method public setAnimator(Landroid/animation/ValueAnimator;)V
    .locals 1
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/amazon/androidmotion/effect/EffectManager;->detachFromAnimator()V

    .line 49
    if-eqz p1, :cond_0

    .line 50
    iget-object v0, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mListener:Lcom/amazon/androidmotion/effect/EffectManager$UpdateListener;

    invoke-virtual {p1, v0}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 52
    :cond_0
    iput-object p1, p0, Lcom/amazon/androidmotion/effect/EffectManager;->mAnimator:Landroid/animation/ValueAnimator;

    .line 53
    return-void
.end method
