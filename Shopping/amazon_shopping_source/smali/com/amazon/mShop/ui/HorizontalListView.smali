.class public Lcom/amazon/mShop/ui/HorizontalListView;
.super Landroid/widget/AdapterView;
.source "HorizontalListView.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/AdapterView",
        "<",
        "Landroid/widget/ListAdapter;",
        ">;",
        "Landroid/view/View$OnFocusChangeListener;"
    }
.end annotation


# instance fields
.field protected mAdapter:Landroid/widget/ListAdapter;

.field private mCanReceiveKeyEvent:Z

.field private mCurrentFocusPosition:I

.field protected mCurrentX:I

.field private mDataChanged:Z

.field private mDataObserver:Landroid/database/DataSetObserver;

.field private mDisplayOffset:I

.field private mGesture:Landroid/view/GestureDetector;

.field private mHighlightBackground:Landroid/graphics/drawable/Drawable;

.field private mLastLeft:I

.field private mLastRight:I

.field private mLeftViewPosition:I

.field private mMaxX:I

.field protected mNextX:I

.field private mNormalBackground:Landroid/graphics/drawable/Drawable;

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

.field private mRightViewPosition:I

.field protected mScroller:Landroid/widget/Scroller;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, -0x1

    const/4 v1, 0x0

    .line 84
    invoke-direct {p0, p1, p2}, Landroid/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 64
    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    .line 65
    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    .line 68
    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    .line 69
    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastRight:I

    .line 70
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    .line 71
    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 74
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    .line 78
    iput-boolean v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataChanged:Z

    .line 79
    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 150
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    .line 152
    new-instance v0, Lcom/amazon/mShop/ui/HorizontalListView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/ui/HorizontalListView$1;-><init>(Lcom/amazon/mShop/ui/HorizontalListView;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    .line 481
    new-instance v0, Lcom/amazon/mShop/ui/HorizontalListView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/ui/HorizontalListView$3;-><init>(Lcom/amazon/mShop/ui/HorizontalListView;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    .line 87
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$color;->transparent:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 88
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 90
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->initView()V

    .line 91
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/ui/HorizontalListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;
    .param p1, "x1"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataChanged:Z

    return p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/ui/HorizontalListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;
    .param p1, "x1"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/ui/HorizontalListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->reset()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;
    .param p1, "x1"    # Landroid/view/MotionEvent;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/ui/HorizontalListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/ui/HorizontalListView;Landroid/view/MotionEvent;Landroid/view/View;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;
    .param p1, "x1"    # Landroid/view/MotionEvent;
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 58
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/ui/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    iget v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemSelectedListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/HorizontalListView;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    return-object v0
.end method

.method private addAndMeasureChild(Landroid/view/View;I)V
    .locals 4
    .param p1, "child"    # Landroid/view/View;
    .param p2, "viewPos"    # I

    .prologue
    const/4 v1, -0x1

    const/high16 v3, -0x80000000

    .line 212
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 213
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    if-nez v0, :cond_0

    .line 214
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    .end local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 217
    .restart local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v1

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getHeight()I

    move-result v2

    invoke-static {v2, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/view/View;->measure(II)V

    .line 219
    const/4 v1, 0x1

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 220
    return-void
.end method

.method private checkRight(II)I
    .locals 1
    .param p1, "rightEdge"    # I
    .param p2, "rightViewPos"    # I

    .prologue
    .line 241
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v0

    if-ge p1, v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    if-ge p2, v0, :cond_0

    .line 242
    invoke-direct {p0, p2}, Lcom/amazon/mShop/ui/HorizontalListView;->getViewWidth(I)I

    move-result v0

    add-int/2addr p1, v0

    .line 243
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 246
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v0

    if-ge p1, v0, :cond_1

    .line 247
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v0

    sub-int/2addr v0, p1

    .line 249
    :goto_1
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private checkedDelta(II)I
    .locals 4
    .param p1, "left"    # I
    .param p2, "right"    # I

    .prologue
    .line 264
    sub-int v1, p2, p1

    .line 265
    .local v1, "width":I
    const/4 v0, 0x0

    .line 266
    .local v0, "dx":I
    iget v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 267
    iput p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    .line 268
    iput p2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastRight:I

    .line 271
    :cond_0
    iget v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastRight:I

    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    sub-int/2addr v2, v3

    if-ne v2, v1, :cond_1

    .line 273
    iget v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentX:I

    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    sub-int v0, v2, v3

    .line 285
    :goto_0
    return v0

    .line 279
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getRightEdge()I

    move-result v2

    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    invoke-direct {p0, v2, v3}, Lcom/amazon/mShop/ui/HorizontalListView;->checkRight(II)I

    move-result v0

    .line 281
    iput p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    .line 282
    iput p2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastRight:I

    goto :goto_0
.end method

.method private fillList(I)V
    .locals 3
    .param p1, "dx"    # I

    .prologue
    .line 366
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 367
    .local v1, "edge":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 368
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 369
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 371
    :cond_0
    invoke-direct {p0, v1, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->fillListRight(II)V

    .line 373
    const/4 v1, 0x0

    .line 374
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 375
    if-eqz v0, :cond_1

    .line 376
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 378
    :cond_1
    invoke-direct {p0, v1, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->fillListLeft(II)V

    .line 381
    return-void
.end method

.method private fillListLeft(II)V
    .locals 4
    .param p1, "leftEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 401
    :goto_0
    add-int v1, p1, p2

    if-lez v1, :cond_0

    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    if-ltz v1, :cond_0

    .line 402
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-interface {v2, v3, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 403
    .local v0, "child":Landroid/view/View;
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 404
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    sub-int/2addr p1, v1

    .line 405
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    .line 406
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    goto :goto_0

    .line 411
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    add-int v1, p1, p2

    if-lez v1, :cond_1

    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    .line 412
    neg-int v1, p2

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 414
    :cond_1
    return-void
.end method

.method private fillListRight(II)V
    .locals 4
    .param p1, "rightEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 384
    :goto_0
    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_0

    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 385
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-interface {v2, v3, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 386
    .local v0, "child":Landroid/view/View;
    const/4 v1, -0x1

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 387
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    add-int/2addr p1, v1

    .line 388
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    goto :goto_0

    .line 391
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-ne v1, v2, :cond_1

    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 392
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentX:I

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    .line 395
    :cond_1
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    if-gez v1, :cond_2

    .line 396
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    .line 398
    :cond_2
    return-void
.end method

.method private getRightEdge()I
    .locals 3

    .prologue
    .line 293
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 294
    .local v1, "rightEdge":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 295
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 296
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 298
    :cond_0
    return v1
.end method

.method private getViewWidth(I)I
    .locals 5
    .param p1, "pos"    # I

    .prologue
    const/high16 v4, -0x80000000

    .line 224
    iget-object v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    invoke-interface {v3, p1, v2, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 226
    .local v0, "v":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v2

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getHeight()I

    move-result v3

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/view/View;->measure(II)V

    .line 228
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 229
    .local v1, "w":I
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v2, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 230
    return v1
.end method

.method private declared-synchronized initView()V
    .locals 3

    .prologue
    .line 94
    monitor-enter p0

    const/4 v0, -0x1

    :try_start_0
    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    .line 95
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    .line 96
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 97
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastLeft:I

    .line 98
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLastRight:I

    .line 99
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentX:I

    .line 100
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 101
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 102
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 104
    new-instance v0, Landroid/widget/Scroller;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    .line 105
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mGesture:Landroid/view/GestureDetector;

    .line 106
    invoke-virtual {p0, p0}, Lcom/amazon/mShop/ui/HorizontalListView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 108
    monitor-exit p0

    return-void

    .line 94
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z
    .locals 8
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 617
    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    .line 618
    .local v5, "viewRect":Landroid/graphics/Rect;
    const/4 v6, 0x2

    new-array v1, v6, [I

    .line 619
    .local v1, "childPosition":[I
    invoke-virtual {p2, v1}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 620
    const/4 v6, 0x0

    aget v2, v1, v6

    .line 621
    .local v2, "left":I
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    move-result v6

    add-int v3, v2, v6

    .line 622
    .local v3, "right":I
    const/4 v6, 0x1

    aget v4, v1, v6

    .line 623
    .local v4, "top":I
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    move-result v6

    add-int v0, v4, v6

    .line 624
    .local v0, "bottom":I
    invoke-virtual {v5, v2, v4, v3, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 625
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v6

    float-to-int v6, v6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v7

    float-to-int v7, v7

    invoke-virtual {v5, v6, v7}, Landroid/graphics/Rect;->contains(II)Z

    move-result v6

    return v6
.end method

.method private positionItems(I)V
    .locals 7
    .param p1, "dx"    # I

    .prologue
    .line 439
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v4

    if-lez v4, :cond_0

    .line 440
    iget v4, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    add-int/2addr v4, p1

    iput v4, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 441
    iget v3, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 442
    .local v3, "left":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 443
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 444
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 445
    .local v1, "childWidth":I
    const/4 v4, 0x0

    add-int v5, v3, v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v6

    invoke-virtual {v0, v3, v4, v5, v6}, Landroid/view/View;->layout(IIII)V

    .line 446
    add-int/2addr v3, v1

    .line 442
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 449
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "childWidth":I
    .end local v2    # "i":I
    .end local v3    # "left":I
    :cond_0
    return-void
.end method

.method private removeNonVisibleItems(I)V
    .locals 4
    .param p1, "dx"    # I

    .prologue
    const/4 v3, 0x0

    .line 417
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 418
    .local v0, "child":Landroid/view/View;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    add-int/2addr v1, p1

    if-gtz v1, :cond_0

    .line 419
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDisplayOffset:I

    .line 420
    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 421
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 422
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    .line 423
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 426
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 427
    :goto_1
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-lt v1, v2, :cond_1

    .line 428
    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 429
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 430
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    .line 431
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 434
    const v1, 0x7fffffff

    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    goto :goto_1

    .line 436
    :cond_1
    return-void
.end method

.method private declared-synchronized reset()V
    .locals 1

    .prologue
    .line 201
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->initView()V

    .line 202
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->removeAllViewsInLayout()V

    .line 203
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 204
    monitor-exit p0

    return-void

    .line 201
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V
    .locals 4
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    .line 575
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_1

    .line 576
    const/4 v1, 0x0

    .line 577
    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 578
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 579
    .local v0, "child":Landroid/view/View;
    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 580
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 585
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    instance-of v2, v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    if-eqz v2, :cond_1

    .line 586
    if-nez v1, :cond_3

    .line 587
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getHomeShovelerItemsShownSubscriber()Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    move-result-object v2

    invoke-interface {v2, v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;->onMostLeftItemFocused(Z)V

    .line 593
    .end local v1    # "i":I
    :cond_1
    :goto_1
    return-void

    .line 577
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "i":I
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 588
    .end local v0    # "child":Landroid/view/View;
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v1, v2, :cond_1

    .line 589
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getHomeShovelerItemsShownSubscriber()Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    move-result-object v2

    invoke-interface {v2, v3}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;->onMostRightItemFocused(Z)V

    goto :goto_1
.end method

.method private setHighlightItemToNormalBackground()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 596
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_1

    .line 597
    const/4 v1, 0x0

    .line 598
    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 599
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 600
    .local v0, "child":Landroid/view/View;
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 601
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 606
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    instance-of v2, v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    if-eqz v2, :cond_1

    .line 607
    if-nez v1, :cond_3

    .line 608
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getHomeShovelerItemsShownSubscriber()Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    move-result-object v2

    invoke-interface {v2, v4}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;->onMostLeftItemFocused(Z)V

    .line 614
    .end local v1    # "i":I
    :cond_1
    :goto_1
    return-void

    .line 598
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "i":I
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 609
    .end local v0    # "child":Landroid/view/View;
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v2

    if-ne v1, v2, :cond_1

    .line 610
    iget-object v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    check-cast v2, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;->getHomeShovelerItemsShownSubscriber()Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;

    move-result-object v2

    invoke-interface {v2, v4}, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItemsShownSubscriber;->onMostRightItemFocused(Z)V

    goto :goto_1
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 13
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v8, 0x14

    const/high16 v12, -0x80000000

    const/4 v7, 0x0

    const/4 v9, 0x1

    .line 631
    iget-boolean v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    if-nez v6, :cond_0

    move v6, v9

    .line 688
    :goto_0
    return v6

    .line 639
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v6

    if-nez v6, :cond_4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v6

    const/16 v10, 0x16

    if-ne v6, v10, :cond_4

    .line 640
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v10

    invoke-interface {v10}, Landroid/widget/ListAdapter;->getCount()I

    move-result v10

    if-ge v6, v10, :cond_2

    .line 642
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 648
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v10, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v10, v10, -0x1

    if-lt v6, v10, :cond_7

    .line 650
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getRight()I

    move-result v4

    .line 651
    .local v4, "rightEdge":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getWidth()I

    move-result v3

    .line 652
    .local v3, "parentWidth":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;

    invoke-virtual {v6}, Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;->getTotalCount()I

    move-result v5

    .line 654
    .local v5, "totalCount":I
    sub-int v6, v4, v3

    if-nez v6, :cond_1

    .line 656
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v10

    iget v11, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget-object v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v6}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-interface {v10, v11, v6, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 657
    .local v2, "nextViewToShow":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getWidth()I

    move-result v6

    invoke-static {v6, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getHeight()I

    move-result v10

    invoke-static {v10, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v10

    invoke-virtual {v2, v6, v10}, Landroid/view/View;->measure(II)V

    .line 659
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    add-int/2addr v6, v10

    iput v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 663
    .end local v2    # "nextViewToShow":Landroid/view/View;
    :cond_1
    sub-int v10, v4, v3

    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v11, v5, -0x1

    if-ne v6, v11, :cond_3

    move v6, v7

    :goto_1
    add-int v0, v10, v6

    .line 664
    .local v0, "delta":I
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    add-int/2addr v6, v0

    iput v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 665
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    move v6, v9

    .line 666
    goto/16 :goto_0

    .end local v0    # "delta":I
    .end local v3    # "parentWidth":I
    .end local v4    # "rightEdge":I
    .end local v5    # "totalCount":I
    :cond_2
    move v6, v9

    .line 645
    goto/16 :goto_0

    .restart local v3    # "parentWidth":I
    .restart local v4    # "rightEdge":I
    .restart local v5    # "totalCount":I
    :cond_3
    move v6, v8

    .line 663
    goto :goto_1

    .line 668
    .end local v3    # "parentWidth":I
    .end local v4    # "rightEdge":I
    .end local v5    # "totalCount":I
    :cond_4
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v6

    if-nez v6, :cond_7

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v6

    const/16 v10, 0x15

    if-ne v6, v10, :cond_7

    .line 669
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, -0x1

    if-ltz v6, :cond_5

    .line 671
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, -0x1

    iput v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 677
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v10, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v10, v10, 0x1

    if-ne v6, v10, :cond_7

    .line 679
    invoke-virtual {p0, v7}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 681
    .local v1, "left":I
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    if-nez v6, :cond_6

    :goto_2
    sub-int v0, v1, v7

    .line 682
    .restart local v0    # "delta":I
    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    add-int/2addr v6, v0

    iput v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 683
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    move v6, v9

    .line 684
    goto/16 :goto_0

    .end local v0    # "delta":I
    .end local v1    # "left":I
    :cond_5
    move v6, v9

    .line 674
    goto/16 :goto_0

    .restart local v1    # "left":I
    :cond_6
    move v7, v8

    .line 681
    goto :goto_2

    .line 688
    .end local v1    # "left":I
    :cond_7
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v6

    goto/16 :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 475
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 476
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V

    .line 478
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mGesture:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getSelectedView()Landroid/view/View;
    .locals 1

    .prologue
    .line 181
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onDown(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    .line 469
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 470
    return v1
.end method

.method protected onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 9
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 458
    monitor-enter p0

    .line 461
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    const/4 v2, 0x0

    neg-float v3, p3

    float-to-int v3, v3

    const/4 v4, 0x0

    const/high16 v5, -0x80000000

    const v6, 0x7fffffff

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    .line 462
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 463
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    .line 465
    const/4 v0, 0x1

    return v0

    .line 462
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onFocusChange(Landroid/view/View;Z)V
    .locals 10
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 699
    if-eqz p2, :cond_0

    .line 703
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v9, v9, 0x1

    if-lt v8, v9, :cond_5

    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v9, v9, -0x1

    if-gt v8, v9, :cond_5

    .line 705
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v9, v9, 0x1

    sub-int v4, v8, v9

    .line 707
    .local v4, "toBeFocusedItemIndex":I
    invoke-virtual {p0, v4}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 709
    .local v5, "toBeFocusedView":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 710
    .local v2, "left":I
    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v3

    .line 712
    .local v3, "right":I
    invoke-virtual {v5}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getWidth()I

    move-result v7

    .line 714
    .local v7, "w":I
    if-lez v2, :cond_1

    if-ge v3, v7, :cond_1

    .line 716
    invoke-virtual {v5}, Landroid/view/View;->requestFocus()Z

    .line 761
    .end local v2    # "left":I
    .end local v3    # "right":I
    .end local v4    # "toBeFocusedItemIndex":I
    .end local v5    # "toBeFocusedView":Landroid/view/View;
    .end local v7    # "w":I
    :cond_0
    :goto_0
    return-void

    .line 718
    .restart local v2    # "left":I
    .restart local v3    # "right":I
    .restart local v4    # "toBeFocusedItemIndex":I
    .restart local v5    # "toBeFocusedView":Landroid/view/View;
    .restart local v7    # "w":I
    :cond_1
    if-gtz v2, :cond_3

    .line 720
    const/4 v0, 0x0

    .line 721
    .local v0, "delta":I
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    if-lez v8, :cond_2

    .line 723
    add-int/lit8 v0, v2, -0x14

    .line 728
    :goto_1
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    add-int/2addr v8, v0

    iput v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 729
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    goto :goto_0

    .line 726
    :cond_2
    move v0, v2

    goto :goto_1

    .line 730
    .end local v0    # "delta":I
    :cond_3
    if-lt v3, v7, :cond_0

    .line 732
    const/4 v0, 0x0

    .line 733
    .restart local v0    # "delta":I
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v9

    invoke-interface {v9}, Landroid/widget/ListAdapter;->getCount()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    if-eq v8, v9, :cond_4

    .line 735
    sub-int v8, v3, v7

    add-int/lit8 v0, v8, 0x14

    .line 740
    :goto_2
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    add-int/2addr v8, v0

    iput v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 741
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    goto :goto_0

    .line 738
    :cond_4
    sub-int v0, v3, v7

    goto :goto_2

    .line 746
    .end local v0    # "delta":I
    .end local v2    # "left":I
    .end local v3    # "right":I
    .end local v4    # "toBeFocusedItemIndex":I
    .end local v5    # "toBeFocusedView":Landroid/view/View;
    .end local v7    # "w":I
    :cond_5
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_3
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildCount()I

    move-result v8

    if-ge v1, v8, :cond_0

    .line 747
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 748
    .local v6, "view":Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 749
    .restart local v2    # "left":I
    if-ltz v2, :cond_7

    .line 750
    if-eq p1, v6, :cond_6

    .line 751
    invoke-virtual {v6}, Landroid/view/View;->requestFocus()Z

    .line 753
    :cond_6
    iget v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v8, v8, 0x1

    add-int/2addr v8, v1

    iput v8, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    goto :goto_0

    .line 746
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_3
.end method

.method protected declared-synchronized onLayout(ZIIII)V
    .locals 7
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x1

    .line 303
    monitor-enter p0

    :try_start_0
    invoke-super/range {p0 .. p5}, Landroid/widget/AdapterView;->onLayout(ZIIII)V

    .line 305
    iget-object v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v6, :cond_1

    .line 361
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 310
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getFocusedChild()Landroid/view/View;

    move-result-object v6

    if-eqz v6, :cond_7

    .line 312
    .local v3, "shouldRequireFocus":Z
    :goto_1
    iget-boolean v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataChanged:Z

    if-eqz v5, :cond_2

    .line 313
    iget v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentX:I

    .line 314
    .local v1, "oldCurrentX":I
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mRightViewPosition:I

    .line 315
    const v5, 0x7fffffff

    iput v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    .line 316
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->removeAllViewsInLayout()V

    .line 317
    iput v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 318
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataChanged:Z

    .line 321
    .end local v1    # "oldCurrentX":I
    :cond_2
    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v5}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 322
    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v5}, Landroid/widget/Scroller;->getCurrX()I

    move-result v2

    .line 323
    .local v2, "scrollx":I
    iput v2, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 326
    .end local v2    # "scrollx":I
    :cond_3
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    if-gtz v5, :cond_4

    .line 327
    const/4 v5, 0x0

    iput v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 328
    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 331
    :cond_4
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    if-lt v5, v6, :cond_5

    .line 332
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mMaxX:I

    iput v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    .line 333
    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 336
    :cond_5
    invoke-direct {p0, p2, p4}, Lcom/amazon/mShop/ui/HorizontalListView;->checkedDelta(II)I

    move-result v0

    .line 338
    .local v0, "dx":I
    invoke-direct {p0, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->removeNonVisibleItems(I)V

    .line 339
    invoke-direct {p0, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->fillList(I)V

    .line 340
    invoke-direct {p0, v0}, Lcom/amazon/mShop/ui/HorizontalListView;->positionItems(I)V

    .line 342
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNextX:I

    iput v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentX:I

    .line 344
    iget v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v6, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v6, v6, 0x1

    sub-int/2addr v5, v6

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 345
    .local v4, "viewShouldTakeFocus":Landroid/view/View;
    if-eqz v4, :cond_6

    invoke-virtual {v4}, Landroid/view/View;->isInTouchMode()Z

    move-result v5

    if-nez v5, :cond_6

    if-eqz v3, :cond_6

    .line 346
    invoke-virtual {v4}, Landroid/view/View;->requestFocus()Z

    .line 350
    :cond_6
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    .line 352
    iget-object v5, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v5}, Landroid/widget/Scroller;->isFinished()Z

    move-result v5

    if-nez v5, :cond_0

    .line 353
    new-instance v5, Lcom/amazon/mShop/ui/HorizontalListView$2;

    invoke-direct {v5, p0}, Lcom/amazon/mShop/ui/HorizontalListView$2;-><init>(Lcom/amazon/mShop/ui/HorizontalListView;)V

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/ui/HorizontalListView;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 303
    .end local v0    # "dx":I
    .end local v3    # "shouldRequireFocus":Z
    .end local v4    # "viewShouldTakeFocus":Landroid/view/View;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    :cond_7
    move v3, v5

    .line 310
    goto/16 :goto_1
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 58
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 189
    :cond_0
    if-nez p1, :cond_1

    .line 198
    :goto_0
    return-void

    .line 192
    :cond_1
    instance-of v0, p1, Lcom/amazon/mShop/ui/HorizontalListView$HorizontalListViewAdapter;

    if-nez v0, :cond_2

    .line 193
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "You should set a HorizontalListViewAdapter instance to this listview"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 195
    :cond_2
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 197
    invoke-direct {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->reset()V

    goto :goto_0
.end method

.method public setHighlightBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 131
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 132
    return-void
.end method

.method public setHighlightBackgroundResource(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 140
    return-void
.end method

.method public setNormalBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 136
    return-void
.end method

.method public setNormalBackgroundResource(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 143
    if-eqz p1, :cond_0

    .line 144
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 146
    :cond_0
    return-void
.end method

.method public setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemClickListener;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    .line 118
    return-void
.end method

.method public setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemLongClickListener;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 123
    return-void
.end method

.method public setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemSelectedListener;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 113
    return-void
.end method

.method public setSelection(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 209
    return-void
.end method
