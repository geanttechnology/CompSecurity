.class public Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;
.source "EntityGridView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;,
        Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private compositeScrollListener:Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

.field private inflater:Landroid/view/LayoutInflater;

.field private isAccessibilityEnabled:Z

.field private isFlinging:Z

.field private mTrackedChild:Landroid/view/View;

.field private mTrackedChildPrevLeft:I

.field private mTrackedChildPrevPosition:I

.field private mTrackedChildPrevTop:I

.field private noResultsText:Landroid/view/View;

.field private onScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;

.field private scrollingShadow:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;-><init>(Landroid/content/Context;)V

    .line 28
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->compositeScrollListener:Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    .line 54
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->initialize(Landroid/content/Context;)V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->compositeScrollListener:Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    .line 59
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->initialize(Landroid/content/Context;)V

    .line 60
    return-void
.end method

.method private getChildInTheMiddle()Landroid/view/View;
    .locals 1

    .prologue
    .line 184
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildCount()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private initialize(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 63
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->inflater:Landroid/view/LayoutInflater;

    .line 64
    return-void
.end method


# virtual methods
.method public computeVerticalScrollRange()I
    .locals 1

    .prologue
    .line 280
    invoke-super {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->computeVerticalScrollRange()I

    move-result v0

    return v0
.end method

.method public getContentHeight()I
    .locals 1

    .prologue
    .line 263
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    return v0
.end method

.method public getStateDescription(Ljava/lang/CharSequence;III)Ljava/lang/String;
    .locals 7
    .param p1, "description"    # Ljava/lang/CharSequence;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 268
    add-int/lit8 v0, p2, 0x1

    .line 269
    .local v0, "itemFrom":I
    add-int v2, p2, p3

    if-le v2, p4, :cond_0

    move v1, p4

    .line 271
    .local v1, "itemTo":I
    :goto_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/comcast/cim/cmasl/android/util/R$string;->content_description_entity_grid_view:I

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 269
    .end local v1    # "itemTo":I
    :cond_0
    add-int v1, p2, p3

    goto :goto_0
.end method

.method public initialize(Landroid/widget/ListAdapter;)V
    .locals 4
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    const/4 v3, 0x0

    .line 67
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->inflater:Landroid/view/LayoutInflater;

    sget v2, Lcom/comcast/cim/cmasl/android/util/R$layout;->entity_grid_emtpy_view:I

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v1, v2, v0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    .line 68
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setEmptyView(Landroid/view/View;)V

    .line 70
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 71
    invoke-virtual {p0, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 72
    invoke-virtual {p0, v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setScrollingCacheEnabled(Z)V

    .line 73
    return-void
.end method

.method public isFlinging()Z
    .locals 1

    .prologue
    .line 202
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    return v0
.end method

.method public isScrolledToTop()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 197
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getFirstVisiblePosition()I

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    return v0
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 3
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 132
    iget-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isAccessibilityEnabled:Z

    if-eqz v1, :cond_0

    .line 133
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p0, v1, p2, p3, p4}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getStateDescription(Ljava/lang/CharSequence;III)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "content_description":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 136
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 141
    .end local v0    # "content_description":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->scrollingShadow:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 142
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->scrollingShadow:Landroid/view/View;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isScrolledToTop()Z

    move-result v1

    if-eqz v1, :cond_2

    const/16 v1, 0x8

    :goto_0
    invoke-virtual {v2, v1}, Landroid/view/View;->setVisibility(I)V

    .line 145
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->compositeScrollListener:Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;

    invoke-virtual {v1, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/android/util/view/widget/CompositeOnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    .line 146
    return-void

    .line 142
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected onScrollChanged(IIII)V
    .locals 7
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 150
    invoke-super {p0, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->onScrollChanged(IIII)V

    .line 151
    const/4 v1, 0x0

    .line 152
    .local v1, "deltaX":F
    const/4 v2, 0x0

    .line 154
    .local v2, "deltaY":F
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->onScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;

    if-eqz v5, :cond_1

    .line 156
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    if-nez v5, :cond_2

    .line 157
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildCount()I

    move-result v5

    if-lez v5, :cond_0

    .line 158
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getChildInTheMiddle()Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    .line 159
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v5

    iput v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevTop:I

    .line 160
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v5

    iput v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevLeft:I

    .line 161
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {p0, v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getPositionForView(Landroid/view/View;)I

    move-result v5

    iput v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevPosition:I

    .line 179
    :cond_0
    :goto_0
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->onScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;

    invoke-interface {v5, v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;->onScrollChanged(FF)V

    .line 181
    :cond_1
    return-void

    .line 164
    :cond_2
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v5

    if-ne v5, p0, :cond_3

    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {p0, v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getPositionForView(Landroid/view/View;)I

    move-result v5

    iget v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevPosition:I

    if-ne v5, v6, :cond_3

    const/4 v0, 0x1

    .line 165
    .local v0, "childIsSafeToTrack":Z
    :goto_1
    if-eqz v0, :cond_4

    .line 166
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v4

    .line 167
    .local v4, "top":I
    iget-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v3

    .line 169
    .local v3, "left":I
    iget v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevLeft:I

    sub-int/2addr v5, v3

    int-to-float v1, v5

    .line 170
    iget v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevTop:I

    sub-int/2addr v5, v4

    int-to-float v2, v5

    .line 172
    iput v4, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevTop:I

    .line 173
    iput v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChildPrevLeft:I

    goto :goto_0

    .line 164
    .end local v0    # "childIsSafeToTrack":Z
    .end local v3    # "left":I
    .end local v4    # "top":I
    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    .line 175
    .restart local v0    # "childIsSafeToTrack":Z
    :cond_4
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->mTrackedChild:Landroid/view/View;

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 3
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    const/4 v1, 0x1

    .line 107
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    .line 108
    .local v0, "previousIsFlingingValue":Z
    packed-switch p2, :pswitch_data_0

    .line 120
    :goto_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging()Z

    move-result v1

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    if-eq v0, v1, :cond_0

    .line 121
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->LOG:Lorg/slf4j/Logger;

    const-string v2, "notifyDataSetChanged because we are no longer flinging"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 122
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    check-cast v1, Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 124
    :cond_0
    return-void

    .line 110
    :pswitch_0
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    goto :goto_0

    .line 113
    :pswitch_1
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    goto :goto_0

    .line 116
    :pswitch_2
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging:Z

    goto :goto_0

    .line 108
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->stopIfFlinging()V

    .line 98
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 99
    return-void
.end method

.method public setAccessibilityEnabled(Z)V
    .locals 0
    .param p1, "isAccessibilityEnabled"    # Z

    .prologue
    .line 188
    iput-boolean p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isAccessibilityEnabled:Z

    .line 189
    return-void
.end method

.method public setOnScrollChangedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;)V
    .locals 0
    .param p1, "l"    # Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;

    .prologue
    .line 289
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->onScrollChangedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;

    .line 290
    return-void
.end method

.method public setScrollingShadow(Landroid/view/View;)V
    .locals 0
    .param p1, "scrollingShadow"    # Landroid/view/View;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->scrollingShadow:Landroid/view/View;

    .line 77
    return-void
.end method

.method public stopIfFlinging()V
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 206
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    const/4 v4, 0x3

    const/4 v7, 0x0

    move v6, v5

    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v8

    .line 207
    .local v8, "event":Landroid/view/MotionEvent;
    invoke-virtual {p0, v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    .line 208
    invoke-virtual {v8}, Landroid/view/MotionEvent;->recycle()V

    .line 209
    return-void
.end method

.method public update()V
    .locals 3

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Landroid/widget/BaseAdapter;

    .line 81
    .local v0, "adapter":Landroid/widget/BaseAdapter;
    if-eqz v0, :cond_0

    .line 82
    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 83
    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 84
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 85
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 94
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    invoke-virtual {v0}, Landroid/widget/BaseAdapter;->notifyDataSetInvalidated()V

    .line 89
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 90
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->noResultsText:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
