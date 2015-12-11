.class public Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
.super Landroid/widget/FrameLayout;
.source "ContextualUndoView.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ViewConstructor"
    }
.end annotation


# instance fields
.field private mContentView:Landroid/view/View;

.field private mItemId:J

.field private mUndoView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "undoLayoutResourceId"    # I

    .prologue
    .line 32
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 33
    invoke-direct {p0, p2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->initUndo(I)V

    .line 34
    return-void
.end method

.method private initUndo(I)V
    .locals 2
    .param p1, "undoLayoutResourceId"    # I

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mUndoView:Landroid/view/View;

    .line 38
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mUndoView:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->addView(Landroid/view/View;)V

    .line 39
    return-void
.end method


# virtual methods
.method public displayContentView()V
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 71
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mUndoView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 72
    return-void
.end method

.method public displayUndo()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 66
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mUndoView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 67
    return-void
.end method

.method public getContentView()Landroid/view/View;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    return-object v0
.end method

.method public getItemId()J
    .locals 2

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mItemId:J

    return-wide v0
.end method

.method public isContentDisplayed()Z
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setItemId(J)V
    .locals 0
    .param p1, "itemId"    # J

    .prologue
    .line 53
    iput-wide p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mItemId:J

    .line 54
    return-void
.end method

.method public updateContentView(Landroid/view/View;)V
    .locals 1
    .param p1, "contentView"    # Landroid/view/View;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 43
    invoke-virtual {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->addView(Landroid/view/View;)V

    .line 45
    :cond_0
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->mContentView:Landroid/view/View;

    .line 46
    return-void
.end method
