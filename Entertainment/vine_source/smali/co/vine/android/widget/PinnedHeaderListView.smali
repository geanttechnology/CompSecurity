.class public Lco/vine/android/widget/PinnedHeaderListView;
.super Lcom/twitter/android/widget/RefreshableListView;
.source "PinnedHeaderListView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;
    }
.end annotation


# instance fields
.field private mNavBottom:I

.field private mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field private mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

.field private mPinnedHeaderHeight:I

.field private mPinnedHeaderIsVisible:Z

.field private mPinnedHeaderOffset:I

.field private mPinnedHeaderView:Landroid/view/View;

.field private mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

.field private mTrackedChild:Landroid/view/View;

.field private mTrackedChildPrevPosition:I

.field private mTrackedChildPrevTop:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 35
    invoke-direct {p0, p1}, Lcom/twitter/android/widget/RefreshableListView;-><init>(Landroid/content/Context;)V

    .line 21
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    .line 22
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    .line 23
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    .line 24
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 25
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    .line 27
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    .line 28
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    .line 29
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    .line 30
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevPosition:I

    .line 31
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    .line 32
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    .line 36
    invoke-direct {p0}, Lco/vine/android/widget/PinnedHeaderListView;->init()V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/twitter/android/widget/RefreshableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    .line 22
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    .line 23
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    .line 24
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 25
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    .line 27
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    .line 28
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    .line 29
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    .line 30
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevPosition:I

    .line 31
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    .line 32
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    .line 41
    invoke-direct {p0}, Lco/vine/android/widget/PinnedHeaderListView;->init()V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 45
    invoke-direct {p0, p1, p2, p3}, Lcom/twitter/android/widget/RefreshableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 21
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    .line 22
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    .line 23
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    .line 24
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 25
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    .line 27
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    .line 28
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    .line 29
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    .line 30
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevPosition:I

    .line 31
    iput-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    .line 32
    iput v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    .line 46
    invoke-direct {p0}, Lco/vine/android/widget/PinnedHeaderListView;->init()V

    .line 47
    return-void
.end method

.method private ensureHeaderHasLayoutParams(Landroid/view/View;)V
    .locals 4
    .param p1, "header"    # Landroid/view/View;

    .prologue
    const/4 v3, -0x1

    const/4 v2, -0x2

    .line 163
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 164
    .local v0, "lp":Landroid/view/ViewGroup$LayoutParams;
    if-nez v0, :cond_1

    .line 165
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    .end local v0    # "lp":Landroid/view/ViewGroup$LayoutParams;
    invoke-direct {v0, v3, v2}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 166
    .restart local v0    # "lp":Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-ne v1, v3, :cond_0

    .line 168
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 169
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method private getChildInTheMiddle()Landroid/view/View;
    .locals 1

    .prologue
    .line 214
    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getChildCount()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-virtual {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private init()V
    .locals 0

    .prologue
    .line 50
    invoke-super {p0, p0}, Lcom/twitter/android/widget/RefreshableListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 51
    return-void
.end method

.method private measureHeader(Landroid/view/View;)V
    .locals 5
    .param p1, "header"    # Landroid/view/View;

    .prologue
    const/high16 v4, 0x40000000    # 2.0f

    .line 174
    if-eqz p1, :cond_0

    .line 175
    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getMeasuredWidth()I

    move-result v2

    .line 176
    .local v2, "width":I
    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 178
    .local v1, "parentWidthMeasureSpec":I
    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 180
    .local v0, "parentHeightMeasureSpec":I
    invoke-virtual {p0, p1, v1, v0}, Lco/vine/android/widget/PinnedHeaderListView;->measureChild(Landroid/view/View;II)V

    .line 183
    .end local v0    # "parentHeightMeasureSpec":I
    .end local v1    # "parentWidthMeasureSpec":I
    .end local v2    # "width":I
    :cond_0
    return-void
.end method


# virtual methods
.method public dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "c"    # Landroid/graphics/Canvas;

    .prologue
    .line 93
    invoke-super {p0, p1}, Lcom/twitter/android/widget/RefreshableListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 94
    iget-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->isMode(I)Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    neg-int v1, v1

    if-le v0, v1, :cond_0

    .line 95
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 96
    const/4 v0, 0x0

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v1, v2

    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getWidth()I

    move-result v2

    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    add-int/2addr v3, v4

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 97
    const/4 v0, 0x0

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 98
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 99
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 101
    :cond_0
    return-void
.end method

.method public getPinnedHeaderBottomAbs()I
    .locals 3

    .prologue
    .line 78
    const/4 v1, 0x2

    new-array v0, v1, [I

    .line 79
    .local v0, "absoluteLoc":[I
    invoke-virtual {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->getLocationInWindow([I)V

    .line 80
    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    add-int/2addr v1, v2

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v1, v2

    const/4 v2, 0x1

    aget v2, v0, v2

    add-int/2addr v1, v2

    return v1
.end method

.method public getPositionForPixelLocation(I)I
    .locals 3
    .param p1, "y"    # I

    .prologue
    .line 230
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 231
    invoke-virtual {p0, v1}, Lco/vine/android/widget/PinnedHeaderListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 232
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v2

    if-gt v2, p1, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v2

    if-lt v2, p1, :cond_0

    .line 236
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "i":I
    :goto_1
    return v1

    .line 230
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "i":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 236
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public isAbsoluteTouchInPinnedHeader(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    .line 69
    const/4 v2, 0x2

    new-array v0, v2, [I

    .line 70
    .local v0, "absoluteLoc":[I
    invoke-virtual {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->getLocationInWindow([I)V

    .line 71
    iget-boolean v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v2

    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    aget v4, v0, v1

    add-int/2addr v3, v4

    int-to-float v3, v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v2

    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    add-int/2addr v3, v4

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    add-int/2addr v3, v4

    aget v4, v0, v1

    add-int/2addr v3, v4

    int-to-float v3, v3

    cmpg-float v2, v2, v3

    if-gez v2, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isTouchInPinnedHeader(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 62
    iget-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    add-int/2addr v1, v2

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v1, v2

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 55
    invoke-virtual {p0, p1}, Lco/vine/android/widget/PinnedHeaderListView;->isTouchInPinnedHeader(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    const/4 v0, 0x1

    .line 58
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/twitter/android/widget/RefreshableListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onMeasure(II)V
    .locals 1
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 104
    invoke-super {p0, p1, p2}, Lcom/twitter/android/widget/RefreshableListView;->onMeasure(II)V

    .line 105
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-direct {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->measureHeader(Landroid/view/View;)V

    .line 106
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 8
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 132
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    iget v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    invoke-interface {v0, v1}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderStatus(I)Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;

    move-result-object v6

    .line 137
    .local v6, "headerStatus":Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
    if-eqz v6, :cond_0

    .line 139
    iget v0, v6, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->pinnedHeaderOffset:I

    iput v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    .line 140
    iget-boolean v0, v6, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->pinnedHeaderIsVisible:Z

    iput-boolean v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderIsVisible:Z

    .line 142
    iget-boolean v0, v6, Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;->shouldRequestNewView:Z

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    invoke-interface {v0}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderHeight()I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    .line 144
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    iget-object v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-interface {v0, v1}, Lco/vine/android/widget/PinnedHeaderAdapter;->getPinnedHeaderView(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    .line 146
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-direct {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->ensureHeaderHasLayoutParams(Landroid/view/View;)V

    .line 148
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-direct {p0, v0}, Lco/vine/android/widget/PinnedHeaderListView;->measureHeader(Landroid/view/View;)V

    .line 149
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    iget-object v1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    const/4 v2, 0x0

    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    add-int/2addr v3, v4

    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getWidth()I

    move-result v4

    iget v5, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    iget v7, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    add-int/2addr v5, v7

    iget v7, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderHeight:I

    add-int/2addr v5, v7

    invoke-interface/range {v0 .. v5}, Lco/vine/android/widget/PinnedHeaderAdapter;->layoutPinnedHeader(Landroid/view/View;IIII)V

    .line 157
    .end local v6    # "headerStatus":Lco/vine/android/widget/PinnedHeaderAdapter$PinnedHeaderStatus;
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_1

    .line 158
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    .line 160
    :cond_1
    return-void
.end method

.method protected onScrollChanged(IIII)V
    .locals 5
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 187
    invoke-super {p0, p1, p2, p3, p4}, Lcom/twitter/android/widget/RefreshableListView;->onScrollChanged(IIII)V

    .line 188
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    if-nez v3, :cond_1

    .line 189
    invoke-virtual {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getChildCount()I

    move-result v3

    if-lez v3, :cond_0

    .line 190
    invoke-direct {p0}, Lco/vine/android/widget/PinnedHeaderListView;->getChildInTheMiddle()Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    .line 191
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v3

    iput v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    .line 192
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {p0, v3}, Lco/vine/android/widget/PinnedHeaderListView;->getPositionForView(Landroid/view/View;)I

    move-result v3

    iput v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevPosition:I

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-ne v3, p0, :cond_3

    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {p0, v3}, Lco/vine/android/widget/PinnedHeaderListView;->getPositionForView(Landroid/view/View;)I

    move-result v3

    iget v4, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevPosition:I

    if-ne v3, v4, :cond_3

    const/4 v0, 0x1

    .line 196
    .local v0, "childIsSafeToTrack":Z
    :goto_1
    if-eqz v0, :cond_4

    .line 197
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v2

    .line 198
    .local v2, "top":I
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    if-eqz v3, :cond_2

    .line 199
    iget v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    sub-int v1, v2, v3

    .line 200
    .local v1, "deltaY":I
    iget-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    invoke-interface {v3, v1}, Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;->onScroll(I)V

    .line 202
    .end local v1    # "deltaY":I
    :cond_2
    iput v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChildPrevTop:I

    goto :goto_0

    .line 195
    .end local v0    # "childIsSafeToTrack":Z
    .end local v2    # "top":I
    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    .line 204
    .restart local v0    # "childIsSafeToTrack":Z
    :cond_4
    const/4 v3, 0x0

    iput-object v3, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 125
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 128
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 85
    invoke-virtual {p0, p1}, Lco/vine/android/widget/PinnedHeaderListView;->isTouchInPinnedHeader(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderOffset:I

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iget v2, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    int-to-float v2, v2

    sub-float/2addr v1, v2

    invoke-virtual {p1, v0, v1}, Landroid/view/MotionEvent;->setLocation(FF)V

    .line 87
    iget-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 89
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/twitter/android/widget/RefreshableListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 20
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lco/vine/android/widget/PinnedHeaderListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 1
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 109
    invoke-super {p0, p1}, Lcom/twitter/android/widget/RefreshableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 110
    instance-of v0, p1, Lco/vine/android/widget/PinnedHeaderAdapter;

    if-eqz v0, :cond_0

    .line 111
    check-cast p1, Lco/vine/android/widget/PinnedHeaderAdapter;

    .end local p1    # "adapter":Landroid/widget/ListAdapter;
    invoke-virtual {p0, p1}, Lco/vine/android/widget/PinnedHeaderListView;->setPinnedHeaderAdapter(Lco/vine/android/widget/PinnedHeaderAdapter;)V

    .line 113
    :cond_0
    return-void
.end method

.method public setNavBottom(I)V
    .locals 0
    .param p1, "bottom"    # I

    .prologue
    .line 226
    iput p1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mNavBottom:I

    .line 227
    return-void
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AbsListView$OnScrollListener;

    .prologue
    .line 120
    iput-object p1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 121
    return-void
.end method

.method public setPinnedHeaderAdapter(Lco/vine/android/widget/PinnedHeaderAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lco/vine/android/widget/PinnedHeaderAdapter;

    .prologue
    .line 116
    iput-object p1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mPinnedHeaderAdapter:Lco/vine/android/widget/PinnedHeaderAdapter;

    .line 117
    return-void
.end method

.method public setScrollDeltaListener(Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    .prologue
    .line 222
    iput-object p1, p0, Lco/vine/android/widget/PinnedHeaderListView;->mScrollDeltaListener:Lco/vine/android/widget/PinnedHeaderListView$ScrollDeltaListener;

    .line 223
    return-void
.end method

.method public untrackScrollawayChild()V
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/PinnedHeaderListView;->mTrackedChild:Landroid/view/View;

    .line 211
    return-void
.end method
