.class Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;
.super Ljava/lang/Object;
.source "ContextualUndoAdapter.java"

# interfaces
.implements Landroid/widget/AbsListView$RecyclerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RecycleViewListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;


# direct methods
.method private constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)V
    .locals 0

    .prologue
    .line 242
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;)V
    .locals 0

    .prologue
    .line 242
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)V

    return-void
.end method


# virtual methods
.method public onMovedToScrapHeap(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 245
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;->this$0:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;

    # getter for: Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mActiveAnimators:Ljava/util/Map;
    invoke-static {v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->access$0(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/nineoldandroids/animation/Animator;

    .line 246
    .local v0, "animator":Lcom/nineoldandroids/animation/Animator;
    if-eqz v0, :cond_0

    .line 247
    invoke-virtual {v0}, Lcom/nineoldandroids/animation/Animator;->cancel()V

    .line 249
    :cond_0
    return-void
.end method
