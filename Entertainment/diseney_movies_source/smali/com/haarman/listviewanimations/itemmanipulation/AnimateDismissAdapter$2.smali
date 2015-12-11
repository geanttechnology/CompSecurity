.class Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;
.super Ljava/lang/Object;
.source "AnimateDismissAdapter.java"

# interfaces
.implements Lcom/nineoldandroids/animation/Animator$AnimatorListener;


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
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    iput-object p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->val$view:Landroid/view/View;

    .line 131
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 149
    return-void
.end method

.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 2
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    const/4 v1, 0x0

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 144
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->val$view:Landroid/view/View;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;->val$lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 145
    return-void
.end method

.method public onAnimationRepeat(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 139
    return-void
.end method

.method public onAnimationStart(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 135
    return-void
.end method
