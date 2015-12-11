.class public Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;
.super Landroid/widget/ListView;
.source "StickyListHeadersListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;
    }
.end annotation


# instance fields
.field private mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

.field private mAdapterHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper$OnHeaderClickListener;

.field private mAreHeadersSticky:Z

.field private final mClippingRect:Landroid/graphics/Rect;

.field private mClippingToPadding:Ljava/lang/Boolean;

.field private mCurrentHeaderId:Ljava/lang/Long;

.field private mDataSetChangedObserver:Landroid/database/DataSetObserver;

.field private mDivider:Landroid/graphics/drawable/Drawable;

.field private mDividerHeight:I

.field private mDrawingListUnderStickyHeader:Z

.field private mFooterViews:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mHeader:Landroid/view/View;

.field private mHeaderBeingPressed:Z

.field private mHeaderBottomPosition:I

.field private mHeaderDownY:F

.field private mHeaderPosition:Ljava/lang/Integer;

.field private mOnHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

.field private mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field private mOnScrollListenerDelegate:Landroid/widget/AbsListView$OnScrollListener;

.field private mSelectorPositionField:Ljava/lang/reflect/Field;

.field private mSelectorRect:Landroid/graphics/Rect;

.field private mViewConfig:Landroid/view/ViewConfiguration;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 101
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 102
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 105
    const v0, 0x1010074

    invoke-direct {p0, p1, p2, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 106
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 110
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 34
    iput-boolean v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    .line 40
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    .line 41
    iput-object v5, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mCurrentHeaderId:Ljava/lang/Long;

    .line 43
    const/high16 v2, -0x40800000    # -1.0f

    iput v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderDownY:F

    .line 44
    iput-boolean v4, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBeingPressed:Z

    .line 49
    iput-boolean v4, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDrawingListUnderStickyHeader:Z

    .line 50
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 53
    new-instance v2, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$1;

    invoke-direct {v2, p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$1;-><init>(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)V

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapterHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper$OnHeaderClickListener;

    .line 65
    new-instance v2, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$2;

    invoke-direct {v2, p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$2;-><init>(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)V

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDataSetChangedObserver:Landroid/database/DataSetObserver;

    .line 77
    new-instance v2, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$3;

    invoke-direct {v2, p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$3;-><init>(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)V

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 112
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-super {p0, v2}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 115
    invoke-super {p0, v5}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 116
    invoke-super {p0, v4}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 117
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mViewConfig:Landroid/view/ViewConfiguration;

    .line 118
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    if-nez v2, :cond_0

    .line 119
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    .line 123
    :cond_0
    :try_start_0
    const-class v2, Landroid/widget/AbsListView;

    const-string v3, "mSelectorRect"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 125
    .local v1, "selectorRectField":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 126
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/graphics/Rect;

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorRect:Landroid/graphics/Rect;

    .line 128
    const-class v2, Landroid/widget/AbsListView;

    const-string v3, "mSelectorPosition"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    iput-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorPositionField:Ljava/lang/reflect/Field;

    .line 130
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorPositionField:Ljava/lang/reflect/Field;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/reflect/Field;->setAccessible(Z)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    .line 138
    .end local v1    # "selectorRectField":Ljava/lang/reflect/Field;
    :goto_0
    return-void

    .line 131
    :catch_0
    move-exception v0

    .line 132
    .local v0, "e":Ljava/lang/NoSuchFieldException;
    invoke-virtual {v0}, Ljava/lang/NoSuchFieldException;->printStackTrace()V

    goto :goto_0

    .line 133
    .end local v0    # "e":Ljava/lang/NoSuchFieldException;
    :catch_1
    move-exception v0

    .line 134
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0

    .line 135
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 136
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->reset()V

    return-void
.end method

.method static synthetic access$200(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;)Landroid/widget/AbsListView$OnScrollListener;
    .locals 1
    .param p0, "x0"    # Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnScrollListenerDelegate:Landroid/widget/AbsListView$OnScrollListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;I)V
    .locals 0
    .param p0, "x0"    # Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->scrollChanged(I)V

    return-void
.end method

.method private drawStickyHeader(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 316
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getHeaderHeight()I

    move-result v0

    .line 317
    .local v0, "headerHeight":I
    iget v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    sub-int v1, v2, v0

    .line 319
    .local v1, "top":I
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v3

    iput v3, v2, Landroid/graphics/Rect;->left:I

    .line 320
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingRight()I

    move-result v4

    sub-int/2addr v3, v4

    iput v3, v2, Landroid/graphics/Rect;->right:I

    .line 321
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    add-int v3, v1, v0

    iput v3, v2, Landroid/graphics/Rect;->bottom:I

    .line 322
    iget-object v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v2

    :goto_0
    iput v2, v3, Landroid/graphics/Rect;->top:I

    .line 324
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 325
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 326
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v2

    int-to-float v2, v2

    int-to-float v3, v1

    invoke-virtual {p1, v2, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 327
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v2, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 328
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 329
    return-void

    .line 322
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private fixedFirstVisibleItem(I)I
    .locals 4
    .param p1, "firstVisibleItem"    # I

    .prologue
    .line 484
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_0

    move v0, p1

    .line 504
    .end local p1    # "firstVisibleItem":I
    .local v0, "firstVisibleItem":I
    :goto_0
    return v0

    .line 488
    .end local v0    # "firstVisibleItem":I
    .restart local p1    # "firstVisibleItem":I
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 489
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v2

    if-ltz v2, :cond_3

    .line 490
    add-int/2addr p1, v1

    .line 497
    :cond_1
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v2

    if-lez v2, :cond_2

    .line 498
    const/4 v2, 0x0

    invoke-super {p0, v2}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v2

    if-lez v2, :cond_2

    .line 499
    if-lez p1, :cond_2

    .line 500
    add-int/lit8 p1, p1, -0x1

    :cond_2
    move v0, p1

    .line 504
    .end local p1    # "firstVisibleItem":I
    .restart local v0    # "firstVisibleItem":I
    goto :goto_0

    .line 488
    .end local v0    # "firstVisibleItem":I
    .restart local p1    # "firstVisibleItem":I
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private getHeaderHeight()I
    .locals 1

    .prologue
    .line 359
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    goto :goto_0
.end method

.method private getSelectorPosition()I
    .locals 4

    .prologue
    .line 296
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorPositionField:Ljava/lang/reflect/Field;

    if-nez v2, :cond_1

    .line 298
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 299
    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v2

    iget-object v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->bottom:I

    if-ne v2, v3, :cond_0

    .line 300
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getFirstVisiblePosition()I

    move-result v2

    invoke-direct {p0, v2}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->fixedFirstVisibleItem(I)I

    move-result v2

    add-int/2addr v2, v1

    .line 312
    .end local v1    # "i":I
    :goto_1
    return v2

    .line 298
    .restart local v1    # "i":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 305
    .end local v1    # "i":I
    :cond_1
    :try_start_0
    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorPositionField:Ljava/lang/reflect/Field;

    invoke-virtual {v2, p0}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    goto :goto_1

    .line 306
    :catch_0
    move-exception v0

    .line 307
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    .line 312
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :cond_2
    :goto_2
    const/4 v2, -0x1

    goto :goto_1

    .line 308
    :catch_1
    move-exception v0

    .line 309
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_2
.end method

.method private isScrollBarOverlay()Z
    .locals 2

    .prologue
    .line 354
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getScrollBarStyle()I

    move-result v0

    .line 355
    .local v0, "scrollBarStyle":I
    if-eqz v0, :cond_0

    const/high16 v1, 0x2000000

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private measureHeader()V
    .locals 8

    .prologue
    const/high16 v6, 0x40000000    # 2.0f

    const/4 v4, 0x0

    .line 333
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v5

    sub-int/2addr v3, v5

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingRight()I

    move-result v5

    sub-int v5, v3, v5

    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->isScrollBarOverlay()Z

    move-result v3

    if-eqz v3, :cond_0

    move v3, v4

    :goto_0
    sub-int v3, v5, v3

    invoke-static {v3, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 336
    .local v2, "widthMeasureSpec":I
    const/4 v0, 0x0

    .line 338
    .local v0, "heightMeasureSpec":I
    iget-object v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 339
    .local v1, "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v1, :cond_1

    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v3, :cond_1

    .line 340
    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {v3, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 346
    :goto_1
    iget-object v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v3, v2, v0}, Landroid/view/View;->measure(II)V

    .line 349
    iget-object v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingLeft()I

    move-result v5

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingRight()I

    move-result v7

    sub-int/2addr v6, v7

    iget-object v7, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    invoke-virtual {v3, v5, v4, v6, v7}, Landroid/view/View;->layout(IIII)V

    .line 351
    return-void

    .line 333
    .end local v0    # "heightMeasureSpec":I
    .end local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    .end local v2    # "widthMeasureSpec":I
    :cond_0
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getVerticalScrollbarWidth()I

    move-result v3

    goto :goto_0

    .line 343
    .restart local v0    # "heightMeasureSpec":I
    .restart local v1    # "params":Landroid/view/ViewGroup$LayoutParams;
    .restart local v2    # "widthMeasureSpec":I
    :cond_1
    invoke-static {v4, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    goto :goto_1
.end method

.method private positionSelectorRect()V
    .locals 7

    .prologue
    .line 282
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v4}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 283
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getSelectorPosition()I

    move-result v1

    .line 284
    .local v1, "selectorPosition":I
    if-ltz v1, :cond_0

    .line 285
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getFirstVisiblePosition()I

    move-result v4

    invoke-direct {p0, v4}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->fixedFirstVisibleItem(I)I

    move-result v0

    .line 286
    .local v0, "firstVisibleItem":I
    sub-int v4, v1, v0

    invoke-virtual {p0, v4}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 287
    .local v2, "v":Landroid/view/View;
    instance-of v4, v2, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    if-eqz v4, :cond_0

    move-object v3, v2

    .line 288
    check-cast v3, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    .line 289
    .local v3, "wrapper":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mSelectorRect:Landroid/graphics/Rect;

    invoke-virtual {v3}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->getTop()I

    move-result v5

    iget v6, v3, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItemTop:I

    add-int/2addr v5, v6

    iput v5, v4, Landroid/graphics/Rect;->top:I

    .line 293
    .end local v0    # "firstVisibleItem":I
    .end local v1    # "selectorPosition":I
    .end local v2    # "v":Landroid/view/View;
    .end local v3    # "wrapper":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    :cond_0
    return-void
.end method

.method private reset()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 150
    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    .line 151
    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mCurrentHeaderId:Ljava/lang/Long;

    .line 152
    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    .line 153
    const/4 v0, -0x1

    iput v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    .line 154
    return-void
.end method

.method private scrollChanged(I)V
    .locals 18
    .param p1, "reportedFirstVisibleItem"    # I

    .prologue
    .line 370
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    if-nez v15, :cond_1

    const/4 v2, 0x0

    .line 371
    .local v2, "adapterCount":I
    :goto_0
    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-boolean v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    if-nez v15, :cond_2

    .line 444
    :cond_0
    :goto_1
    return-void

    .line 370
    .end local v2    # "adapterCount":I
    :cond_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-virtual {v15}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->getCount()I

    move-result v2

    goto :goto_0

    .line 375
    .restart local v2    # "adapterCount":I
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getHeaderViewsCount()I

    move-result v10

    .line 376
    .local v10, "listViewHeaderCount":I
    invoke-direct/range {p0 .. p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->fixedFirstVisibleItem(I)I

    move-result v15

    sub-int v7, v15, v10

    .line 379
    .local v7, "firstVisibleItem":I
    if-ltz v7, :cond_3

    add-int/lit8 v15, v2, -0x1

    if-le v7, v15, :cond_4

    .line 380
    :cond_3
    invoke-direct/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->reset()V

    .line 381
    invoke-direct/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->updateHeaderVisibilities()V

    .line 382
    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate()V

    goto :goto_1

    .line 386
    :cond_4
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    if-eqz v15, :cond_5

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    invoke-virtual {v15}, Ljava/lang/Integer;->intValue()I

    move-result v15

    if-eq v15, v7, :cond_6

    .line 387
    :cond_5
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    .line 388
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-virtual {v15, v7}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->getHeaderId(I)J

    move-result-wide v16

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mCurrentHeaderId:Ljava/lang/Long;

    .line 389
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Integer;->intValue()I

    move-result v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    move-object/from16 v17, v0

    invoke-virtual/range {v15 .. v18}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v15

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    .line 390
    invoke-direct/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->measureHeader()V

    .line 393
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildCount()I

    move-result v4

    .line 394
    .local v4, "childCount":I
    if-eqz v4, :cond_10

    .line 395
    const/4 v12, 0x0

    .line 396
    .local v12, "viewToWatch":Landroid/view/View;
    const v14, 0x7fffffff

    .line 397
    .local v14, "watchingChildDistance":I
    const/4 v13, 0x0

    .line 399
    .local v13, "viewToWatchIsFooter":Z
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_2
    if-ge v9, v4, :cond_e

    .line 400
    move-object/from16 v0, p0

    invoke-super {v0, v9}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 401
    .local v3, "child":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    if-eqz v15, :cond_8

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    invoke-virtual {v15, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_8

    const/4 v6, 0x1

    .line 404
    .local v6, "childIsFooter":Z
    :goto_3
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v16

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v15

    if-eqz v15, :cond_9

    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v15

    :goto_4
    sub-int v5, v16, v15

    .line 406
    .local v5, "childDistance":I
    if-gez v5, :cond_a

    .line 399
    :cond_7
    :goto_5
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 401
    .end local v5    # "childDistance":I
    .end local v6    # "childIsFooter":Z
    :cond_8
    const/4 v6, 0x0

    goto :goto_3

    .line 404
    .restart local v6    # "childIsFooter":Z
    :cond_9
    const/4 v15, 0x0

    goto :goto_4

    .line 410
    .restart local v5    # "childDistance":I
    :cond_a
    if-eqz v12, :cond_d

    if-nez v13, :cond_b

    move-object v15, v12

    check-cast v15, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    invoke-virtual {v15}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->hasHeader()Z

    move-result v15

    if-eqz v15, :cond_d

    :cond_b
    if-nez v6, :cond_c

    move-object v15, v3

    check-cast v15, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    invoke-virtual {v15}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->hasHeader()Z

    move-result v15

    if-eqz v15, :cond_7

    :cond_c
    if-ge v5, v14, :cond_7

    .line 414
    :cond_d
    move-object v12, v3

    .line 415
    move v13, v6

    .line 416
    move v14, v5

    goto :goto_5

    .line 420
    .end local v3    # "child":Landroid/view/View;
    .end local v5    # "childDistance":I
    .end local v6    # "childIsFooter":Z
    :cond_e
    invoke-direct/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getHeaderHeight()I

    move-result v8

    .line 421
    .local v8, "headerHeight":I
    if-eqz v12, :cond_14

    if-nez v13, :cond_f

    move-object v15, v12

    check-cast v15, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    invoke-virtual {v15}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->hasHeader()Z

    move-result v15

    if-eqz v15, :cond_14

    .line 424
    :cond_f
    if-ne v7, v10, :cond_11

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-super {v0, v15}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v15

    invoke-virtual {v15}, Landroid/view/View;->getTop()I

    move-result v15

    if-lez v15, :cond_11

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v15

    if-nez v15, :cond_11

    .line 427
    const/4 v15, 0x0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    .line 442
    .end local v8    # "headerHeight":I
    .end local v9    # "i":I
    .end local v12    # "viewToWatch":Landroid/view/View;
    .end local v13    # "viewToWatchIsFooter":Z
    .end local v14    # "watchingChildDistance":I
    :cond_10
    :goto_6
    invoke-direct/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->updateHeaderVisibilities()V

    .line 443
    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate()V

    goto/16 :goto_1

    .line 429
    .restart local v8    # "headerHeight":I
    .restart local v9    # "i":I
    .restart local v12    # "viewToWatch":Landroid/view/View;
    .restart local v13    # "viewToWatchIsFooter":Z
    .restart local v14    # "watchingChildDistance":I
    :cond_11
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v15

    if-eqz v15, :cond_12

    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v11

    .line 431
    .local v11, "paddingTop":I
    :goto_7
    invoke-virtual {v12}, Landroid/view/View;->getTop()I

    move-result v15

    add-int v16, v8, v11

    invoke-static/range {v15 .. v16}, Ljava/lang/Math;->min(II)I

    move-result v15

    move-object/from16 v0, p0

    iput v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    .line 433
    move-object/from16 v0, p0

    iget v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    if-ge v15, v11, :cond_13

    add-int v15, v8, v11

    :goto_8
    move-object/from16 v0, p0

    iput v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    goto :goto_6

    .line 429
    .end local v11    # "paddingTop":I
    :cond_12
    const/4 v11, 0x0

    goto :goto_7

    .line 433
    .restart local v11    # "paddingTop":I
    :cond_13
    move-object/from16 v0, p0

    iget v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    goto :goto_8

    .line 438
    .end local v11    # "paddingTop":I
    :cond_14
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v15

    if-eqz v15, :cond_15

    invoke-virtual/range {p0 .. p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v15

    :goto_9
    add-int/2addr v15, v8

    move-object/from16 v0, p0

    iput v15, v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    goto :goto_6

    :cond_15
    const/4 v15, 0x0

    goto :goto_9
.end method

.method private updateHeaderVisibilities()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 465
    iget-object v7, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getPaddingTop()I

    move-result v4

    .line 466
    .local v4, "top":I
    :goto_0
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildCount()I

    move-result v1

    .line 467
    .local v1, "childCount":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v1, :cond_3

    .line 468
    invoke-super {p0, v3}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 469
    .local v0, "child":Landroid/view/View;
    instance-of v7, v0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    if-eqz v7, :cond_0

    move-object v5, v0

    .line 470
    check-cast v5, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    .line 471
    .local v5, "wrapperViewChild":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    invoke-virtual {v5}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->hasHeader()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 472
    iget-object v2, v5, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    .line 473
    .local v2, "childHeader":Landroid/view/View;
    invoke-virtual {v5}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->getTop()I

    move-result v7

    if-ge v7, v4, :cond_2

    .line 474
    const/4 v7, 0x4

    invoke-virtual {v2, v7}, Landroid/view/View;->setVisibility(I)V

    .line 467
    .end local v2    # "childHeader":Landroid/view/View;
    .end local v5    # "wrapperViewChild":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    :cond_0
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "childCount":I
    .end local v3    # "i":I
    .end local v4    # "top":I
    :cond_1
    move v4, v6

    .line 465
    goto :goto_0

    .line 476
    .restart local v0    # "child":Landroid/view/View;
    .restart local v1    # "childCount":I
    .restart local v2    # "childHeader":Landroid/view/View;
    .restart local v3    # "i":I
    .restart local v4    # "top":I
    .restart local v5    # "wrapperViewChild":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    :cond_2
    invoke-virtual {v2, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 481
    .end local v0    # "child":Landroid/view/View;
    .end local v2    # "childHeader":Landroid/view/View;
    .end local v5    # "wrapperViewChild":Lcom/emilsjolander/components/stickylistheaders/WrapperView;
    :cond_3
    return-void
.end method

.method private wrapAdapter(Landroid/widget/ListAdapter;)Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 229
    instance-of v1, p1, Landroid/widget/SectionIndexer;

    if-eqz v1, :cond_0

    .line 230
    new-instance v0, Lcom/emilsjolander/components/stickylistheaders/SectionIndexerAdapterWrapper;

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast p1, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    .end local p1    # "adapter":Landroid/widget/ListAdapter;
    invoke-direct {v0, v1, p1}, Lcom/emilsjolander/components/stickylistheaders/SectionIndexerAdapterWrapper;-><init>(Landroid/content/Context;Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;)V

    .line 236
    .local v0, "wrapper":Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;
    :goto_0
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 237
    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDividerHeight:I

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->setDividerHeight(I)V

    .line 238
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDataSetChangedObserver:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 239
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapterHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper$OnHeaderClickListener;

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->setOnHeaderClickListener(Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper$OnHeaderClickListener;)V

    .line 240
    return-object v0

    .line 233
    .end local v0    # "wrapper":Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;
    .restart local p1    # "adapter":Landroid/widget/ListAdapter;
    :cond_0
    new-instance v0, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast p1, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    .end local p1    # "adapter":Landroid/widget/ListAdapter;
    invoke-direct {v0, v1, p1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;-><init>(Landroid/content/Context;Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;)V

    .restart local v0    # "wrapper":Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;
    goto :goto_0
.end method


# virtual methods
.method public addFooterView(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 448
    invoke-super {p0, p1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 449
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 450
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    .line 452
    :cond_0
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 453
    return-void
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 256
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-ge v0, v1, :cond_0

    .line 257
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getFirstVisiblePosition()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->scrollChanged(I)V

    .line 259
    :cond_0
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->positionSelectorRect()V

    .line 260
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    if-nez v0, :cond_2

    .line 261
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 279
    :goto_0
    return-void

    .line 265
    :cond_2
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDrawingListUnderStickyHeader:Z

    if-nez v0, :cond_3

    .line 266
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    const/4 v1, 0x0

    iget v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getHeight()I

    move-result v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 268
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 269
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 272
    :cond_3
    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 274
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDrawingListUnderStickyHeader:Z

    if-nez v0, :cond_4

    .line 275
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 278
    :cond_4
    invoke-direct {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->drawStickyHeader(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method public getAreHeadersSticky()Z
    .locals 1

    .prologue
    .line 203
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    return v0
.end method

.method public getWrappedAdapter()Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    iget-object v0, v0, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->mDelegate:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    goto :goto_0
.end method

.method public getWrappedView(I)Landroid/view/View;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 248
    invoke-virtual {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 249
    .local v0, "view":Landroid/view/View;
    instance-of v1, v0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    if-eqz v1, :cond_0

    .line 250
    check-cast v0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    .end local v0    # "view":Landroid/view/View;
    iget-object v0, v0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    .line 251
    :cond_0
    return-object v0
.end method

.method public isDrawingListUnderStickyHeader()Z
    .locals 1

    .prologue
    .line 518
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDrawingListUnderStickyHeader:Z

    return v0
.end method

.method protected onLayout(ZIIII)V
    .locals 1
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 142
    invoke-super/range {p0 .. p5}, Landroid/widget/ListView;->onLayout(ZIIII)V

    .line 143
    if-eqz p1, :cond_0

    .line 144
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->reset()V

    .line 145
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getFirstVisiblePosition()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->scrollChanged(I)V

    .line 147
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/high16 v3, -0x40800000    # -1.0f

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 524
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v7

    .line 525
    .local v7, "action":I
    if-nez v7, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gtz v0, :cond_1

    .line 527
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderDownY:F

    .line 528
    iput-boolean v6, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBeingPressed:Z

    .line 529
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setPressed(Z)V

    .line 530
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 531
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate(IIII)V

    .line 558
    :cond_0
    :goto_0
    return v6

    .line 534
    :cond_1
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBeingPressed:Z

    if-eqz v0, :cond_4

    .line 535
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderDownY:F

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mViewConfig:Landroid/view/ViewConfiguration;

    invoke-virtual {v1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-gez v0, :cond_3

    .line 537
    if-eq v7, v6, :cond_2

    const/4 v0, 0x3

    if-ne v7, v0, :cond_0

    .line 539
    :cond_2
    iput v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderDownY:F

    .line 540
    iput-boolean v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBeingPressed:Z

    .line 541
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setPressed(Z)V

    .line 542
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 543
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate(IIII)V

    .line 544
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

    if-eqz v0, :cond_0

    .line 545
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

    iget-object v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderPosition:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mCurrentHeaderId:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    move-object v1, p0

    invoke-interface/range {v0 .. v6}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;->onHeaderClick(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;Landroid/view/View;IJZ)V

    goto :goto_0

    .line 551
    :cond_3
    iput v3, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderDownY:F

    .line 552
    iput-boolean v2, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBeingPressed:Z

    .line 553
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setPressed(Z)V

    .line 554
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeader:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 555
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->getWidth()I

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mHeaderBottomPosition:I

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate(IIII)V

    .line 558
    :cond_4
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v6

    goto :goto_0
.end method

.method public performItemClick(Landroid/view/View;IJ)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    .line 158
    instance-of v0, p1, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    if-eqz v0, :cond_0

    .line 159
    check-cast p1, Lcom/emilsjolander/components/stickylistheaders/WrapperView;

    .end local p1    # "view":Landroid/view/View;
    iget-object p1, p1, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    .line 161
    .restart local p1    # "view":Landroid/view/View;
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->performItemClick(Landroid/view/View;IJ)Z

    move-result v0

    return v0
.end method

.method public removeFooterView(Landroid/view/View;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 457
    invoke-super {p0, p1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 458
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mFooterViews:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 459
    const/4 v0, 0x1

    .line 461
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 26
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    const/4 v1, 0x0

    .line 208
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 209
    invoke-super {p0, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 225
    :goto_0
    return-void

    .line 212
    :cond_0
    if-nez p1, :cond_1

    .line 213
    iput-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    .line 214
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->reset()V

    .line 215
    invoke-super {p0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0

    .line 218
    :cond_1
    instance-of v0, p1, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;

    if-nez v0, :cond_2

    .line 219
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Adapter must implement StickyListHeadersAdapter"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 222
    :cond_2
    invoke-direct {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->wrapAdapter(Landroid/widget/ListAdapter;)Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    move-result-object v0

    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    .line 223
    invoke-direct {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->reset()V

    .line 224
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-super {p0, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0
.end method

.method public setAreHeadersSticky(Z)V
    .locals 1
    .param p1, "areHeadersSticky"    # Z

    .prologue
    .line 196
    iget-boolean v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    if-eq v0, p1, :cond_0

    .line 197
    iput-boolean p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAreHeadersSticky:Z

    .line 198
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->requestLayout()V

    .line 200
    :cond_0
    return-void
.end method

.method public setClipToPadding(Z)V
    .locals 1
    .param p1, "clipToPadding"    # Z

    .prologue
    .line 364
    invoke-super {p0, p1}, Landroid/widget/ListView;->setClipToPadding(Z)V

    .line 365
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mClippingToPadding:Ljava/lang/Boolean;

    .line 366
    return-void
.end method

.method public setDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "divider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 167
    if-eqz p1, :cond_0

    .line 168
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 169
    .local v0, "dividerDrawableHeight":I
    if-ltz v0, :cond_0

    .line 170
    invoke-virtual {p0, v0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setDividerHeight(I)V

    .line 173
    .end local v0    # "dividerDrawableHeight":I
    :cond_0
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    if-eqz v1, :cond_1

    .line 174
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-virtual {v1, p1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 175
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->requestLayout()V

    .line 176
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate()V

    .line 178
    :cond_1
    return-void
.end method

.method public setDividerHeight(I)V
    .locals 1
    .param p1, "height"    # I

    .prologue
    .line 182
    iput p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDividerHeight:I

    .line 183
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mAdapter:Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;

    invoke-virtual {v0, p1}, Lcom/emilsjolander/components/stickylistheaders/AdapterWrapper;->setDividerHeight(I)V

    .line 185
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->requestLayout()V

    .line 186
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->invalidate()V

    .line 188
    :cond_0
    return-void
.end method

.method public setDrawingListUnderStickyHeader(Z)V
    .locals 0
    .param p1, "drawingListUnderStickyHeader"    # Z

    .prologue
    .line 514
    iput-boolean p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mDrawingListUnderStickyHeader:Z

    .line 515
    return-void
.end method

.method public setOnHeaderClickListener(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;)V
    .locals 0
    .param p1, "onHeaderClickListener"    # Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

    .prologue
    .line 509
    iput-object p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnHeaderClickListener:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;

    .line 510
    return-void
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0
    .param p1, "l"    # Landroid/widget/AbsListView$OnScrollListener;

    .prologue
    .line 192
    iput-object p1, p0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->mOnScrollListenerDelegate:Landroid/widget/AbsListView$OnScrollListener;

    .line 193
    return-void
.end method
