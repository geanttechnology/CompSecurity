.class Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;
.super Ljava/lang/Object;
.source "SwipeDismissListViewTouchListener.java"

# interfaces
.implements Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->performDismiss(Landroid/view/View;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

.field private final synthetic val$dismissView:Landroid/view/View;

.field private final synthetic val$lp:Landroid/view/ViewGroup$LayoutParams;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    iput-object p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->val$dismissView:Landroid/view/View;

    .line 285
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Lcom/nineoldandroids/animation/ValueAnimator;)V
    .locals 2
    .param p1, "valueAnimator"    # Lcom/nineoldandroids/animation/ValueAnimator;

    .prologue
    .line 288
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p1}, Lcom/nineoldandroids/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 289
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->val$dismissView:Landroid/view/View;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$3;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 290
    return-void
.end method
