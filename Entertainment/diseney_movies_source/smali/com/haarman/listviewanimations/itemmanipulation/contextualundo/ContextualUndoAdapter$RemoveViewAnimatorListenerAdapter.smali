.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;
.super Lcom/nineoldandroids/animation/AnimatorListenerAdapter;
.source "ContextualUndoAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RemoveViewAnimatorListenerAdapter"
.end annotation


# instance fields
.field private final mDismissView:Landroid/view/View;

.field private final mOriginalHeight:I

.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;


# direct methods
.method public constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V
    .locals 1
    .param p2, "dismissView"    # Landroid/view/View;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    invoke-direct {p0}, Lcom/nineoldandroids/animation/AnimatorListenerAdapter;-><init>()V

    .line 174
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mDismissView:Landroid/view/View;

    .line 175
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mOriginalHeight:I

    .line 176
    return-void
.end method

.method private deleteCurrentItem()V
    .locals 3

    .prologue
    .line 194
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mDismissView:Landroid/view/View;

    check-cast v0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 195
    .local v0, "contextualUndoView":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
    iget-object v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    invoke-virtual {v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/widget/ListView;->getPositionForView(Landroid/view/View;)I

    move-result v1

    .line 196
    .local v1, "position":I
    iget-object v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mDeleteItemCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;
    invoke-static {v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->access$2(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;->deleteItem(I)V

    .line 197
    return-void
.end method

.method private restoreViewDimension(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 188
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 189
    .local v0, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mOriginalHeight:I

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 190
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 191
    return-void
.end method


# virtual methods
.method public onAnimationEnd(Lcom/nineoldandroids/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Lcom/nineoldandroids/animation/Animator;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mActiveAnimators:Ljava/util/Map;
    invoke-static {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->access$0(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mDismissView:Landroid/view/View;

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mDismissView:Landroid/view/View;

    # invokes: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->restoreViewPosition(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->access$1(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V

    .line 182
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->mDismissView:Landroid/view/View;

    invoke-direct {p0, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->restoreViewDimension(Landroid/view/View;)V

    .line 183
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;->deleteCurrentItem()V

    .line 184
    return-void
.end method
