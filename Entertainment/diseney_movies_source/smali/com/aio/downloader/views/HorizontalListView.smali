.class public Lcom/aio/downloader/views/HorizontalListView;
.super Landroid/widget/AdapterView;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/AdapterView",
        "<",
        "Landroid/widget/ListAdapter;",
        ">;"
    }
.end annotation


# instance fields
.field protected mAdapter:Landroid/widget/ListAdapter;

.field public mAlwaysOverrideTouch:Z

.field protected mCurrentX:I

.field private mDataChanged:Z

.field private mDataObserver:Landroid/database/DataSetObserver;

.field private mDisplayOffset:I

.field private mGesture:Landroid/view/GestureDetector;

.field private mLeftViewIndex:I

.field private mMaxX:I

.field protected mNextX:I

.field private mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

.field private mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

.field private mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

.field private mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

.field private mRemovedViewQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mRightViewIndex:I

.field protected mScroller:Landroid/widget/Scroller;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 38
    invoke-direct {p0, p1, p2}, Landroid/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 20
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mAlwaysOverrideTouch:Z

    .line 22
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    .line 23
    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    .line 26
    const v0, 0x7fffffff

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    .line 27
    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    .line 30
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    .line 34
    iput-boolean v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataChanged:Z

    .line 68
    new-instance v0, Lcom/aio/downloader/views/HorizontalListView$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/HorizontalListView$1;-><init>(Lcom/aio/downloader/views/HorizontalListView;)V

    iput-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    .line 289
    new-instance v0, Lcom/aio/downloader/views/HorizontalListView$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/HorizontalListView$2;-><init>(Lcom/aio/downloader/views/HorizontalListView;)V

    iput-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    .line 39
    invoke-direct {p0}, Lcom/aio/downloader/views/HorizontalListView;->initView()V

    .line 40
    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/HorizontalListView;Z)V
    .locals 0

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataChanged:Z

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/HorizontalListView;)V
    .locals 0

    .prologue
    .line 109
    invoke-direct {p0}, Lcom/aio/downloader/views/HorizontalListView;->reset()V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/HorizontalListView;)Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/HorizontalListView;)I
    .locals 1

    .prologue
    .line 22
    iget v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/views/HorizontalListView;)Landroid/widget/AdapterView$OnItemSelectedListener;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/views/HorizontalListView;)Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    return-object v0
.end method

.method private addAndMeasureChild(Landroid/view/View;I)V
    .locals 4
    .param p1, "child"    # Landroid/view/View;
    .param p2, "viewPos"    # I

    .prologue
    const/4 v1, -0x1

    const/high16 v3, -0x80000000

    .line 121
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 122
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    if-nez v0, :cond_0

    .line 123
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    .end local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 126
    .restart local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    const/4 v1, 0x1

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/aio/downloader/views/HorizontalListView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 127
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getWidth()I

    move-result v1

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 128
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getHeight()I

    move-result v2

    invoke-static {v2, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 127
    invoke-virtual {p1, v1, v2}, Landroid/view/View;->measure(II)V

    .line 129
    return-void
.end method

.method private fillList(I)V
    .locals 3
    .param p1, "dx"    # I

    .prologue
    .line 183
    const/4 v1, 0x0

    .line 184
    .local v1, "edge":I
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 185
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 186
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 188
    :cond_0
    invoke-direct {p0, v1, p1}, Lcom/aio/downloader/views/HorizontalListView;->fillListRight(II)V

    .line 190
    const/4 v1, 0x0

    .line 191
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 192
    if-eqz v0, :cond_1

    .line 193
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 195
    :cond_1
    invoke-direct {p0, v1, p1}, Lcom/aio/downloader/views/HorizontalListView;->fillListLeft(II)V

    .line 198
    return-void
.end method

.method private fillListLeft(II)V
    .locals 4
    .param p1, "leftEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 220
    :goto_0
    add-int v1, p1, p2

    if-lez v1, :cond_0

    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    if-gez v1, :cond_1

    .line 227
    :cond_0
    return-void

    .line 221
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-interface {v2, v3, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 222
    .local v0, "child":Landroid/view/View;
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/aio/downloader/views/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 223
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    sub-int/2addr p1, v1

    .line 224
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    .line 225
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    goto :goto_0
.end method

.method private fillListRight(II)V
    .locals 4
    .param p1, "rightEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 201
    :goto_0
    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_0

    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    iget-object v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-lt v1, v2, :cond_1

    .line 217
    :cond_0
    return-void

    .line 203
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-interface {v2, v3, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 204
    .local v0, "child":Landroid/view/View;
    const/4 v1, -0x1

    invoke-direct {p0, v0, v1}, Lcom/aio/downloader/views/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 205
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    add-int/2addr p1, v1

    .line 207
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    iget-object v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v1, v2, :cond_2

    .line 208
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mCurrentX:I

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    .line 211
    :cond_2
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    if-gez v1, :cond_3

    .line 212
    const/4 v1, 0x0

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    .line 214
    :cond_3
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    goto :goto_0
.end method

.method private declared-synchronized initView()V
    .locals 3

    .prologue
    .line 43
    monitor-enter p0

    const/4 v0, -0x1

    :try_start_0
    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    .line 44
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    .line 45
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    .line 46
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mCurrentX:I

    .line 47
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    .line 48
    const v0, 0x7fffffff

    iput v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    .line 49
    new-instance v0, Landroid/widget/Scroller;

    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    .line 50
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mGesture:Landroid/view/GestureDetector;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 51
    monitor-exit p0

    return-void

    .line 43
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private positionItems(I)V
    .locals 7
    .param p1, "dx"    # I

    .prologue
    .line 250
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getChildCount()I

    move-result v4

    if-lez v4, :cond_0

    .line 251
    iget v4, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    add-int/2addr v4, p1

    iput v4, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    .line 252
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    .line 253
    .local v3, "left":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getChildCount()I

    move-result v4

    if-lt v2, v4, :cond_1

    .line 260
    .end local v2    # "i":I
    .end local v3    # "left":I
    :cond_0
    return-void

    .line 254
    .restart local v2    # "i":I
    .restart local v3    # "left":I
    :cond_1
    invoke-virtual {p0, v2}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 255
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 256
    .local v1, "childWidth":I
    const/4 v4, 0x0

    add-int v5, v3, v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v6

    invoke-virtual {v0, v3, v4, v5, v6}, Landroid/view/View;->layout(IIII)V

    .line 257
    invoke-virtual {v0}, Landroid/view/View;->getPaddingRight()I

    move-result v4

    add-int/2addr v4, v1

    add-int/2addr v3, v4

    .line 253
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private removeNonVisibleItems(I)V
    .locals 4
    .param p1, "dx"    # I

    .prologue
    const/4 v3, 0x0

    .line 230
    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 231
    .local v0, "child":Landroid/view/View;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    add-int/2addr v1, p1

    if-lez v1, :cond_2

    .line 240
    :cond_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 241
    :goto_1
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_3

    .line 247
    :cond_1
    return-void

    .line 232
    :cond_2
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDisplayOffset:I

    .line 233
    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 234
    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 235
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mLeftViewIndex:I

    .line 236
    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 242
    :cond_3
    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 243
    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 244
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mRightViewIndex:I

    .line 245
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    goto :goto_1
.end method

.method private declared-synchronized reset()V
    .locals 1

    .prologue
    .line 110
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/views/HorizontalListView;->initView()V

    .line 111
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->removeAllViewsInLayout()V

    .line 112
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    monitor-exit p0

    return-void

    .line 110
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 269
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 270
    .local v0, "handled":Z
    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mGesture:Landroid/view/GestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 271
    return v0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getSelectedView()Landroid/view/View;
    .locals 1

    .prologue
    .line 96
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onDown(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    .line 285
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 286
    return v1
.end method

.method protected onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 9
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 276
    monitor-enter p0

    .line 277
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    const/4 v2, 0x0

    neg-float v3, p3

    float-to-int v3, v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    iget v6, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    .line 276
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 279
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V

    .line 281
    const/4 v0, 0x1

    return v0

    .line 276
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected declared-synchronized onLayout(ZIIII)V
    .locals 5
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 135
    monitor-enter p0

    :try_start_0
    invoke-super/range {p0 .. p5}, Landroid/widget/AdapterView;->onLayout(ZIIII)V

    .line 137
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v3, :cond_1

    .line 180
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 141
    :cond_1
    :try_start_1
    iget-boolean v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataChanged:Z

    if-eqz v3, :cond_2

    .line 142
    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mCurrentX:I

    .line 143
    .local v1, "oldCurrentX":I
    invoke-direct {p0}, Lcom/aio/downloader/views/HorizontalListView;->initView()V

    .line 144
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->removeAllViewsInLayout()V

    .line 145
    iput v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    .line 146
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataChanged:Z

    .line 149
    .end local v1    # "oldCurrentX":I
    :cond_2
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 150
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->getCurrX()I

    move-result v2

    .line 151
    .local v2, "scrollx":I
    iput v2, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    .line 154
    .end local v2    # "scrollx":I
    :cond_3
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    if-gtz v3, :cond_4

    .line 155
    const/4 v3, 0x0

    iput v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    .line 156
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 158
    :cond_4
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    iget v4, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    if-lt v3, v4, :cond_5

    .line 159
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mMaxX:I

    iput v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    .line 160
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 163
    :cond_5
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mCurrentX:I

    iget v4, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    sub-int v0, v3, v4

    .line 165
    .local v0, "dx":I
    invoke-direct {p0, v0}, Lcom/aio/downloader/views/HorizontalListView;->removeNonVisibleItems(I)V

    .line 166
    invoke-direct {p0, v0}, Lcom/aio/downloader/views/HorizontalListView;->fillList(I)V

    .line 167
    invoke-direct {p0, v0}, Lcom/aio/downloader/views/HorizontalListView;->positionItems(I)V

    .line 169
    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    iput v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mCurrentX:I

    .line 171
    iget-object v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v3}, Landroid/widget/Scroller;->isFinished()Z

    move-result v3

    if-nez v3, :cond_0

    .line 172
    new-instance v3, Lcom/aio/downloader/views/HorizontalListView$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/views/HorizontalListView$3;-><init>(Lcom/aio/downloader/views/HorizontalListView;)V

    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/HorizontalListView;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 135
    .end local v0    # "dx":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized scrollTo(I)V
    .locals 5
    .param p1, "x"    # I

    .prologue
    .line 263
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    iget v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    const/4 v2, 0x0

    iget v3, p0, Lcom/aio/downloader/views/HorizontalListView;->mNextX:I

    sub-int v3, p1, v3

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/Scroller;->startScroll(IIII)V

    .line 264
    invoke-virtual {p0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 265
    monitor-exit p0

    return-void

    .line 263
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Landroid/widget/ListAdapter;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 104
    :cond_0
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 105
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 106
    invoke-direct {p0}, Lcom/aio/downloader/views/HorizontalListView;->reset()V

    .line 107
    return-void
.end method

.method public setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V
    .locals 0

    .prologue
    .line 60
    .local p1, "listener":Landroid/widget/AdapterView$OnItemClickListener;, "Landroid/widget/AdapterView$OnItemClickListener;"
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    .line 61
    return-void
.end method

.method public setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    .locals 0

    .prologue
    .line 65
    .local p1, "listener":Landroid/widget/AdapterView$OnItemLongClickListener;, "Landroid/widget/AdapterView$OnItemLongClickListener;"
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 66
    return-void
.end method

.method public setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    .locals 0

    .prologue
    .line 55
    .local p1, "listener":Landroid/widget/AdapterView$OnItemSelectedListener;, "Landroid/widget/AdapterView$OnItemSelectedListener;"
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 56
    return-void
.end method

.method public setSelection(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 118
    return-void
.end method
