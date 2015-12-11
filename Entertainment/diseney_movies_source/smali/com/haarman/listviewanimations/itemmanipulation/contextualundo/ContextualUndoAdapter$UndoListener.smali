.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;
.super Ljava/lang/Object;
.source "ContextualUndoAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UndoListener"
.end annotation


# instance fields
.field private final mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;


# direct methods
.method public constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;)V
    .locals 0
    .param p2, "contextualUndoView"    # Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .prologue
    .line 221
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 222
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 223
    return-void
.end method

.method private animateViewComingBack()V
    .locals 3

    .prologue
    .line 238
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-static {v0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->animate(Landroid/view/View;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->translationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v1, 0x96

    invoke-virtual {v0, v1, v2}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setDuration(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    .line 239
    return-void
.end method

.method private moveViewOffScreen()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-virtual {v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-static {v0, v1}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 235
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 227
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    # invokes: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->clearCurrentRemovedView()V
    invoke-static {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->access$3(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)V

    .line 228
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->mContextualUndoView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-virtual {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->displayContentView()V

    .line 229
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->moveViewOffScreen()V

    .line 230
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;->animateViewComingBack()V

    .line 231
    return-void
.end method
