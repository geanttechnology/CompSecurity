.class Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;
.super Lcom/nineoldandroids/animation/AnimatorListenerAdapter;
.source "SwipeDismissListViewTouchListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

.field private final synthetic val$downPosition:I

.field private final synthetic val$downView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/View;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->val$downView:Landroid/view/View;

    iput p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->val$downPosition:I

    .line 178
    invoke-direct {p0}, Lcom/nineoldandroids/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 3
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 181
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->val$downView:Landroid/view/View;

    iget v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener$1;->val$downPosition:I

    # invokes: Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->performDismiss(Landroid/view/View;I)V
    invoke-static {v0, v1, v2}, Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;->access$0(Lcom/haarman/listviewanimations/itemmanipulation/SwipeDismissListViewTouchListener;Landroid/view/View;I)V

    .line 182
    return-void
.end method
