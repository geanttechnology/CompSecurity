.class Lcom/poshmark/utils/GestureViewUtils$1;
.super Ljava/lang/Object;
.source "GestureViewUtils.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/GestureViewUtils;->startTranslationAnimation(Landroid/graphics/Point;Landroid/graphics/Point;Lcom/poshmark/ui/customviews/GestureView;)V
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
    .line 72
    iput-object p1, p0, Lcom/poshmark/utils/GestureViewUtils$1;->this$0:Lcom/poshmark/utils/GestureViewUtils;

    iput-object p2, p0, Lcom/poshmark/utils/GestureViewUtils$1;->val$v:Lcom/poshmark/ui/customviews/GestureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2
    .param p1, "valueAnimator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 75
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Point;

    .line 76
    .local v0, "value":Landroid/graphics/Point;
    iget-object v1, p0, Lcom/poshmark/utils/GestureViewUtils$1;->val$v:Lcom/poshmark/ui/customviews/GestureView;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/GestureView;->updateTranslation(Landroid/graphics/Point;)V

    .line 77
    return-void
.end method
