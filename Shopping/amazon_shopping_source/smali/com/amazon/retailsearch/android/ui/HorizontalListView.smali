.class public Lcom/amazon/retailsearch/android/ui/HorizontalListView;
.super Landroid/widget/AdapterView;
.source "HorizontalListView.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;,
        Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;,
        Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;
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


# static fields
.field private static final ID_VIEW_TYPE:I

.field private static final PREVIEW_OFFSET:I = 0x14

.field private static final VIEW_TYPE_FOOTER:Ljava/lang/String; = "F"

.field private static final VIEW_TYPE_PRODUCT:Ljava/lang/String; = "P"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private itemWidth:I

.field protected mAdapter:Landroid/widget/ListAdapter;

.field private mCanReceiveKeyEvent:Z

.field private mCurrentFocusPosition:I

.field protected mCurrentX:I

.field private mDataChanged:Z

.field private mDataObserver:Landroid/database/DataSetObserver;

.field private mDisplayOffset:I

.field private mDivider:Landroid/graphics/drawable/Drawable;

.field private mDividerWidth:I

.field private mFooterViewInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mGesture:Landroid/view/GestureDetector;

.field private mHighlightBackground:Landroid/graphics/drawable/Drawable;

.field protected mInitialPosition:I

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

.field private onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

.field private prevState:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 67
    const-class v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    .line 70
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_horizontal_list_view_type:I

    sput v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->ID_VIEW_TYPE:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 104
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, -0x1

    const/4 v1, 0x0

    .line 108
    invoke-direct {p0, p1, p2}, Landroid/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 75
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 76
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    .line 80
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    .line 81
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    .line 82
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 83
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 86
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    .line 90
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z

    .line 91
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 95
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->prevState:I

    .line 96
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->itemWidth:I

    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 196
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    .line 652
    new-instance v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$2;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$2;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    .line 111
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$color;->transparent:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 112
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 114
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->initView()V

    .line 115
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v0, -0x1

    const/4 v1, 0x0

    .line 119
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AdapterView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 75
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 76
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    .line 80
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    .line 81
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    .line 82
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 83
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 86
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    .line 90
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z

    .line 91
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 95
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->prevState:I

    .line 96
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->itemWidth:I

    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    .line 196
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    .line 652
    new-instance v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$2;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$2;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    .line 120
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z

    return p1
.end method

.method static synthetic access$1000(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->reset()V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Landroid/view/MotionEvent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p1, "x1"    # Landroid/view/MotionEvent;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setHighlightItemToNormalBackground()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Landroid/view/MotionEvent;Landroid/view/View;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p1, "x1"    # Landroid/view/MotionEvent;
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    return v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)Landroid/widget/AdapterView$OnItemSelectedListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    return-object v0
.end method

.method private addAndMeasureChild(Landroid/view/View;I)V
    .locals 4
    .param p1, "child"    # Landroid/view/View;
    .param p2, "viewPos"    # I

    .prologue
    const/4 v1, -0x1

    const/high16 v3, -0x80000000

    .line 293
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 294
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    if-nez v0, :cond_0

    .line 296
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    .end local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    .line 299
    .restart local v0    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v1

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getHeight()I

    move-result v2

    invoke-static {v2, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/view/View;->measure(II)V

    .line 301
    const/4 v1, 0x1

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 302
    return-void
.end method

.method private checkRight(II)I
    .locals 1
    .param p1, "rightEdge"    # I
    .param p2, "rightViewPos"    # I

    .prologue
    .line 325
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v0

    if-ge p1, v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    if-ge p2, v0, :cond_0

    .line 327
    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewWidth(I)I

    move-result v0

    add-int/2addr p1, v0

    .line 328
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 331
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v0

    if-ge p1, v0, :cond_1

    .line 333
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v0

    sub-int/2addr v0, p1

    .line 335
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
    .line 353
    sub-int v1, p2, p1

    .line 354
    .local v1, "width":I
    const/4 v0, 0x0

    .line 355
    .local v0, "dx":I
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 357
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    .line 358
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    .line 361
    :cond_0
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    sub-int/2addr v2, v3

    if-ne v2, v1, :cond_1

    .line 364
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentX:I

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    sub-int v0, v2, v3

    .line 378
    :goto_0
    return v0

    .line 372
    :cond_1
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getRightEdge()I

    move-result v2

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    invoke-direct {p0, v2, v3}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->checkRight(II)I

    move-result v0

    .line 374
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    .line 375
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    goto :goto_0
.end method

.method private fillList(I)V
    .locals 3
    .param p1, "dx"    # I

    .prologue
    .line 483
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 484
    .local v1, "edge":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 485
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 487
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 489
    :cond_0
    invoke-direct {p0, v1, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->fillListRight(II)V

    .line 491
    const/4 v1, 0x0

    .line 492
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 493
    if-eqz v0, :cond_1

    .line 495
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 497
    :cond_1
    invoke-direct {p0, v1, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->fillListLeft(II)V

    .line 499
    return-void
.end method

.method private fillListLeft(II)V
    .locals 3
    .param p1, "leftEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 534
    :goto_0
    add-int v1, p1, p2

    if-lez v1, :cond_0

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    if-ltz v1, :cond_0

    .line 536
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewFromAdapter(I)Landroid/view/View;

    move-result-object v0

    .line 537
    .local v0, "child":Landroid/view/View;
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 538
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    sub-int/2addr p1, v1

    .line 539
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 540
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    goto :goto_0

    .line 545
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    add-int v1, p1, p2

    if-lez v1, :cond_1

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    .line 547
    neg-int v1, p2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 549
    :cond_1
    return-void
.end method

.method private fillListRight(II)V
    .locals 3
    .param p1, "rightEdge"    # I
    .param p2, "dx"    # I

    .prologue
    .line 503
    :goto_0
    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_1

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 506
    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v2

    neg-int v2, v2

    if-gt v1, v2, :cond_0

    .line 508
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 509
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 510
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v1

    add-int/2addr p1, v1

    .line 518
    :goto_1
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    goto :goto_0

    .line 514
    :cond_0
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewFromAdapter(I)Landroid/view/View;

    move-result-object v0

    .line 515
    .local v0, "child":Landroid/view/View;
    const/4 v1, -0x1

    invoke-direct {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->addAndMeasureChild(Landroid/view/View;I)V

    .line 516
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    add-int/2addr p1, v1

    goto :goto_1

    .line 521
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2}, Landroid/widget/ListAdapter;->getCount()I

    move-result v2

    if-ne v1, v2, :cond_2

    add-int v1, p1, p2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 523
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentX:I

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 526
    :cond_2
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    if-gez v1, :cond_3

    .line 528
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 530
    :cond_3
    return-void
.end method

.method private getRightEdge()I
    .locals 3

    .prologue
    .line 389
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 390
    .local v1, "rightEdge":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 391
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 393
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 395
    :cond_0
    return v1
.end method

.method private getViewWidth(I)I
    .locals 5
    .param p1, "pos"    # I

    .prologue
    const/high16 v4, -0x80000000

    .line 306
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewFromAdapter(I)Landroid/view/View;

    move-result-object v0

    .line 308
    .local v0, "v":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v2

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getHeight()I

    move-result v3

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/view/View;->measure(II)V

    .line 310
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 311
    .local v1, "w":I
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->recycleView(Landroid/view/View;)Z

    .line 312
    return v1
.end method

.method private declared-synchronized initView()V
    .locals 4

    .prologue
    .line 124
    monitor-enter p0

    const/4 v1, -0x1

    :try_start_0
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 125
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    .line 126
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 127
    const/4 v1, -0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastLeft:I

    .line 128
    const/4 v1, -0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLastRight:I

    .line 129
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentX:I

    .line 130
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 131
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 132
    const v1, 0x7fffffff

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 133
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->clear()V

    .line 134
    new-instance v1, Landroid/widget/Scroller;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    .line 135
    new-instance v1, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnGesture:Landroid/view/GestureDetector$OnGestureListener;

    invoke-direct {v1, v2, v3}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mGesture:Landroid/view/GestureDetector;

    .line 136
    invoke-virtual {p0, p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 139
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setHorizontalScrollBarEnabled(Z)V

    .line 140
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setVerticalScrollBarEnabled(Z)V

    .line 141
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/amazon/retailsearch/R$styleable;->ScrollableView:[I

    invoke-virtual {v1, v2}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 142
    .local v0, "typedArray":Landroid/content/res/TypedArray;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->initializeScrollbars(Landroid/content/res/TypedArray;)V

    .line 143
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 144
    monitor-exit p0

    return-void

    .line 124
    .end local v0    # "typedArray":Landroid/content/res/TypedArray;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z
    .locals 8
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 803
    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    .line 804
    .local v5, "viewRect":Landroid/graphics/Rect;
    const/4 v6, 0x2

    new-array v1, v6, [I

    .line 805
    .local v1, "childPosition":[I
    invoke-virtual {p2, v1}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 806
    const/4 v6, 0x0

    aget v2, v1, v6

    .line 807
    .local v2, "left":I
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    move-result v6

    add-int v3, v2, v6

    .line 808
    .local v3, "right":I
    const/4 v6, 0x1

    aget v4, v1, v6

    .line 809
    .local v4, "top":I
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    move-result v6

    add-int v0, v4, v6

    .line 810
    .local v0, "bottom":I
    invoke-virtual {v5, v2, v4, v3, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 811
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
    const/4 v6, 0x0

    .line 592
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v4

    if-lez v4, :cond_1

    .line 594
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mInitialPosition:I

    if-eqz v4, :cond_0

    .line 596
    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 602
    :goto_0
    iget v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 603
    .local v3, "left":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 605
    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 606
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 607
    .local v1, "childWidth":I
    add-int v4, v3, v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    invoke-virtual {v0, v3, v6, v4, v5}, Landroid/view/View;->layout(IIII)V

    .line 608
    add-int/2addr v3, v1

    .line 603
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 600
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "childWidth":I
    .end local v2    # "i":I
    .end local v3    # "left":I
    :cond_0
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    add-int/2addr v4, p1

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    goto :goto_0

    .line 611
    :cond_1
    return-void
.end method

.method private removeAllVisibleItems()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 553
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 554
    .local v0, "child":Landroid/view/View;
    :goto_0
    if-eqz v0, :cond_0

    .line 556
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->recycleView(Landroid/view/View;)Z

    .line 557
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 558
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 560
    :cond_0
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    .line 561
    const v1, 0x7fffffff

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    .line 562
    return-void
.end method

.method private removeNonVisibleItems(I)V
    .locals 4
    .param p1, "dx"    # I

    .prologue
    const/4 v3, 0x0

    .line 566
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 567
    .local v0, "child":Landroid/view/View;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    add-int/2addr v1, p1

    if-gtz v1, :cond_0

    .line 569
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDisplayOffset:I

    .line 570
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->recycleView(Landroid/view/View;)Z

    .line 571
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 572
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    .line 573
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 576
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 577
    :goto_1
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    add-int/2addr v1, p1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v2

    if-lt v1, v2, :cond_1

    .line 579
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->recycleView(Landroid/view/View;)Z

    .line 580
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeViewInLayout(Landroid/view/View;)V

    .line 581
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    .line 582
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 586
    const v1, 0x7fffffff

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    goto :goto_1

    .line 588
    :cond_1
    return-void
.end method

.method private declared-synchronized reset()V
    .locals 1

    .prologue
    .line 267
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->initView()V

    .line 268
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeAllViewsInLayout()V

    .line 269
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 270
    monitor-exit p0

    return-void

    .line 267
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private setFocusedItemToHightLightBackground(Landroid/view/MotionEvent;)V
    .locals 3
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 769
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_0

    .line 771
    const/4 v1, 0x0

    .line 772
    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 774
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 775
    .local v0, "child":Landroid/view/View;
    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->isEventWithinView(Landroid/view/MotionEvent;Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 777
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 782
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "i":I
    :cond_0
    return-void

    .line 772
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "i":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private setHighlightItemToNormalBackground()V
    .locals 4

    .prologue
    .line 786
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_0

    .line 788
    const/4 v1, 0x0

    .line 789
    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 791
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 792
    .local v0, "child":Landroid/view/View;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 794
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 799
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "i":I
    :cond_0
    return-void

    .line 789
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "i":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "data"    # Ljava/lang/Object;
    .param p3, "isSelectable"    # Z

    .prologue
    .line 1129
    new-instance v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    .line 1130
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;
    iput-object p1, v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->view:Landroid/view/View;

    .line 1131
    iput-object p2, v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->data:Ljava/lang/Object;

    .line 1132
    iput-boolean p3, v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$FixedViewInfo;->isSelectable:Z

    .line 1133
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1134
    return-void
.end method

.method protected computeHorizontalScrollExtent()I
    .locals 1

    .prologue
    .line 1239
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v0

    return v0
.end method

.method protected computeHorizontalScrollOffset()I
    .locals 1

    .prologue
    .line 1245
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentX:I

    return v0
.end method

.method protected computeHorizontalScrollRange()I
    .locals 2

    .prologue
    .line 1251
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    mul-int/2addr v0, v1

    return v0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 1205
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    .line 1207
    .local v2, "count":I
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v6, :cond_1

    const/4 v6, 0x1

    if-le v2, v6, :cond_1

    .line 1209
    const/4 v6, 0x0

    invoke-virtual {p0, v6}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1210
    .local v1, "child":Landroid/view/View;
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 1211
    .local v0, "bounds":Landroid/graphics/Rect;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getTop()I

    move-result v6

    iput v6, v0, Landroid/graphics/Rect;->top:I

    .line 1212
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getBottom()I

    move-result v6

    iput v6, v0, Landroid/graphics/Rect;->bottom:I

    .line 1213
    const/4 v4, 0x1

    .local v4, "i":I
    :goto_0
    if-ge v4, v2, :cond_1

    .line 1215
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1216
    const-string/jumbo v6, "F"

    sget v7, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->ID_VIEW_TYPE:I

    invoke-virtual {v1, v7}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1213
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1220
    :cond_0
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v5

    .line 1221
    .local v5, "left":I
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDividerWidth:I

    sub-int v6, v5, v6

    iput v6, v0, Landroid/graphics/Rect;->left:I

    .line 1222
    iput v5, v0, Landroid/graphics/Rect;->right:I

    .line 1223
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6, v0}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 1224
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1228
    .end local v0    # "bounds":Landroid/graphics/Rect;
    .end local v1    # "child":Landroid/view/View;
    .end local v2    # "count":I
    .end local v4    # "i":I
    .end local v5    # "left":I
    :catch_0
    move-exception v3

    .line 1230
    .local v3, "e":Ljava/lang/Exception;
    sget-object v6, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v7, "Could not draw the divider"

    invoke-interface {v6, v7, v3}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1233
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 1234
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 12
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v8, 0x14

    const/high16 v11, -0x80000000

    const/4 v7, 0x0

    const/4 v9, 0x1

    .line 817
    iget-boolean v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    if-nez v6, :cond_0

    move v6, v9

    .line 891
    :goto_0
    return v6

    .line 826
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v6

    if-nez v6, :cond_4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v6

    const/16 v10, 0x16

    if-ne v6, v10, :cond_4

    .line 828
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v10

    invoke-interface {v10}, Landroid/widget/ListAdapter;->getCount()I

    move-result v10

    if-ge v6, v10, :cond_2

    .line 831
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 839
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v10, v10, -0x1

    if-lt v6, v10, :cond_7

    .line 842
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {p0, v6}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getRight()I

    move-result v4

    .line 843
    .local v4, "rightEdge":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getWidth()I

    move-result v3

    .line 844
    .local v3, "parentWidth":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v6

    invoke-interface {v6}, Landroid/widget/ListAdapter;->getCount()I

    move-result v5

    .line 846
    .local v5, "totalCount":I
    sub-int v6, v4, v3

    if-nez v6, :cond_1

    .line 850
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    invoke-virtual {p0, v6}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewFromAdapter(I)Landroid/view/View;

    move-result-object v2

    .line 851
    .local v2, "nextViewToShow":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getWidth()I

    move-result v6

    invoke-static {v6, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getHeight()I

    move-result v10

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v10

    invoke-virtual {v2, v6, v10}, Landroid/view/View;->measure(II)V

    .line 853
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v10

    add-int/2addr v6, v10

    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 858
    .end local v2    # "nextViewToShow":Landroid/view/View;
    :cond_1
    sub-int v10, v4, v3

    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v11, v5, -0x1

    if-ne v6, v11, :cond_3

    move v6, v7

    :goto_1
    add-int v0, v10, v6

    .line 859
    .local v0, "delta":I
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    add-int/2addr v6, v0

    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 860
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    move v6, v9

    .line 861
    goto/16 :goto_0

    .end local v0    # "delta":I
    .end local v3    # "parentWidth":I
    .end local v4    # "rightEdge":I
    .end local v5    # "totalCount":I
    :cond_2
    move v6, v9

    .line 836
    goto/16 :goto_0

    .restart local v3    # "parentWidth":I
    .restart local v4    # "rightEdge":I
    .restart local v5    # "totalCount":I
    :cond_3
    move v6, v8

    .line 858
    goto :goto_1

    .line 864
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

    .line 866
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, -0x1

    if-ltz v6, :cond_5

    .line 869
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    add-int/lit8 v6, v6, -0x1

    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    .line 877
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v10, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v10, v10, 0x1

    if-ne v6, v10, :cond_7

    .line 881
    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 884
    .local v1, "left":I
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    if-nez v6, :cond_6

    :goto_2
    sub-int v0, v1, v7

    .line 885
    .restart local v0    # "delta":I
    iget v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    add-int/2addr v6, v0

    iput v6, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 886
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    move v6, v9

    .line 887
    goto/16 :goto_0

    .end local v0    # "delta":I
    .end local v1    # "left":I
    :cond_5
    move v6, v9

    .line 874
    goto/16 :goto_0

    .restart local v1    # "left":I
    :cond_6
    move v7, v8

    .line 884
    goto :goto_2

    .line 891
    .end local v1    # "left":I
    :cond_7
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v6

    goto/16 :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 643
    invoke-super {p0, p1}, Landroid/widget/AdapterView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 644
    .local v0, "handled":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 646
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setHighlightItemToNormalBackground()V

    .line 648
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mGesture:Landroid/view/GestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 649
    return v0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getFirstVisiblePosition()I
    .locals 1

    .prologue
    .line 897
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method protected getItemWidth()I
    .locals 1

    .prologue
    .line 284
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->itemWidth:I

    if-nez v0, :cond_0

    .line 286
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getViewWidth(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->itemWidth:I

    .line 288
    :cond_0
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->itemWidth:I

    return v0
.end method

.method public getLastVisiblePosition()I
    .locals 1

    .prologue
    .line 903
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public getSelectedView()Landroid/view/View;
    .locals 1

    .prologue
    .line 235
    const/4 v0, 0x0

    return-object v0
.end method

.method public getViewFromAdapter(I)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 1145
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1}, Landroid/widget/ListAdapter;->getCount()I

    move-result v1

    sub-int/2addr v1, p1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-gt v1, v2, :cond_0

    .line 1147
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    const/4 v2, 0x0

    invoke-interface {v1, p1, v2, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1148
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->ID_VIEW_TYPE:I

    const-string/jumbo v2, "F"

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 1155
    :goto_0
    return-object v0

    .line 1152
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-interface {v2, p1, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1153
    .restart local v0    # "view":Landroid/view/View;
    sget v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->ID_VIEW_TYPE:I

    const-string/jumbo v2, "P"

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    goto :goto_0
.end method

.method invokeOnItemScrollListener()V
    .locals 4

    .prologue
    .line 1071
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    .line 1073
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getFirstVisiblePosition()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v3}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    invoke-interface {v0, p0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;->onScroll(Lcom/amazon/retailsearch/android/ui/HorizontalListView;III)V

    .line 1075
    :cond_0
    return-void
.end method

.method protected onDown(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    .line 636
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0, v1}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 637
    return v1
.end method

.method protected onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 9
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 621
    monitor-enter p0

    .line 627
    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    const/4 v2, 0x0

    neg-float v3, p3

    float-to-int v3, v3

    const/4 v4, 0x0

    const/high16 v5, -0x80000000

    const v6, 0x7fffffff

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    .line 628
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 629
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    .line 631
    const/4 v0, 0x1

    return v0

    .line 628
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
    .line 910
    if-eqz p2, :cond_0

    .line 917
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v9, v9, 0x1

    if-lt v8, v9, :cond_5

    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRightViewPosition:I

    add-int/lit8 v9, v9, -0x1

    if-gt v8, v9, :cond_5

    .line 921
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v9, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v9, v9, 0x1

    sub-int v4, v8, v9

    .line 923
    .local v4, "toBeFocusedItemIndex":I
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 925
    .local v5, "toBeFocusedView":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 926
    .local v2, "left":I
    invoke-virtual {v5}, Landroid/view/View;->getRight()I

    move-result v3

    .line 928
    .local v3, "right":I
    invoke-virtual {v5}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getWidth()I

    move-result v7

    .line 930
    .local v7, "w":I
    if-lez v2, :cond_1

    if-ge v3, v7, :cond_1

    .line 933
    invoke-virtual {v5}, Landroid/view/View;->requestFocus()Z

    .line 1002
    .end local v2    # "left":I
    .end local v3    # "right":I
    .end local v4    # "toBeFocusedItemIndex":I
    .end local v5    # "toBeFocusedView":Landroid/view/View;
    .end local v7    # "w":I
    :cond_0
    :goto_0
    return-void

    .line 937
    .restart local v2    # "left":I
    .restart local v3    # "right":I
    .restart local v4    # "toBeFocusedItemIndex":I
    .restart local v5    # "toBeFocusedView":Landroid/view/View;
    .restart local v7    # "w":I
    :cond_1
    if-gtz v2, :cond_3

    .line 941
    const/4 v0, 0x0

    .line 942
    .local v0, "delta":I
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    if-lez v8, :cond_2

    .line 946
    add-int/lit8 v0, v2, -0x14

    .line 954
    :goto_1
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    add-int/2addr v8, v0

    iput v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 955
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    goto :goto_0

    .line 952
    :cond_2
    move v0, v2

    goto :goto_1

    .line 957
    .end local v0    # "delta":I
    :cond_3
    if-lt v3, v7, :cond_0

    .line 961
    const/4 v0, 0x0

    .line 962
    .restart local v0    # "delta":I
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v9

    invoke-interface {v9}, Landroid/widget/ListAdapter;->getCount()I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    if-eq v8, v9, :cond_4

    .line 966
    sub-int v8, v3, v7

    add-int/lit8 v0, v8, 0x14

    .line 974
    :goto_2
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    add-int/2addr v8, v0

    iput v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 975
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    goto :goto_0

    .line 972
    :cond_4
    sub-int v0, v3, v7

    goto :goto_2

    .line 984
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
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildCount()I

    move-result v8

    if-ge v1, v8, :cond_0

    .line 986
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 987
    .local v6, "view":Landroid/view/View;
    invoke-virtual {v6}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 988
    .restart local v2    # "left":I
    if-ltz v2, :cond_7

    .line 990
    if-eq p1, v6, :cond_6

    .line 992
    invoke-virtual {v6}, Landroid/view/View;->requestFocus()Z

    .line 994
    :cond_6
    iget v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v8, v8, 0x1

    add-int/2addr v8, v1

    iput v8, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    goto :goto_0

    .line 984
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_3
.end method

.method protected declared-synchronized onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 401
    monitor-enter p0

    :try_start_0
    invoke-super/range {p0 .. p5}, Landroid/widget/AdapterView;->onLayout(ZIIII)V

    .line 403
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v5, :cond_0

    .line 479
    :goto_0
    monitor-exit p0

    return-void

    .line 410
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getFocusedChild()Landroid/view/View;

    move-result-object v5

    if-eqz v5, :cond_7

    .line 412
    .local v2, "shouldRequireFocus":Z
    :goto_1
    iget-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z

    if-eqz v4, :cond_1

    .line 414
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeAllVisibleItems()V

    .line 415
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z

    .line 418
    :cond_1
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mInitialPosition:I

    if-eqz v4, :cond_2

    .line 420
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mInitialPosition:I

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getItemWidth()I

    move-result v5

    mul-int/2addr v4, v5

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 423
    :cond_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 425
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->getCurrX()I

    move-result v1

    .line 426
    .local v1, "scrollx":I
    iput v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 429
    .end local v1    # "scrollx":I
    :cond_3
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    if-gtz v4, :cond_4

    .line 431
    const/4 v4, 0x0

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 432
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 435
    :cond_4
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    iget v5, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    if-lt v4, v5, :cond_5

    .line 437
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mMaxX:I

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    .line 438
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroid/widget/Scroller;->forceFinished(Z)V

    .line 441
    :cond_5
    invoke-direct {p0, p2, p4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->checkedDelta(II)I

    move-result v0

    .line 443
    .local v0, "dx":I
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->removeNonVisibleItems(I)V

    .line 444
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->fillList(I)V

    .line 445
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->positionItems(I)V

    .line 447
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentX:I

    .line 448
    const/4 v4, 0x0

    iput v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mInitialPosition:I

    .line 450
    iget v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCurrentFocusPosition:I

    iget v5, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mLeftViewPosition:I

    add-int/lit8 v5, v5, 0x1

    sub-int/2addr v4, v5

    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 451
    .local v3, "viewShouldTakeFocus":Landroid/view/View;
    if-eqz v3, :cond_6

    invoke-virtual {v3}, Landroid/view/View;->isInTouchMode()Z

    move-result v4

    if-nez v4, :cond_6

    if-eqz v2, :cond_6

    .line 453
    invoke-virtual {v3}, Landroid/view/View;->requestFocus()Z

    .line 457
    :cond_6
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z

    .line 459
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v4}, Landroid/widget/Scroller;->isFinished()Z

    move-result v4

    if-nez v4, :cond_8

    .line 461
    new-instance v4, Lcom/amazon/retailsearch/android/ui/HorizontalListView$1;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$1;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->post(Ljava/lang/Runnable;)Z

    .line 469
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->reportScrollStateChange(I)V

    .line 477
    :goto_2
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->awakenScrollBars()Z

    .line 478
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->invalidate()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 401
    .end local v0    # "dx":I
    .end local v2    # "shouldRequireFocus":Z
    .end local v3    # "viewShouldTakeFocus":Landroid/view/View;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    :cond_7
    move v2, v4

    .line 410
    goto/16 :goto_1

    .line 473
    .restart local v0    # "dx":I
    .restart local v2    # "shouldRequireFocus":Z
    .restart local v3    # "viewShouldTakeFocus":Landroid/view/View;
    :cond_8
    const/4 v4, 0x0

    :try_start_2
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->reportScrollStateChange(I)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2
.end method

.method public recycleView(Landroid/view/View;)Z
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1166
    if-nez p1, :cond_0

    .line 1168
    const/4 v0, 0x0

    .line 1178
    :goto_0
    return v0

    .line 1170
    :cond_0
    const-string/jumbo v0, "F"

    sget v1, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->ID_VIEW_TYPE:I

    invoke-virtual {p1, v1}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1172
    const/4 v0, 0x1

    goto :goto_0

    .line 1177
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->forceLayout()V

    .line 1178
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mRemovedViewQueue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method reportScrollStateChange(I)V
    .locals 1
    .param p1, "newState"    # I

    .prologue
    .line 1088
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->prevState:I

    if-eq p1, v0, :cond_0

    .line 1090
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    if-eqz v0, :cond_0

    .line 1092
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->prevState:I

    .line 1093
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    invoke-interface {v0, p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;->onScrollStateChanged(Lcom/amazon/retailsearch/android/ui/HorizontalListView;I)V

    .line 1096
    :cond_0
    return-void
.end method

.method public declared-synchronized scrollTo(I)V
    .locals 5
    .param p1, "x"    # I

    .prologue
    .line 615
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mScroller:Landroid/widget/Scroller;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    const/4 v2, 0x0

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNextX:I

    sub-int v3, p1, v3

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/Scroller;->startScroll(IIII)V

    .line 616
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 617
    monitor-exit p0

    return-void

    .line 615
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 65
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 3
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    const/4 v2, 0x0

    .line 241
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_0

    .line 243
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 244
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    .line 246
    :cond_0
    if-nez p1, :cond_1

    .line 263
    :goto_0
    return-void

    .line 251
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 253
    new-instance v0, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mFooterViewInfos:Ljava/util/ArrayList;

    invoke-direct {v0, v2, v1, p1}, Lcom/amazon/retailsearch/android/ui/HeaderFooterListAdapter;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/widget/ListAdapter;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 260
    :goto_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;

    invoke-direct {v0, p0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Lcom/amazon/retailsearch/android/ui/HorizontalListView$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    .line 261
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 262
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->reset()V

    goto :goto_0

    .line 257
    :cond_2
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;

    goto :goto_1
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "mDivider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 1188
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 1189
    return-void
.end method

.method public setDividerWidth(I)V
    .locals 0
    .param p1, "mDividerWidth"    # I

    .prologue
    .line 1197
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDividerWidth:I

    .line 1198
    return-void
.end method

.method public setHighlightBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 172
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 173
    return-void
.end method

.method public setHighlightBackgroundResource(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 182
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mHighlightBackground:Landroid/graphics/drawable/Drawable;

    .line 183
    return-void
.end method

.method public setNormalBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 177
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 178
    return-void
.end method

.method public setNormalBackgroundResource(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 187
    if-eqz p1, :cond_0

    .line 189
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mNormalBackground:Landroid/graphics/drawable/Drawable;

    .line 191
    :cond_0
    return-void
.end method

.method public setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemClickListener;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemClicked:Landroid/widget/AdapterView$OnItemClickListener;

    .line 156
    return-void
.end method

.method public setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemLongClickListener;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemLongClicked:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 162
    return-void
.end method

.method public setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/AdapterView$OnItemSelectedListener;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mOnItemSelected:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 150
    return-void
.end method

.method public setOnScrollListener(Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;)V
    .locals 0
    .param p1, "onScrollListener"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    .prologue
    .line 1006
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->onScrollListener:Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;

    .line 1007
    return-void
.end method

.method public setSelection(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 275
    const/4 v0, -0x1

    if-le p1, v0, :cond_0

    .line 277
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mInitialPosition:I

    .line 278
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    .line 280
    :cond_0
    return-void
.end method
