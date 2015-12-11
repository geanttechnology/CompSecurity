.class public Lcom/aio/downloader/views/LTabIndicator;
.super Landroid/widget/HorizontalScrollView;
.source "LTabIndicator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;,
        Lcom/aio/downloader/views/LTabIndicator$PageListener;,
        Lcom/aio/downloader/views/LTabIndicator$TabView;
    }
.end annotation


# instance fields
.field private currentPosition:I

.field private currentPositionOffset:F

.field private diviPaint:Landroid/graphics/Paint;

.field private dividerColor:I

.field private dividerPadding:I

.field private dividerWidth:I

.field private enableDivider:Z

.field private enableExpand:Z

.field private indicatorColor:I

.field private indicatorHeight:F

.field private indicatorOnTop:Z

.field private lastScrollX:I

.field private mAnimColor:I

.field private mBaseLinePaint:Landroid/graphics/Paint;

.field private mCurrentPaint:Landroid/graphics/Paint;

.field public mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

.field private mPager:Landroid/support/v4/view/ViewPager;

.field private mTabSelectedListener:Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

.field private mTabsContainer:Landroid/widget/LinearLayout;

.field private scrollOffset:I

.field private tabCount:I

.field private tabPadding:I

.field private tabTextSize:I

.field private textSelectedColor:I

.field private textUnselectColor:I

.field private underlineColor:I

.field private underlineHeight:F

.field private viewPagerScrollWithAnimation:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/LTabIndicator;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 64
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 67
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/aio/downloader/views/LTabIndicator;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v7, -0x1

    const v6, -0x21000001

    const v5, -0x75000001

    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 71
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 34
    iput v3, p0, Lcom/aio/downloader/views/LTabIndicator;->currentPosition:I

    .line 35
    const/4 v2, 0x0

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    .line 37
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    .line 38
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    .line 41
    iput v6, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorColor:I

    .line 42
    iput v5, p0, Lcom/aio/downloader/views/LTabIndicator;->underlineColor:I

    .line 43
    const/high16 v2, 0x1a000000

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerColor:I

    .line 44
    iput v6, p0, Lcom/aio/downloader/views/LTabIndicator;->textSelectedColor:I

    .line 45
    iput v5, p0, Lcom/aio/downloader/views/LTabIndicator;->textUnselectColor:I

    .line 46
    iput v5, p0, Lcom/aio/downloader/views/LTabIndicator;->mAnimColor:I

    .line 48
    iput-boolean v4, p0, Lcom/aio/downloader/views/LTabIndicator;->enableExpand:Z

    .line 49
    iput-boolean v3, p0, Lcom/aio/downloader/views/LTabIndicator;->enableDivider:Z

    .line 50
    iput-boolean v3, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorOnTop:Z

    .line 51
    iput-boolean v4, p0, Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z

    .line 53
    const/16 v2, 0x10

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabTextSize:I

    .line 54
    const/16 v2, 0x34

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->scrollOffset:I

    .line 55
    const/high16 v2, 0x40400000    # 3.0f

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorHeight:F

    .line 56
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->underlineHeight:F

    .line 57
    const/16 v2, 0xc

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerPadding:I

    .line 58
    const/16 v2, 0x18

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabPadding:I

    .line 59
    iput v4, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerWidth:I

    .line 60
    iput v3, p0, Lcom/aio/downloader/views/LTabIndicator;->lastScrollX:I

    .line 73
    invoke-virtual {p0, v4}, Lcom/aio/downloader/views/LTabIndicator;->setFillViewport(Z)V

    .line 74
    invoke-virtual {p0, v3}, Lcom/aio/downloader/views/LTabIndicator;->setWillNotDraw(Z)V

    .line 76
    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 78
    .local v0, "dm":Landroid/util/DisplayMetrics;
    new-instance v2, Landroid/widget/LinearLayout;

    invoke-direct {v2, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    .line 79
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 80
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v7, v7}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 83
    .local v1, "params":Landroid/widget/FrameLayout$LayoutParams;
    const/high16 v2, 0x42480000    # 50.0f

    .line 82
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->height:I

    .line 84
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 85
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/views/LTabIndicator;->addView(Landroid/view/View;)V

    .line 88
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->scrollOffset:I

    int-to-float v2, v2

    .line 87
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->scrollOffset:I

    .line 90
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerPadding:I

    int-to-float v2, v2

    .line 89
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerPadding:I

    .line 92
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabPadding:I

    int-to-float v2, v2

    .line 91
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabPadding:I

    .line 94
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerWidth:I

    int-to-float v2, v2

    .line 93
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerWidth:I

    .line 96
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorHeight:F

    .line 95
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorHeight:F

    .line 98
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->underlineHeight:F

    .line 97
    invoke-static {v4, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/LTabIndicator;->underlineHeight:F

    .line 100
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 101
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 102
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    iget v3, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorColor:I

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 103
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 104
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 105
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    iget v3, p0, Lcom/aio/downloader/views/LTabIndicator;->underlineColor:I

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 106
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    iput-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->diviPaint:Landroid/graphics/Paint;

    .line 107
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->diviPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 108
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->diviPaint:Landroid/graphics/Paint;

    iget v3, p0, Lcom/aio/downloader/views/LTabIndicator;->dividerWidth:I

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 109
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/LTabIndicator;)I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/aio/downloader/views/LTabIndicator;->mAnimColor:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/LTabIndicator;)I
    .locals 1

    .prologue
    .line 53
    iget v0, p0, Lcom/aio/downloader/views/LTabIndicator;->tabTextSize:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/LTabIndicator;I)V
    .locals 0

    .prologue
    .line 34
    iput p1, p0, Lcom/aio/downloader/views/LTabIndicator;->currentPosition:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/LTabIndicator;F)V
    .locals 0

    .prologue
    .line 35
    iput p1, p0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/LTabIndicator;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/LTabIndicator;II)V
    .locals 0

    .prologue
    .line 324
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/views/LTabIndicator;->scrollToChild(II)V

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/views/LTabIndicator;)Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/views/LTabIndicator;I)V
    .locals 0

    .prologue
    .line 302
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/LTabIndicator;->tabSelect(I)V

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/views/LTabIndicator;)Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabSelectedListener:Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/views/LTabIndicator;)Z
    .locals 1

    .prologue
    .line 51
    iget-boolean v0, p0, Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z

    return v0
.end method

.method private addTab(ILjava/lang/String;)V
    .locals 6
    .param p1, "position"    # I
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    const/4 v5, -0x1

    const/4 v4, 0x0

    .line 230
    new-instance v0, Lcom/aio/downloader/views/LTabIndicator$TabView;

    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/views/LTabIndicator$TabView;-><init>(Lcom/aio/downloader/views/LTabIndicator;Landroid/content/Context;)V

    .line 231
    .local v0, "tab":Lcom/aio/downloader/views/LTabIndicator$TabView;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getTextView()Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 232
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LTabIndicator$TabView;->setFocusable(Z)V

    .line 233
    new-instance v1, Lcom/aio/downloader/views/LTabIndicator$1;

    invoke-direct {v1, p0, p1}, Lcom/aio/downloader/views/LTabIndicator$1;-><init>(Lcom/aio/downloader/views/LTabIndicator;I)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LTabIndicator$TabView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 245
    iget-boolean v1, p0, Lcom/aio/downloader/views/LTabIndicator;->enableExpand:Z

    if-nez v1, :cond_0

    .line 246
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator;->tabPadding:I

    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabPadding:I

    invoke-virtual {v0, v1, v4, v2, v4}, Lcom/aio/downloader/views/LTabIndicator$TabView;->setPadding(IIII)V

    .line 248
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    .line 249
    iget-boolean v1, p0, Lcom/aio/downloader/views/LTabIndicator;->enableExpand:Z

    if-eqz v1, :cond_1

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 250
    const/high16 v3, 0x3f800000    # 1.0f

    invoke-direct {v1, v4, v5, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 248
    :goto_0
    invoke-virtual {v2, v0, p1, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 254
    return-void

    .line 251
    :cond_1
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 252
    const/4 v3, -0x2

    .line 251
    invoke-direct {v1, v3, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    goto :goto_0
.end method

.method private scrollToChild(II)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "offset"    # I

    .prologue
    .line 325
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    if-nez v1, :cond_1

    .line 339
    :cond_0
    :goto_0
    return-void

    .line 329
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    add-int v0, v1, p2

    .line 331
    .local v0, "newScrollX":I
    if-gtz p1, :cond_2

    if-lez p2, :cond_3

    .line 332
    :cond_2
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator;->scrollOffset:I

    sub-int/2addr v0, v1

    .line 335
    :cond_3
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator;->lastScrollX:I

    if-eq v0, v1, :cond_0

    .line 336
    iput v0, p0, Lcom/aio/downloader/views/LTabIndicator;->lastScrollX:I

    .line 337
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/views/LTabIndicator;->scrollTo(II)V

    goto :goto_0
.end method

.method private tabSelect(I)V
    .locals 6
    .param p1, "index"    # I

    .prologue
    .line 303
    iget-object v4, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    .line 304
    .local v3, "tabCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v3, :cond_0

    .line 314
    return-void

    .line 305
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 306
    .local v0, "child":Landroid/view/View;
    if-ne v1, p1, :cond_1

    const/4 v2, 0x1

    .line 307
    .local v2, "isSelected":Z
    :goto_1
    invoke-virtual {v0, v2}, Landroid/view/View;->setSelected(Z)V

    .line 308
    if-eqz v2, :cond_2

    .line 309
    check-cast v0, Lcom/aio/downloader/views/LTabIndicator$TabView;

    .end local v0    # "child":Landroid/view/View;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getTextView()Landroid/widget/TextView;

    move-result-object v4

    iget v5, p0, Lcom/aio/downloader/views/LTabIndicator;->textSelectedColor:I

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 304
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 306
    .end local v2    # "isSelected":Z
    .restart local v0    # "child":Landroid/view/View;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 311
    .restart local v2    # "isSelected":Z
    :cond_2
    check-cast v0, Lcom/aio/downloader/views/LTabIndicator$TabView;

    .end local v0    # "child":Landroid/view/View;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getTextView()Landroid/widget/TextView;

    move-result-object v4

    iget v5, p0, Lcom/aio/downloader/views/LTabIndicator;->textUnselectColor:I

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_2
.end method

.method private updateTabStyles()V
    .locals 3

    .prologue
    .line 317
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    if-lt v0, v2, :cond_0

    .line 321
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-direct {p0, v2}, Lcom/aio/downloader/views/LTabIndicator;->tabSelect(I)V

    .line 322
    return-void

    .line 318
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 319
    .local v1, "v":Landroid/view/View;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 317
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getViewPagerScrollWithAnimation()Z
    .locals 1

    .prologue
    .line 295
    iget-boolean v0, p0, Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z

    return v0
.end method

.method public isEnableDivider()Z
    .locals 1

    .prologue
    .line 283
    iget-boolean v0, p0, Lcom/aio/downloader/views/LTabIndicator;->enableDivider:Z

    return v0
.end method

.method public isEnableExpand()Z
    .locals 1

    .prologue
    .line 275
    iget-boolean v0, p0, Lcom/aio/downloader/views/LTabIndicator;->enableExpand:Z

    return v0
.end method

.method public isIndicatorOnTop()Z
    .locals 1

    .prologue
    .line 267
    iget-boolean v0, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorOnTop:Z

    return v0
.end method

.method public notifyDataSetChanged()V
    .locals 2

    .prologue
    .line 186
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 188
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    .line 190
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    if-lt v0, v1, :cond_0

    .line 194
    invoke-direct {p0}, Lcom/aio/downloader/views/LTabIndicator;->updateTabStyles()V

    .line 195
    return-void

    .line 191
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/view/PagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/aio/downloader/views/LTabIndicator;->addTab(ILjava/lang/String;)V

    .line 190
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 18
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 113
    invoke-super/range {p0 .. p1}, Landroid/widget/HorizontalScrollView;->onDraw(Landroid/graphics/Canvas;)V

    .line 115
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/views/LTabIndicator;->isInEditMode()Z

    move-result v1

    if-nez v1, :cond_0

    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    if-nez v1, :cond_1

    .line 161
    :cond_0
    return-void

    .line 119
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/views/LTabIndicator;->getHeight()I

    move-result v12

    .line 121
    .local v12, "height":I
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/aio/downloader/views/LTabIndicator;->indicatorOnTop:Z

    if-eqz v1, :cond_3

    .line 122
    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getWidth()I

    move-result v1

    int-to-float v4, v1

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/views/LTabIndicator;->underlineHeight:F

    .line 123
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    .line 122
    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 129
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPosition:I

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 130
    .local v11, "currentTab":Landroid/view/View;
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v1

    int-to-float v2, v1

    .line 131
    .local v2, "lineLeft":F
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v1

    int-to-float v4, v1

    .line 133
    .local v4, "lineRight":F
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    const/4 v3, 0x0

    cmpl-float v1, v1, v3

    if-lez v1, :cond_2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPosition:I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    add-int/lit8 v3, v3, -0x1

    if-ge v1, v3, :cond_2

    .line 134
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPosition:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v14

    .line 135
    .local v14, "nextTab":Landroid/view/View;
    invoke-virtual {v14}, Landroid/view/View;->getLeft()I

    move-result v1

    int-to-float v15, v1

    .line 136
    .local v15, "nextTabLeft":F
    invoke-virtual {v14}, Landroid/view/View;->getRight()I

    move-result v1

    int-to-float v0, v1

    move/from16 v16, v0

    .line 138
    .local v16, "nextTabRight":F
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    mul-float/2addr v1, v15

    const/high16 v3, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    sub-float/2addr v3, v5

    .line 139
    mul-float/2addr v3, v2

    .line 138
    add-float v2, v1, v3

    .line 140
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    mul-float v1, v1, v16

    const/high16 v3, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/views/LTabIndicator;->currentPositionOffset:F

    sub-float/2addr v3, v5

    .line 141
    mul-float/2addr v3, v4

    .line 140
    add-float v4, v1, v3

    .line 145
    .end local v14    # "nextTab":Landroid/view/View;
    .end local v15    # "nextTabLeft":F
    .end local v16    # "nextTabRight":F
    :cond_2
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/aio/downloader/views/LTabIndicator;->indicatorOnTop:Z

    if-eqz v1, :cond_4

    .line 146
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/views/LTabIndicator;->indicatorHeight:F

    .line 147
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    .line 146
    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 153
    :goto_1
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/aio/downloader/views/LTabIndicator;->enableDivider:Z

    if-eqz v1, :cond_0

    .line 154
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->diviPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->dividerColor:I

    invoke-virtual {v1, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 155
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_2
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->tabCount:I

    add-int/lit8 v1, v1, -0x1

    if-ge v13, v1, :cond_0

    .line 156
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v13}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v17

    .line 157
    .local v17, "tab":Landroid/view/View;
    invoke-virtual/range {v17 .. v17}, Landroid/view/View;->getRight()I

    move-result v1

    int-to-float v6, v1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->dividerPadding:I

    int-to-float v7, v1

    invoke-virtual/range {v17 .. v17}, Landroid/view/View;->getRight()I

    move-result v1

    int-to-float v8, v1

    .line 158
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/views/LTabIndicator;->dividerPadding:I

    sub-int v1, v12, v1

    int-to-float v9, v1

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/aio/downloader/views/LTabIndicator;->diviPaint:Landroid/graphics/Paint;

    move-object/from16 v5, p1

    .line 157
    invoke-virtual/range {v5 .. v10}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 155
    add-int/lit8 v13, v13, 0x1

    goto :goto_2

    .line 125
    .end local v2    # "lineLeft":F
    .end local v4    # "lineRight":F
    .end local v11    # "currentTab":Landroid/view/View;
    .end local v13    # "i":I
    .end local v17    # "tab":Landroid/view/View;
    :cond_3
    const/4 v2, 0x0

    int-to-float v1, v12

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->underlineHeight:F

    sub-float v3, v1, v3

    .line 126
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getWidth()I

    move-result v1

    int-to-float v4, v1

    int-to-float v5, v12

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/views/LTabIndicator;->mBaseLinePaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    .line 125
    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 149
    .restart local v2    # "lineLeft":F
    .restart local v4    # "lineRight":F
    .restart local v11    # "currentTab":Landroid/view/View;
    :cond_4
    int-to-float v1, v12

    move-object/from16 v0, p0

    iget v3, v0, Lcom/aio/downloader/views/LTabIndicator;->indicatorHeight:F

    sub-float v3, v1, v3

    .line 150
    int-to-float v5, v12

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/views/LTabIndicator;->mCurrentPaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    .line 149
    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto :goto_1
.end method

.method public setCurrentItem(I)V
    .locals 2
    .param p1, "item"    # I

    .prologue
    .line 299
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    iget-boolean v1, p0, Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z

    invoke-virtual {v0, p1, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 300
    return-void
.end method

.method public setEnableDivider(Z)V
    .locals 0
    .param p1, "enableDivider"    # Z

    .prologue
    .line 287
    iput-boolean p1, p0, Lcom/aio/downloader/views/LTabIndicator;->enableDivider:Z

    .line 288
    return-void
.end method

.method public setEnableExpand(Z)V
    .locals 0
    .param p1, "enableExpand"    # Z

    .prologue
    .line 279
    iput-boolean p1, p0, Lcom/aio/downloader/views/LTabIndicator;->enableExpand:Z

    .line 280
    return-void
.end method

.method public setIndicatorOnTop(Z)V
    .locals 0
    .param p1, "indicatorOnTop"    # Z

    .prologue
    .line 271
    iput-boolean p1, p0, Lcom/aio/downloader/views/LTabIndicator;->indicatorOnTop:Z

    .line 272
    return-void
.end method

.method public setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    .line 178
    return-void
.end method

.method public setOnTabReselectedListener(Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

    .prologue
    .line 181
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabSelectedListener:Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

    .line 182
    return-void
.end method

.method public setTabText(ILjava/lang/String;)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 257
    if-ltz p1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    if-le p1, v1, :cond_1

    .line 258
    :cond_0
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "tabs does not have this position."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 260
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 261
    .local v0, "tab":Landroid/view/View;
    instance-of v1, v0, Landroid/widget/TextView;

    if-eqz v1, :cond_2

    .line 262
    check-cast v0, Landroid/widget/TextView;

    .end local v0    # "tab":Landroid/view/View;
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 264
    :cond_2
    return-void
.end method

.method public setViewPager(Landroid/support/v4/view/ViewPager;)V
    .locals 2
    .param p1, "pager"    # Landroid/support/v4/view/ViewPager;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;

    .line 166
    invoke-virtual {p1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    if-nez v0, :cond_0

    .line 167
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 168
    const-string v1, "ViewPager does not have adapter instance."

    .line 167
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 171
    :cond_0
    new-instance v0, Lcom/aio/downloader/views/LTabIndicator$PageListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/views/LTabIndicator$PageListener;-><init>(Lcom/aio/downloader/views/LTabIndicator;Lcom/aio/downloader/views/LTabIndicator$PageListener;)V

    invoke-virtual {p1, v0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 173
    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator;->notifyDataSetChanged()V

    .line 174
    return-void
.end method

.method public setViewPagerScrollWithAnimation(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 291
    iput-boolean p1, p0, Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z

    .line 292
    return-void
.end method
