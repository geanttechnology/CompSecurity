.class public Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;
.super Lcom/haarman/listviewanimations/BaseAdapterDecorator;
.source "AnimateDismissAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/haarman/listviewanimations/BaseAdapterDecorator;"
    }
.end annotation


# instance fields
.field private mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;


# direct methods
.method public constructor <init>(Landroid/widget/BaseAdapter;Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;)V
    .locals 0
    .param p1, "baseAdapter"    # Landroid/widget/BaseAdapter;
    .param p2, "callback"    # Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .prologue
    .line 52
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/BaseAdapterDecorator;-><init>(Landroid/widget/BaseAdapter;)V

    .line 53
    iput-object p2, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    .line 54
    return-void
.end method

.method static synthetic access$0(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Ljava/util/Collection;)V
    .locals 0

    .prologue
    .line 105
    invoke-direct {p0, p1}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->invokeCallback(Ljava/util/Collection;)V

    return-void
.end method

.method private createAnimatorForView(Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    const/4 v5, 0x0

    .line 127
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 128
    .local v1, "lp":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v2

    .line 130
    .local v2, "originalHeight":I
    const/4 v3, 0x2

    new-array v3, v3, [I

    aput v2, v3, v5

    const/4 v4, 0x1

    aput v5, v3, v4

    invoke-static {v3}, Lcom/nineoldandroids/animation/ValueAnimator;->ofInt([I)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v0

    .line 131
    .local v0, "animator":Lcom/nineoldandroids/animation/ValueAnimator;
    new-instance v3, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;

    invoke-direct {v3, p0, v1, p1}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$2;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V

    invoke-virtual {v0, v3}, Lcom/nineoldandroids/animation/ValueAnimator;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    .line 152
    new-instance v3, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;

    invoke-direct {v3, p0, v1, p1}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$3;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V

    invoke-virtual {v0, v3}, Lcom/nineoldandroids/animation/ValueAnimator;->addUpdateListener(Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 161
    return-object v0
.end method

.method private getVisibleViewsForPositions(Ljava/util/Collection;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 116
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    .local p1, "positions":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Integer;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 117
    .local v2, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ListView;->getChildCount()I

    move-result v3

    if-lt v1, v3, :cond_0

    .line 123
    return-object v2

    .line 118
    :cond_0
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 119
    .local v0, "child":Landroid/view/View;
    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/widget/ListView;->getPositionForView(Landroid/view/View;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v3}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 120
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 117
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private invokeCallback(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 106
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    .local p1, "positions":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Integer;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 107
    .local v2, "positionsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    invoke-static {v2}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 108
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v0, v3, [I

    .line 109
    .local v0, "dismissPositions":[I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lt v1, v3, :cond_0

    .line 112
    iget-object v3, p0, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->mCallback:Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;

    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;->onDismiss(Landroid/widget/ListView;[I)V

    .line 113
    return-void

    .line 110
    :cond_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    sub-int/2addr v3, v1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    aput v3, v0, v1

    .line 109
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public animateDismiss(I)V
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 57
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Integer;

    const/4 v1, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->animateDismiss(Ljava/util/Collection;)V

    .line 58
    return-void
.end method

.method public animateDismiss(Ljava/util/Collection;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p0, "this":Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;, "Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter<TT;>;"
    .local p1, "positions":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Integer;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 62
    .local v4, "positionsCopy":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const-string v7, "Call setListView() on this AnimateDismissAdapter before calling setAdapter()!"

    invoke-virtual {p0}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getListView()Landroid/widget/ListView;

    move-result-object v8

    invoke-static {v7, v8}, Ljunit/framework/Assert;->assertNotNull(Ljava/lang/String;Ljava/lang/Object;)V

    .line 64
    invoke-direct {p0, v4}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->getVisibleViewsForPositions(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v6

    .line 66
    .local v6, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_2

    .line 67
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 68
    .local v1, "animators":Ljava/util/List;, "Ljava/util/List<Lcom/nineoldandroids/animation/Animator;>;"
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_0

    .line 72
    new-instance v0, Lcom/nineoldandroids/animation/AnimatorSet;

    invoke-direct {v0}, Lcom/nineoldandroids/animation/AnimatorSet;-><init>()V

    .line 74
    .local v0, "animatorSet":Lcom/nineoldandroids/animation/AnimatorSet;
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    new-array v2, v7, [Lcom/nineoldandroids/animation/Animator;

    .line 75
    .local v2, "animatorsArray":[Lcom/nineoldandroids/animation/Animator;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v7, v2

    if-lt v3, v7, :cond_1

    .line 79
    invoke-virtual {v0, v2}, Lcom/nineoldandroids/animation/AnimatorSet;->playTogether([Lcom/nineoldandroids/animation/Animator;)V

    .line 80
    new-instance v7, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;

    invoke-direct {v7, p0, v4}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter$1;-><init>(Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;Ljava/util/List;)V

    invoke-virtual {v0, v7}, Lcom/nineoldandroids/animation/AnimatorSet;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    .line 99
    invoke-virtual {v0}, Lcom/nineoldandroids/animation/AnimatorSet;->start()V

    .line 103
    .end local v0    # "animatorSet":Lcom/nineoldandroids/animation/AnimatorSet;
    .end local v1    # "animators":Ljava/util/List;, "Ljava/util/List<Lcom/nineoldandroids/animation/Animator;>;"
    .end local v2    # "animatorsArray":[Lcom/nineoldandroids/animation/Animator;
    .end local v3    # "i":I
    :goto_2
    return-void

    .line 68
    .restart local v1    # "animators":Ljava/util/List;, "Ljava/util/List<Lcom/nineoldandroids/animation/Animator;>;"
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/View;

    .line 69
    .local v5, "view":Landroid/view/View;
    invoke-direct {p0, v5}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->createAnimatorForView(Landroid/view/View;)Lcom/nineoldandroids/animation/Animator;

    move-result-object v8

    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 76
    .end local v5    # "view":Landroid/view/View;
    .restart local v0    # "animatorSet":Lcom/nineoldandroids/animation/AnimatorSet;
    .restart local v2    # "animatorsArray":[Lcom/nineoldandroids/animation/Animator;
    .restart local v3    # "i":I
    :cond_1
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/nineoldandroids/animation/Animator;

    aput-object v7, v2, v3

    .line 75
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 101
    .end local v0    # "animatorSet":Lcom/nineoldandroids/animation/AnimatorSet;
    .end local v1    # "animators":Ljava/util/List;, "Ljava/util/List<Lcom/nineoldandroids/animation/Animator;>;"
    .end local v2    # "animatorsArray":[Lcom/nineoldandroids/animation/Animator;
    .end local v3    # "i":I
    :cond_2
    invoke-direct {p0, v4}, Lcom/haarman/listviewanimations/itemmanipulation/AnimateDismissAdapter;->invokeCallback(Ljava/util/Collection;)V

    goto :goto_2
.end method
