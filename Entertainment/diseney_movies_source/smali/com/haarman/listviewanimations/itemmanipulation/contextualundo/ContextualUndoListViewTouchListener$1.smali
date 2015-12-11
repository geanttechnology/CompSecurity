.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$1;
.super Ljava/lang/Object;
.source "ContextualUndoListViewTouchListener.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->makeScrollListener()Landroid/widget/AbsListView$OnScrollListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;


# direct methods
.method constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I
    .param p3, "i1"    # I
    .param p4, "i2"    # I

    .prologue
    .line 90
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 2
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    const/4 v0, 0x1

    .line 82
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    if-eq p2, v0, :cond_1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->setEnabled(Z)V

    .line 83
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->mPaused:Z
    invoke-static {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->access$0(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$1;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;
    invoke-static {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->access$1(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;)Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;

    move-result-object v0

    invoke-interface {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;->onListScrolled()V

    .line 86
    :cond_0
    return-void

    .line 82
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
