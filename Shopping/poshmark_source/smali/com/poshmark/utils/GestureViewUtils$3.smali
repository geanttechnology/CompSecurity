.class Lcom/poshmark/utils/GestureViewUtils$3;
.super Ljava/lang/Object;
.source "GestureViewUtils.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/GestureViewUtils;->startScaleAnimation(FFLcom/poshmark/ui/customviews/GestureView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/GestureViewUtils;

.field final synthetic val$v:Lcom/poshmark/ui/customviews/GestureView;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/GestureViewUtils;Lcom/poshmark/ui/customviews/GestureView;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/poshmark/utils/GestureViewUtils$3;->this$0:Lcom/poshmark/utils/GestureViewUtils;

    iput-object p2, p0, Lcom/poshmark/utils/GestureViewUtils$3;->val$v:Lcom/poshmark/ui/customviews/GestureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 3
    .param p1, "valueAnimator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 102
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    .line 103
    .local v0, "value":Ljava/lang/Float;
    iget-object v1, p0, Lcom/poshmark/utils/GestureViewUtils$3;->val$v:Lcom/poshmark/ui/customviews/GestureView;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/GestureView;->updateScaleFactor(F)V

    .line 105
    return-void
.end method
