.class public Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;
.super Lcom/haarman/listviewanimations/BaseAdapterDecorator;
.source "ContextualUndoAdapter.java"

# interfaces
.implements Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;,
        Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;,
        Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;,
        Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;,
        Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;
    }
.end annotation


# instance fields
.field private mActiveAnimators:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/view/View;",
            "Lcom/nineoldandroids/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field private final mAnimationTime:I

.field private mCurrentRemovedId:J

.field private mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

.field private mDeleteItemCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;

.field private final mUndoActionId:I

.field private final mUndoLayoutId:I


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;II)V
    .locals 2
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "undoLayoutId"    # I
    .param p3, "undoActionId"    # I

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;-><init>(Landroid/widget/BaseAdapter;)V

    .line 49
    const/16 v0, 0x96

    iput v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mAnimationTime:I

    .line 52
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mActiveAnimators:Ljava/util/Map;

    .line 58
    iput p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mUndoLayoutId:I

    .line 59
    iput p3, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mUndoActionId:I

    .line 60
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    .line 61
    return-void
.end method

.method static synthetic access$0(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mActiveAnimators:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$1(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 112
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->restoreViewPosition(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$2(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mDeleteItemCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;

    return-object v0
.end method

.method static synthetic access$3(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;)V
    .locals 0

    .prologue
    .line 128
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->clearCurrentRemovedView()V

    return-void
.end method

.method private clearCurrentRemovedView()V
    .locals 2

    .prologue
    .line 129
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 130
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    .line 131
    return-void
.end method

.method private performRemoval()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 141
    const/4 v1, 0x2

    new-array v1, v1, [I

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-virtual {v3}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->getHeight()I

    move-result v3

    aput v3, v1, v2

    aput v4, v1, v4

    invoke-static {v1}, Lcom/nineoldandroids/animation/ValueAnimator;->ofInt([I)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v1

    const-wide/16 v2, 0x96

    invoke-virtual {v1, v2, v3}, Lcom/nineoldandroids/animation/ValueAnimator;->setDuration(J)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v0

    .line 142
    .local v0, "animator":Lcom/nineoldandroids/animation/ValueAnimator;
    new-instance v1, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;

    iget-object v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-direct {v1, p0, v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorListenerAdapter;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/animation/ValueAnimator;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    .line 143
    new-instance v1, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;

    iget-object v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-direct {v1, p0, v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RemoveViewAnimatorUpdateListener;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/animation/ValueAnimator;->addUpdateListener(Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 144
    invoke-virtual {v0}, Lcom/nineoldandroids/animation/ValueAnimator;->start()V

    .line 145
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mActiveAnimators:Ljava/util/Map;

    iget-object v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->clearCurrentRemovedView()V

    .line 147
    return-void
.end method

.method private removePreviousContextualUndoIfPresent()V
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    if-eqz v0, :cond_0

    .line 119
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->performRemoval()V

    .line 121
    :cond_0
    return-void
.end method

.method private restoreViewPosition(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 113
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setAlpha(Landroid/view/View;F)V

    .line 114
    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 115
    return-void
.end method

.method private setCurrentRemovedView(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;)V
    .locals 2
    .param p1, "currentRemovedView"    # Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 125
    invoke-virtual {p1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->getItemId()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    .line 126
    return-void
.end method


# virtual methods
.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 65
    move-object v1, p2

    check-cast v1, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 66
    .local v1, "contextualUndoView":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
    if-nez v1, :cond_0

    .line 67
    new-instance v1, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .end local v1    # "contextualUndoView":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
    invoke-virtual {p3}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    iget v5, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mUndoLayoutId:I

    invoke-direct {v1, v4, v5}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;-><init>(Landroid/content/Context;I)V

    .line 68
    .restart local v1    # "contextualUndoView":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
    iget v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mUndoActionId:I

    invoke-virtual {v1, v4}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    new-instance v5, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;

    invoke-direct {v5, p0, v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$UndoListener;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;)V

    invoke-virtual {v4, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    move-object p2, v1

    .line 72
    :cond_0
    invoke-virtual {v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->getContentView()Landroid/view/View;

    move-result-object v4

    invoke-super {p0, p1, v4, p3}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 73
    .local v0, "contentView":Landroid/view/View;
    invoke-virtual {v1, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->updateContentView(Landroid/view/View;)V

    .line 75
    invoke-virtual {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->getItemId(I)J

    move-result-wide v2

    .line 77
    .local v2, "itemId":J
    iget-wide v4, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    cmp-long v4, v2, v4

    if-nez v4, :cond_1

    .line 78
    invoke-virtual {v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->displayUndo()V

    .line 79
    iput-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 84
    :goto_0
    invoke-virtual {v1, v2, v3}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->setItemId(J)V

    .line 85
    return-object v1

    .line 81
    :cond_1
    invoke-virtual {v1}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->displayContentView()V

    goto :goto_0
.end method

.method public onListScrolled()V
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    if-eqz v0, :cond_0

    .line 136
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->performRemoval()V

    .line 138
    :cond_0
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 4
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 160
    move-object v0, p1

    check-cast v0, Landroid/os/Bundle;

    .line 161
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "mCurrentRemovedId"

    const-wide/16 v2, -0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    .line 162
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 4

    .prologue
    .line 154
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 155
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "mCurrentRemovedId"

    iget-wide v2, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 156
    return-object v0
.end method

.method public onViewSwiped(Landroid/view/View;I)V
    .locals 2
    .param p1, "dismissView"    # Landroid/view/View;
    .param p2, "dismissPosition"    # I

    .prologue
    .line 99
    move-object v0, p1

    check-cast v0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    .line 100
    .local v0, "contextualUndoView":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;
    invoke-virtual {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->isContentDisplayed()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 101
    invoke-direct {p0, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->restoreViewPosition(Landroid/view/View;)V

    .line 102
    invoke-virtual {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;->displayUndo()V

    .line 103
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->removePreviousContextualUndoIfPresent()V

    .line 104
    invoke-direct {p0, v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->setCurrentRemovedView(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;)V

    .line 110
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    iget-object v1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mCurrentRemovedView:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoView;

    if-eqz v1, :cond_0

    .line 107
    invoke-direct {p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->performRemoval()V

    goto :goto_0
.end method

.method public setDeleteItemCallback(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;)V
    .locals 0
    .param p1, "deleteItemCallback"    # Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;->mDeleteItemCallback:Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$DeleteItemCallback;

    .line 151
    return-void
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 3
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 90
    invoke-super {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;->setListView(Landroid/widget/ListView;)V

    .line 91
    new-instance v0, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;

    invoke-direct {v0, p1, p0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;-><init>(Landroid/widget/ListView;Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener$Callback;)V

    .line 92
    .local v0, "contextualUndoListViewTouchListener":Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;
    invoke-virtual {p1, v0}, Landroid/widget/ListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 93
    invoke-virtual {v0}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoListViewTouchListener;->makeScrollListener()Landroid/widget/AbsListView$OnScrollListener;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 94
    new-instance v1, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter;Lcom/haarman/listviewanimations/itemmanipulation/contextualundo/ContextualUndoAdapter$RecycleViewListener;)V

    invoke-virtual {p1, v1}, Landroid/widget/ListView;->setRecyclerListener(Landroid/widget/AbsListView$RecyclerListener;)V

    .line 95
    return-void
.end method
