.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;
.super Ljava/lang/Object;
.source "ContextualUndoAdapter.java"

# interfaces
.implements Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RemoveViewAnimatorUpdateListener"
.end annotation


# instance fields
.field private final mDismissView:Landroid/view/View;

.field private final mLayoutParams:Landroid/view/ViewGroup$LayoutParams;

.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;


# direct methods
.method public constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V
    .locals 1
    .param p2, "dismissView"    # Landroid/view/View;

    .prologue
    .line 205
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 206
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->mDismissView:Landroid/view/View;

    .line 207
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iput-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->mLayoutParams:Landroid/view/ViewGroup$LayoutParams;

    .line 208
    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Lcom/nineoldandroids/animation/ValueAnimator;)V
    .locals 2
    .param p1, "valueAnimator"    # Lcom/nineoldandroids/animation/ValueAnimator;

    .prologue
    .line 212
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->mLayoutParams:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p1}, Lcom/nineoldandroids/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 213
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->mDismissView:Landroid/view/View;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;->mLayoutParams:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 214
    return-void
.end method
