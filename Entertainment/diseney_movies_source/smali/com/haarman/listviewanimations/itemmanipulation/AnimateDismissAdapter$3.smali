.class Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;
.super Ljava/lang/Object;
.source "AnimateDismissAdapter.java"

# interfaces
.implements Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->createAnimatorForView(Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

.field private final synthetic val$lp:Landroid/view/ViewGroup$LayoutParams;

.field private final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    iput-object p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->val$view:Landroid/view/View;

    .line 152
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Lcom/nineoldandroids/animation/ValueAnimator;)V
    .locals 2
    .param p1, "valueAnimator"    # Lcom/nineoldandroids/animation/ValueAnimator;

    .prologue
    .line 156
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p1}, Lcom/nineoldandroids/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 157
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->val$view:Landroid/view/View;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 158
    return-void
.end method
