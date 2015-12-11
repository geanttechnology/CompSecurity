.class public Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;
.super Landroid/widget/ListView;
.source "StickyListHeadersListView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# instance fields
.field private areHeadersSticky:Z

.field private clipToPaddingHasBeenSet:Z

.field private clippingRect:Landroid/graphics/Rect;

.field private clippingToPadding:Z

.field private divider:Landroid/graphics/drawable/Drawable;

.field private dividerHeight:I

.field private header:Landroid/view/View;

.field private headerBottomPosition:I

.field private headerHasChanged:Z

.field private headerHeight:I

.field private lastWatchedViewHeader:Landroid/view/View;

.field private oldHeaderId:J

.field private scrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field private setupDone:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 44
    const/4 v0, -0x1

    iput v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    .line 50
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->oldHeaderId:J

    .line 51
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 54
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    .line 58
    invoke-direct {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setup()V

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x1

    .line 62
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 44
    const/4 v1, -0x1

    iput v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    .line 50
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->oldHeaderId:J

    .line 51
    iput-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 54
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    .line 63
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/emilsjolander/components/StickyListHeaders/R$styleable;->StickyListHeadersListView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 64
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setAreHeadersSticky(Z)V

    .line 65
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 66
    invoke-direct {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setup()V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v4, 0x1

    .line 70
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 44
    const/4 v1, -0x1

    iput v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    .line 50
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->oldHeaderId:J

    .line 51
    iput-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 54
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iput-object v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    .line 71
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/emilsjolander/components/StickyListHeaders/R$styleable;->StickyListHeadersListView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 72
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setAreHeadersSticky(Z)V

    .line 73
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 74
    invoke-direct {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setup()V

    .line 75
    return-void
.end method

.method private setup()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 78
    iget-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setupDone:Z

    if-nez v0, :cond_0

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setupDone:Z

    .line 80
    invoke-super {p0, p0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 81
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getDivider()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 82
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getDividerHeight()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setDividerHeight(I)V

    .line 84
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 85
    invoke-super {p0, v1}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 86
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setVerticalFadingEdgeEnabled(Z)V

    .line 88
    :cond_0
    return-void
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v7, 0x0

    .line 170
    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 171
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    if-eqz v3, :cond_1

    iget-boolean v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->areHeadersSticky:Z

    if-eqz v3, :cond_1

    .line 172
    iget-boolean v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    if-eqz v3, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getWidth()I

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 174
    .local v2, "widthMeasureSpec":I
    invoke-static {v7, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 175
    .local v0, "heightMeasureSpec":I
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    invoke-virtual {v3, v2, v0}, Landroid/view/View;->measure(II)V

    .line 176
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getLeft()I

    move-result v4

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v5

    add-int/2addr v4, v5

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getRight()I

    move-result v5

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingRight()I

    move-result v6

    sub-int/2addr v5, v6

    iget v6, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {v3, v4, v7, v5, v6}, Landroid/view/View;->layout(IIII)V

    .line 177
    iput-boolean v7, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 179
    .end local v0    # "heightMeasureSpec":I
    .end local v2    # "widthMeasureSpec":I
    :cond_0
    iget v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    sub-int v1, v3, v4

    .line 180
    .local v1, "top":I
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v4

    iput v4, v3, Landroid/graphics/Rect;->left:I

    .line 181
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getWidth()I

    move-result v4

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingRight()I

    move-result v5

    sub-int/2addr v4, v5

    iput v4, v3, Landroid/graphics/Rect;->right:I

    .line 182
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    add-int/2addr v4, v1

    iput v4, v3, Landroid/graphics/Rect;->bottom:I

    .line 183
    iget-boolean v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v3, :cond_2

    .line 184
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v4

    iput v4, v3, Landroid/graphics/Rect;->top:I

    .line 189
    :goto_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 190
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v3}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 191
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v3

    int-to-float v3, v3

    int-to-float v4, v1

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->translate(FF)V

    .line 192
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    invoke-virtual {v3, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 193
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 195
    .end local v1    # "top":I
    :cond_1
    return-void

    .line 186
    .restart local v1    # "top":I
    :cond_2
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingRect:Landroid/graphics/Rect;

    iput v7, v3, Landroid/graphics/Rect;->top:I

    goto :goto_0
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 92
    move-object v0, p1

    check-cast v0, Landroid/os/Bundle;

    const-string v1, "headerHeight"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    .line 93
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 94
    check-cast p1, Landroid/os/Bundle;

    .end local p1    # "state":Landroid/os/Parcelable;
    const-string v0, "superInstanceState"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/ListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 95
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 99
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 100
    .local v0, "instanceState":Landroid/os/Bundle;
    const-string v1, "headerHeight"

    iget v2, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 101
    const-string v1, "superInstanceState"

    invoke-super {p0}, Landroid/widget/ListView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 102
    return-object v0
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 8
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    const/4 v7, 0x0

    .line 206
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->scrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v4, :cond_0

    .line 207
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->scrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v4, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    .line 209
    :cond_0
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    invoke-interface {v4}, Landroid/widget/ListAdapter;->getCount()I

    move-result v4

    if-nez v4, :cond_2

    .line 285
    :cond_1
    :goto_0
    return-void

    .line 212
    :cond_2
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->areHeadersSticky:Z

    if-eqz v4, :cond_1

    .line 213
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildCount()I

    move-result v4

    if-eqz v4, :cond_a

    .line 214
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->lastWatchedViewHeader:Landroid/view/View;

    if-eqz v4, :cond_3

    .line 215
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->lastWatchedViewHeader:Landroid/view/View;

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 218
    :cond_3
    invoke-virtual {p0, v7}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 219
    .local v3, "viewToWatch":Landroid/view/View;
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildCount()I

    move-result v4

    if-ge v1, v4, :cond_8

    .line 222
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_6

    .line 223
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v5

    sub-int/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v0

    .line 229
    .local v0, "firstChildDistance":I
    :goto_2
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_7

    .line 230
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v5

    sub-int/2addr v4, v5

    iget v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    sub-int/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .line 235
    .local v2, "secondChildDistance":I
    :goto_3
    invoke-virtual {v3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_5

    if-ge v2, v0, :cond_5

    .line 236
    :cond_4
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 219
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 225
    .end local v0    # "firstChildDistance":I
    .end local v2    # "secondChildDistance":I
    :cond_6
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v0

    .restart local v0    # "firstChildDistance":I
    goto :goto_2

    .line 232
    :cond_7
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    iget v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    sub-int/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v2

    .restart local v2    # "secondChildDistance":I
    goto :goto_3

    .line 240
    .end local v0    # "firstChildDistance":I
    .end local v2    # "secondChildDistance":I
    :cond_8
    invoke-virtual {v3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_14

    .line 241
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    if-gez v4, :cond_9

    .line 242
    sget v4, Lcom/emilsjolander/components/StickyListHeaders/R$id;->header_view:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v4

    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    .line 245
    :cond_9
    if-nez p2, :cond_d

    invoke-virtual {p0, v7}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    if-lez v4, :cond_d

    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-nez v4, :cond_d

    .line 246
    iput v7, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    .line 256
    :goto_4
    sget v4, Lcom/emilsjolander/components/StickyListHeaders/R$id;->header_view:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->lastWatchedViewHeader:Landroid/view/View;

    .line 257
    iget v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_11

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v6

    add-int/2addr v4, v6

    :goto_5
    if-ne v5, v4, :cond_13

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v5

    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_12

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v6

    add-int/2addr v4, v6

    :goto_6
    if-ge v5, v4, :cond_13

    .line 258
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->lastWatchedViewHeader:Landroid/view/View;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 269
    .end local v1    # "i":I
    .end local v3    # "viewToWatch":Landroid/view/View;
    :cond_a
    :goto_7
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-ge v4, v5, :cond_b

    .line 270
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-nez v4, :cond_b

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v4

    if-lez v4, :cond_b

    .line 271
    invoke-virtual {p0, v7}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    if-lez v4, :cond_b

    .line 272
    if-lez p2, :cond_b

    .line 273
    add-int/lit8 p2, p2, -0x1

    .line 278
    :cond_b
    iget-wide v6, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->oldHeaderId:J

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    check-cast v4, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    invoke-interface {v4, p2}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->getHeaderId(I)J

    move-result-wide v4

    cmp-long v4, v6, v4

    if-eqz v4, :cond_c

    .line 279
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHasChanged:Z

    .line 280
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    check-cast v4, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    iget-object v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    invoke-interface {v4, p2, v5}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->getHeaderView(ILandroid/view/View;)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    .line 281
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->header:Landroid/view/View;

    new-instance v5, Landroid/view/ViewGroup$LayoutParams;

    const/4 v6, -0x1

    iget v7, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-direct {v5, v6, v7}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v4, v5}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 283
    :cond_c
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v4

    check-cast v4, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    invoke-interface {v4, p2}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->getHeaderId(I)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->oldHeaderId:J

    goto/16 :goto_0

    .line 248
    .restart local v1    # "i":I
    .restart local v3    # "viewToWatch":Landroid/view/View;
    :cond_d
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_f

    .line 249
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v4

    iget v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v6

    add-int/2addr v5, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    .line 250
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v5

    if-ge v4, v5, :cond_e

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v5

    add-int/2addr v4, v5

    :goto_8
    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    goto/16 :goto_4

    :cond_e
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    goto :goto_8

    .line 252
    :cond_f
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v4

    iget v5, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    .line 253
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    if-gez v4, :cond_10

    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    :goto_9
    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    goto/16 :goto_4

    :cond_10
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    goto :goto_9

    .line 257
    :cond_11
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    goto/16 :goto_5

    :cond_12
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    goto/16 :goto_6

    .line 260
    :cond_13
    iget-object v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->lastWatchedViewHeader:Landroid/view/View;

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_7

    .line 263
    :cond_14
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerHeight:I

    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    .line 264
    iget-boolean v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    if-eqz v4, :cond_a

    .line 265
    iget v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v5

    add-int/2addr v4, v5

    iput v4, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->headerBottomPosition:I

    goto/16 :goto_7
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 289
    iget-object v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->scrollListener:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 290
    iget-object v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->scrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 292
    :cond_0
    return-void
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0

    .prologue
    .line 36
    check-cast p1, Landroid/widget/ListAdapter;

    invoke-virtual {p0, p1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 157
    iget-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clipToPaddingHasBeenSet:Z

    if-nez v0, :cond_0

    .line 158
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    .line 160
    :cond_0
    instance-of v0, p1, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    if-nez v0, :cond_1

    .line 161
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Adapter must be a subclass of StickyListHeadersAdapter"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    move-object v0, p1

    .line 163
    check-cast v0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    iget-object v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->divider:Landroid/graphics/drawable/Drawable;

    invoke-interface {v0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->setDivider(Landroid/graphics/drawable/Drawable;)V

    move-object v0, p1

    .line 164
    check-cast v0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    iget v1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->dividerHeight:I

    invoke-interface {v0, v1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->setDividerHeight(I)V

    .line 165
    invoke-super {p0, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 166
    return-void
.end method

.method public setAreHeadersSticky(Z)V
    .locals 1
    .param p1, "areHeadersSticky"    # Z

    .prologue
    .line 145
    if-eqz p1, :cond_0

    .line 146
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/ListView;->setVerticalFadingEdgeEnabled(Z)V

    .line 148
    :cond_0
    iput-boolean p1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->areHeadersSticky:Z

    .line 149
    return-void
.end method

.method public setClipToPadding(Z)V
    .locals 1
    .param p1, "clipToPadding"    # Z

    .prologue
    .line 199
    invoke-super {p0, p1}, Landroid/widget/ListView;->setClipToPadding(Z)V

    .line 200
    iput-boolean p1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clippingToPadding:Z

    .line 201
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->clipToPaddingHasBeenSet:Z

    .line 202
    return-void
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "divider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 117
    iget-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setupDone:Z

    if-eqz v0, :cond_1

    .line 118
    iput-object p1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->divider:Landroid/graphics/drawable/Drawable;

    .line 119
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 120
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    invoke-interface {v0, p1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public setDividerHeight(I)V
    .locals 1
    .param p1, "height"    # I

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->setupDone:Z

    if-eqz v0, :cond_1

    .line 130
    iput p1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->dividerHeight:I

    .line 131
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 132
    invoke-virtual {p0}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;

    invoke-interface {v0, p1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersAdapter;->setDividerHeight(I)V

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 135
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/ListView;->setDividerHeight(I)V

    goto :goto_0
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0
    .param p1, "l"    # Landroid/widget/AbsListView$OnScrollListener;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->scrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 142
    return-void
.end method

.method public setVerticalFadingEdgeEnabled(Z)V
    .locals 1
    .param p1, "verticalFadingEdgeEnabled"    # Z

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;->areHeadersSticky:Z

    if-eqz v0, :cond_0

    .line 109
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/ListView;->setVerticalFadingEdgeEnabled(Z)V

    .line 113
    :goto_0
    return-void

    .line 111
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ListView;->setVerticalFadingEdgeEnabled(Z)V

    goto :goto_0
.end method
