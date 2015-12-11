.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;
.super Lcom/nineoldandroids/animation/AnimatorListenerAdapter;
.source "ContextualUndoListViewTouchListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

.field private final synthetic val$downPosition:I

.field private final synthetic val$downView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;Landroid/view/View;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->val$downView:Landroid/view/View;

    iput p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->val$downPosition:I

    .line 162
    invoke-direct {p0}, Lcom/nineoldandroids/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 3
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 165
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;
    invoke-static {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->access$1(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;)Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;

    move-result-object v0

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->val$downView:Landroid/view/View;

    iget v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$2;->val$downPosition:I

    invoke-interface {v0, v1, v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;->onViewSwiped(Landroid/view/View;I)V

    .line 166
    return-void
.end method
