.class Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;
.super Ljava/lang/Object;
.source "AnimateDismissAdapter.java"

# interfaces
.implements Lcom/nineoldandroids/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->animateDismiss(Ljava/util/Collection;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

.field private final synthetic val$positionsCopy:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;->val$positionsCopy:Ljava/util/List;

    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 97
    return-void
.end method

.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 2
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;->val$positionsCopy:Ljava/util/List;

    # invokes: Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->invokeCallback(Ljava/util/Collection;)V
    invoke-static {v0, v1}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->access$0(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Ljava/util/Collection;)V

    .line 93
    return-void
.end method

.method public onAnimationRepeat(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 88
    return-void
.end method

.method public onAnimationStart(Lcom/nineoldandroids/animation/Animator;)V
    .locals 0
    .param p1, "arg0"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 84
    return-void
.end method
